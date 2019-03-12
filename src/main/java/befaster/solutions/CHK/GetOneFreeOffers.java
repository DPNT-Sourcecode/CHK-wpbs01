package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.Map;

public class GetOneFreeOffers {
    private static Map<Item, Map<Integer, Item>> offers = new HashMap<>();

    static {
        offers.put(Item.E, offerE());
    }

    private static Map<Integer, Item> offerE() {
        Map<Integer, Item> offer = new HashMap<>();
        offer.put(2, Item.B);
        return offer;
    }

    public static Map<Item, Map<Integer, Item>> getOffers() {
        return offers;
    }
}

