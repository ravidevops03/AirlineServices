package com.airline.service.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import com.airline.service.model.ArrivesOn;
import com.airline.service.model.BookingFee;
import com.airline.service.model.BookingFee_;
import com.airline.service.model.BookingFee__;
import com.airline.service.model.Business;
import com.airline.service.model.DepartsOn;
import com.airline.service.model.Economy;
import com.airline.service.model.FarePrices;
import com.airline.service.model.First;
import com.airline.service.model.Information;
import com.airline.service.model.Tax;
import com.airline.service.model.Tax_;
import com.airline.service.model.Tax__;
import com.airline.service.model.Ticket;
import com.airline.service.model.Ticket_;
import com.airline.service.model.Ticket__;
import com.airline.service.schema.Availability;
import com.airline.service.schema.Availability.Flight;
import com.airline.service.schema.Availability.Flight.Fares.Fare;


/**
 * @author Ravi Ranjan Kumar
 * @version 1.0
 * 
 *          This class performs main activities of communicate to an airline
 *          service, get the response as XML and convert into as Object format
 *          using the Resteasy.
 * 
 */

public class APIUtils {

	/**
	 * 
	 * @param orgAirport
	 * @param distAirport
	 * @param serviceURL
	 * @return
	 * @throws Exception
	 * 
	 * This method takes input paramter and converts the response
	 * to desired objects and returns it as Information Object to Rest controller.
	 * 
	 */
	
	public static Information resteasyClientGETRequest(String orgAirport,String distAirport, String serviceURL) throws Exception {
		// Define the API URI where API will be accessed
		ClientRequest request = new ClientRequest(serviceURL);

		// Set the accept header to tell the accepted response format
		request.accept("application/xml");

		// RESTEasy client automatically converts the response to desired objects.
		// This is how it is done.
		// Populate the response in Availability object
		ClientResponse<Availability> response = request.get(Availability.class);

		// First validate the api status code
		int apiResponseCode = response.getResponseStatus().getStatusCode();

		if (response.getResponseStatus().getStatusCode() != 200) {
			throw new RuntimeException("Failed with HTTP error code : " + apiResponseCode);
		}

		// Get the Availability object from entity
		Availability availability = response.getEntity();

		// verify the Availability object

		System.out.println("Total no. of records available in Mock AirlineServices :" +availability.getFlight().size());
		Information _information = new Information();
		_information = convertXMLToJSONObject(orgAirport, distAirport, availability);

		System.out.println(availability);
		return _information;
	}
	
	/**
	 * 
	 * @param splitStr
	 * @return
	 * 
	 * This method is to split the fares into currency and amount
	 * 
	 */

	public static String[] splitFares(String splitStr) {
		String[] arrOfFares = splitStr.split(" ", 2);
		return arrOfFares;
	}
	
	/**
	 * 
	 * @param dateVal
	 * @return
	 * 
	 * This method is to split the time in 12 hour format from ISO date 
	 * 
	 */

	public static String splitTime(String dateVal) {
		java.util.Date date = Date.from(Instant.parse((CharSequence) dateVal));
		DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
		String timeString = dateFormat.format(date).toString();
		return timeString;
	}
	
	/**
	 * 
	 * @param dateVal
	 * @return
	 * 
	 * This method is to split the date from ISO date 
	 * 
	 */

	public static String splitDate(String dateVal) {
		java.util.Date date = Date.from(Instant.parse((CharSequence) dateVal));
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String dateString = dateFormat.format(date).toString();
		return dateString;
	}
	
	/**
	 * 
	 * @param orgAirport
	 * @param distAirport
	 * @param availability
	 * @return
	 * 
	 * This method is to convert XML Object record into JSON Object 
	 * and Filtering the flight details based on org and destination
	 * 
	 */

