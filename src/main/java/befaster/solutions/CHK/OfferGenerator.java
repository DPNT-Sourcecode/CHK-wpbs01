package befaster.solutions.CHK;

import java.util.*;

public class OfferGenerator {
    public static Map<Item, List<Discount>> generate() {
        Map<Item, List<Discount>> offers = new HashMap<>();
        offers.put(Item.A, Arrays.asList(new Discount(5, 200, null), new Discount(3, 130, null)));
        offers.put(Item.B, Arrays.asList(new Discount(2, 45, null)));
        offers.put(Item.E, Arrays.asList(new Discount(2, null, Item.B)));
        return Collections.unmodifiableMap(offers);
    }
}
