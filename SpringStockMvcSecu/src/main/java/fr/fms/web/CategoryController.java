/**
 * 
 */
package fr.fms.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.fms.dao.CategoryRepository;
import fr.fms.entities.Category;

/**
 * @author Stagiaires10P
 *
 */
@Controller
public class CategoryController {
	@Autowired
	CategoryRepository categoryRepository;
	
	@GetMapping("/categories")
	public String categories(Model model) {
		List<Category> categories = categoryRepository.findAll();
		model.addAttribute("listCategory", categories);
		
		return "categories/categories";
	}
	
//	@GetMapping("/displayCategory")
//	public List<Category> displayCategory(int id){
//		List<Category> categories = categoryRepository.findAll();
//		return ;
//	}
}
