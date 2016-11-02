package code.lunatech.dao;

import java.util.List;

import code.lunatech.dao.types.Airport;

public interface AirportDAO {

	public List<Airport> getAiportsByCountryCode(String countryCode);
}
