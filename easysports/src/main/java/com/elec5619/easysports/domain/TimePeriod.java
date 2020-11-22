package com.elec5619.easysports.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TimePeriod")
public class TimePeriod implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="playgroundId")
    private int playgroundId;

    @Column(name="bookingId")
    private int bookingId;

    @Column(name="isAvailable")
    private boolean isAvailable;

    @Column(name="timeType")
    private int timeType;

    @Column(name="day")
    private String day;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlaygroundId() {
        return playgroundId;
    }

    public void setPlaygroundId(int courtId) {
        this.playgroundId = courtId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }


    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getTimeType() {
        return timeType;
    }

    public void setTimeType(int timeType) {
        this.timeType = timeType;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "TimePeriod{" +
                "id=" + id +
                ", playgroundId=" + playgroundId +
                ", bookingId=" + bookingId +
                ", isAvailable=" + isAvailable +
                ", timeType=" + timeType +
                ", day=" + day +
                '}';
    }
}
