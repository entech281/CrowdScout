package com.crowdscout.model.scoutingreport;

import java.util.ArrayList;
import java.util.List;

public abstract class SingleScoutReportVerifier {
    private static List<SingleScoutReportVerifier> allReportVerifiers = new ArrayList<>();

    public SingleScoutReportVerifier(){
        allReportVerifiers.add(this);
    }

    public SingleScoutReportVerifier getInstance(){
        return this;
    }

    public abstract double getValidityLikelyhood(MatchReport report);

    public double verifyAll(MatchReport report) throws Exception{
        if(allReportVerifiers.size() != 0){
            throw new Exception("There were no subclasses of SingleScoutReportDataVerifier initialized.");
        }
        int totalCorrect = 0; 
        for (SingleScoutReportVerifier checker : allReportVerifiers) 
            totalCorrect +=checker.getValidityLikelyhood(report);
        return ((double) totalCorrect) / allReportVerifiers.size();
    }
}