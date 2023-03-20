package com.sg.propertyWebsite.daos;

import com.sg.propertyWebsite.entities.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class PropertyDaoDB implements PropertyDao{
    @Autowired
    JdbcTemplate jdbc;
    @Override
    public Property getPropertyByID(int id) {
        return null;
    }

    @Override
    public List<Property> getAllProperties() {
        return null;
    }

    @Override
    public Property addProperty(Property property) {
        return null;
    }

    @Override
    public void updateProperty(Property property) {

    }

    @Override
    public void deletePropertyByID(int id) {

    }
}
