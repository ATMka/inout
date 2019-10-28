package ru.barsim.dto;

import java.util.List;

public class TimesInMonth {
    private int year;
    private int month;
    private List<TimeAndEVN> timeAndEVNS;

    public TimesInMonth() {
    }

    public TimesInMonth(int year, int month, List<TimeAndEVN> timeAndEVNS) {
        this.year = year;
        this.month = month;
        this.timeAndEVNS = timeAndEVNS;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public List<TimeAndEVN> getTimeAndEVNS() {
        return timeAndEVNS;
    }

    public void setTimeAndEVNS(List<TimeAndEVN> timeAndEVNS) {
        this.timeAndEVNS = timeAndEVNS;
    }
}
