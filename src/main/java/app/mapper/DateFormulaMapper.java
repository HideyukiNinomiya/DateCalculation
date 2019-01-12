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
	@Select("SELECT * FROM dateCalculation ORDER BY dateId")
	List<DateFormula> select();

	//プライマリーキー(dateId)を指定し日付計算式を取得する。
	@Select("SELECT * FROM dateCalculation WHERE dateId = #{dateId}")
	DateFormula selectPK(String dateId);
	
	//日付計算式を新規登録する。
	@Insert("INSERT INTO dateCalculation VALUES(#{dateId}, #{dateName}, #{formulaYear}, #{formulaMonth}, #{formulaDay})")
	void insert(DateFormula dateFormula);
	
	//日付計算式の内容を更新する。
	@Update("UPDATE dateCalculation SET dateName = #{dateName},  formulaYear = #{formulaYear}, formulaMonth = #{formulaMonth}, formulaDay = #{formulaDay} WHERE dateId = #{dateId}")
	void update(DateFormula dateFormula);
	
	//プライマリーキー(dateId)を指定し日付計算式を削除する。
	@Delete("DELETE FROM dateCalculation WHERE dateId = #{dateId}")
	void deletePK(String dateId);
}