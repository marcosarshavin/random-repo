package code.lunatech.dao.mapper;


import org.apache.commons.lang3.StringUtils;

import code.lunatech.dao.types.Country;

public class CountryMapper {

	public static Country fromStringtoCountry(String csvLine)	{
		Country country = new Country();

		String[] csvFields = StringUtils.splitPreserveAllTokens(csvLine, ',');
		
		country.setId(new Long(csvFields[0]));
		country.setCode(csvFields[1] != null ?  csvFields[1].replaceAll("\"", "") : null);
		country.setName(csvFields[2] != null ? csvFields[2].replaceAll("\"", "") : null);
		country.setContinent(csvFields[3] != null ? csvFields[3].replaceAll("\"", "") : null);
		country.setWikipedia_link(csvFields[4] != null ? csvFields[4].replaceAll("\"", "") : null);
		country.setKeywords(csvFields[5] != null ? csvFields[5].replaceAll("\"", "") : null);
		
		return country;
	}
}
