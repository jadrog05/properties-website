package com.sg.propertyWebsite.Service;

import com.sg.propertyWebsite.daos.GuestDaoDB;
import com.sg.propertyWebsite.daos.PropertyDaoDB;
import com.sg.propertyWebsite.entities.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
public class BookingService {

    @Autowired
    PropertyDaoDB propertyDao;
    public Booking calculateTotalCost(Booking b){
        double perNight = propertyDao.getPropertyByID(b.getPropertiesID()).getPerNightCost();

        Date firstDate = b.getStartDate();
        Date secondDate = b.getEndDate();

        long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
        int diff =  (int) TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        double total = perNight * diff;
        b.setTotalCost(total);
        return b;
    }
}
