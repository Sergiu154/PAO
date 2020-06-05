package sample.DB;

import sample.Flight;

import javax.xml.transform.Result;
import java.net.ConnectException;
import java.sql.*;

public class FlightDB {

    private static final String INSERT_STATEMENT = "INSERT INTO flights (flight_id,plane_type,company,dep_airport,arr_airport) VALUES(?,?,?,?,?)";
    private static final String DELETE_STATEMENT = "DELETE FROM flights WHERE flight_id =?";
    private static final String READ_STATEMENT = "SELECT * FROM flights WHERE flight_id=?";
    private static final String CREATE_STATEMENT = " CREATE TABLE IF NOT EXISTS flights ( " +
            "id int NOT NULL AUTO_INCREMENT," +
            "flight_id varchar(20)," +
            "plane_type varchar(50)," +
            "company varchar(20)," +
            "dep_airport varchar(20)," +
            "arr_airport varchar(20)," +
            "PRIMARY KEY(id));";


    private static FlightDB instance;

    private FlightDB() {


        try (Statement statement = DBConnection.getConnection().createStatement()) {

            // create table using the CREATE_STATEMENT statement
            statement.executeUpdate(CREATE_STATEMENT);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static FlightDB getInstance() {
        if (instance == null)
            instance = new FlightDB();
        return instance;
    }

    // print the queried data in the console
    // get the tickets which have dep_loc as departure_location and arr_loc as arrival_location

    public void findFlights(String flight_id) {

        try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(READ_STATEMENT)) {

            preparedStatement.setString(1, flight_id);

            try (ResultSet res = preparedStatement.executeQuery()) {

                System.out.println("Plane with fligt_id= " + flight_id);

                while (res.next()) {

                    Flight flight = new Flight(res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6));
                    System.out.println(flight.toString());

                }


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void insertFlight(String flight_id, String plane_type, String company, String depAirport, String arrAirport) {

        try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(INSERT_STATEMENT)) {

            preparedStatement.setString(1, flight_id);
            preparedStatement.setString(2, plane_type);
            preparedStatement.setString(3, company);
            preparedStatement.setString(4, depAirport);
            preparedStatement.setString(5, arrAirport);

            int rows = preparedStatement.executeUpdate();
            if (rows > 0)
                System.out.println("Data has been inserted");


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    // remove ticket by departure_date
    public void removeFlight(String flightId) {


        try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(DELETE_STATEMENT)) {


            preparedStatement.setString(1, flightId);
            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                System.out.println(rows + " rows have been deleted");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // update the option field given the ticket's id
    public void updateFlight(int option, String value, String flight_id) {

        String whatToUPdate = "";

        switch (option) {

            case 1:
                whatToUPdate = "company";
                break;
            case 2:
                whatToUPdate = "flight_id";
                break;
            default:
                break;
        }
        if (!whatToUPdate.equals("")) {

            String UPDATE_STATEMENT = "UPDATE flights SET " + whatToUPdate + "=? WHERE flight_id=?";
            try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(UPDATE_STATEMENT)) {

                preparedStatement.setString(1, value);
                preparedStatement.setString(2, flight_id);

                int rows = preparedStatement.executeUpdate();
                if (rows > 0)
                    System.out.println(rows + " rows have been updated");

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }


}