package com.SpringTest.SpringTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringTest.SpringTest.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
