package com.sg.propertyWebsite.daos;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.sg.propertyWebsite.entities.Booking;
import com.sg.propertyWebsite.entities.Guest;
import com.sg.propertyWebsite.entities.Property;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookingDaoDBTest {

    @Autowired
    BookingDaoDB bookingDao;
    @Autowired
    PropertyDaoDB propertyDao;
    @Autowired
    GuestDaoDB guestDao;


    @BeforeEach
    void setUp() {
        List<Booking> bookings = bookingDao.getAllBooking();
        List<Guest> guests = guestDao.getAllGuests();
        List<Property> properties = propertyDao.getAllProperties();
        for (Booking b : bookings){
            bookingDao.deleteBookingByID(b.getBookingID());
        }
        for(Guest g : guests){
            guestDao.deleteGuestByID(g.getGuestID());
        }
        for(Property p : properties){
            propertyDao.deletePropertyByID(p.getPropertyID());
        }

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testAddAndGetBooking(){
        Guest guest = new Guest();
        guest.setFirstName("Test first name");
        guest.setLastName("Test last name");
        guest.setEmail("test@email.com");
        guest.setPostcode("tEstC0De");
        guest.setPhoneNumber("TestPhone");

        guest = guestDao.addGuest(guest);

        Property p = new Property();
        p.setPropertyName("Test Name");
        p.setRating(4.67);
        p.setPerNightCost(99.99);
        p.setAmmenitiesID(1);
        p.setCapacity(99);
        p.setPropertyType("Igloo");

        p = propertyDao.addProperty(p);

        Booking b = new Booking();
        b.setPropertiesID(p.getPropertyID());
        b.setGuestID(guest.getGuestID());
        b.setStartDate(new Date("09/13/2024"));
        b.setEndDate(new Date("09/16/2024"));
        b.setTotalCost(999.78);
        b.setNumberOfGuests(5);


        b = bookingDao.addBooking(b);

        Booking fromDao = bookingDao.getBookingByID(b.getBookingID());

        assertEquals(true, b.equals(fromDao));
}

    @Test
    void testGetAllBookings(){
        Guest guest = new Guest();
        guest.setFirstName("Test first name");
        guest.setLastName("Test last name");
        guest.setEmail("test@email.com");
        guest.setPostcode("tEstC0De");
        guest.setPhoneNumber("TestPhone");

        guest = guestDao.addGuest(guest);

        Property p = new Property();
        p.setPropertyName("Test Name");
        p.setRating(4.67);
        p.setPerNightCost(99.99);
        p.setAmmenitiesID(1);
        p.setCapacity(99);
        p.setPropertyType("Igloo");

        p = propertyDao.addProperty(p);

        Booking b = new Booking();
        b.setPropertiesID(p.getPropertyID());
        b.setGuestID(guest.getGuestID());
        b.setStartDate(new Date("09/13/2024"));
        b.setEndDate(new Date("09/16/2024"));
        b.setTotalCost(999.78);
        b.setNumberOfGuests(5);

        Booking b2 = new Booking();
        b2.setPropertiesID(p.getPropertyID());
        b2.setGuestID(guest.getGuestID());
        b2.setStartDate(new Date(2024,9,20));
        b2.setEndDate(new Date(2024,9,25));
        b2.setTotalCost(222.78);
        b2.setNumberOfGuests(8);

        b = bookingDao.addBooking(b);
        b2 = bookingDao.addBooking(b2);

        List<Booking> bookings = bookingDao.getAllBooking();

        assertEquals(2, bookings.size());
        assertEquals(true, bookings.contains(b));
        assertEquals(true, bookings.contains(b2));
}

@Test
    void testUpdateBooking(){
    Guest guest = new Guest();
    guest.setFirstName("Test first name");
    guest.setLastName("Test last name");
    guest.setEmail("test@email.com");
    guest.setPostcode("tEstC0De");
    guest.setPhoneNumber("TestPhone");

    guest = guestDao.addGuest(guest);

    Property p = new Property();
    p.setPropertyName("Test Name");
    p.setRating(4.67);
    p.setPerNightCost(99.99);
    p.setAmmenitiesID(1);
    p.setCapacity(99);
    p.setPropertyType("Igloo");

    p = propertyDao.addProperty(p);

    Booking b = new Booking();
    b.setPropertiesID(p.getPropertyID());
    b.setGuestID(guest.getGuestID());
    b.setStartDate(new Date("09/13/2024"));
    b.setEndDate(new Date("09/16/2024"));
    b.setTotalCost(999.78);
    b.setNumberOfGuests(5);

    b = bookingDao.addBooking(b);

    Booking fromDao = bookingDao.getBookingByID(b.getBookingID());
    assertEquals(true, b.equals(fromDao));

    b.setNumberOfGuests(7);
    bookingDao.updateBooking(b);

    assertNotEquals(b,fromDao);

    fromDao = bookingDao.getBookingByID(b.getBookingID());
    assertEquals(true, b.equals(fromDao));
}

@Test
    void testDeleteBooking(){
    Guest guest = new Guest();
    guest.setFirstName("Test first name");
    guest.setLastName("Test last name");
    guest.setEmail("test@email.com");
    guest.setPostcode("tEstC0De");
    guest.setPhoneNumber("TestPhone");

    guest = guestDao.addGuest(guest);

    Property p = new Property();
    p.setPropertyName("Test Name");
    p.setRating(4.67);
    p.setPerNightCost(99.99);
    p.setAmmenitiesID(1);
    p.setCapacity(99);
    p.setPropertyType("Igloo");

    p = propertyDao.addProperty(p);

    Booking b = new Booking();
    b.setPropertiesID(p.getPropertyID());
    b.setGuestID(guest.getGuestID());
    b.setStartDate(new Date("09/13/2024"));
    b.setEndDate(new Date("09/16/2024"));
    b.setTotalCost(999.78);
    b.setNumberOfGuests(5);

    b = bookingDao.addBooking(b);

    Booking fromDao = bookingDao.getBookingByID(b.getBookingID());
    assertEquals(true, b.equals(fromDao));

    bookingDao.deleteBookingByID(b.getBookingID());

    fromDao = bookingDao.getBookingByID(b.getBookingID());
    assertNull(fromDao);
}
}