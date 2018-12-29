package app.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormula {
	
	private String date_id = "D00";
	private String date_name = "";
	private int cf_year = 0;
	private int cf_month = 0;
	private int cf_day = 0;
	private String resultDate = "9999/12/31";
	
	public DateFormula(){
	}
	
	public DateFormula DateConversion(String inputDate) {
		LocalDate baseDate = LocalDate.parse(inputDate,DateTimeFormatter.ofPattern("yyyyMMdd"));
		LocalDate result = baseDate.plusYears(cf_year).plusMonths(cf_month).plusDays(cf_day);
		this.resultDate = result.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		return this;
	}
	
	public String getDateId() {
		return date_id;
	}
	
	public void setDateId(String date_id) {
		this.date_id = date_id;
	}

	public String getDateName() {
		return date_name;
	}
	
	public void setDateName(String date_name) {
		this.date_name = date_name;
	}
	
	public int getCfYear() {
		return cf_year;
	}
	
	public void setCfYear(int cf_year) {
		this.cf_year = cf_year;
	}

	public int getCfMonth() {
		return cf_month;
	}
	
	public void setCfMonth(int cf_month) {
		this.cf_month = cf_month;
	}
	
	public int getCfDay() {
		return cf_day;
	}
	
	public void setCfDay(int cf_day) {
		this.cf_day = cf_day;
	}
	
	public String getResultDate() {
		return resultDate;
	}
	
	public void setResultDate(String resultDate) {
		this.resultDate = resultDate;
	}
}