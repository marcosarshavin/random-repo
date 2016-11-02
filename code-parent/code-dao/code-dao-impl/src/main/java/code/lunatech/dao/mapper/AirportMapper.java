package code.lunatech.dao.mapper;


import org.apache.commons.lang3.StringUtils;

import code.lunatech.dao.types.Airport;

public class AirportMapper {

	public static Airport fromStringtoAirport(String csvLine)	{
		Airport airport = new Airport();
		
		String[] csvFields = StringUtils.splitPreserveAllTokens(csvLine, ',');
		
		airport.setId(csvFields[0]);
		airport.setIdent(csvFields[1] != null ? csvFields[1].replaceAll("\"", "") : null);
		airport.setType(csvFields[2] != null ? csvFields[2].replaceAll("\"", "") : null);
		airport.setName(csvFields[3] != null ? csvFields[3].replaceAll("\"", "") : null);
		airport.setLatitude_deg(csvFields[4]);
		airport.setLongitude_deg(csvFields[5]);
		airport.setElevation_ft(csvFields[6]);
		airport.setContinent(csvFields[7] != null ? csvFields[7].replaceAll("\"", "") : null);
		airport.setIso_country(csvFields[8] != null ? csvFields[8].replaceAll("\"", "") : null);
		airport.setIso_region(csvFields[9] != null ? csvFields[9].replaceAll("\"", "") : null);
		airport.setMunicipality(csvFields[10] != null ? csvFields[10].replaceAll("\"", "") : null);
		airport.setScheduled_service(csvFields[11] != null ? csvFields[11].replaceAll("\"", "") : null);
		airport.setGps_code(csvFields[12] != null ? csvFields[12].replaceAll("\"", "") : null);
		airport.setIata_code(csvFields[13] != null ? csvFields[13].replaceAll("\"", "") : null);
		airport.setLocal_code(csvFields[14] != null ? csvFields[14].replaceAll("\"", "") : null);
		airport.setHome_link(csvFields[15] != null ? csvFields[15].replaceAll("\"", "") : null);
		airport.setWikipedia_link(csvFields[16] != null ? csvFields[16].replaceAll("\"", "") : null);
		airport.setKeywords(csvFields[17] != null ? csvFields[17].replaceAll("\"", "") : null);
		
		return airport;
	}
}
