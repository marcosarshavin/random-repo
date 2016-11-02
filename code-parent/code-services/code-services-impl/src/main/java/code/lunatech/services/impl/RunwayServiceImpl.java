package code.lunatech.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import code.lunatech.dao.RunwayDAO;
import code.lunatech.services.RunwayService;
import code.lunatech.services.dto.RunwayDTO;
import code.lunatech.services.mapper.RunwayMapper;

@Service
public class RunwayServiceImpl implements RunwayService	{

	@Autowired
	private RunwayDAO runwayDAO;
	
	@Override
	public List<RunwayDTO> getAllRunways() {
		
		return runwayDAO.getAllRunways().stream().map(runway -> RunwayMapper.fromRunwayToRunwayDTO(runway)).collect(Collectors.toList());
	}

}
