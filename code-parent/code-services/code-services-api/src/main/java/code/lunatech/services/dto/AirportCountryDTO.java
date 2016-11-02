package code.lunatech.services.dto;

public class AirportCountryDTO {

	private String countryCode;
	private String countryName;
	private Integer numberOfAirports;
	
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public Integer getNumberOfAirports() {
		return numberOfAirports;
	}
	public void setNumberOfAirports(Integer numberOfAirports) {
		this.numberOfAirports = numberOfAirports;
	}
}
