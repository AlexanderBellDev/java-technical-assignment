package kata.supermarket.discount;

import kata.supermarket.Item;

import java.math.BigDecimal;
import java.util.List;

public abstract class Discount {
    List<Item> currentBasket;

    public void setCurrentBasket(List<Item> currentBasket) {
        this.currentBasket = currentBasket;
    }

    public Discount() {
    }

    public Discount(List<Item> currentBasket) {
        this.currentBasket = currentBasket;
    }

    public abstract BigDecimal calculateDiscount();

}
