package ru.barsim.dto;

import java.time.LocalDateTime;


public class User {
    private long id;
    private String FIO;
    private LocalDateTime dtMin;
    private LocalDateTime dtMax;

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

    public LocalDateTime getDtMin() {
        return dtMin;
    }

    public void setDtMin(LocalDateTime dtMin) {
        this.dtMin = dtMin;
    }

    public LocalDateTime getDtMax() {
        return dtMax;
    }

    public void setDtMax(LocalDateTime dtMax) {
        this.dtMax = dtMax;
    }
}
