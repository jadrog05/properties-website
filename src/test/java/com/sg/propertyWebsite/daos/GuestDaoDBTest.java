package com.sg.propertyWebsite.daos;

import com.sg.propertyWebsite.entities.Guest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class GuestDaoDBTest {

    @Autowired
    GuestDaoDB guestDao;

    @BeforeEach
    void setUp() {
        List<Guest> guests = guestDao.getAllGuests();
        if (guests.size()>0){
            for(Guest guest: guests){
                guestDao.deleteGuestByID(guest.getGuestID());
            }
        }
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testAddAndGetGuest(){
        Guest guest = new Guest();
        guest.setFirstName("Test first name");
        guest.setLastName("Test last name");
        guest.setEmail("test@email.com");
        guest.setPostcode("tEstC0De");
        guest.setPhoneNumber("TestPhone");
        guest = guestDao.addGuest(guest);

        Guest fromDao = guestDao.getGuestByID(guest.getGuestID());

        assertEquals(true, fromDao.equals(guest));
    }

    @Test
    void testGetAllGuests(){
        Guest guest = new Guest();
        guest.setFirstName("Test first name");
        guest.setLastName("Test last name");
        guest.setEmail("test@email.com");
        guest.setPostcode("tEstC0De");
        guest.setPhoneNumber("TestPhone");
        guest = guestDao.addGuest(guest);

        Guest guest2 = new Guest();
        guest2.setFirstName("Test first name 2");
        guest2.setLastName("Test last name 2");
        guest2.setEmail("test@email.com 2");
        guest2.setPostcode("tEstC0De 2");
        guest2.setPhoneNumber("TestPhone 2");
        guest2 = guestDao.addGuest(guest2);

        List<Guest> guests = guestDao.getAllGuests();

        assertEquals(2, guests.size());
        assertEquals(true, guests.contains(guest));
        assertEquals(true, guests.contains(guest2));
    }

    @Test
    void testUpdateGuest(){
        Guest guest = new Guest();
        guest.setFirstName("Test first name");
        guest.setLastName("Test last name");
        guest.setEmail("test@email.com");
        guest.setPostcode("tEstC0De");
        guest.setPhoneNumber("TestPhone");
        guest = guestDao.addGuest(guest);

        Guest fromDao = guestDao.getGuestByID(guest.getGuestID());
        assertEquals(true, guest.equals(fromDao));

        guest.setFirstName("Updated first name");
        guestDao.updateGuest(guest);

        assertNotEquals(fromDao, guest);

        fromDao = guestDao.getGuestByID(guest.getGuestID());
        assertEquals(guest.getFirstName(),fromDao.getFirstName());
    }

    @Test
    void testDeleteGuest(){
        Guest guest = new Guest();
        guest.setFirstName("Test first name");
        guest.setLastName("Test last name");
        guest.setEmail("test@email.com");
        guest.setPostcode("tEstC0De");
        guest.setPhoneNumber("TestPhone");
        guest = guestDao.addGuest(guest);

        Guest fromDao = guestDao.getGuestByID(guest.getGuestID());
        assertEquals(true, guest.equals(fromDao));

        guestDao.deleteGuestByID(guest.getGuestID());

        fromDao = guestDao.getGuestByID(guest.getGuestID());
        assertNull(fromDao);
    }
}