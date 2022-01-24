package com.uniware.ecommerce.repository;

import com.uniware.ecommerce.model.entity.ShoppingCartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartEntityRepository extends JpaRepository<ShoppingCartEntity, Long> {

}