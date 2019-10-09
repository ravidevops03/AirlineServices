package com.airline.service.api.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.airline.service.model.Information;
import com.airline.service.schema.Availability;
import com.airline.service.utils.APIUtils;
import com.airline.service.utils.AirlineServicesConstants;

/**
 * @author Ravi Ranjan Kumar
 * @version 1.0
 * This class is a rest controller that exposes Airlines which includes flightavailability services
 */

@RestController
@RequestMapping("/airlinesservices/v1")
public class AirlinesServiceController extends CommonController {
	
	/**
	 * 
	 * @param orgAirport
	 * @param distAirport
	 * @param deptDate
	 * @param rtnDate
	 * @param noOfPasnger
	 * @return
	 * @throws Exception
	 * 
	 * This REST service is accessed with the url /flightavailability/{orgAirport}/{distAirport}/{deptDate}/{rtnDate}/{noOfPasnger}
	 * where all are the required variable 
	 */
	@RequestMapping(value = "/flightavailability/{orgAirport}/{distAirport}/{deptDate}/{rtnDate}/{noOfPasnger}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody	
	public Information flightavailability(@PathVariable(value = "orgAirport", required = true) String orgAirport,
			@PathVariable(value = "distAirport", required = true) String distAirport,
			@PathVariable(value = "deptDate", required = true) String deptDate,
			@PathVariable(value = "rtnDate", required = true) String rtnDate,
			@PathVariable(value = "noOfPasnger", required = true) int noOfPasnger) throws Exception {
		return APIUtils.resteasyClientGETRequest(orgAirport,distAirport,AirlineServicesConstants.AIRLINESMOCKSERVICEURL);
	}

}
