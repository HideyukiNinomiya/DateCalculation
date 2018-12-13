package app.controller;

import java.util.List;
import java.util.Map;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.jdbc.core.JdbcTemplate;

import app.domain.DateCalculation;

@Controller
public class IndexController {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
    @ModelAttribute
    DateCalculation setUpForm() {
        return new DateCalculation();
    }
	
	@RequestMapping("/")	
	public String index(Model model) {
		List<Map<String,Object>> list;
		list = jdbcTemplate.queryForList("select * from date_calculation");
		model.addAttribute("dateCalculation", list);
		return "index";
	}

	@RequestMapping("/result")	
	public String index2(@ModelAttribute("basedate") String basedate ,Model model) {
		List<Map<String,Object>> list;
		list = jdbcTemplate.queryForList("select * from date_calculation");
		model.addAttribute("dateCalculation", list);
		LocalDate cfDate = LocalDate.parse(basedate,DateTimeFormatter.ofPattern("yyyyMMdd"));
		model.addAttribute("cfDate",cfDate);
		return "index";
	}
	
}