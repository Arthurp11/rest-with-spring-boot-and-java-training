package com.github.Arthurp11.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.Arthurp11.model.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long>{}
