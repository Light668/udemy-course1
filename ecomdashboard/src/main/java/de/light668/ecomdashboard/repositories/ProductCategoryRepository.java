/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.light668.ecomdashboard.repositories;

import de.light668.ecomdashboard.entity.ProductCategory;
import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Timo Radtke
 */
@Repository
@Qualifier(value= "productCategoryRepository")
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
    
    List<ProductCategory> findByBestCategory(boolean bestCategory);
}
