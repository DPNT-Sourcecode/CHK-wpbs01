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
        assertThat(checkoutSolution.checkout("ABCDEF"), equalTo(-1));
    }

    @Test
    public void returnCorrectSumForSingleSkus() {
        assertThat(checkoutSolution.checkout("ABC"), equalTo(100));
    }

    @Test
    public void returnCorrectSumForMultipleSkus() {
        assertThat(checkoutSolution.checkout("AABCC"), equalTo(170));
    }

    @Test
    public void returnCorrectSumForMultipleSkusWithOffer() {
        assertThat(checkoutSolution.checkout("AAAAA"), equalTo(200));
        assertThat(checkoutSolution.checkout("AAABBCC"), equalTo(215));
        assertThat(checkoutSolution.checkout("AAAA"), equalTo(180));
        assertThat(checkoutSolution.checkout("BBB"), equalTo(75));
        assertThat(checkoutSolution.checkout("ABCDE"), equalTo(155));
        assertThat(checkoutSolution.checkout("EE"), equalTo(80));
    }

}


