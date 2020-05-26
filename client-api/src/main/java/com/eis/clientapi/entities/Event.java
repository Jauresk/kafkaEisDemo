package com.eis.clientapi.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Event {
    private @Id @GeneratedValue int id;
    private String type;
    private String data;
    private String state;

    public Event(){}

    public Event(String type, String data, String state) {
        this.type = type;
        this.data = data;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
