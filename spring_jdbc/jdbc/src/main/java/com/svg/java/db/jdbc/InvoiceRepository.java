package com.svg.java.db.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InvoiceRepository {

    public void insert(Invoice invoice) throws SQLException {
        String sql = "INSERT INTO invoices (number, concept, amount) VALUES (?, ?, ?)";
        try (Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, invoice.getNumber());    
                statement.setString(2, invoice.getConcept());
                statement.setDouble(3, invoice.getAmount());
                statement.execute();
        } catch (SQLException e) {
            throw e;
        }
    }

    public List<Invoice> getAll() throws SQLException {
        String sql = "SELECT * FROM invoices";
        List<Invoice> invoices = new ArrayList<>();
        try (Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Invoice invoice = new Invoice(resultSet.getInt("number"), resultSet.getString("concept"), resultSet.getDouble("amount"));
                    invoices.add(invoice);
                }
        } catch (SQLException e) {
            throw e;
        }
        return invoices;
    }

    private Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/spring_course", "postgres", "password");
        return connection;
    }
    
}
