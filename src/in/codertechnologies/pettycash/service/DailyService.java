package in.codertechnologies.pettycash.service;

import java.sql.Date;
import java.util.List;

import in.codertechnologies.pettycash.dto.Daily;
import in.codertechnologies.pettycash.dto.DetailsDailyMonthly;
import in.codertechnologies.pettycash.exceptions.DataNotFoundException;

public interface DailyService 
{

	 boolean addDaily(Daily daily);
	 boolean updateDaily(Daily daily);
	 boolean deleteDaily(int did)throws DataNotFoundException;
	 Daily findDaily(int did)throws DataNotFoundException;
	
		List<Daily> getAllDaily();

		
		/*Day*/
		public List<Daily> SearchByDetailParticularDate(Date date1);
		public List<Daily> ShowAllTotalOfDay();
		
		/*Month*/
		public List<Daily> SearchByDetailParticularMonth(Date date1);
		public List<Daily> ShowAllTotalOfMonth();
		
		/*Year*/
		public List<Daily> SearchByDetailParticularYear(Date date1);
		public List<Daily> ShowAllTotalOfYear();

}
