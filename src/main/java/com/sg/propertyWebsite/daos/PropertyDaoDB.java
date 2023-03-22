package com.sg.propertyWebsite.daos;

import com.sg.propertyWebsite.entities.Amenity;
import com.sg.propertyWebsite.entities.Guest;
import com.sg.propertyWebsite.entities.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PropertyDaoDB implements PropertyDao {
    @Autowired
    JdbcTemplate jdbc;

    @Override
    public Property getPropertyByID(int id) {
        try {
            String SELECT_PROPERTY_BY_ID = "SELECT * FROM Properties WHERE propertiesID = ?";
            Property property = jdbc.queryForObject(SELECT_PROPERTY_BY_ID, new PropertyDaoDB.PropertyMapper(), id);
            return property;
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Property> getPropertyByLocation(String propertyLocation) {
        try {
            String SELECT_PROPERTY_BY_LOCATION = "SELECT * FROM Properties WHERE propertyLocation = ?";
            List<Property> properties = jdbc.query(SELECT_PROPERTY_BY_LOCATION, new PropertyDaoDB.PropertyMapper(), propertyLocation);
            return properties;
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Property> getAllProperties() {
        try {
            String SELECT_ALL_PROPERTIES = "SELECT * FROM Properties";
            List<Property> properties = jdbc.query(SELECT_ALL_PROPERTIES, new PropertyDaoDB.PropertyMapper());
            return properties;
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    @Transactional
    public Property addProperty(Property property) {
        try {
            String INSERT_PRODUCT = "INSERT INTO Properties(propertyName, propertyLocation, capacity, rating, ammenitiesID, " +
                    "perNightPrice, propertyType)" + " VALUES(?,?,?,?,?,?,?);";
            jdbc.update(INSERT_PRODUCT,
                    property.getPropertyName(),
                    property.getPropertyLocation(),
                    String.valueOf(property.getCapacity()),
                    String.valueOf(property.getRating()),
                    String.valueOf(property.getAmmenitiesID()),
                    String.valueOf(property.getPerNightCost()),
                    property.getPropertyType());
            int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
            property.setPropertyID(newId);
            return property;
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public void updateProperty(Property property) {
        try {
            String UPDATE_GUEST = "UPDATE Properties SET propertyName = ?, propertyLocation = ?, rating = ?, perNightPrice = ?, ammenitiesID = ?," +
                    "propertyType = ?," + "WHERE propertiesID = ?;";
            jdbc.update(UPDATE_GUEST,
                    property.getPropertyName(),
                    property.getPropertyLocation(),
                    String.valueOf(property.getRating()),
                    String.valueOf(property.getPerNightCost()),
                    String.valueOf(property.getAmmenitiesID()),
                    property.getPropertyType(),
                    String.valueOf(property.getPropertyID()));

        } catch (DataAccessException e) {
            System.out.println("Error updating properties");
        }

    }

    @Override
    public void deletePropertyByID(int id) {
        try {
            String DELETE_PROPERTY = "DELETE FROM Properties WHERE propertiesID = ?";
            jdbc.update(DELETE_PROPERTY, id);
        } catch (DataAccessException e) {
            System.out.println("Error deleting property");
        }

    }

    @Override
    public List<String> getAmmentiesByID(int id) {
        try {
            String SELECT_AMMENITIES = "SELECT * FROM Ammenities WHERE ammenitiesID = ?;";
            Amenity a = jdbc.queryForObject(SELECT_AMMENITIES, new PropertyDaoDB.AmmenitiesMapper(), id);
            return a.getAmmenities();
        } catch (DataAccessException e) {
            return null;
        }
    }


    public static final class PropertyMapper implements RowMapper<Property> {

        @Override
        public Property mapRow(ResultSet rs, int index) throws SQLException {
            Property property = new Property();
            property.setPropertyID(rs.getInt("propertiesID"));
            property.setPropertyLocation(rs.getString("propertyLocation"));
            property.setPropertyName(rs.getString("propertyName"));
            property.setCapacity(rs.getInt("capacity"));
            property.setRating(rs.getDouble("rating"));
            property.setAmmenitiesID(rs.getInt("ammenitiesID"));
            property.setPerNightCost(rs.getDouble("perNightPrice"));
            property.setPropertyType(rs.getString("propertyType"));
            return property;
        }
    }

    public static final class AmmenitiesMapper implements RowMapper<Amenity> {

        @Override
        public Amenity mapRow(ResultSet rs, int index) throws SQLException {
            Amenity a = new Amenity();
            a.setFridge(rs.getBoolean("fridge"));
            a.setHotTub(rs.getBoolean("hotTub"));
            a.setOven(rs.getBoolean("oven"));
            a.setMicrowave(rs.getBoolean("microwave"));
            a.setTv(rs.getBoolean("tv"));
            a.setSwimmingPool(rs.getBoolean("swimmingPool"));
            return a;
        }
    }
}

