package code.lunatech.services.helper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import code.lunatech.dao.RunwayDAO;
import code.lunatech.services.dto.RunwayDTO;
import code.lunatech.services.mapper.RunwayMapper;

@Component
public class RunwayHelper {
	
	@Autowired
	private RunwayDAO runwayDAO;
	
	public List<RunwayDTO> getAllRunways() {
		return runwayDAO.getAllRunways().stream().map(runway -> RunwayMapper.fromRunwayToRunwayDTO(runway)).collect(Collectors.toList());
	}

}
