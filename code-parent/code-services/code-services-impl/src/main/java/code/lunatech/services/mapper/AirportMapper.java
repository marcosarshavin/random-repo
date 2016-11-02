package code.lunatech.services.mapper;

import code.lunatech.dao.types.Airport;
import code.lunatech.services.dto.AirportDTO;

public class AirportMapper {
	
	public static AirportDTO fromAirportToAirportDTO(Airport airport)	{
		
		AirportDTO airportDTO = new AirportDTO();
		
		airportDTO.setId(airport.getId());
		airportDTO.setIdent(airport.getIdent());
		airportDTO.setType(airport.getType());
		airportDTO.setName(airport.getName());
		airportDTO.setLatitude_deg(airport.getLatitude_deg());
		airportDTO.setLongitude_deg(airport.getLongitude_deg());
		airportDTO.setElevation_ft(airport.getElevation_ft());
		airportDTO.setContinent(airport.getContinent());
		airportDTO.setIso_country(airport.getIso_country());
		airportDTO.setIso_region(airport.getIso_region());
		airportDTO.setMunicipality(airport.getMunicipality());
		airportDTO.setScheduled_service(airport.getScheduled_service());
		airportDTO.setGps_code(airport.getGps_code());
		airportDTO.setIata_code(airport.getIata_code());
		airportDTO.setLocal_code(airport.getLocal_code());
		airportDTO.setHome_link(airport.getHome_link());
		airport.setWikipedia_link(airport.getWikipedia_link());
		airport.setKeywords(airport.getKeywords());
		
		return airportDTO;
	}
}
