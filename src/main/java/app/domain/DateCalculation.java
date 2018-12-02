package app.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.StringJoiner;

public class DateCalculation {
	
	String date_id;
	String date_name;
	int cf_year;
	int cf_month;
	int cf_day;
	String calculated;
	
	public String getdate_id() {
		return date_name;
	}
	
	public void setdate_id(String date_id) {
		this.date_id = date_id;
	}

	public String getdate_name() {
		return date_name;
	}
	
	public void setdate_name(String date_name) {
		this.date_name = date_name;
	}
	
	public void setcf_year(int cf_year) {
		this.cf_year = cf_year;
	}

	public void setcf_month(int cf_month) {
		this.cf_month = cf_month;
	}
	
	public void setcf_day(int cf_day) {
		this.cf_day = cf_day;
	}
	
	public String getCaculated() {
		return calculated;
	}
	
	public void calculate(String baseDate) {
		LocalDate date = LocalDate.parse(baseDate, DateTimeFormatter.ofPattern("yyyyMMdd"));
		LocalDate calculatedDate = date.plusYears(cf_year).plusMonths(cf_month).plusDays(cf_day);
		calculated = calculatedDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
	}

	public String getFormula() {
		int[] formula = {cf_year, cf_month, cf_day};
		StringJoiner joiner = new StringJoiner(" / ");
		Arrays.stream(formula).forEach(i -> joiner.add(String.valueOf(i)));
		return joiner.toString();
	}
	
}
