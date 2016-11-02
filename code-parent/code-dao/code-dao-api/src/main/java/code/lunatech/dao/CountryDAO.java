package code.lunatech.dao;

import java.util.List;

import code.lunatech.dao.types.Country;

public interface CountryDAO {

	public  List<Country> getAllCountries();
	public  Country findCountryByName(String name);
}
