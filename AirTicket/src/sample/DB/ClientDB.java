package sample.DB;

import sample.Client;

import javax.xml.transform.Result;
import java.net.ConnectException;
import java.sql.*;

public class ClientDB {

    private static final String INSERT_STATEMENT = "INSERT INTO clients (first_name,last_name,age,email,num_tickets) VALUES(?,?,?,?,?)";
    private static final String DELETE_STATEMENT = "DELETE FROM clients WHERE first_name =? AND last_name=?";
    private static final String READ_STATEMENT = "SELECT * FROM clients WHERE first_name = ? AND last_name =?";
    private static final String CREATE_STATEMENT = " CREATE TABLE IF NOT EXISTS clients ( " +
            "id int NOT NULL AUTO_INCREMENT," +
            "first_name varchar(255) NOT NULL," +
            "last_name varchar(255) NOT NULL," +
            "age varchar(255)," +
            "email varchar(255)," +
            "num_tickets int," +
            "PRIMARY KEY(id) );";


    private static ClientDB instance;

    private ClientDB() {


        try (Statement statement = DBConnection.getConnection().createStatement()) {

            // create table using the CREATE_STATEMENT statement
            statement.executeUpdate(CREATE_STATEMENT);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static ClientDB getInstance() {
        if (instance == null)
            instance = new ClientDB();
        return instance;
    }

    // print the queried data in the console
    // get the tickets which have dep_loc as departure_location and arr_loc as arrival_location

    public void findClient(String first_name, String last_name) {

        try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(READ_STATEMENT)) {

            preparedStatement.setString(1, first_name);
            preparedStatement.setString(2, last_name);

            try (ResultSet res = preparedStatement.executeQuery()) {

                System.out.println("Tickets with first_name = " + first_name + " and last_name = " + last_name + " have been found");

                while (res.next()) {

                    Client client = new Client(res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getInt(6));
                    System.out.println(client.toString());

                }


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void insertClient(String first_name, String last_name, String age, String email, int numTickets) {

        try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(INSERT_STATEMENT)) {

            preparedStatement.setString(1, first_name);
            preparedStatement.setString(2, last_name);
            preparedStatement.setString(3, age);
            preparedStatement.setString(4, email);
            preparedStatement.setInt(5, numTickets);

            int rows = preparedStatement.executeUpdate();
            if (rows > 0)
                System.out.println("Data has been inserted");


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    // remove ticket by departure_date
    public void removeClient(String first_name, String last_name) {


        try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(DELETE_STATEMENT)) {


            preparedStatement.setString(1, first_name);
            preparedStatement.setString(2, last_name);

            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                System.out.println(rows + " rows have been deleted");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // update the option field given the ticket's id
    public void updateClient(int option, String value, int clientID) {

        String whatToUPdate = "";

        switch (option) {

            case 1:
                whatToUPdate = "first_name";
                break;
            case 2:
                whatToUPdate = "last_name";
                break;
            case 3:
                whatToUPdate = "email";
                break;
            default:
                break;
        }
        if (!whatToUPdate.equals("")) {

            String UPDATE_STATEMENT = "UPDATE clients SET " + whatToUPdate + "=? WHERE id=?";
            try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(UPDATE_STATEMENT)) {

                preparedStatement.setString(1, value);
                preparedStatement.setInt(2, clientID);

                int rows = preparedStatement.executeUpdate();
                if (rows > 0)
                    System.out.println(rows + " rows have been updated");

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }


}