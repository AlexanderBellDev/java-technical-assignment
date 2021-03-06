package kata.supermarket.discount;

import kata.supermarket.Item;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class BuyThreeItemsForPriceOfTwoDiscount extends Discount {

    public BuyThreeItemsForPriceOfTwoDiscount() {
    }

    public BuyThreeItemsForPriceOfTwoDiscount(List<Item> currentBasket) {
        super(currentBasket);
    }

    @Override
    public BigDecimal calculateDiscount() {
        if(currentBasket.size() < 2) return BigDecimal.ZERO;

        Map<BigDecimal, List<Item>> itemByPriceMap = currentBasket.stream()
                .collect(Collectors.groupingBy(Item::price));

        TreeMap<BigDecimal, List<Item>> ascendingOrderMap = new TreeMap<>();
        itemByPriceMap.forEach(ascendingOrderMap::put);

        for (BigDecimal prices : ascendingOrderMap.keySet()) {
            // if there is an item with a quantity of three it will discount one of them
            // it will try the cheapest items first
            if(ascendingOrderMap.get(prices).size() >= 3){
                return prices;
            }
        }

        //if no items exist with the quantity of three
        return BigDecimal.ZERO;
    }
}
