package ru.barsim.dto;

public class TimeAndEVN {
    private User usr;
    private String dt;
    private int evn;

    public TimeAndEVN() {
    }

    public TimeAndEVN(User usr, String dt, int evn) {
        this.usr = usr;
        this.dt = dt;
        this.evn = evn;
    }

    public User getUsr() {
        return usr;
    }

    public void setUsr(User usr) {
        this.usr = usr;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public int getEvn() {
        return evn;
    }

    public void setEvn(int evn) {
        this.evn = evn;
    }
}
