package com.crowdscout.model.gameconfiguration.components;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class OneTimeActionPerRobot {
    @JsonProperty
    private String name;
    @JsonProperty("min attemptors")
    private int minAttemptors;
    @JsonProperty("max attemptors")
    private int maxAttemptors;
    @JsonProperty("points per succesful attempt")
    private int successPoints;

    public OneTimeActionPerRobot() {}

    public OneTimeActionPerRobot(String name, int minAttemptors, int maxAttemptors, int successPoints) {
        this.name = name;
        this.minAttemptors = minAttemptors;
        this.maxAttemptors = maxAttemptors;
        this.successPoints = successPoints;
    }

    /**
     * @return the sucessPoints
     */
    public int getSuccessPoints() {
        return successPoints;
    }

    /**
     * @param successPoints the sucessPoints to set
     */
    public void setSuccessPoints(int successPoints) {
        this.successPoints = successPoints;
    }

    /**
     * @return the minAttemptors
     */
    public int getMinAttemptors() {
        return minAttemptors;
    }

    /**
     * @param minAttemptors the minAttemptors to set
     */
    public void setMinAttemptors(int minAttemptors) {
        this.minAttemptors = minAttemptors;
    }

    /**
     * @return the maxAttemptors
     */
    public int getMaxAttemptors() {
        return maxAttemptors;
    }

    /**
     * @param maxAttemptors the maxAttemptors to set
     */
    public void setMaxAttemptors(int maxAttemptors) {
        this.maxAttemptors = maxAttemptors;
    }



    /**
     * @return the name
     */
    
    public String getName() {
        return name;
    }

    /**
     * @return the name
     */
    public void setName(String name) {
        this.name = name;
    }
}