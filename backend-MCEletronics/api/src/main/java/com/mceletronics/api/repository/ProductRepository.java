package com.mceletronics.api.repository;

import com.mceletronics.api.model.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	@Query("FROM Product WHERE name LIKE ?1% ")
	List <Product> findByProductNameStartingWith(String name);
}
