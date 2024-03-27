package es.yan.categorys;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class ControllerCategory {
	
	private CategoryService categoryService;
	
	@PostMapping("/addCategory")
	public Category addCategory(@RequestBody Category category) {
		return categoryService.addCategory(category);
	}

	@GetMapping("/deleteCategory")
	public Category deleteCategory(@RequestParam Long id) {
		return categoryService.deleteCategory(id);
	}

	@GetMapping("/getAllCategory")
	public List<Category> getAllCategory() {
		return categoryService.getAllCategory();
	}

	@GetMapping("/getCategoryById")
	public Category getCategoryById(@RequestParam Long id) {
		return categoryService.getCategoryById(id);
	}

}
