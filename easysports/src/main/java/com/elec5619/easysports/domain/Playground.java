package com.elec5619.easysports.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Playground")
public class Playground implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="address")
    private String address;

    @Column(name="rating")
    private int rating;

    @Column(name="bookingRequired")
    private boolean bookingRequired;//0: true 1: false

    @Column(name="imageUrl")
    private String imageUrl;

    @Column(name="imageUrlE")
    private String imageUrlE;

    @Column(name="imageUrlP")
    private String imageUrlP;

    @Column(name="type")
    private String type;

    @Column(name="createTime")
    private Date createTime;

    private long distance;

    private String visitedTime;


    public String getImageUrlE() {
        return imageUrlE;
    }

    public String getImageUrlP() {
        return imageUrlP;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean isBookingRequired() {
        return bookingRequired;
    }

    public void setBookingRequired(boolean bookingRequired) {
        this.bookingRequired = bookingRequired;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getDistance() {
        return distance;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }
    public String getVisitedTime() {
        return visitedTime;
    }

    public void setVisitedTime(String visitedTime) {
        this.visitedTime = visitedTime;
    }

    @Override
    public String toString() {
        return "Playground{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", ratingId=" + rating +
                ", bookingRequired=" + bookingRequired +
                ", imageUrl='" + imageUrl + '\'' +
                ", type=" + type +
                ", createTime=" + createTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Playground that = (Playground) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
