package com.example.kompletfysio_backend.service;

import com.example.kompletfysio_backend.dto.availabilityInterval.AvailabilityInterval;
import com.example.kompletfysio_backend.dto.timeslot.Timeslot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GeneralAvailabilityServiceTest {

    @Autowired
    GeneralAvailabilityService generalAvailabilityService;

    int employeeID = 1;
    int duration = 30;
    List<AvailabilityInterval> availabilityIntervalList = new ArrayList<>();

    LocalDateTime startTime = LocalDateTime.of(2021, 12, 24, 9, 0);
    LocalDateTime endTime = LocalDateTime.of(2021, 12, 24, 10, 0);
    AvailabilityInterval availabilityInterval1 = new AvailabilityInterval(startTime, endTime, employeeID);

    @BeforeEach
    public void initData() {
        //ARRANGE
        availabilityIntervalList.add(availabilityInterval1);
    }

    @Test
    public void test1Hour() {
        List<Timeslot> timeslotList = new ArrayList<>();
        timeslotList.add(new Timeslot(1, "9:00"));
        timeslotList.add(new Timeslot(1, "9:30"));

        List<Timeslot> actual = generalAvailabilityService
                .getAvailableTimeslots(availabilityIntervalList, 30, 1);

        assertEquals(timeslotList.size(),actual.size());
        assertEquals(timeslotList.get(0).getTimeSlot(),actual.get(0).getTimeSlot());
        assertEquals(timeslotList.get(1).getTimeSlot(),actual.get(1).getTimeSlot());
    }

    @Test
    public void testTooLongDuration(){
        //ACT
        List<Timeslot> expected = new ArrayList<>();
        List<Timeslot> actual = generalAvailabilityService
                .getAvailableTimeslots(availabilityIntervalList, 90, 1);
        //ASSERT
        assertEquals(expected.size(), actual.size());

        //kommentar
        fail();

    }




//    List<Timeslot> getAvailableTimeslots(List<AvailabilityInterval> list, int duration, int employeeID)

}