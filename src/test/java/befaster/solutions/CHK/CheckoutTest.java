package befaster.solutions.CHK;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CheckoutTest {

    private CheckoutSolution checkoutSolution;

    @Before
    public void init() {
        checkoutSolution = new CheckoutSolution();
    }

    @Test
    public void returnNegativeForIncorrectInput() {
        assertThat(checkoutSolution.checkout("ABCDE"), equalTo(-1));
    }
}
