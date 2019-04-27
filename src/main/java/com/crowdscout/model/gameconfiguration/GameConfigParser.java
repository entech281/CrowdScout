package com.crowdscout.model.gameconfiguration;

import com.crowdscout.model.gameconfiguration.gamecomponents.GameOneTimeActionPerRobot;
import com.crowdscout.model.gameconfiguration.gamecomponents.GameResourceDestination;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import java.nio.file.Files;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GameConfigParser {

    private final String CONFIG_FILE_NAME = "Season Config Files/GameConfig.json";
    private List<GameResourceDestination> resourceDestinations = new ArrayList<GameResourceDestination>();
    private List<GameOneTimeActionPerRobot> actions = new ArrayList<GameOneTimeActionPerRobot>();
    private List<String> resources = new ArrayList<String>();

    public GameConfigParser() throws JSONException, FileNotFoundException, IOException {

        String fileContent = new String(
                Files.readAllBytes(Paths.get(System.getProperty("user.dir") + "/" + CONFIG_FILE_NAME)));

        JSONObject gameConfigObject = (JSONObject) new JSONObject(fileContent);
        JSONArray gameResourceArray = (JSONArray) gameConfigObject.get("resources");

        


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
                    GameOneTimeActionPerRobot gota;
                    if (currentObj.has("min attemptors")){
                        gota = new GameOneTimeActionPerRobot(
                            currentObj.getString("name"),
                            currentObj.getInt("max attemptors")
                        );
                    }
                    else{
                        gota = new GameOneTimeActionPerRobot(
                            currentObj.getString("name"), 
                            currentObj.getInt("min attemptors"), 
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
    public List<String> getResources() {
        return resources;
    }

    /**
     * @param resources the resources to set
     */
    public void setResources(List<String> resources) {
        this.resources = resources;
    }

    /**
     * @return the actions
     */
    public List<GameOneTimeActionPerRobot> getActions() {
        return actions;
    }

    /**
     * @param actions the actions to set
     */
    public void setActions(List<GameOneTimeActionPerRobot> actions) {
        this.actions = actions;
    }

    public List<GameResourceDestination> getDestinations() {
        return resourceDestinations;
    }
}