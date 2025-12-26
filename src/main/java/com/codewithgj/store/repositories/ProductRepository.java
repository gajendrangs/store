package com.codewithgj.store.repositories;

import com.codewithgj.store.dtos.ProductSummary;
import com.codewithgj.store.dtos.ProductSummaryDTO;
import com.codewithgj.store.entities.Category;
import com.codewithgj.store.entities.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    public List<Product> findByPriceBetweenOrderByName(BigDecimal min, BigDecimal max);

    //@Query(value="select p from Product p where p.price between :min and :max order by p.name")
    @Procedure("findProductByPrice")
    public List<Product> findProducts(double min, double max);

    @Modifying
    @Query(value = "update Product p set p.price = :price where p.category.id = :categoryId" )
    public void updatePriceByCategory(double price, Byte categoryId);

    @Query("select new com.codewithgj.store.dtos.ProductSummaryDTO(p.id, p.name) from Product p where p.category = :category")
    public List<ProductSummaryDTO> findByCategory(@Param("category") Category category);
}
