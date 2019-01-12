package app.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormula {
	//デフォルト値入れすぎ！
	private String dateId = "D00";
	private String dateName = "";
	private int formulaYear = 0;
	private int formulaMonth = 0;
	private int formulaDay = 0;
	private String resultDate = "9999/12/31";
	
	public DateFormula(){
	}
	
	public DateFormula DateConversion(String inputDate) {
		LocalDate baseDate = LocalDate.parse(inputDate,DateTimeFormatter.ofPattern("yyyyMMdd"));
		LocalDate result = baseDate.plusYears(formulaYear).plusMonths(formulaMonth).plusDays(formulaDay);
		this.resultDate = result.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		return this;
	}
	
	public String getDateId() {
		return dateId;
	}
	
	public void setDateId(String dateId) {
		this.dateId = dateId;
	}

	public String getDateName() {
		return dateName;
	}
	
	public void setDateName(String dateName) {
		this.dateName = dateName;
	}
	
	public int getFormulaYear() {
		return formulaYear;
	}
	
	public void setFormulaYear(int formulaYear) {
		this.formulaYear = formulaYear;
	}

	public int getFormulaMonth() {
		return formulaMonth;
	}
	
	public void setFormulaMonth(int formulaMonth) {
		this.formulaMonth = formulaMonth;
	}
	
	public int getFormulaDay() {
		return formulaDay;
	}
	
	public void setFormulaDay(int formulaDay) {
		this.formulaDay = formulaDay;
	}
	
	public String getResultDate() {
		return resultDate;
	}
	
	public void setResultDate(String resultDate) {
		this.resultDate = resultDate;
	}
}