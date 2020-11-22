package com.elec5619.easysports.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Booking")
public class Booking implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="userId")
    private int userId;

    @Column(name="playgroundId")
    private int playgroundId;

    @Column(name="timePeriodId")
    private int timePeriodId;

    @Column(name="status")
    private String status; // Canceled Modified Created...

    @Column(name="createTime")
    private Date createTime;

    private String playgroundname;

    private String bookingdate;

    private String timeperiod;

    private String playgroundimage;


    public String getPlaygroundimage() {
        return playgroundimage;
    }

    public void setPlaygroundimage(String playgroundimage) {
        this.playgroundimage = playgroundimage;
    }

    public void setTimeperiod(int timeperiod) {
        String time="";
        if (timeperiod==1){
            time="9:00 - 11:00";
        }
        if (timeperiod==2){
            time="11:00 - 13:00";
        }
        if (timeperiod==3){
            time="13:00 - 15:00";
        }
        if (timeperiod==4){
            time="15:00 - 17:00";
        }
        if (timeperiod==5){
            time="17:00 - 19:00";
        }

        this.timeperiod = time;
    }

    public String getTimeperiod() {
        return timeperiod;
    }

    public String getBookingdate() {
        return bookingdate;
    }

    public void setBookingdate(String bookingdate) {
        this.bookingdate = bookingdate;
    }

    public String getPlaygroundname() {
        return playgroundname;
    }

    public void setPlaygroundname(String playgroundname) {
        this.playgroundname = playgroundname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPlaygroundId() {
        return playgroundId;
    }

    public void setPlaygroundId(int playgroundId) {
        this.playgroundId = playgroundId;
    }

    public int getTimePeriodId() {
        return timePeriodId;
    }

    public void setTimePeriodId(int timePeriodId) {
        this.timePeriodId = timePeriodId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
