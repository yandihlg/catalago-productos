package es.yan.categorys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryService {

	@Autowired
	private CategoryReopository categoryRepository;

	@Transactional
	public Category addCategory(Category category) {
		return categoryRepository.save(category);
	}

	@Transactional
	public Category deleteCategory(Long id) {
		Category category = categoryRepository.findById(id).orElse(null);
		if (category != null) {
			category.setEnable(false);
			categoryRepository.save(category);
		}
		return category;
	}

	public List<Category> getAllCategory() {
		return categoryRepository.findAll();
	}

	public Category getCategoryById(Long id) {
		return categoryRepository.findById(id).orElse(null);
	}
}
