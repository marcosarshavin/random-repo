package code.lunatech.dao.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import code.lunatech.dao.RunwayDAO;
import code.lunatech.dao.exception.DataAccessException;
import code.lunatech.dao.mapper.RunwayMapper;
import code.lunatech.dao.types.Runway;

public class RunwayDAOImpl implements RunwayDAO {

	private String runwaysCsv; 
	
	@Override
	public List<Runway> getAllRunways() {
		try {
			
			//TODO: Cerrar reader
			BufferedReader reader = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream(runwaysCsv)));
			
			String firstLine = reader.readLine();
			
			List<Runway> runways = new ArrayList<Runway>();
			
			if (firstLine == null)
				return runways;
			
			while (true)	{
				String csvLine = reader.readLine();
				if (csvLine == null)
					break;
				
				runways.add(RunwayMapper.fromStringtoRunway(csvLine));
			}
			
			return runways;
		
		} catch (Exception e)	{
			throw new DataAccessException("Error ocurred when trying to obtain the runways", e);
		}
	}
	
	public void setRunwaysCsv(String runwaysCsv)	{
		this.runwaysCsv = runwaysCsv;
	}

}
