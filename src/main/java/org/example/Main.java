package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        mainFrame.histogramDisplay().show(new DataProvider() {

            @Override
            public ArrayList<Integer> getEdades() {
                ArrayList<Integer> edades = new ArrayList<>();
                try(Connection connection = DatabaseManager.getConnection()) {
                    String query = "SELECT * FROM Persons";
                    try(PreparedStatement statement = connection.prepareStatement(query);
                        ResultSet resultSet = statement.executeQuery()) {
                        while (resultSet.next()) {
                            edades.add(resultSet.getInt("Age"));
                        }
                        System.out.println(edades);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return edades;
            }
        });
        mainFrame.setVisible(true);
    }
}