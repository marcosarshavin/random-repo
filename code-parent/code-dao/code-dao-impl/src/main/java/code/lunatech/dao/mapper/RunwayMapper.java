package code.lunatech.dao.mapper;


import org.apache.commons.lang3.StringUtils;

import code.lunatech.dao.types.Runway;

public class RunwayMapper {

	public static Runway fromStringtoRunway(String csvLine)	{
		Runway runway = new Runway();
		
		String[] csvFields = StringUtils.splitPreserveAllTokens(csvLine, ',');
		
		runway.setId(csvFields[0] != null ?  csvFields[0].replaceAll("\"", "") : null);
		runway.setAirport_ref(csvFields[1] != null ?  csvFields[1].replaceAll("\"", "") : null);
		runway.setAirport_ident(csvFields[2] != null ?  csvFields[2].replaceAll("\"", "") : null);
		runway.setLength_ft(csvFields[3] != null ?  csvFields[3].replaceAll("\"", "") : null);
		runway.setWidth_ft(csvFields[4] != null ?  csvFields[4].replaceAll("\"", "") : null);
		runway.setSurface(csvFields[5] != null ?  csvFields[5].replaceAll("\"", "") : null);
		runway.setLighted(csvFields[6] != null ?  csvFields[6].replaceAll("\"", "") : null);
		runway.setClosed(csvFields[7] != null ?  csvFields[7].replaceAll("\"", "") : null);
		runway.setLe_ident(csvFields[8] != null ?  csvFields[8].replaceAll("\"", "") : null);
		runway.setLe_latitude_deg(csvFields[9] != null ?  csvFields[9].replaceAll("\"", "") : null);
		runway.setLe_longitude_deg(csvFields[10] != null ?  csvFields[10].replaceAll("\"", "") : null);
		runway.setLe_elevation_ft(csvFields[11] != null ?  csvFields[11].replaceAll("\"", "") : null);
		runway.setLe_heading_degT(csvFields[12] != null ?  csvFields[12].replaceAll("\"", "") : null);
		runway.setLe_displaced_threshold_ft(csvFields[13] != null ?  csvFields[13].replaceAll("\"", "") : null);
		runway.setHe_ident(csvFields[14] != null ?  csvFields[14].replaceAll("\"", "") : null);
		runway.setHe_latitude_deg(csvFields[15] != null ?  csvFields[15].replaceAll("\"", "") : null);
		runway.setHe_longitude_deg(csvFields[16] != null ?  csvFields[16].replaceAll("\"", "") : null);
		runway.setHe_elevation_ft(csvFields[17] != null ?  csvFields[17].replaceAll("\"", "") : null);
		runway.setHe_heading_degT(csvFields[18] != null ?  csvFields[18].replaceAll("\"", "") : null);
		runway.setHe_displaced_threshold_ft(csvFields[19] != null ?  csvFields[19].replaceAll("\"", "") : null);
		
		return runway;
	}
}
