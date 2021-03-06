package kata.supermarket.discount;

import java.math.BigDecimal;
import java.util.List;

public class DiscountCalculator {
    public static BigDecimal calculateTotalDiscount(List<Discount> discountList){
        BigDecimal totalDiscount = BigDecimal.ZERO;

        for (Discount discount : discountList) {
            totalDiscount = totalDiscount.add(discount.calculateDiscount());
        }

        return totalDiscount;
    }
}
