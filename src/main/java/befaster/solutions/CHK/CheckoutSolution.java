package befaster.solutions.CHK;

public class CheckoutSolution {
    public Integer checkout(String skus) {
        Integer sum = 0;
        for (char sku : skus.toCharArray()) {
            if (skuNotValid(sku)) {
                return -1;
            }
            sum += mapSkuToCost(sku);
        }
        return sum;
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
