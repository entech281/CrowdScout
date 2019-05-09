package com.crowdscout.model.scoutingreport.verifiers;

import com.crowdscout.model.scoutingreport.MatchRecord;

public class LocationLimitsReportVerifier extends SingleScoutReportVerifier {

    @Override
    public double getValidityLikelyhood(MatchRecord report) {
        return 0;
    }
    
}