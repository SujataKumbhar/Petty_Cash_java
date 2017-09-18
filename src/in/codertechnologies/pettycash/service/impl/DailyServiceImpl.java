package in.codertechnologies.pettycash.service.impl;

import java.sql.Date;
import java.util.List;

import in.codertechnologies.pettycash.dao.DailyDao;
import in.codertechnologies.pettycash.dao.impl.DailyDaoImpl;
import in.codertechnologies.pettycash.dto.Daily;
import in.codertechnologies.pettycash.dto.DetailsDailyMonthly;
import in.codertechnologies.pettycash.exceptions.DataNotFoundException;
import in.codertechnologies.pettycash.service.DailyService;

public class DailyServiceImpl implements DailyService{

	private DailyDao dailydao;
	
	public DailyServiceImpl()
	{
		dailydao=new DailyDaoImpl();
	}
	@Override
	public boolean addDaily(Daily daily) 
	{
		return dailydao.addDaily(daily);
	}

	@Override
	public boolean updateDaily(Daily daily) 
	{
		return dailydao.updateDaily(daily);
	}

	@Override
	public boolean deleteDaily(int did) throws DataNotFoundException 
	{
		return dailydao.deleteDaily(did);
	}

	@Override
	public Daily findDaily(int did) throws DataNotFoundException 
	{
		return dailydao.findDaily(did);
	}
	@Override
	public List<Daily> getAllDaily() {
	
		return dailydao.getAllDaily();
	}
	@Override
	public List<Daily> SearchByDetailParticularDate(Date date1) {
		// TODO Auto-generated method stub
		return dailydao.SearchByDetailParticularDate(date1);
	}
	@Override
	public List<Daily> ShowAllTotalOfDay() {
		// TODO Auto-generated method stub
		return dailydao.ShowAllTotalOfDay();
	}
	@Override
	public List<Daily> SearchByDetailParticularMonth(Date date1) {
		// TODO Auto-generated method stub
		return dailydao.SearchByDetailParticularMonth(date1);
	}
	@Override
	public List<Daily> ShowAllTotalOfMonth() {
		// TODO Auto-generated method stub
		return dailydao.ShowAllTotalOfMonth();
	}
	@Override
	public List<Daily> ShowAllTotalOfYear() {
		// TODO Auto-generated method stub
		return dailydao.ShowAllTotalOfYear();
	}
	@Override
	public List<Daily> SearchByDetailParticularYear(Date date1) {
		// TODO Auto-generated method stub
		return dailydao.SearchByDetailParticularYear(date1);
	}
	
	
}
