package com.crowdscout.model.gameconfiguration.components;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class ResourceMap<T>{
    private Map<String, T> resourceNameToMaxAmount = new HashMap<>();

    public ResourceMap(){

    }

    @JsonAnySetter
    public void add(String name, T maxAmount){
        resourceNameToMaxAmount.put(name, maxAmount);
    }

    /**
     * @return the resourceNameToMaxAmount
     */
    @JsonAnyGetter
    public Map<String, T> getResourceNameToMaxAmount() {
        return resourceNameToMaxAmount;
    }

    /**
     * @param resourceNameToMaxAmount the resourceNameToMaxAmount to set
     */
    public void setResourceNameToMaxAmount(Map<String, T> resourceNameToMaxAmount) {
        this.resourceNameToMaxAmount = resourceNameToMaxAmount;
    }
}