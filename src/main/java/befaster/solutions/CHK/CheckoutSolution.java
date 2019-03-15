package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckoutSolution {

    private ValidOffers validOffers;
    private DiscountOffers discountOffers;

    public Integer checkout(String skus) {
        Integer sum = 0;
        Map<Item, Integer> frequency = populateFrequency(skus);
        for (char sku : skus.toCharArray()) {
            if (skuNotValid(sku)) {
                return -1;
            }
        }
        Map<Item, List<Discount>> offers = OfferGenerator.generate();

        return calculateDiscounts(frequency, skus, offers) + calculateRemainingProducts(frequency);
    }

    private Integer calculateRemainingProducts(Map<Item, Integer> frequency) {
        Integer sum = 0;
        for (Item item : Item.values()) {
            sum = sum + (item.getPrice()*frequency.get(item));
        }
        return sum;
    }

    private Integer calculateDiscounts(Map<Item, Integer> frequency, String skus, Map<Item, List<Discount>> offers) {
        Integer totalCost = 0;
        for (char product : skus.toCharArray()) {
            Item item = mapCharToItem(product);
            Integer quantity = frequency.getOrDefault(item, 0);
            List<Discount> discounts = offers.get(item);
            for (int i=0; discounts != null && i < discounts.size(); i++) {
                Discount discount = discounts.get(i);
                if (quantity >= discount.getQuantity() && discount.getItemForFree() == null) {
                    totalCost = discount.getPrice();
                    frequency.put(item, frequency.get(item) - discount.getQuantity());
                } else if (discount.getPrice() == null) {
                    frequency.put(discount.getItemForFree(), frequency.get(mapCharToItem(product)) - 1);
                }
            }
        }
        return totalCost;
    }

    private Map<Item, Integer> populateFrequency(String skus) {
        Map<Item, Integer> frequency = new HashMap<>();
        for(char product : skus.toCharArray()) {
            Item item = mapCharToItem(product);
            Integer productFrequency = frequency.getOrDefault(item, 0);
            frequency.put(item, ++productFrequency);
        }
        return frequency;
    }

    private Item mapCharToItem(char product) {
        for (Item item : Item.values()) {
            if (item.getCharacter() == product) {
                return item;
            }
        }
        return null;
    }

    private boolean skuNotValid(char sku) {
        return sku != 'A' && sku != 'B' && sku != 'C' && sku != 'D' && sku != 'E';
    }

    private Integer mapSkuToCost(char sku) {
        Integer cost = 0;
        if (sku == 'A') {
            cost = 50;
        } else if (sku == 'B') {
            cost = 30;
        } else if (sku == 'C') {
            cost = 20;
        } else if (sku == 'D') {
            cost = 15;
        } else if (sku == 'E') {
            cost = 40;
        }
        return cost;
    }
}

