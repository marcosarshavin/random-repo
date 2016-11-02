package code.lunatech.web.dto;

import java.util.List;

public class AirportInformation	{
	
	private String type;
	private String latitude_deg;
	private String longitude_deg;
	private List<RunwayInformation> runwayInformation;
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLatitude_deg() {
		return latitude_deg;
	}
	public void setLatitude_deg(String latitude_deg) {
		this.latitude_deg = latitude_deg;
	}
	public String getLongitude_deg() {
		return longitude_deg;
	}
	public void setLongitude_deg(String longitude_deg) {
		this.longitude_deg = longitude_deg;
	}
	public List<RunwayInformation> getRunwayInformation() {
		return runwayInformation;
	}
	public void setRunwayInformation(List<RunwayInformation> runwayInformation) {
		this.runwayInformation = runwayInformation;
	}
}
