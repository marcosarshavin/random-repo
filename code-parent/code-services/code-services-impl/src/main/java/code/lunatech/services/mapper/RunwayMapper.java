package code.lunatech.services.mapper;

import code.lunatech.dao.types.Runway;
import code.lunatech.services.dto.RunwayDTO;

public class RunwayMapper {

public static RunwayDTO fromRunwayToRunwayDTO(Runway runway)	{
		
		RunwayDTO runwayDTO = new RunwayDTO();
	
		runwayDTO.setId(runway.getId());
		runwayDTO.setAirport_ref(runway.getAirport_ref());
		runwayDTO.setAirport_ident(runway.getAirport_ident());
		runwayDTO.setLength_ft(runway.getLength_ft());
		runwayDTO.setWidth_ft(runway.getWidth_ft());
		runwayDTO.setSurface(runway.getSurface());
		runwayDTO.setLighted(runway.getLighted());
		runwayDTO.setClosed(runway.getClosed());
		runwayDTO.setLe_ident(runway.getLe_ident());
		runwayDTO.setLe_latitude_deg(runway.getLe_latitude_deg());
		runwayDTO.setLe_longitude_deg(runway.getLe_longitude_deg());
		runway.setLe_elevation_ft(runway.getLe_elevation_ft());
		runwayDTO.setLe_heading_degT(runway.getLe_heading_degT());
		runwayDTO.setLe_displaced_threshold_ft(runway.getLe_displaced_threshold_ft());
		runwayDTO.setHe_ident(runway.getHe_ident());
		runwayDTO.setHe_latitude_deg(runway.getHe_ident());
		runwayDTO.setHe_longitude_deg(runway.getHe_longitude_deg());
		runwayDTO.setHe_elevation_ft(runway.getHe_elevation_ft());
		runwayDTO.setHe_heading_degT(runway.getHe_heading_degT());
		runwayDTO.setHe_displaced_threshold_ft(runway.getHe_displaced_threshold_ft());
		
		return runwayDTO;
	}
}
