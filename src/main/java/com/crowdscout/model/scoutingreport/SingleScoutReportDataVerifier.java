package com.crowdscout.model.scoutingreport;

import java.util.ArrayList;
import java.util.List;

public abstract class SingleScoutReportDataVerifier {
    private static List<SingleScoutReportDataVerifier> allReportVerifiers = new ArrayList<>();

    public SingleScoutReportDataVerifier(){
        allReportVerifiers.add(this);
    }

    public abstract boolean isValid(IMatchScoutingReport imsr);

    public double verifyAll(IMatchScoutingReport imsr)throws Exception{
        if(allReportVerifiers.size() != 0){
            throw new Exception("There were no subclasses of SingleScoutReportDataVerifier initialized.");
        }
        int totalCorrect = 0; 
        for (SingleScoutReportDataVerifier checker : allReportVerifiers) 
            if(checker.isValid(imsr))
                totalCorrect ++;
        return ((double) totalCorrect) / allReportVerifiers.size();
    }
}