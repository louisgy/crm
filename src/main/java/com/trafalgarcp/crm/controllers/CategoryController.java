package com.trafalgarcp.crm.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.trafalgarcp.crm.domain.Category;
import com.trafalgarcp.crm.domain.Industry;
import com.trafalgarcp.crm.repository.CategoryRepository;

@Controller
public class CategoryController {

	@Autowired
	CategoryRepository categoryRepository;

	Category categorytest;

	/*
	 * Show new Category form
	 */

	public CategoryController() {
		super();
		categorytest = new Category();
		// TODO Auto-generated constructor stub
	}

	@GetMapping("/category/new")
	public String showCategoryForm(Model model) {

		Category category = new Category();
		List<String> categories = new ArrayList<String>();
		List<String> subcategories = new ArrayList<String>();
		subcategories = this.categoryRepository.findDistinctSubcategorie();

		categories = this.categoryRepository.findDistinctCategorie();

		System.out.println("\n\n" + "**************");
		categories.forEach(System.out::println);
		System.out.println("\n\n");
		subcategories.forEach(System.out::println);
		System.out.println("\n\n" + "****************");

		model.addAttribute("category", category);
		model.addAttribute("categories", categories);
		model.addAttribute("subcategories", subcategories);

		return "category/category-form";
	}

	/*
	 * Create new category
	 */

	@PostMapping("/category/new")
	public String processCategoryForm(Category category, Model model) {
		System.out.println("\n" + "^^^^^^^^^^^^^^^^^^^^^^^" + "^^^^^^^^^^^^^^^^^^^^^^^" + "\n");

		System.out.println("\n" + "^^^^^^^^^^^^^^^^^^^^^^^" + category.getCategorie() + "^^^^^^^^"
				+ category.getCategorie() + "^^^^^^^^^^^^^^^" + "\n");

		this.categoryRepository.save(category);
		return "category/category-view";
	}

	/*
	 * Show edit category form
	 */
	@GetMapping("/category/{categoryId}/edit")
	public String showUpdateForm(@PathVariable Integer categoryId, Model model) {
		List<String> categories = new ArrayList<String>();
		List<String> subcategories = new ArrayList<String>();
		subcategories = this.categoryRepository.findDistinctSubcategorie();

		categories = this.categoryRepository.findDistinctCategorie();
		Category category = new Category();
		category = this.categoryRepository.findById(categoryId).get();

		// System.out.println("\n\n"+categoryId+"\n\n"); // THESE 2 CAN BE DELETED
		// s System.out.println("\n\n"+category.getCategorie()+"\n\n");

		model.addAttribute("category", category);
		model.addAttribute("categories", categories);
		model.addAttribute("subcategories", subcategories);
		return "category/category-form";
	}

	/*
	 * Process edit category form
	 */
	@PostMapping("/category/{categoryId}/edit")
	public String processUpdateForm(Category old_category, Model model) {
		Category category = new Category();
		category.setId(old_category.getId());
		// model.addAttribute("category",category);
		model.addAttribute("isDelete", "no");
		this.categoryRepository.save(old_category);
		return "category/category-view";

	}

	/*
	 * Show All Categories
	 */
	@GetMapping("/category")
	public String showAllCategories(Model model) {
		Category category = new Category();
		List<Category> categories = this.categoryRepository.findAll();
		model.addAttribute("categories", categories);
		model.addAttribute("category", category);
		return "category/category-items";
	}

	/*
	 * Delete a category (Show)
	 */
	@GetMapping("/category/{categoryId}/del")
	public String showDeleteACategory(@PathVariable Integer categoryId, Model model) {
		// this.categoryRepository.delete(this.categoryRepository.findById(categoryId).get());
		// categorytaest=this.categoryRepository.findById(categoryId).get();
		Optional<Category> category = this.categoryRepository.findById(categoryId);

		Category category1 = category.orElse(new Category());
		model.addAttribute("category", category1);
		model.addAttribute("isDelete", "yes");
		return "category/category-view";
	}

	@PostMapping("/category/{categoryId}/del")
	public String deleteACategory(@PathVariable Integer categoryId, Model model) {
        System.out.println("\n"+categoryId+"\n");
		Optional<Category> category = this.categoryRepository.findById(categoryId);
		if(category.isPresent()) {
			System.out.println("\n"+"********************"+category.get().getCategorie()+"***********"+"\n");
			 this.categoryRepository.delete(category.orElse(new Category()));
		}
//		Category categor = category.orElse(new Category());
//		System.out.println("\n\n");
//		System.out.println(category.toString());
//		System.out.println("\n\n");
//        ÷≥≥if (category.isPresent()) {
//			company1 = companyRepository.findById(id).get();
//		}
		

		model.addAttribute("category", categorytest);
		model.addAttribute("isDelete", "yes");
		return "redirect:/category/";
	}

}
