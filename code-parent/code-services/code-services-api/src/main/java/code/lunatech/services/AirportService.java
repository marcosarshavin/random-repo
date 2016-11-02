package code.lunatech.services;

import java.util.List;

import code.lunatech.services.dto.AirportCountryDTO;
import code.lunatech.services.dto.AirportDTO;

public interface AirportService {
	public List<AirportDTO> getAirportsAndRunwaysInfoByCountry(String countryCode, String country);
	public List<AirportCountryDTO> getNumberOfAirportsByCountry();
}
