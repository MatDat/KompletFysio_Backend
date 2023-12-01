package com.example.kompletfysio_backend.dto.availabilityInterval;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class AvailabilityInterval {

    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
