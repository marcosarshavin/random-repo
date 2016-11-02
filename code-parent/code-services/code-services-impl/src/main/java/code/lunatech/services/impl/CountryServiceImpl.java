package code.lunatech.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import code.lunatech.dao.CountryDAO;
import code.lunatech.dao.types.Country;
import code.lunatech.services.CountryService;
import code.lunatech.services.dto.CountryDTO;
import code.lunatech.services.mapper.CountryMapper;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryDAO countryDAO;
	
	public List<CountryDTO> getAllCountries() {
		List<Country> countries = countryDAO.getAllCountries();
		
		List<CountryDTO> countryCodes = countries.stream().map(
					country -> CountryMapper.fromCountryToCountryDTO(country))
				.collect(Collectors.toList());
		
		return countryCodes;
	}

	@Override
	public CountryDTO getCountryCodeByName(String name) {
				
		return CountryMapper.fromCountryToCountryDTO(countryDAO.findCountryByName(name));
	}
}
