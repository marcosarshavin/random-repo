package code.lunatech.dao.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import code.lunatech.dao.CountryDAO;
import code.lunatech.dao.exception.DataAccessException;
import code.lunatech.dao.mapper.CountryMapper;
import code.lunatech.dao.types.Country;

public class CountryDAOImpl implements CountryDAO	{

	private String countriesCsv;

	@Override
	public Country findCountryByName(String name) {
		
		List<Country> allCountries = this.getAllCountries();
		
		for (Country country: allCountries)	{
			if (country.getName().equals(name))	{
				return country;
			}
		}
		
		throw new DataAccessException("Country " + name + " does not exists");
	}
	
	public List<Country> getAllCountries() {
		
		try {
			//TODO: Cerrar reader
			BufferedReader reader = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream(countriesCsv)));
			
			String firstLine = reader.readLine();
			
			List<Country> countries = new ArrayList<Country>();
			
			if (firstLine == null)
				return countries;
			
			while (true)	{
				String csvLine = reader.readLine();
				if (csvLine == null)
					break;
				
				countries.add(CountryMapper.fromStringtoCountry(csvLine));
			}
			
			return countries;
		
		} catch (Exception e)	{
			throw new DataAccessException("Error ocurred when trying to obtain countries", e);
		}
	}
	
	public void setCountriesCsv(String countriesCsv)	{
		this.countriesCsv = countriesCsv;
	}
}
