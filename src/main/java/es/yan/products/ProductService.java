package es.yan.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Transactional
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	@Transactional
	public Product deleteProductById(Long id) {
		Product productDisable = productRepository.findById(id).orElse(null);
		if (productDisable != null) {
			productDisable.setEnable(false);
			productRepository.save(productDisable);
		}
		return productDisable;
	}

	public List<Product> getAllElement() {
		return productRepository.findAll();
	}

	public Product getElementById(Long id) {
		return productRepository.findById(id).orElse(null);
	}
}
