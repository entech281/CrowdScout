package com.crowdscout.model.scoutingreport.verifiers;

import java.util.ArrayList;
import java.util.List;

import com.crowdscout.model.scoutingreport.MatchRecord;

public abstract class AllReportsForMatchVerifyer {
    private static List<AllReportsForMatchVerifyer> allReportVerifiers = new ArrayList<>();

    public AllReportsForMatchVerifyer() {
        allReportVerifiers.add(this);
    }

    public abstract List<MatchRecord> whichReportsAreValid(MatchRecord... reports);
}