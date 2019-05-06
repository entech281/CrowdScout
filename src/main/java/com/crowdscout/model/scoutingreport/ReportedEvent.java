package com.crowdscout.model.scoutingreport;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class ReportedEvent{

    @JsonProperty("type")
    private String name;
    @JsonProperty("started")
    private double startedTime;
    private double duration;

    public ReportedEvent(String name, double started, double duration) {
        this.name = name;
        this.startedTime = started;
        this.duration = duration;
    }

    /**
     * @return the duration
     */
    public double getDuration() {
        return duration;
    }

    /**
     * @return the started time of the event
     */
    public double getStartedTime() {
        return startedTime;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

     /**
     * @return the duration
     */
    public void setDuration(double duration) {
        this.duration = duration;
    }

    /**
     * @return the started time of the event
     */
    public void setStartedTime(double startedTime) {
        this.startedTime = startedTime;
    }

    /**
     * @return the name
     */
    public void setName(String name) {
        this.name = name;
    }
}