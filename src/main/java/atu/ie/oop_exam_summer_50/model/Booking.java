package atu.ie.oop_exam_summer_50.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Booking {
    private Long Id;
    @NotBlank(message="Student Email is requiered")
    private String email;
    @Positive(message="Email must be not already used")
    private double date;
}
