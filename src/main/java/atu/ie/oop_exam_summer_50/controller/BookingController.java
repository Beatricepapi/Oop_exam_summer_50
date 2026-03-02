package atu.ie.oop_exam_summer_50.controller;

import atu.ie.oop_exam_summer_50.model.Booking;
import atu.ie.oop_exam_summer_50.service.BookingService;
import jakarta.validation.Valid;
import org.hibernate.validator.internal.constraintvalidators.bv.time.futureorpresent.FutureOrPresentValidatorForDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.ReadOnlyFileSystemException;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/dates")

public class BookingController {
    private final BookingService bookingService;
    private final FutureOrPresentValidatorForDate date;

    public BookingController(BookingService bookingService, FutureOrPresentValidatorForDate date) {
        this.bookingService = bookingService;
        this.date = date;
    }

    @PostMapping
    public ResponseEntity<Booking> addBooking(@Valid @RequestBody Booking booking) {
        return new ResponseEntity<>(bookingService.addBooking(booking), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Booking>> getAllBooking(@Valid @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd")date date) {
        Booking booking = new Booking();
        if (date != null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(Collections.singletonList(booking));
    }
}
