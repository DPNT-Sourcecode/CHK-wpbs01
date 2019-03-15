package befaster.solutions.CHK;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CheckoutSolution {

    public Integer checkout(String skus) {
        for (char sku : skus.toCharArray()) {
            if (skuNotValid(sku)) {
                return -1;
            }
        }
        Map<Item, List<Discount>> offers = OfferGenerator.generate();
        Map<Item, Integer> frequency = populateFrequency(skus);
        return calculateDiscounts(frequency, skus, offers) + calculateRemainingProducts(frequency);
    }

    private Integer calculateRemainingProducts(Map<Item, Integer> frequency) {
        Integer sum = 0;
        for (Item item : Item.values()) {
            Integer itemFrequency = frequency.getOrDefault(item, 0);
            if (itemFrequency > 0) {
                sum = sum + (item.getPrice()*itemFrequency);
            }
        }
        return sum;
    }

    private Integer calculateDiscounts(Map<Item, Integer> frequency, String skus, Map<Item, List<Discount>> offers) {
        Integer totalCost = 0;
        for (char product : skus.toCharArray()) {
            Item item = mapCharToItem(product);
            Integer quantity = frequency.getOrDefault(item, 0);
            boolean discountApplied = false;
            List<Discount> discounts = offers.getOrDefault(item, new ArrayList<>());
            ArrayList<Discount> getOneFreeDiscounts = discounts.stream().filter(d -> d.getItemForFree() != null).collect(Collectors.toCollection(ArrayList::new));
            ArrayList<Discount> multipackDiscounts = discounts.stream().filter(d -> d.getPrice() != null).collect(Collectors.toCollection(ArrayList::new));
            for (Discount discount : getOneFreeDiscounts) {
                if (quantity >= discount.getQuantity() && discount.getPrice() == null && !discountApplied) {
                    discountApplied = true;
                    frequency.put(discount.getItemForFree(), frequency.getOrDefault(discount.getItemForFree(), 0) - 1);
                }
            }
            for (Discount discount : multipackDiscounts) {
                if (quantity >= discount.getQuantity() && discount.getItemForFree() == null && !discountApplied) {
                    discountApplied = true;
                    totalCost += discount.getPrice();
                    frequency.put(item, frequency.get(item) - discount.getQuantity());
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
}


