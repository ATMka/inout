package ru.barsim.dto;

import java.util.Map;

public class User {
    private long id;
    private String FIO;
    private Map<String,Integer> timesAndEVN;

    public User() {
    }

    public User(long id) {
        this.id = id;
    }

    public User(long id, String FIO) {
        this.id = id;
        this.FIO = FIO;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public Map<String, Integer> getTimesAndEVN() {
        return timesAndEVN;
    }

    public void setTimesAndEVN(Map<String, Integer> timesAndEVN) {
        this.timesAndEVN = timesAndEVN;
    }
}
