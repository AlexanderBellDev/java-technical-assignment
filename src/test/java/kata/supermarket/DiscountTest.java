package kata.supermarket;

import kata.supermarket.discount.BuyOneGetOneFreeDiscount;
import kata.supermarket.discount.BuyThreeItemsForPriceOfTwoDiscount;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DiscountTest {

    @Test
    void buyOneGetOneFreeTest(){
        Product product = new Product(BigDecimal.valueOf(15.00));
        WeighedProduct weighedProduct = new WeighedProduct(BigDecimal.valueOf(1.00));

        Basket basket = new Basket();
        basket.addDiscount(new BuyOneGetOneFreeDiscount());
        basket.add(product.oneOf());
        basket.add(weighedProduct.weighing(BigDecimal.valueOf(20)));

        assertEquals(BigDecimal.valueOf(20).doubleValue(),basket.total().doubleValue());
    }

    @Test
    void buyThreeItemsForPriceOfTwoTest(){
        Product productOne = new Product(BigDecimal.valueOf(15.00));
        Product productTwo = new Product(BigDecimal.valueOf(5.00));


        Basket basket = new Basket();
        basket.addDiscount(new BuyThreeItemsForPriceOfTwoDiscount());
        basket.add(productOne.oneOf());
        basket.add(productOne.oneOf());
        basket.add(productOne.oneOf());
        basket.add(productTwo.oneOf());
        basket.add(productTwo.oneOf());
        basket.add(productTwo.oneOf());

        assertEquals(BigDecimal.valueOf(55).doubleValue(),basket.total().doubleValue());
    }

}
