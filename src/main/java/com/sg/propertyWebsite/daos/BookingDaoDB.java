package com.sg.propertyWebsite.daos;

import com.sg.propertyWebsite.entities.Booking;
import com.sg.propertyWebsite.entities.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
public class BookingDaoDB implements BookingDao {
    @Autowired
    JdbcTemplate jdbc;

    @Override
    public Booking getBookingByID(int id) {
        try {
            String SELECT_BOOKING_BY_ID = "SELECT * FROM Bookings WHERE bookingID = ?;";
            Booking booking = jdbc.queryForObject(SELECT_BOOKING_BY_ID, new BookingDaoDB.BookingMapper(), id);
            return booking;
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public Booking getBookingByGuestId(int id) {
        try {
            String SELECT_BOOKING_BY_GUEST_ID = "SELECT * FROM Bookings WHERE guestID = ?;";
            Booking booking = jdbc.queryForObject(SELECT_BOOKING_BY_GUEST_ID, new BookingDaoDB.BookingMapper(), id);
            return booking;
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Booking> getAllBooking() {
        try {
            String SELECT_ALL_BOOKINGS = "SELECT * FROM Bookings;";
            List<Booking> bookings = jdbc.query(SELECT_ALL_BOOKINGS, new BookingMapper());
            return bookings;
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public Booking addBooking(Booking booking) {
        try {
            String INSERT_BOOKING = "INSERT INTO Bookings(propertiesID, guestID, numberOfGuests, startDate, endDate, totalCost)" +
                    "VALUES (?,?,?,?,?,?);";
            jdbc.update(INSERT_BOOKING,
                    String.valueOf(booking.getPropertiesID()),
                    String.valueOf(booking.getGuestID()),
                    String.valueOf(booking.getNumberOfGuests()),
                    dateFormatter(booking.getStartDate()),
                    dateFormatter(booking.getEndDate()),
                    String.valueOf(booking.getTotalCost()));
            int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
            booking.setBookingID(newId);
            return booking;
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public void updateBooking(Booking booking) {
        try {
            String UPDATE_BOOKING = "UPDATE Bookings SET propertiesID = ?, guestID = ?, numberOfGuests = ?, startDate = ?, " +
                    "endDate = ?, totalCost = ? WHERE bookingID = ?;";
            jdbc.update(UPDATE_BOOKING,
                    String.valueOf(booking.getPropertiesID()),
                    String.valueOf(booking.getGuestID()),
                    String.valueOf(booking.getNumberOfGuests()),
                    dateFormatter(booking.getStartDate()),
                    dateFormatter(booking.getEndDate()),
                    String.valueOf(booking.getTotalCost()),
                    String.valueOf(booking.getBookingID()));
        } catch (DataAccessException e) {
            System.out.println("Error updating booking");
        }
    }

    @Override
    public void deleteBookingByID(int id) {
        try {
            String DELETE_BOOKING = "DELETE FROM Bookings WHERE bookingID = ?";
            jdbc.update(DELETE_BOOKING, id);
        } catch (DataAccessException e) {
            System.out.println("Error deleting booking");
        }
    }

    public static String dateFormatter(Date date) {
        SimpleDateFormat mdyFormat = new SimpleDateFormat("yyyy-MM-dd");
        return mdyFormat.format(date);
    }

    public static final class BookingMapper implements RowMapper<Booking> {
        @Override
        public Booking mapRow(ResultSet rs, int index) throws SQLException {
            Booking booking = new Booking();
            booking.setBookingID(rs.getInt("bookingID"));
            booking.setNumberOfGuests(rs.getInt("numberOfGuests"));
            booking.setGuestID(rs.getInt("guestID"));
            booking.setStartDate(rs.getDate("startDate"));
            booking.setEndDate(rs.getDate("endDate"));
            booking.setTotalCost(rs.getDouble("totalCost"));
            booking.setPropertiesID(rs.getInt("propertiesID"));
            return booking;
        }
    }
}
