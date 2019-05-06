package com.crowdscout.dto;

import com.crowdscout.constants.RegionalLocation;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class ScoutLoginDTO{

    @JsonProperty("regional")
    private RegionalLocation regionalCode;
    @JsonProperty("team number")
    private int teamNumber;
    private String name;
    @JsonProperty("pass phrase")
    private String passPhrase;

    public ScoutLoginDTO(RegionalLocation regionalCode, int teamNumber, String name, String passPhrase) {
        this.regionalCode = regionalCode;
        this.teamNumber = teamNumber;
        this.name = name;
        this.passPhrase = passPhrase;
    }


    /**
     * @return the regionalCode
     */
    public RegionalLocation getRegionalCode() {
        return regionalCode;
    }

    /**
     * @return the passPhrase
     */
    public String getPassPhrase() {
        return passPhrase;
    }

    /**
     * @param passPhrase the passPhrase to set
     */
    public void setPassPhrase(String passPhrase) {
        this.passPhrase = passPhrase;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the teamNumber
     */
    public int getTeamNumber() {
        return teamNumber;
    }

    /**
     * @param teamNumber the teamNumber to set
     */
    public void setTeamNumber(int teamNumber) {
        this.teamNumber = teamNumber;
    }

    /**
     * @param regionalCode the regionalCode to set
     */
    public void setRegionalCode(RegionalLocation regionalCode) {
        this.regionalCode = regionalCode;
    }
}