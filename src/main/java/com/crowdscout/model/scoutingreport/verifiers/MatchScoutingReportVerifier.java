package com.crowdscout.model.scoutingreport.verifiers;

import com.crowdscout.model.scoutingreport.MatchRecord;

public abstract class MatchScoutingReportVerifier {
    public abstract double getValidityLikelyhood(MatchRecord ... reports);
}