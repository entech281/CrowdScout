package com.crowdscout.matchprocessor;

import com.crowdscout.dto.ScoutLoginDTO;
import com.crowdscout.dto.ScoutLoginResponseDTO;
import com.crowdscout.dto.ScoutReportDTO;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController{
    @RequestMapping(value = "/submit_report", method = RequestMethod.POST)
    ScoutReportDTO submitReport(@RequestBody ScoutReportDTO report){
        return report;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    ScoutLoginResponseDTO login(@RequestBody ScoutLoginDTO credentials){
        return ScoutLoginResponseDTO.getDefault();
    }
}