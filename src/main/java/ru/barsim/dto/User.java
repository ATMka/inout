package ru.barsim.dto;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class User {
    private long id;
    private String FIO;
    private HashMap<LocalDate,String> dtMin;
    private HashMap<LocalDate,String> dtMax;

    public User(long id) {
        this.id = id;
    }

    public User(long id, String FIO) {
        this.id = id;
        this.FIO = FIO;
    }

    public User() {
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

    public HashMap<LocalDate, String> getDtMin() {
        return dtMin;
    }

    public void setDtMin(HashMap<LocalDate, String> dtMin) {
        this.dtMin = dtMin;
    }

    public HashMap<LocalDate, String> getDtMax() {
        return dtMax;
    }

    public void setDtMax(HashMap<LocalDate, String> dtMax) {
        this.dtMax = dtMax;
    }
}
