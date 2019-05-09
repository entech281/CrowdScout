package com.crowdscout.model.scoutingreport.verifiers;

import java.util.ArrayList;
import java.util.List;

import com.crowdscout.model.scoutingreport.MatchRecord;

public abstract class SingleScoutReportVerifier {
    private static List<SingleScoutReportVerifier> allReportVerifiers = new ArrayList<>();

    public SingleScoutReportVerifier(){
        allReportVerifiers.add(this);
    }

    public SingleScoutReportVerifier getInstance(){
        return this;
    }

    public abstract double getValidityLikelyhood(MatchRecord report);

    public double verifyAll(MatchRecord report) throws Exception{
        if(allReportVerifiers.size() != 0){
            throw new Exception("There were no subclasses of SingleScoutReportDataVerifier initialized.");
        }
        int totalCorrect = 0; 
        for (SingleScoutReportVerifier checker : allReportVerifiers) 
            totalCorrect += checker.getValidityLikelyhood(report);
        return totalCorrect / allReportVerifiers.size();
    }
}