import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AmountTest {
    private Amount balance;

    @Before
    public void setUp() throws Exception {
        this.balance = new Amount(1200, 65);
    }

    @Test
    public void getDollars() {
        Assert.assertEquals(new Integer(1200), balance.getDollars());
    }

    @Test
    public void getCents() {
        Assert.assertEquals(new Integer(65), balance.getCents());
    }
}