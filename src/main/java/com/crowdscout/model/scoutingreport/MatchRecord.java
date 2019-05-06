package com.crowdscout.model.scoutingreport;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class MatchRecord {

    @JsonProperty("scouted team number")
    private int teamNumber;
    @JsonProperty("match number")
    private int matchNumber;
    private List<ReportedEvent> events;

    public MatchRecord(int teamNumber, int matchNumber, List<ReportedEvent> events){
        this.events = events;
        this.teamNumber = teamNumber;
        this.matchNumber = matchNumber;
    }

    public MatchRecord( List<ReportedEvent> events) {
        this.events = events;
    }

    public List<ReportedEvent> getEvents() {
        return events;
    }

    public void setEvents( List<ReportedEvent> events){
        this.events = events;
    }

    /**
     * @return the matchNumber
     */
    public int getMatchNumber() {
        return matchNumber;
    }

    /**
     * @return the teamNumber
     */
    public int getTeamNumber() {
        return teamNumber;
    }


    public void setMatchNumber(int matchNumber) {
        this.matchNumber = matchNumber;
    }

    public void setTeamNumber(int teamNumber) {
        this.teamNumber = teamNumber;
    }
}
