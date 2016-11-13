package code.lunatech.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import code.lunatech.services.CountryService;
import code.lunatech.services.dto.CountryDTO;
import code.lunatech.services.helper.CountryHelper;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryHelper countryhelper;
	
	public List<CountryDTO> getAllCountries() {
		return countryhelper.getAllCountries();
	}

	@Override
	public CountryDTO getCountryCodeByName(String name) {
		return countryhelper.getCountryCodeByName(name);
	}
}
