package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.Map;

public class ValidOffers {

    private Map<Item, Integer> validOffers = new HashMap<>();

    public Map<Item, Integer> getValidOffers() {
        return validOffers;
    }

    public void setValidOffers(Map<Item, Integer> validOffers) {
        this.validOffers = validOffers;
    }
}


