package kata.supermarket.discount;

import kata.supermarket.Item;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BuyOneGetOneFreeDiscount extends Discount {

    public BuyOneGetOneFreeDiscount() {
    }

    public BuyOneGetOneFreeDiscount(List<Item> currentBasket) {
        super(currentBasket);
    }

    @Override
    public BigDecimal calculateDiscount() {
        if(currentBasket.size() < 2) return BigDecimal.ZERO;

        List<Item> sortItemsByCheapest = currentBasket.stream()
                .sorted(Comparator.comparing(Item::price))
                .collect(Collectors.toList());

        //return cheapest item
        return sortItemsByCheapest.get(0).price();
    }
}
