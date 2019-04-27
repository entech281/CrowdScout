package com.crowdscout.model.scoutingreport;

import java.util.ArrayList;
import java.util.List;

public abstract class AllReportsForMatchVerifyer {
    private static List<AllReportsForMatchVerifyer> allReportVerifiers = new ArrayList<>();

    public AllReportsForMatchVerifyer() {
        allReportVerifiers.add(this);
    }

    public abstract List<IMatchScoutingReport> WhichReportsAreValid(IMatchScoutingReport ... reports);
}