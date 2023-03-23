package com.sg.propertyWebsite.daos;

import com.sg.propertyWebsite.entities.Guest;
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
public class GuestDaoDB implements GuestDao {
    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public Guest getGuestByID(int id) {
        try {
            String SELECT_GUEST_BY_ID = "SELECT * FROM Guests WHERE guestID = ?;";
            Guest guest = jdbc.queryForObject(SELECT_GUEST_BY_ID, new GuestMapper(), id);
            return guest;
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public Guest getGuestByEmail(String email) {
        try {
            String SELECT_GUEST_BY_EMAIL = "SELECT * FROM Guests WHERE email = ?;";
            Guest guest = jdbc.queryForObject(SELECT_GUEST_BY_EMAIL, new GuestMapper(), email);
            return guest;
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Guest> getAllGuests() {
        try {
            String SELECT_ALL_GUESTS = "SELECT * FROM Guests;";
            List<Guest> guests = jdbc.query(SELECT_ALL_GUESTS, new GuestMapper());
            return guests;
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    @Transactional
    public Guest addGuest(Guest guest) {
        try {
            String INSERT_GUEST = "INSERT INTO Guests(firstName, lastName, email, postcode, phoneNumber) VALUES(?,?,?,?,?);";
            jdbc.update(INSERT_GUEST,
                    guest.getFirstName(),
                    guest.getLastName(),
                    guest.getEmail(),
                    guest.getPostcode(),
                    guest.getPhoneNumber());
            int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
            guest.setGuestID(newId);
            return guest;
        } catch (DataAccessException | NullPointerException e) {
            return null;
        }
    }

    @Override
    public void updateGuest(Guest guest) {
        try {
            String UPDATE_GUEST = "UPDATE Guests SET firstName = ?, lastName = ?, email = ?, postcode = ?, phoneNumber = ?"
                    + "WHERE guestID = ?;";
            jdbc.update(UPDATE_GUEST,
                    guest.getFirstName(),
                    guest.getLastName(),
                    guest.getEmail(),
                    guest.getPostcode(),
                    guest.getPhoneNumber(),
                    String.valueOf(guest.getGuestID()));
        } catch (DataAccessException e) {
            System.out.println("Error updating Guest");
        }
    }

    @Override
    public void deleteGuestByID(int id) {
        try {
            String DELETE_GUEST = "DELETE FROM Guests WHERE guestID = ?;";
            jdbc.update(DELETE_GUEST, id);
        } catch (DataAccessException e) {
            System.out.println("Error deleting guest");
        }
    }

    public static final class GuestMapper implements RowMapper<Guest> {
        @Override
        public Guest mapRow(ResultSet rs, int index) throws SQLException {
            Guest guest = new Guest();
            guest.setGuestID(rs.getInt("guestID"));
            guest.setFirstName(rs.getString("firstName"));
            guest.setLastName(rs.getString("lastName"));
            guest.setEmail(rs.getString("email"));
            guest.setPostcode(rs.getString("postcode"));
            guest.setPhoneNumber(rs.getString("phoneNumber"));
            return guest;
        }
    }
}
