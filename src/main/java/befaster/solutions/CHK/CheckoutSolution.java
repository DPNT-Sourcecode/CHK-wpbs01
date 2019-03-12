package befaster.solutions.CHK;

public class CheckoutSolution {
    public Integer checkout(String skus) {
        for (char sku : skus.toCharArray()) {
            if (skuNotValid(sku)) {
                return -1;
            }
        }
        return 0;
    }

    private boolean skuNotValid(char sku) {
        return sku != 'A' && sku != 'B' && sku != 'C' && sku != 'D';
    }
}

