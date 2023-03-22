package com.sg.propertyWebsite.daos;

import com.sg.propertyWebsite.entities.Property;

import java.util.List;

public interface PropertyDao {
    Property getPropertyByID(int id);
    List<Property> getPropertyByLocation(String propertyLocation);
    List<Property> getAllProperties();
    Property addProperty(Property property);
    void updateProperty(Property property);
    void deletePropertyByID(int id);

    List<String> getAmmentiesByID(int id);
}
