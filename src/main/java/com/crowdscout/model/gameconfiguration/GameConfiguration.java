package com.crowdscout.model.gameconfiguration;

import com.crowdscout.model.gameconfiguration.components.OneTimeActionPerRobot;
import com.crowdscout.model.gameconfiguration.components.ResourceMap;
import com.crowdscout.model.gameconfiguration.components.GameResourceDestination;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.List;
import java.util.ArrayList;

@JsonAutoDetect
public class GameConfiguration {

    private static final String CONFIG_FILE_NAME = "Season Config Files/GameConfig.json";

    @JsonProperty("resource destinations")
    private List<GameResourceDestination> resourceDestinations = new ArrayList<>();
    @JsonProperty("start actions")
    private List<OneTimeActionPerRobot> startActions = new ArrayList<>();
    @JsonProperty("endgame actions")
    private List<OneTimeActionPerRobot> endgameActions = new ArrayList<>();
    @JsonProperty
    private ResourceMap<Integer> resources = new ResourceMap<>();
    @JsonProperty
    private List<String> assistables = new ArrayList<>();
    @JsonProperty("periods")
    private ResourceMap<Integer> gamePeriods = new ResourceMap<>();

    private static GameConfiguration defaultConfiguration;

    private GameConfiguration() {

    }

    /**
     * @return the startActions
     */
    public List<OneTimeActionPerRobot> getStartActions() {
        return startActions;
    }

    /**
     * @param startActions the startActions to set
     */
    public void setStartActions(List<OneTimeActionPerRobot> startActions) {
        this.startActions = startActions;
    }

    /**
     * @return the gamePeriods
     */
    
    public ResourceMap<Integer> getGamePeriods() {
        return gamePeriods;
    }

    /**
     * @param gamePeriods the gamePeriods to set
     */
    public void setGamePeriods(ResourceMap<Integer> gamePeriods) {
        this.gamePeriods = gamePeriods;
    }

    /**
     * @return the assistables
     */
    public List<String> getAssistables() {
        return assistables;
    }

    /**
     * @param assistables the assistables to set
     */
    public void setAssistables(List<String> assistables) {
        this.assistables = assistables;
    }

    /**
     * @return the resources
     */
    public ResourceMap<Integer> getResources() {
        return resources;
    }

    /**
     * @param resources the resources to set
     */
    public void setResources(ResourceMap<Integer> resources) {
        this.resources = resources;
    }

    /**
     * @return the endgameActions
     */
    public List<OneTimeActionPerRobot> getEndgameActions() {
        return endgameActions;
    }

    /**
     * @param endgameActions the endgameActions to set
     */
    public void setEndgameActions(List<OneTimeActionPerRobot> endgameActions) {
        this.endgameActions = endgameActions;
    }

    /**
     * @return the resourceDestinations
     */
    public List<GameResourceDestination> getResourceDestinations() {
        return resourceDestinations;
    }

    /**
     * @param resourceDestinations the resourceDestinations to set
     */
    public void setResourceDestinations(List<GameResourceDestination> resourceDestinations) {
        this.resourceDestinations = resourceDestinations;
    }

    public static GameConfiguration loadDefaultConfigJson() throws FileNotFoundException, IOException {
        return loadConfigJson(System.getProperty("user.dir") + "/" + CONFIG_FILE_NAME);
    }

    public static GameConfiguration loadConfigJson(String filename) throws  FileNotFoundException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(filename), GameConfiguration.class);
    }

    public static GameConfiguration getDefaultConfiguration() throws FileNotFoundException,IOException {
        if (defaultConfiguration == null) {
           defaultConfiguration = GameConfiguration.loadDefaultConfigJson();
        }
        return defaultConfiguration;
    }
}