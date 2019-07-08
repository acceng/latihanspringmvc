package com.eksad.latihanspringmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eksad.latihanspringmvc.model.Brand;
import com.eksad.latihanspringmvc.repository.BrandDaoRepository;

@Controller
@RequestMapping("/tugasbrand")
public class BrandController {

	@Autowired
	BrandDaoRepository brandDaoRepository;

	@RequestMapping("/")
	public String index(Model modelx) {

		List<Brand> listbaru = (List<Brand>) brandDaoRepository.findAll();

		modelx.addAttribute("listBrand", listbaru);

		return "listbrand";

	}
	
	@RequestMapping("/tambah")
	public String addBrand(Model modely) {

		Brand brandy = new Brand();

		modely.addAttribute("Brandnew", brandy);

		return "addbrand";

	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String saveBrand(@ModelAttribute Brand brand) {
		
		brandDaoRepository.save(brand);
		
		return "redirect:/tugasbrand/";
	}
	
	@RequestMapping("delete/{id}")
	public String deleteBrand(@PathVariable Long id) {
		
		brandDaoRepository.delete(id);
		return "redirect:/tugasbrand/";	
	}
	
	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public String editBrand(@PathVariable Long id, Model model) {
		
		Brand brand = brandDaoRepository.findOne(id);
		model.addAttribute("Brandnew", brand);
		
		return "addbrand";
		
	}
	

}

    

