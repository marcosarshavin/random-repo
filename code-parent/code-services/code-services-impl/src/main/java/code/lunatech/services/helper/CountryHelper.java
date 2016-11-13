package code.lunatech.services.helper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import code.lunatech.dao.CountryDAO;
import code.lunatech.dao.types.Country;
import code.lunatech.services.dto.CountryDTO;
import code.lunatech.services.mapper.CountryMapper;

public class CountryHelper {

	@Autowired
	private CountryDAO countryDAO;
	
	public List<CountryDTO> getAllCountries() {
		List<Country> countries = countryDAO.getAllCountries();
		
		List<CountryDTO> countryCodes = countries.stream().map(
					country -> CountryMapper.fromCountryToCountryDTO(country))
				.collect(Collectors.toList());
		
		return countryCodes;
	}

	public CountryDTO getCountryCodeByName(String name) {
		return CountryMapper.fromCountryToCountryDTO(countryDAO.findCountryByName(name));
	}
}
