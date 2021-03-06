package kata.supermarket;

import kata.supermarket.discount.BuyOneGetOneFreeDiscount;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DiscountTest {

    @Test
    void buyOneGetOneFreeTest(){
        Product product = new Product(BigDecimal.valueOf(15.00));
        Item item = product.oneOf();
        WeighedProduct weighedProduct = new WeighedProduct(BigDecimal.valueOf(1.00));

        Basket basket = new Basket();
        basket.addDiscount(new BuyOneGetOneFreeDiscount());
        basket.add(item);
        basket.add(weighedProduct.weighing(BigDecimal.valueOf(20)));

        assertEquals(BigDecimal.valueOf(20).doubleValue(),basket.total().doubleValue());
    }

}
