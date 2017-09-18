package in.codertechnologies.pettycash.dao;

import java.sql.Date;
import java.util.List;

import in.codertechnologies.pettycash.dto.Daily;
import in.codertechnologies.pettycash.dto.SearchEngine;
import in.codertechnologies.pettycash.exceptions.DataNotFoundException;

public interface DailyDao extends AutoCloseable
{
	 boolean addDaily(Daily daily);
	 boolean updateDaily(Daily daily);
	 boolean deleteDaily(int did)throws DataNotFoundException;
	 Daily findDaily(int did)throws DataNotFoundException;
	 
		List<Daily> getAllDaily();//all details
		
		/*Day*/
		public List<Daily> SearchByDetailParticularDate(Date date1);
		public List<Daily> ShowAllTotalOfDay();
		
		/*Month*/
		public List<Daily> SearchByDetailParticularMonth(Date date1);
		public List<Daily> ShowAllTotalOfMonth();
		
		/*Year*/
		public List<Daily> SearchByDetailParticularYear(Date date1);
		public List<Daily> ShowAllTotalOfYear();
		
		/*Search Engine*/
		public List<SearchEngine> SearchByProduct(String productName);
		public List<SearchEngine> SearchByDate(String date1);
		
		public List<SearchEngine> SearchByMonth(String date1); //Month
		
		
		/*Pagination*/
		
		public List<Daily> getRecords(int offset,int noOfRecords);
		public int getNoOfRecords();
		   
	
		
		

		
}
