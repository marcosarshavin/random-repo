package code.lunatech.services;

import java.util.List;

import code.lunatech.services.dto.CountryDTO;

public interface CountryService {
	public List<CountryDTO> getAllCountries();
	public CountryDTO getCountryCodeByName(String name);
}