	public static Information convertXMLToJSONObject(String orgAirport, String distAirport,Availability availability) {
		
		List<Flight> lines = availability.getFlight();
		
		// Filtering the flight details based on org and destination 
		List<Flight> result = lines.stream() // convert list to stream
				.filter(line -> orgAirport.equals(line.getOriginAirport()) && distAirport.equals(line.getDestinationAirport())) 
				.collect(Collectors.toList()); // collect the output and convert streams to a List

		System.out.println("Total Flight Available ::: " + result.size());

		// create an empty list for List<Availability> availability
		List<com.airline.service.model.Availability> _availability = new ArrayList<>();
		Information _information = new Information();
		com.airline.service.model.Flight _flight = new com.airline.service.model.Flight();
		com.airline.service.model.Availability avialFlight = new com.airline.service.model.Availability();
		
		//Converting the XMl object records in java class to display as in JSON format
		for (Flight flight : result) {

			DepartsOn departon = new DepartsOn();
			ArrivesOn arriveson = new ArrivesOn();

			_flight.setOperator(flight.getCarrierCode());
			_flight.setFlightNumber(flight.getFlightDesignator());
			_flight.setDepartsFrom(flight.getOriginAirport());
			_flight.setArrivesAt(flight.getDestinationAirport());

			String departTime = splitTime(flight.getDepartureDate().toString());
			String departDate = splitDate(flight.getDepartureDate().toString());

			String arrTime = splitTime(flight.getArrivalDate().toString());
			String arrDate = splitDate(flight.getArrivalDate().toString());

			departon.setTime(departTime);
			departon.setDate(departDate);

			arriveson.setTime(arrTime);
			arriveson.setDate(arrDate);

			_flight.setDepartsOn(departon);
			_flight.setArrivesOn(arriveson);

			System.out.println("arrTime 	:" + arrTime);
			System.out.println("departTime 	:" + departTime);
			
			_flight.setFlightTime(departTime);
			
			FarePrices fp = new FarePrices();
			
			for (Fare fare : flight.getFares().getFare()) {
//				YIF: economy, CIF: business, FIF: first
//				Validating Class and fetching their details 
				if (AirlineServicesConstants.ECONOMY.equalsIgnoreCase(fare.getClazz())) {  // Validating for ECONOMY Class
					Economy economy = new Economy();
					Tax__ tax = new Tax__();
					BookingFee__ bookingfee = new BookingFee__();
					Ticket__ ticket = new Ticket__();
					
					String[] arrOfFare = splitFares(fare.getFees());
					String[] arrOfTax = splitFares(fare.getTax());
					String[] arrOfBaseprice = splitFares(fare.getBasePrice());
					
					tax.setCurrency(arrOfFare[0]);
					tax.setAmount(Double.parseDouble(arrOfFare[1]));
					
					bookingfee.setCurrency(arrOfTax[0]);
					bookingfee.setAmount(Double.parseDouble(arrOfTax[1]));
					
					ticket.setCurrency(arrOfBaseprice[0]);
					ticket.setAmount(Double.parseDouble(arrOfBaseprice[1]));
					
					economy.setTax(tax);
					economy.setBookingFee(bookingfee);
					economy.setTicket(ticket);
					
					fp.setEconomy(economy);
					_flight.setFarePrices(fp);
				} else if (AirlineServicesConstants.BUSINESS.equalsIgnoreCase(fare.getClazz())) { // Validating for BUSINESS Class
					Business business = new Business();
					Tax_ tax = new Tax_();
					BookingFee_ bookingfee = new BookingFee_();
					Ticket_ ticket = new Ticket_();
					
					String[] arrOfFare = splitFares(fare.getFees());
					String[] arrOfTax = splitFares(fare.getTax());
					String[] arrOfBaseprice = splitFares(fare.getBasePrice());
					
					tax.setCurrency(arrOfFare[0]);
					tax.setAmount(Double.parseDouble(arrOfFare[1]));
					
					bookingfee.setCurrency(arrOfTax[0]);
					bookingfee.setAmount(Double.parseDouble(arrOfTax[1]));
					
					ticket.setCurrency(arrOfBaseprice[0]);
					ticket.setAmount(Double.parseDouble(arrOfBaseprice[1]));
					
					business.setTax(tax);
					business.setBookingFee(bookingfee);
					business.setTicket(ticket);
					
					fp.setBusiness(business);
					_flight.setFarePrices(fp);
				} else if (AirlineServicesConstants.FIRST.equalsIgnoreCase(fare.getClazz())) { // Validating for FIRST Class
					First first = new First();
					Tax tax = new Tax();
					BookingFee bookingfee = new BookingFee();
					Ticket ticket = new Ticket();
					
					String[] arrOfFare = splitFares(fare.getFees());
					String[] arrOfTax = splitFares(fare.getTax());
					String[] arrOfBaseprice = splitFares(fare.getBasePrice());
					
					tax.setCurrency(arrOfFare[0]);
					tax.setAmount(Double.parseDouble(arrOfFare[1]));
					
					bookingfee.setCurrency(arrOfTax[0]);
					bookingfee.setAmount(Double.parseDouble(arrOfTax[1]));
					
					ticket.setCurrency(arrOfBaseprice[0]);
					ticket.setAmount(Double.parseDouble(arrOfBaseprice[1]));
					
					first.setTax(tax);
					first.setBookingFee(bookingfee);
					first.setTicket(ticket);
					
					fp.setFirst(first);
					_flight.setFarePrices(fp);
				}
			}
			avialFlight.setFlight(_flight);
			_availability.add(avialFlight);
		}
		_information.setAvailability(_availability);

		return _information;
	}
}
