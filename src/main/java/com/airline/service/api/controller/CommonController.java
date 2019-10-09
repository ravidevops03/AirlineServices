package com.airline.service.api.controller;

import java.io.IOException;
import java.io.Writer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Ravi Ranjan Kumar
 * @version 1.0
 * This class is a common controller that contains exception handler method.
 */
public class CommonController {
	
	/**
	 * 
	 * @param e
	 * @param writer
	 * 
	 * If any exception occurs, this method will take care automatically.
	 * 
	 */
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)	
	public void handle(final Exception e, final Writer writer) {
		try {
			writer.write("An Exception Occered, Please reach out to Technical Support");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
