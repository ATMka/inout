package ru.barsim.dto;

public class User {
    private long id;
    private String FIO;

    public User() {
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
}
