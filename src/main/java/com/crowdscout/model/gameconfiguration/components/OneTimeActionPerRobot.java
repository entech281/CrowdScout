package com.crowdscout.model.gameconfiguration.components;

public class OneTimeActionPerRobot{
    private final String name;

    private final int minAttemptors;
    private final int maxAttemptors;

    public OneTimeActionPerRobot( String name, int maxAttemptors ) {
        this.name = name;
        this.minAttemptors = 0;
        this.maxAttemptors = maxAttemptors;
    }

    public OneTimeActionPerRobot( String name, int minAttemptors, int maxAttemptors ) {
        this.name = name;
        this.minAttemptors = minAttemptors;
        this.maxAttemptors = maxAttemptors;
    }

    /**
     * @return the maxAttemptors
     */
    public int getMaxAttemptors() {
        return maxAttemptors;
    }

    /**
     * @return the minAttemptors
     */
    public int getMinAttemptors() {
        return minAttemptors;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
}