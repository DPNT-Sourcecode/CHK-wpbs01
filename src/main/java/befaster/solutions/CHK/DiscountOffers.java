package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.Map;

public class DiscountOffers {
    private static Map<Item, Map<Integer, Integer>> offers = new HashMap<>();

    static {
        offers.put(Item.A, offerA());
        offers.put(Item.B, offerA());
        offers.put(Item.E, offerA());
    }

    private static Map<Integer, Integer> offerA() {
        Map<Integer, Integer> offer = new HashMap<>();
        offer.put(3, 130);
        offer.put(5, 200);
        return offer;
    }

    private static Map<Integer, Integer> offerB() {
        Map<Integer, Integer> offer = new HashMap<>();
        offer.put(2, 145);
        return offer;
    }

    private static Map<Integer, Integer> offerE() {
        Map<Integer, Integer> offer = new HashMap<>();
        offer.put(2, 145);
        return offer;
    }
}
