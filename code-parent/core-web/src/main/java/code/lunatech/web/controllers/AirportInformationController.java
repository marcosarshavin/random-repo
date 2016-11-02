package code.lunatech.web.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import code.lunatech.services.AirportService;
import code.lunatech.services.dto.AirportCountryDTO;
import code.lunatech.services.dto.AirportDTO;
import code.lunatech.web.dto.JsonContainer;

@Controller
@RequestMapping(value = "/airports")
public class AirportInformationController {

	private static final Logger logger = LoggerFactory.getLogger(AirportInformationController.class);
	
	@Autowired
	private AirportService airportService;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody JsonContainer getCountryAirportsInformation(@RequestParam String countryCode, @RequestParam String country)	{
		
		logger.info("Getting airports and runways information for country: {} - {}", new Object[]{countryCode, country});
		
		List<AirportDTO> airports = airportService.getAirportsAndRunwaysInfoByCountry(countryCode, country);
		
		logger.info("Obtained {} airports for country: {} - {}", new Object[]{airports.size(), countryCode, country});
		
		JsonContainer json = new JsonContainer();
		json.setInfo("OK");
		json.setData(airports);
		json.setSuccess(true);
		json.setTotalCount(new Long(airports.size()));
		return json;
	}
	
	@RequestMapping(value = "/biggestNumberOfAirports", method = RequestMethod.GET)
	public @ResponseBody JsonContainer getBiggestNumberOfAirports()	{
		
		List<AirportCountryDTO> airports = airportService.getNumberOfAirportsByCountry();
		
		JsonContainer json = new JsonContainer();
		json.setInfo("OK");
		json.setData(airports);
		json.setSuccess(true);
		json.setTotalCount(new Long(10));
		return json;
	}
	
	
}
