package in.codertechnologies.pettycash.dto;

public class DetailsDailyMonthly 
{
	private Daily dailyDetailsDailyMonthly;
	private int monthlyTotal;
	@Override
	public String toString() {
		return "DetailsDailyMonthly [dailyDetailsDailyMonthly=" + dailyDetailsDailyMonthly + ", monthlyTotal="
				+ monthlyTotal + "]";
	}
	public Daily getDailyDetailsDailyMonthly() {
		return dailyDetailsDailyMonthly;
	}
	public void setDailyDetailsDailyMonthly(Daily dailyDetailsDailyMonthly) {
		this.dailyDetailsDailyMonthly = dailyDetailsDailyMonthly;
	}
	public int getMonthlyTotal() {
		return monthlyTotal;
	}
	public void setMonthlyTotal(int monthlyTotal) {
		this.monthlyTotal = monthlyTotal;
	}
}
