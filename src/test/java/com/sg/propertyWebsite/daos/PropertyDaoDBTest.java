package com.sg.propertyWebsite.daos;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.sg.propertyWebsite.entities.Property;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PropertyDaoDBTest {

    @Autowired
    PropertyDaoDB propertyDao;

    @BeforeEach
    void setUp() {
        List<Property> properties = propertyDao.getAllProperties();
        if (properties.size()>0){
            for (Property p: properties){
                propertyDao.deletePropertyByID(p.getPropertyID());
            }
        }
    }
    @AfterEach
    void tearDown() {
    }

    @Test
    void testAddAndGetProperty(){
        Property p = new Property();
        p.setPropertyName("Test Name");
        p.setRating(4.67);
        p.setPerNightCost(99.99);
        p.setAmmenitiesID(1);
        p.setCapacity(99);
        p.setPropertyType("Igloo");

        p = propertyDao.addProperty(p);

        Property fromDao = propertyDao.getPropertyByID(p.getPropertyID());

        assertEquals(true, p.equals(fromDao));
    }

    @Test
    void testGetAllProperties(){
        Property p = new Property();
        p.setPropertyName("Test Name");
        p.setRating(4.67);
        p.setPerNightCost(99.99);
        p.setAmmenitiesID(1);
        p.setCapacity(99);
        p.setPropertyType("Igloo");

        Property p2 = new Property();
        p2.setPropertyName("Test Name 2");
        p2.setRating(3.14);
        p2.setPerNightCost(11.99);
        p2.setAmmenitiesID(1);
        p2.setCapacity(34);
        p2.setPropertyType("Teepee");

        p = propertyDao.addProperty(p);
        p2 = propertyDao.addProperty(p2);

        List<Property> properties = propertyDao.getAllProperties();

        assertEquals(2, properties.size());
        assertEquals(true, properties.contains(p));
        assertEquals(true, properties.contains(p2));
    }

    @Test
    void testUpdateProperty(){
        Property p = new Property();
        p.setPropertyName("Test Name");
        p.setRating(4.67);
        p.setPerNightCost(99.99);
        p.setAmmenitiesID(1);
        p.setCapacity(99);
        p.setPropertyType("Igloo");
        p = propertyDao.addProperty(p);

        Property fromDao = propertyDao.getPropertyByID(p.getPropertyID());
        assertEquals(true, p.equals(fromDao));

        p.setPropertyName("Updated property name");
        propertyDao.updateProperty(p);

        assertNotEquals(fromDao, p);

        fromDao = propertyDao.getPropertyByID(p.getPropertyID());
        assertEquals(true, p.equals(fromDao));
    }

    @Test
    void testDeleteProperty(){
        Property p = new Property();
        p.setPropertyName("Test Name");
        p.setRating(4.67);
        p.setPerNightCost(99.99);
        p.setAmmenitiesID(1);
        p.setCapacity(99);
        p.setPropertyType("Igloo");
        p = propertyDao.addProperty(p);

        Property fromDao = propertyDao.getPropertyByID(p.getPropertyID());
        assertEquals(true, p.equals(fromDao));

        propertyDao.deletePropertyByID(p.getPropertyID());

        fromDao = propertyDao.getPropertyByID(p.getPropertyID());
        assertNull(fromDao);
    }
}