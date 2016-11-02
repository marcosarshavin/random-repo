package code.lunatech.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import code.lunatech.services.CountryService;
import code.lunatech.web.dto.JsonContainer;

@Controller
@RequestMapping(value = "/countries")
public class CountriesController {
	
	@Autowired
	private CountryService countryService;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody JsonContainer getAllCountries()	{
		
		JsonContainer json = new JsonContainer();
		json.setInfo("OK");
		json.setData(countryService.getAllCountries());
		json.setSuccess(true);
		
		return json;
	}
}
