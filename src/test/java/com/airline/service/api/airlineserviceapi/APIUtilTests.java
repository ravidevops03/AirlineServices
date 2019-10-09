package com.airline.service.api.airlineserviceapi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.airline.service.model.Information;
import com.airline.service.schema.Availability;
import com.airline.service.utils.APIUtils;
import com.airline.service.utils.AirlineServicesConstants;

public class APIUtilTests {
	

	@Before
	public void setUp() throws Exception {
	
	}
	
	@Test
	public void testRestClientResponse() {
		
		Information info = null;
		
		try {
			info = APIUtils.resteasyClientGETRequest("MUC","LHR",AirlineServicesConstants.AIRLINESMOCKSERVICEURL);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		assertNotNull(info);
	}
	
	@Test
	public void testRestClientAvailability() {		
		Information info = null;		
		try {
			info = APIUtils.resteasyClientGETRequest("","","");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			assertTrue(e instanceof RuntimeException);
		}				
	}

}
