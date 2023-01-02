package com.svg.java.spring.springjdbc.beanmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

public class InvoiceRowMapper implements RowMapper<Invoice>{

    @Override
    @Nullable
    public Invoice mapRow(ResultSet rs, int rowNum) throws SQLException {        
        return new Invoice(rs.getInt("number"), rs.getString("concept"), rs.getDouble("amount"));
    }
    
}
