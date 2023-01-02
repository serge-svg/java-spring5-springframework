package com.svg.java.spring.springjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InvoiceRepository {

    @Autowired
    DataSource dataSource;

    public List<Invoice> getAll() throws SQLException {
        List<Invoice> invoices = new ArrayList<>();
        try (Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM invoices");
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Invoice invoice = new Invoice();
                invoice.setNumber(resultSet.getInt("number"));
                invoice.setConcept(resultSet.getString("concept"));
                invoice.setAmount(resultSet.getDouble("amount"));
                invoices.add(invoice);
            }
        } catch (SQLException e) {
            throw e;
        }
        return invoices;
    }

    public void insert(Invoice invoice) throws Exception {
        String sql = "INSERT INTO invoices(number, concept, amount) VALUES(?,?,?)";

        try (Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, invoice.getNumber());
            statement.setString(2, invoice.getConcept());
            statement.setDouble(3, invoice.getAmount());
            statement.execute();

        } catch (Exception e) {
            throw e;
        }

    }

    private Connection getConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        return connection;
    }

}
