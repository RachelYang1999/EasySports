package com.elec5619.easysports.domain;
import java.util.Date;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "User")
public class User implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="userName")
    private String userName;

    @Column(name="email")
    private String email;

    @Column(name="address")
    private String address;

    @Column(name="password")
    private String password;

    @Column(name="type")
    private String type; // Normal user or Admin

    @Column(name="description")
    private String description;

    @Column(name="securityQuestion")
    private String securityQuestion;

    @Column(name="answer")
    private String answer;

    @Column(name="createTime")
    private Date createTime;

    @Column(name="fbURL")
    private String fbURL;

    @Column(name="twitterURL")
    private String twitterURL;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getFbURL() {
        return fbURL;
    }

    public void setFbURL(String fbURL) {
        this.fbURL = fbURL;
    }

    public String getTwitterURL() {
        return twitterURL;
    }

    public void setTwitterURL(String twitterURL) {
        this.twitterURL = twitterURL;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", securityQuestion='" + securityQuestion + '\'' +
                ", answer='" + answer + '\'' +
                ", createTime=" + createTime + '\'' +
                ", fbURL='" + fbURL + '\'' +
                ", twitterURL='" + twitterURL +
                '}';
    }
}
