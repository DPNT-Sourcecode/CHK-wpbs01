package befaster.solutions.CHK;

public class CheckoutSolution {

    private Integer validOfferA = 0;
    private Integer validOfferB = 0;

    public Integer checkout(String skus) {
        Integer sum = 0;
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
        if (validOfferA >= 3) {
            int validFullOfferA = validOfferA/3;
            sum = sum + validFullOfferA*130 - validOfferA*50;
        }
        if (validOfferB >= 2) {
            int validFullOfferB = validOfferB/2;
            sum = sum + validFullOfferB*45 - validOfferB*30;
        }
        return sum;
    }

    private void countOffersEligibleProducts(char sku) {
        if (sku == 'A') {
            validOfferA++;
        } else if (sku == 'B') {
            validOfferB++;
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
        }
        return cost;
    }
}


