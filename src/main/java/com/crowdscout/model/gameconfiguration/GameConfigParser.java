package com.crowdscout.model.gameconfiguration;

import com.crowdscout.model.gameconfiguration.components.OneTimeActionPerRobot;
import com.crowdscout.model.gameconfiguration.components.GameResourceDestination;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Files;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GameConfigParser {

    private final String CONFIG_FILE_NAME = "Season Config Files/GameConfig.json";
    private List<GameResourceDestination> resourceDestinations = new ArrayList<GameResourceDestination>();
    private List<OneTimeActionPerRobot> actions = new ArrayList<OneTimeActionPerRobot>();
    private Map<String, Integer> resources = new HashMap<String, Integer>();

    public GameConfigParser() throws JSONException, FileNotFoundException, IOException {
        loadDefaultConfigJson();
    }

    public void loadDefaultConfigJson() throws FileNotFoundException, JSONException, IOException {
        loadConfigJson(System.getProperty("user.dir") + "/" + CONFIG_FILE_NAME);
    }

    public void loadConfigJson(String filename) throws JSONException, FileNotFoundException, IOException {
        String fileContent = new String(Files.readAllBytes(Paths.get(filename)));

        JSONObject gameConfigObject = new JSONObject(fileContent);
        JSONArray gameResourceArray = (JSONArray) gameConfigObject.get("resources");

        for(int i = 0; i < gameResourceArray.length(); i ++){
            JSONObject currentObj = gameResourceArray.getJSONObject(i);
            resources.put(currentObj.getString("name"), currentObj.getInt("max"));
        }

        JSONArray allowableGameActions = (JSONArray) gameConfigObject.get("game actions");

        for (int i = 0; i < allowableGameActions.length(); i++) {
            JSONObject currentObj = allowableGameActions.getJSONObject(i);
            switch (currentObj.getString("type")) {
                case "resource destination":
                    GameResourceDestination g = new GameResourceDestination(
                        currentObj.getString("name"), 
                        currentObj.getString("resource"), 
                        currentObj.getInt("min"), 
                        currentObj.getInt("max")
                    );
                    resourceDestinations.add(g);
                    break;
                case "one time action":
                    OneTimeActionPerRobot gota;
                    if (currentObj.has("min attemptors")){
                        gota = new OneTimeActionPerRobot(
                            currentObj.getString("name"),
                            currentObj.getInt("min attemptors"), 
                            currentObj.getInt("max attemptors")
                        );
                    }
                    else{
                        gota = new OneTimeActionPerRobot(
                            currentObj.getString("name"), 
                            currentObj.getInt("max attemptors")
                        );
                    }
                    actions.add(gota);
                }
            }
    }

    /**
     * @return the resources
     */
    public Map<String, Integer> getResources() {
        return resources;
    }

    /**
     * @param resources the resources to set
     */
    public void setResources(Map<String, Integer> resources) {
        this.resources = resources;
    }

    /**
     * @return the actions
     */
    public List<OneTimeActionPerRobot> getActions() {
        return actions;
    }

    /**
     * @param actions the actions to set
     */
    public void setActions(List<OneTimeActionPerRobot> actions) {
        this.actions = actions;
    }

    public List<GameResourceDestination> getDestinations() {
        return resourceDestinations;
    }
}