package code.lunatech.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import code.lunatech.dao.AirportDAO;
import code.lunatech.dao.types.Airport;
import code.lunatech.services.AirportService;
import code.lunatech.services.CountryService;
import code.lunatech.services.RunwayService;
import code.lunatech.services.dto.AirportCountryDTO;
import code.lunatech.services.dto.AirportDTO;
import code.lunatech.services.dto.CountryDTO;
import code.lunatech.services.dto.RunwayDTO;
import code.lunatech.services.mapper.AirportMapper;

@Service
public class AirportServiceImpl implements AirportService {

	private static final Logger logger = LoggerFactory.getLogger(AirportServiceImpl.class);
	
	@Autowired
	private AirportDAO airportDAO;
	
	@Autowired
	private RunwayService runwayService;
	
	@Autowired
	private CountryService countryService;
	
	@Override
	public List<AirportDTO> getAirportsAndRunwaysInfoByCountry(String countryCode, String country) {
		
		List<Airport> airports;
		if (countryCode != null && !countryCode.trim().isEmpty())	{
			airports = airportDAO.getAiportsByCountryCode(countryCode);
		} else {
			CountryDTO countryDTO = countryService.getCountryCodeByName(country);
			logger.info("Obtained country {} with code {}", new Object[]{country, countryDTO.getCountryCode()});
			airports = airportDAO.getAiportsByCountryCode(countryDTO.getCountryCode());
		}
		
		logger.info("Obtained {} aiports for country {} - {}", new Object[]{airports.size(), countryCode, country});
		
		List<AirportDTO> airportsAndRunways = airports.stream().map(
				airport -> AirportMapper.fromAirportToAirportDTO(airport))
			.collect(Collectors.toList());
	
		List<RunwayDTO> allRunways = runwayService.getAllRunways();
		
		logger.info("Obtained {} runways", new Object[]{allRunways.size()});
		
		airportsAndRunways.forEach(
				airport -> 	{
							airport.setRunwayInformation(allRunways.stream().filter(runway -> runway.getAirport_ref().equals(airport.getId())).collect(Collectors.toList()));
							allRunways.removeAll(airport.getRunwayInformation());
						}
			);
		
		return airportsAndRunways;
	}

	@Override
	public List<AirportCountryDTO> getNumberOfAirportsByCountry() {
		
		List<CountryDTO> allCountries = countryService.getAllCountries();
		logger.info("Found {} countries", new Object[]{allCountries.size()});
		
		List<AirportCountryDTO> airportCountryInfo = new ArrayList<AirportCountryDTO>();
		
		allCountries.stream().forEach(country -> {
			AirportCountryDTO airportCountry = new AirportCountryDTO();
			airportCountry.setCountryCode(country.getCountryCode());
			airportCountry.setCountryName(country.getCountryName());
			airportCountry.setNumberOfAirports(airportDAO.getAiportsByCountryCode(country.getCountryCode()).size());
			logger.info("Country {} - {} has {} airports", new Object[]{airportCountry.getCountryCode(), airportCountry.getCountryName(), airportCountry.getNumberOfAirports()});
			airportCountryInfo.add(airportCountry);
		});
		
		logger.info("Sorting CountriesAirportList");
		airportCountryInfo.sort(
				(airportCountry1, airportCountry2) -> airportCountry1.getNumberOfAirports().compareTo(airportCountry2.getNumberOfAirports()));

		return airportCountryInfo;
	}
}
