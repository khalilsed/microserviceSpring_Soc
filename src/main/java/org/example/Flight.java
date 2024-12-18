package org.example;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import lombok.Data;

@Data
@XmlRootElement
@XmlType(propOrder = {"id", "year", "month", "day", "depDelay", "arrDelay", "origin", "dest", "airTime", "distance", "hour", "minute", "name"})
public class Flight {
    private Long id;
    private int year;
    private int month;
    private int day;
    private int depDelay;
    private int arrDelay;
    private String origin;
    private String dest;
    private int airTime;
    private int distance;
    private int hour;
    private int minute;
    private String name;

    // Optionally, you can add @XmlElement to each field to specify how they should be serialized in XML
    @XmlElement
    public Long getId() {
        return id;
    }

    @XmlElement
    public int getYear() {
        return year;
    }

    @XmlElement
    public int getMonth() {
        return month;
    }

    @XmlElement
    public int getDay() {
        return day;
    }

    @XmlElement
    public int getDepDelay() {
        return depDelay;
    }

    @XmlElement
    public int getArrDelay() {
        return arrDelay;
    }

    @XmlElement
    public String getOrigin() {
        return origin;
    }

    @XmlElement
    public String getDest() {
        return dest;
    }

    @XmlElement
    public int getAirTime() {
        return airTime;
    }

    @XmlElement
    public int getDistance() {
        return distance;
    }

    @XmlElement
    public int getHour() {
        return hour;
    }

    @XmlElement
    public int getMinute() {
        return minute;
    }

    @XmlElement
    public String getName() {
        return name;
    }
}