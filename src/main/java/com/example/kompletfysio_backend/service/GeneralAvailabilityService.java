package com.example.kompletfysio_backend.service;

import com.example.kompletfysio_backend.dto.availabilityInterval.AvailabilityInterval;
import com.example.kompletfysio_backend.dto.timeslot.Timeslot;
import com.example.kompletfysio_backend.model.GeneralAvailabilityEntity;
import com.example.kompletfysio_backend.model.UnavailableEntity;
import com.example.kompletfysio_backend.model.enumPackage.DayOfWeek;
import com.example.kompletfysio_backend.repository.GeneralAvailabilityRepository;

import com.example.kompletfysio_backend.repository.UnavailableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class GeneralAvailabilityService {
    @Autowired
    GeneralAvailabilityRepository generalAvailabilityRepository;
    @Autowired
    UnavailableRepository unavailableRepository;


    public List<AvailabilityInterval> getAvailabilityFromEmployeeAndDate(int employeeId, LocalDate date) {
        Optional<GeneralAvailabilityEntity> gAEntity = generalAvailabilityRepository
                .findByDayOfWeekAndEmployeeEmployeeId(convertToDayOfWeek(date), employeeId);

        if (gAEntity.isEmpty()) {
            //handle expeption
        }

        Optional<List<UnavailableEntity>> optUnavailableEntities = unavailableRepository
                .findByEmployee_EmployeeIdAndStartTimeLessThanEqualAndEndTimeGreaterThanEqualOrderByStartTime(
                        employeeId,
                        date.atTime(LocalTime.MAX),
                        date.atStartOfDay()
                );

        List<AvailabilityInterval> availabilityIntervals = new ArrayList<>();
        LocalDateTime startTime = gAEntity.get().getStartTime();
        LocalDateTime endTime = gAEntity.get().getEndTime();

        if (optUnavailableEntities.isPresent()) {
            System.out.println("TESTATVIKOMMERIND");
            List<UnavailableEntity> unavailableEntities = optUnavailableEntities.get();

            for (UnavailableEntity unavailableEntity : unavailableEntities) {
                if (unavailableEntity.getStartTime().isEqual(startTime)) {
                    if (unavailableEntity.getEndTime().isAfter(endTime) || unavailableEntity.getEndTime().isEqual(endTime)) {
                        return null;
                    }
                    startTime = unavailableEntity.getEndTime();
                    continue;
                }
                availabilityIntervals.add(new AvailabilityInterval(startTime, unavailableEntity.getStartTime(),employeeId));
                if (unavailableEntity.getEndTime().isBefore(gAEntity.get().getEndTime())) {
                    startTime = unavailableEntity.getEndTime();
                } else {
                    availabilityIntervals.add(new AvailabilityInterval(startTime, gAEntity.get().getEndTime(),employeeId));
                    break;
                }
            }
        }
        availabilityIntervals.add(new AvailabilityInterval(startTime, endTime,employeeId));

        for (int i = 0; i < availabilityIntervals.size(); i++) {
            System.out.println(availabilityIntervals.get(i));
        }

        return availabilityIntervals;
    }

    public List<Timeslot> getAvailableTimeslots(List<AvailabilityInterval> list, int duration, int employeeID) {
        List<String> timeslots = new ArrayList<>();
        System.out.println("duration: " + duration);

        for (int i = 0; i < list.size(); i++) {
            LocalDateTime slot = list.get(i).getStartTime();
            boolean toAddSlot = true;

            while (toAddSlot) {
                if (slot.plusMinutes(duration - 1).isBefore(list.get(i).getEndTime())) {
                    String availableSlot = slot.getHour() + ":" + (slot.getMinute() == (0) ? "00" : slot.getMinute());
                    timeslots.add(availableSlot);
                    slot = slot.plusMinutes(duration);
                    //System.out.println("duration = " + slot.plusMinutes(duration));
                } else {
                    toAddSlot = false;
                }
            }

        }

        System.out.println(timeslots);
        List<Timeslot> timeslotList = new ArrayList<>();
        for (int i = 0; i < timeslots.size(); i++) {
            timeslotList.add(new Timeslot(employeeID, timeslots.get(i)));
        }
        return timeslotList;
    }

    private DayOfWeek convertToDayOfWeek(LocalDate date) {

        return switch (date.getDayOfWeek()) {
            case MONDAY -> DayOfWeek.MONDAY;
            case TUESDAY -> DayOfWeek.TUESDAY;
            case WEDNESDAY -> DayOfWeek.WEDNESDAY;
            case THURSDAY -> DayOfWeek.THURSDAY;
            case FRIDAY -> DayOfWeek.FRIDAY;
            case SATURDAY -> DayOfWeek.SATURDAY;
            case SUNDAY -> DayOfWeek.SUNDAY;
        };
    }


}
