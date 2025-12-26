DELIMITER $$

CREATE PROCEDURE findProductByPrice (
    minPrice DECIMAL(10,2),
    maxPrice DECIMAL(10,2)
)
BEGIN
    SELECT id, name, price, description, category_id
    FROM product
    WHERE price BETWEEN minPrice AND maxPrice;
END $$

DELIMITER ;