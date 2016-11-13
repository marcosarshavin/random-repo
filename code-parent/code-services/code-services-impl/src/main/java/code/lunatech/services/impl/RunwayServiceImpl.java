package code.lunatech.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import code.lunatech.services.RunwayService;
import code.lunatech.services.dto.RunwayDTO;
import code.lunatech.services.helper.RunwayHelper;

@Service
public class RunwayServiceImpl implements RunwayService	{

	@Autowired
	private RunwayHelper runwayHelper;
	
	@Override
	public List<RunwayDTO> getAllRunways() {
		return runwayHelper.getAllRunways();
	}

}
