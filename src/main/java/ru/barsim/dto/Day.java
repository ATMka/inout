package ru.barsim.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Day {
    private LocalDate date;
    private LocalTime startDay;
    private LocalTime endDay;

    public Day() {
    }

    public Day(LocalDate date, LocalTime startDay, LocalTime endDay) {
        this.date = date;
        this.startDay = startDay;
        this.endDay = endDay;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStartDay() {
        return startDay;
    }

    public void setStartDay(LocalTime startDay) {
        this.startDay = startDay;
    }

    public LocalTime getEndDay() {
        return endDay;
    }

    public void setEndDay(LocalTime endDay) {
        this.endDay = endDay;
    }
}
