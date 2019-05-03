package com.crowdscout.model.gameconfiguration.components;


public class GameResourceDestination{

    private final String resourceName;
    private final String resourceType;
    private final int minAmount;
    private final int maxAmount;

    public GameResourceDestination( String resourceName, String resourceType, int minAmount, int maxAmount) {
        this.resourceName = resourceName;
        this.resourceType = resourceType;
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
    }

    /**
     * @return the maxAmount
     */
    public int getMaxAmount() {
        return maxAmount;
    }

    /**
     * @return the minAmount
     */
    public int getMinAmount() {
        return minAmount;
    }

    /**
     * @return the resourceType
     */
    public String getResourceType() {
        return resourceType;
    }

    /**
     * @return the resourceName
     */
    public String getResourceName() {
        return resourceName;
    }


}
