package com.rrtech.webmobiassignment.Models;

public class current {

    public int last_updated_epoch;
    public String last_updated;
    public double temp_c;
    public int is_day;
    public com.rrtech.webmobiassignment.Models.condition condition;
    public double wind_kph;
    public int pressure_mb;
    public int humidity;
    public int cloud;
    public double feelslike_c;
    public double feelslike_f;
    public int uv;

    public current(int last_updated_epoch, String last_updated, int temp_c, int is_day, com.rrtech.webmobiassignment.Models.condition condition, double wind_kph, int pressure_mb, int humidity, int cloud, int feelslike_c, double feelslike_f, int uv) {
        this.last_updated_epoch = last_updated_epoch;
        this.last_updated = last_updated;
        this.temp_c = temp_c;
        this.is_day = is_day;
        this.condition = condition;
        this.wind_kph = wind_kph;
        this.pressure_mb = pressure_mb;
        this.humidity = humidity;
        this.cloud = cloud;
        this.feelslike_c = feelslike_c;
        this.feelslike_f = feelslike_f;
        this.uv = uv;
    }

    public int getLast_updated_epoch() {
        return last_updated_epoch;
    }

    public void setLast_updated_epoch(int last_updated_epoch) {
        this.last_updated_epoch = last_updated_epoch;
    }

    public String getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(String last_updated) {
        this.last_updated = last_updated;
    }

    public double getTemp_c() {
        return temp_c;
    }

    public void setTemp_c(double temp_c) {
        this.temp_c = temp_c;
    }

    public int getIs_day() {
        return is_day;
    }

    public void setIs_day(int is_day) {
        this.is_day = is_day;
    }

    public com.rrtech.webmobiassignment.Models.condition getCondition() {
        return condition;
    }

    public void setCondition(com.rrtech.webmobiassignment.Models.condition condition) {
        this.condition = condition;
    }

    public double getWind_kph() {
        return wind_kph;
    }

    public void setWind_kph(double wind_kph) {
        this.wind_kph = wind_kph;
    }

    public int getPressure_mb() {
        return pressure_mb;
    }

    public void setPressure_mb(int pressure_mb) {
        this.pressure_mb = pressure_mb;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getCloud() {
        return cloud;
    }

    public void setCloud(int cloud) {
        this.cloud = cloud;
    }

    public double getFeelslike_c() {
        return feelslike_c;
    }

    public void setFeelslike_c(double feelslike_c) {
        this.feelslike_c = feelslike_c;
    }

    public double getFeelslike_f() {
        return feelslike_f;
    }

    public void setFeelslike_f(double feelslike_f) {
        this.feelslike_f = feelslike_f;
    }

    public int getUv() {
        return uv;
    }

    public void setUv(int uv) {
        this.uv = uv;
    }
}
