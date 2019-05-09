package com.crowdscout.model.gameconfiguration.components;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class GameResourceDestination{

    private String name;
    private String resource;
    @JsonProperty("min")
    private int minAmount;
    @JsonProperty("max")
    private int maxAmount;
    @JsonProperty("points per placement")
    private int pointsPerPlacement;

    public GameResourceDestination(){}

    public GameResourceDestination(String name, String resource, int minAmount, int maxAmount, int pointsPerPlacement) {
        this.name = name;
        this.resource = resource;
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
        this.pointsPerPlacement = pointsPerPlacement;
    }

    /**
     * @return the pointsPerPlacement
     */
    public int getPointsPerPlacement() {
        return pointsPerPlacement;
    }

    /**
     * @param pointsPerPlacement the pointsPerPlacement to set
     */
    public void setPointsPerPlacement(int pointsPerPlacement) {
        this.pointsPerPlacement = pointsPerPlacement;
    }

    /**
     * @return the maxAmount
     */
    public int getMaxAmount() {
        return maxAmount;
    }

    /**
     * @param maxAmount the maxAmount to set
     */
    public void setMaxAmount(int maxAmount) {
        this.maxAmount = maxAmount;
    }

    /**
     * @return the minAmount
     */
    public int getMinAmount() {
        return minAmount;
    }

    /**
     * @param minAmount the minAmount to set
     */
    public void setMinAmount(int minAmount) {
        this.minAmount = minAmount;
    }

    /**
     * @return the resource
     */
    public String getResource() {
        return resource;
    }

    /**
     * @param resourceType the resourceType to set
     */
    public void setResource(String resource) {
        this.resource = resource;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
