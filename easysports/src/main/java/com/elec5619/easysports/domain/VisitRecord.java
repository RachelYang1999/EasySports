package com.elec5619.easysports.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "VisitRecord")
public class VisitRecord implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="userId")
    private int userId;

    @Column(name="playgroundId")
    private int playgroundId;

    @Column(name="createTime")
    private Date createTime;

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "VisitRecord{" +
                "id=" + id +
                ", userId=" + userId +
                ", playgroundId=" + playgroundId +
                ", createTime=" + createTime +
                '}';
    }
}
