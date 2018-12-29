package app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

import app.domain.DateFormula;

@Mapper
public interface DateFormulaMapper {
	
	//日付計算式の一覧をID順で取得する。
	@Select("SELECT * FROM date_calculation ORDER BY date_id")
	List<DateFormula> select();

	//プライマリーキー(dateId)を指定し日付計算式を取得する。
	@Select("SELECT * FROM date_calculation WHERE date_id = #{dateId}")
	DateFormula selectPK(String dateId);
	
	//日付計算式を新規登録する。
	@Insert("INSERT INTO date_calculation VALUES(#{date_id}, #{date_name}, #{cf_year}, #{cf_month}, #{cf_day})")
	void insert(DateFormula dateFormula);
	
	//日付計算式の内容を更新する。
	@Update("UPDATE date_calculation SET date_name = #{date_name},  cf_year = #{cf_year}, cf_month = #{cf_month}, cf_day = #{cf_day} WHERE date_id = #{date_id}")
	void update(DateFormula dateFormula);
	
	//プライマリーキー(dateId)を指定し日付計算式を削除する。
	@Delete("DELETE FROM date_calculation WHERE date_id = #{date_id}")
	void deletePK(String dateId);
}