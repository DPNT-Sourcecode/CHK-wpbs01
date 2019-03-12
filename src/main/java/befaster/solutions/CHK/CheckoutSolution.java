package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.Map;

public class CheckoutSolution {

    private ValidOffers validOffers;
    private DiscountOffers discountOffers;

    public Integer checkout(String skus) {
        Integer sum = 0;
        validOffers = new ValidOffers();
        discountOffers = new DiscountOffers();
        for (char sku : skus.toCharArray()) {
            if (skuNotValid(sku)) {
                return -1;
            }
            countOffersEligibleProducts(sku);
            sum += mapSkuToCost(sku);
        }
        sum = applyOffersDiscount(sum);
        return sum;
    }

    private Integer applyOffersDiscount(Integer sum) {
        Map<Item, Map<Integer, Integer>> discountOffers = (new DiscountOffers()).getOffers();
        for (Item item : discountOffers.keySet()) {
            Map<Integer, Integer> discounts = discountOffers.get(item);
            if(discounts != null){
                for(Integer amountOfOffer : discounts.keySet()){
                    if((validOffers.getValidOffers() != null) && (validOffers.getValidOffers().get(item) > amountOfOffer)) {
                        int validFullOfferItem = validOffers.getValidOffers().get(item)/amountOfOffer;
                        sum = sum + validFullOfferItem*item.getPrice() - validFullOfferItem*amountOfOffer*discountOffers.get(item).get(amountOfOffer);
                    }
                }
            }

        }
        return sum;
    }

    private void countOffersEligibleProducts(char sku) {

        for (Item item : Item.values()) {
            if (sku == item.getCharacter()){
                Map<Integer, Integer> validOffer = discountOffers.getOffers().get(item);
                if(validOffer != null) {
                    Integer numberOfValidProducts = validOffers.getValidOffers().get(item);
                    numberOfValidProducts++;
                    HashMap<Item, Integer> map = new HashMap<>();
                    map.put(item, numberOfValidProducts);
                    validOffers.setValidOffers(map);
                }
            }
        }
    }

    private boolean skuNotValid(char sku) {
        return sku != 'A' && sku != 'B' && sku != 'C' && sku != 'D';
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



