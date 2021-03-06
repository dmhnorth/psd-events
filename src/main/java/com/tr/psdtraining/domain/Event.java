package com.tr.psdtraining.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Made by kris n' dave lol, on 21/06/2016.
 */
@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue
    private Long id = null;

    private String location;

    private Date time;

    private User owner;

    private String locationDetails;

    @OneToMany
    private List<User> participants;

    public Event() {
        // default constructor
    }

    public Event(String location, Date time, User owner, String locationDetails) {
        this.location = location;
        this.time = time;
        this.owner = owner;
        this.locationDetails = locationDetails;
        this.participants = new ArrayList<>();

    }

    public void addParticipant(User user) {
        participants.add(user);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocationDetails() {
        return locationDetails;
    }

    public void setLocationDetails(String locationDetails) {
        this.locationDetails = locationDetails;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public List<User> getParticipants() {
        return participants;
    }

}
