package com.crowdscout.model;

import java.util.ArrayList;
import java.util.List;

public abstract class SingleReportDataVerifier {
    private static List<SingleReportDataVerifier> allReportVerifiers = new ArrayList<>();

    public SingleReportDataVerifier(){
        allReportVerifiers.add(this);
    }


    public abstract boolean IsValid(IMatchScoutingReport imsr);
}