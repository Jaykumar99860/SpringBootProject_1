package com.example.ProjectJK_1123_2;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByCode(String code);

    Optional<Product> findById(long id);

//    void save(Product pr);
}
