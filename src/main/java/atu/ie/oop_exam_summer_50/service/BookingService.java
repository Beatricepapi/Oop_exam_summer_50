package atu.ie.oop_exam_summer_50.service;

import atu.ie.oop_exam_summer_50.model.Booking;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service

public class BookingService {
    private final List <Booking> dates = new ArrayList<>();
    public Booking addBooking(Booking booking){
        dates.add(booking);
        return booking;
    }
    public List <Booking> getDates(){
        return dates;}
    public Booking getBooking(int id)
    {
        return dates.get(id);
    }
}
