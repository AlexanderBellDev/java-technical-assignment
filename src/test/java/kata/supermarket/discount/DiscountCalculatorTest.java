package kata.supermarket.discount;

import kata.supermarket.Basket;
import kata.supermarket.Item;
import kata.supermarket.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DiscountCalculatorTest {

    @Test
    void calculateTotalDiscount() {
        Product productOne = new Product(BigDecimal.valueOf(15.00));
        Product productTwo = new Product(BigDecimal.valueOf(5.00));

        Basket basket = new Basket();
        ArrayList<Item> items = new ArrayList<>(List.of(productOne.oneOf(), productOne.oneOf(), productOne.oneOf(),
                productTwo.oneOf(), productTwo.oneOf(), productTwo.oneOf()));

        ArrayList<Discount> discountList = new ArrayList<>(List.of(new BuyThreeItemsForPriceOfTwoDiscount(items), new BuyOneGetOneFreeDiscount(items)));
        BigDecimal totalDiscount = DiscountCalculator.calculateTotalDiscount(discountList);

        assertEquals(BigDecimal.valueOf(10).doubleValue(),totalDiscount.doubleValue());
    }
}