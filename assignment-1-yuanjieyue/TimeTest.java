import org.junit.Assert;

import static org.junit.Assert.*;

public class TimeTest {

    private Time time;

    @org.junit.Before
    public void setUp() throws Exception {
        time = new Time(12, 30, 15);
    }

    @org.junit.Test
    public void getHours() {
        Assert.assertEquals(new Integer(12), time.getHours());
    }

    @org.junit.Test
    public void getMinutes() {
        Assert.assertEquals(new Integer(30), time.getMinutes());
    }

    @org.junit.Test
    public void getSeconds() {
        Assert.assertEquals(new Integer(15), time.getSeconds());
    }
}