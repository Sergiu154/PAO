package sample.DB;

import sample.Ticket;

import javax.xml.transform.Result;
import java.net.ConnectException;
import java.sql.*;

public class TicketDB {

    private static final String INSERT_STATEMENT = "INSERT INTO tickets (dep_date,arr_date,dep_loc,arr_loc,num_tickets) VALUES(?,?,?,?,?)";
    private static final String DELETE_STATEMENT = "DELETE FROM tickets WHERE dep_date =?";
    private static final String READ_STATEMENT = "SELECT * FROM tickets WHERE dep_loc = ? AND arr_loc =?";
    private static final String CREATE_STATEMENT = " CREATE TABLE IF NOT EXISTS tickets ( " +
            "id int NOT NULL AUTO_INCREMENT," +
            "dep_date varchar(255) NOT NULL," +
            "arr_date varchar(255)," +
            "dep_loc varchar(255)," +
            "arr_loc varchar(255)," +
            "num_tickets int," +
            "one_way int," +
            "PRIMARY KEY(id) );";


    private static TicketDB instance;

    private TicketDB() {


        try (Statement statement = DBConnection.getConnection().createStatement()) {

            // create table using the CREATE_STATEMENT statement
            statement.executeUpdate(CREATE_STATEMENT);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static TicketDB getInstance() {
        if (instance == null)
            instance = new TicketDB();
        return instance;
    }

    // print the queried data in the console
    // get the tickets which have dep_loc as departure_location and arr_loc as arrival_location

    public void findTickets(String dep_loc, String arr_loc) {

        try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(READ_STATEMENT)) {

            preparedStatement.setString(1, dep_loc);
            preparedStatement.setString(2, arr_loc);

            try (ResultSet res = preparedStatement.executeQuery()) {

                System.out.println("Tickets with dep_location = " + dep_loc + " and arr_loc = " + arr_loc + " have been found");

                while (res.next()) {

                    Ticket ticket = new Ticket(res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getBoolean(6));
                    System.out.println(ticket.toString());

                }


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void insertTicket(String dep_date, String arr_date, String dep_loc, String arr_loc, int oneWay) {

        try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(INSERT_STATEMENT)) {

            preparedStatement.setString(1, dep_date);
            preparedStatement.setString(2, arr_date);
            preparedStatement.setString(3, dep_loc);
            preparedStatement.setString(4, arr_loc);
            preparedStatement.setInt(5, oneWay);

            int rows = preparedStatement.executeUpdate();
            if (rows > 0)
                System.out.println("Data has been inserted");


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    // remove ticket by departure_date
    public void removeTicket(String dep_date) {


        try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(DELETE_STATEMENT)) {


            preparedStatement.setString(1, dep_date);
            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                System.out.println(rows + " rows have been deleted");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // update the option field given the ticket's id
    public void updateTicket(int option, String value, int ticketID) {

        String whatToUPdate = "";

        switch (option) {

            case 1:
                whatToUPdate = "arr_date";
                break;
            case 2:
                whatToUPdate = "dep_date";
                break;
            default:
                break;
        }
        if (!whatToUPdate.equals("")) {

            String UPDATE_STATEMENT = "UPDATE tickets SET " + whatToUPdate + "=? WHERE id=?";
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