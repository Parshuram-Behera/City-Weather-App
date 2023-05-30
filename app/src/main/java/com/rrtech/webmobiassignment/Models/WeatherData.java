package com.rrtech.webmobiassignment.Models;

public class WeatherData {

    public current current;
    public condition condition;
    public location location;


    public WeatherData(com.rrtech.webmobiassignment.Models.current current, com.rrtech.webmobiassignment.Models.condition condition, com.rrtech.webmobiassignment.Models.location location) {
        this.current = current;
        this.condition = condition;
        this.location = location;
    }

    public com.rrtech.webmobiassignment.Models.current getCurrent() {
        return current;
    }

    public void setCurrent(com.rrtech.webmobiassignment.Models.current current) {
        this.current = current;
    }

    public com.rrtech.webmobiassignment.Models.condition getCondition() {
        return condition;
    }

    public void setCondition(com.rrtech.webmobiassignment.Models.condition condition) {
        this.condition = condition;
    }

    public com.rrtech.webmobiassignment.Models.location getLocation() {
        return location;
    }

    public void setLocation(com.rrtech.webmobiassignment.Models.location location) {
        this.location = location;
    }
}
