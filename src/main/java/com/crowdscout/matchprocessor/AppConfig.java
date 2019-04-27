package com.crowdscout.matchprocessor;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.crowdscout.model.gameconfiguration.GameConfigParser;
import com.crowdscout.model.gameconfiguration.gamecomponents.GameResourceDestination;

import org.json.JSONException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
    @Bean("GameConfigParser")
    @Scope("singleton")
    public GameConfigParser getGameConfigParser() throws FileNotFoundException, JSONException, IOException {

        GameConfigParser g = new GameConfigParser();

        for (GameResourceDestination grd : g.getDestinations()) {
            System.out.println(grd.getResourceName());
        }
    
        return g;
   }
}