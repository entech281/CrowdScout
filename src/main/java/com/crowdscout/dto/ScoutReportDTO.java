package com.crowdscout.dto;

import com.crowdscout.model.scoutingreport.MatchRecord;

public class ScoutReportDTO{
    private MatchRecord record;
    private String auth;

    public ScoutReportDTO(MatchRecord record, String auth){
        this.record = record;
        this.auth = auth;
    }

    /**
     * @return the record
     */
    public MatchRecord getrecord() {
        return record;
    }

    /**
     * @return the auth
     */
    public String getAuth() {
        return auth;
    }

    /**
     * @param auth the auth to set
     */
    public void setAuth(String auth) {
        this.auth = auth;
    }

    /**
     * @param record the record to set
     */
    public void setrecord(MatchRecord record) {
        this.record = record;
    }


}