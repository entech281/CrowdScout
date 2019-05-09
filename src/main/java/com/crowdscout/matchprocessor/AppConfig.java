package com.crowdscout.matchprocessor;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.crowdscout.model.gameconfiguration.GameConfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
    @Bean("GameConfigParser")
    @Scope("singleton")
    public GameConfiguration getGameConfigParser() throws FileNotFoundException, IOException {
        GameConfiguration gc = GameConfiguration.getDefaultConfiguration();
        gc.getResourceDestinations().forEach(action->System.out.println(action.getName()));
        return GameConfiguration.getDefaultConfiguration();
    }
}