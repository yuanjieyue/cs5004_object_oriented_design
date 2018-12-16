import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PersonTest {
    private Person john;

    @Before
    public void setUp() throws Exception {
        this.john = new Person("john", "kerry");
    }

    @Test
    public void getFirst() {
        Assert.assertEquals("john", this.john.getFirst());
    }

    @Test
    public void getLast() {
        Assert.assertEquals("kerry", this.john.getLast());
    }
}