package code.lunatech.dao.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import code.lunatech.dao.AirportDAO;
import code.lunatech.dao.exception.DataAccessException;
import code.lunatech.dao.mapper.AirportMapper;
import code.lunatech.dao.types.Airport;

public class AirportDAOImpl implements AirportDAO {
	
	private String airportsCsv;

	@Override
	public List<Airport> getAiportsByCountryCode(String countryCode) {
		
		if (countryCode == null || countryCode.trim().isEmpty())
			throw new DataAccessException("Country code cannot be null or empty");
		
		try {
			
			List<Airport> airports = this.getAllAirports();
			
			List<Airport> airportsFiltered = airports.stream().filter(
					airport -> airport.getIso_country().equals(countryCode))
				.collect(Collectors.toList());
			
			return airportsFiltered;
		
		} catch (Exception e)	{
			throw new DataAccessException("Error ocurred when trying to obtain airports by country code " + countryCode, e);
		}
	}
	
	public void setAirportsCsv(String airportsCsv)	{
		this.airportsCsv = airportsCsv;
	}

	@Override
	public List<Airport> getAllAirports() {

		try {
			//TODO: Cerrar reader
			BufferedReader reader = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream(airportsCsv)));
			
			String firstLine = reader.readLine();
			
			List<Airport> airports = new ArrayList<Airport>();
			
			if (firstLine == null)
				return airports;
			
			while (true)	{
				String csvLine = reader.readLine();
				if (csvLine == null)
					break;
				
				airports.add(AirportMapper.fromStringtoAirport(csvLine));
			}
			
			return airports;
		
		} catch (Exception e)	{
			throw new DataAccessException("Error ocurred when trying to obtain airports");
		}
	}
	
}
