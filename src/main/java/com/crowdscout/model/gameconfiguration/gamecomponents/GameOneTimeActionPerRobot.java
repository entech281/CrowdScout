package com.crowdscout.model.gameconfiguration.gamecomponents;

public class GameOneTimeActionPerRobot{
    private String name;

    private int minAttemptors;
    private int maxAttemptors;

    public GameOneTimeActionPerRobot( String name, int maxAttemptors ) {
        this.name = name;
        this.maxAttemptors = maxAttemptors;
    }

    public GameOneTimeActionPerRobot( String name, int minAttemptors, int maxAttemptors ) {
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