package app.controller;

import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import app.domain.DateFormula;
import app.service.CalculationService;

@Controller
public class CalculationController {
    
	@Autowired
	CalculationService service;
	
	//計算式・結果の一覧画面を表示する。
	@GetMapping("/")	
	public String index(Model model) {
		LocalDate localDate = LocalDate.now();
		String baseDate = localDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
		model.addAttribute("results",service.calculation(baseDate));
		model.addAttribute("baseDate",baseDate);
		return "index";
	}

	//計算基準日に計算式を反映した後の計算式・結果の一覧画面を表示する。
	@PostMapping("/result")
	public String index(@ModelAttribute("baseDate") String baseDate,Model model) {
		model.addAttribute("results",service.calculation(baseDate));
		model.addAttribute("baseDate",baseDate);
		return "index";		
	}
	
	//計算式の新規登録画面を表示する。
	@GetMapping("/new")
	public String register(Model model) {
		model.addAttribute("dateFormula",new DateFormula());
		return "register";
	}
	
	//新規登録画面の入力内容をDBに反映し一覧画面に戻る。
	@PostMapping("/register")
	public String register(@ModelAttribute DateFormula dateFormula,Model model) {
		service.register(dateFormula);
		return index(model);
	}
	
	//計算式の編集画面を表示する。
	@GetMapping("/edit/{dateId}")
	public String edit(@PathVariable String dateId,Model model) {
		model.addAttribute("dateFormula",service.search(dateId));
		return "edit";
	}

	//編集画面の変更内容をDBに反映し一覧画面に戻る。
	@PostMapping("/edit/{dateId}")
	public String edit(DateFormula dateFormula,Model model) {
		service.update(dateFormula);
		return index(model);
	}
	
	//計算式をDBから削除する。
	@PostMapping("/delete/{dateId}")
	public String delete(@PathVariable String dateId,Model model) {
		service.delete(dateId);
		return index(model);
	}
}