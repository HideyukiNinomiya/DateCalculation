package app.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import app.domain.DateCalculation;

@Mapper
public interface DateCalculationMapper {
	List<DateCalculation> selectAll();
}
