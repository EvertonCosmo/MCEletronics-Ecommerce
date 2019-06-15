package com.mceletronics.api.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mceletronics.api.model.Product;
import com.mceletronics.api.repository.ProductRepository;
import com.mceletronics.api.util.Upload;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/MCEletronics/api")
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	@GetMapping("/products")
	public ResponseEntity<List<Product>> getProducts() {

		return new ResponseEntity<List<Product>>(productRepository.findAll(), HttpStatus.OK);
	}

	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable(value = "id") Integer id) {

		Optional<Product> product = productRepository.findById(id);

		if (product.isPresent()) {
			return new ResponseEntity<Product>(product.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/product")
	public ResponseEntity<Product> saveProduct(String name, String category, BigDecimal price, BigDecimal quantity,
			String description, MultipartFile image) {

		if (name == null || category == null || price == null || quantity == null || description == null
				|| image == null || name.equals("null") || category.equals("null") || description.equals("null")) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		Product product = new Product(name, category, price, quantity, description);
		Product productAux = productRepository.save(product);

		try {

			Upload.uploadFile(image.getInputStream(), productAux.getId());
		} catch (IOException e) {

			e.printStackTrace();
		}

		return new ResponseEntity<Product>(product, HttpStatus.OK);

	}

	@DeleteMapping("/product/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable(value = "id") Integer id) {

		if (productRepository.existsById(id)) {

			productRepository.deleteById(id);

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		} else {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/product/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable("id") Integer id, String name, String category,
			BigDecimal price, BigDecimal quantity, String description, MultipartFile image) {

		if (name == null || category == null || price == null || quantity == null || description == null
				|| image == null || name.equals("null") || category.equals("null") || description.equals("null")) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		Optional<Product> product = productRepository.findById(id);

		if (product.isPresent()) {
			product.get().setName(name);
			product.get().setCategory(category);
			product.get().setPrice(price);
			product.get().setQuantity(quantity);
			product.get().setDescription(description);
			productRepository.save(product.get());

			try {
				if (image != null) {
					Upload.uploadFile(image.getInputStream(), id);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			return new ResponseEntity<Product>(product.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
