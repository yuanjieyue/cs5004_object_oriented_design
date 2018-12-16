import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BankAccountTest {
    private Person holder;
    private Amount balance;
    private Amount deposit;
    private Amount withdraw;
    private BankAccount account;

    @Before
    public void setUp() throws Exception {
        this.holder = new Person("Jaylen", "Brown");
        this.balance = new Amount(200, 54);
        this.deposit = new Amount(799, 60);
        this.withdraw = new Amount(100, 90);
        this.account = new BankAccount(holder, balance);
    }

    @Test
    public void getHolder() {
        Assert.assertEquals("Jaylen", this.account.getHolder().getFirst());
        Assert.assertEquals("Brown", this.account.getHolder().getLast());
    }

    @Test
    public void getBalance() {
        Assert.assertEquals(new Integer(200), this.account.getBalance().getDollars());
        Assert.assertEquals(new Integer(54), this.account.getBalance().getCents());
    }

    @Test
    public void balanceAfterDeposit(){
        Assert.assertEquals(new Integer(1000), this.account.balanceAfterDeposit(deposit).getDollars());
        Assert.assertEquals(new Integer(14), this.account.balanceAfterDeposit(deposit).getCents());
    }

    @Test
    public void balanceAfterWithdraw(){
        Assert.assertEquals(new Integer(99), this.account.balanceAfterWithdraw(withdraw).getDollars());
        Assert.assertEquals(new Integer(64), this.account.balanceAfterWithdraw(withdraw).getCents());
    }
}