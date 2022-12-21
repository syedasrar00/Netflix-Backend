package com.netflix.backend.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Otp {
    @Id
    @Column(name = "otp_id", updatable = false, nullable = false)
    private String otpId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String otpNumber;
    private String state;
    private Date createdAt;
    private String sentTo;

    public Otp() {
    }

    public String getOtpId() {
        return otpId;
    }

    public void setOtpId(String otpId) {
        this.otpId = otpId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getOtpNumber() {
        return otpNumber;
    }

    public void setOtpNumber(String otpNumber) {
        this.otpNumber = otpNumber;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getSentTo() {
        return sentTo;
    }

    public void setSentTo(String sentTo) {
        this.sentTo = sentTo;
    }
}
