package code.lunatech.services.mapper;

import code.lunatech.dao.types.Country;
import code.lunatech.services.dto.CountryDTO;

public class CountryMapper {
	
	public static CountryDTO fromCountryToCountryDTO(Country country)	{
	
		CountryDTO countryDTO = new CountryDTO();
		
		countryDTO.setCountryCode(country.getCode());
		countryDTO.setCountryName(country.getName());
		
		return countryDTO;
	}
}
