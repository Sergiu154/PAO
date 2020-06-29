package sample.DB;

import sample.Airport;

import javax.xml.transform.Result;
import java.net.ConnectException;
import java.sql.*;

public class AirportDB {

    private static final String INSERT_STATEMENT = "INSERT INTO airports (location,aname) VALUES(?,?)";
    private static final String DELETE_STATEMENT = "DELETE FROM airports WHERE aname =?";
    private static final String READ_STATEMENT = "SELECT * FROM airports WHERE location = ? AND aname=? ";
    private static final String CREATE_STATEMENT = " CREATE TABLE IF NOT EXISTS airports ( " +
            "id int NOT NULL AUTO_INCREMENT," +
            "location varchar(30)," +
            "aname varchar(30)," +
            "PRIMARY KEY(id) );";


    private static AirportDB instance;

    private AirportDB() {


        try (Statement statement = DBConnection.getConnection().createStatement()) {

            // create table using the CREATE_STATEMENT statement
            statement.executeUpdate(CREATE_STATEMENT);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static AirportDB getInstance() {
        if (instance == null)
            instance = new AirportDB();
        return instance;
    }

    // print the queried data in the console
    // get the tickets which have dep_loc as departure_location and arr_loc as arrival_location

    public void findAirport(String location, String name) {

        try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(READ_STATEMENT)) {

            preparedStatement.setString(1, location);
            preparedStatement.setString(2, name);

            try (ResultSet res = preparedStatement.executeQuery()) {

                System.out.println("Tickets with location = " + location + " and name = " + name + " have been found");

                while (res.next()) {

                    Airport airport = new Airport(res.getString(2), res.getString(3));
                    System.out.println(airport.toString());

                }


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void insertAirport(String location, String name) {

        try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(INSERT_STATEMENT)) {

            preparedStatement.setString(1, location);
            preparedStatement.setString(2, name);


            int rows = preparedStatement.executeUpdate();
            if (rows > 0)
                System.out.println("Data has been inserted");


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    // remove ticket by departure_date
    public void removeAirport(String name) {


        try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(DELETE_STATEMENT)) {


            preparedStatement.setString(1, name);
            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                System.out.println(rows + " rows have been deleted");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // update the option field given the ticket's id
    public void updateAirport(int option, String value, int ticketID) {

        String whatToUPdate = "";

        switch (option) {

            case 1:
                whatToUPdate = "location";
                break;
            case 2:
                whatToUPdate = "aname";
                break;
            default:
                break;
        }
        if (!whatToUPdate.equals("")) {

            String UPDATE_STATEMENT = "UPDATE airports SET " + whatToUPdate + "=? WHERE id=?";
            try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(UPDATE_STATEMENT)) {

                preparedStatement.setString(1, value);
                preparedStatement.setInt(2, ticketID);

                int rows = preparedStatement.executeUpdate();
                if (rows > 0)
                    System.out.println(rows + " rows have been updated");

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }


}