import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RunnerTest {

    private Time startTime;
    private Time duration;
    private Runner runner;

    @Before
    public void setUp() throws Exception {
        this.startTime = new Time(12, 23, 30);
        this.duration = new Time(4, 45, 40);
        this.runner = new Runner("John", startTime, duration);
    }

    @Test
    public void getName() {
        Assert.assertEquals("John", runner.getName());
    }

    @Test
    public void getStartTime() {
        Assert.assertEquals(new Integer(12), runner.getStartTime().getHours());
        Assert.assertEquals(new Integer(23), runner.getStartTime().getMinutes());
        Assert.assertEquals(new Integer(30), runner.getStartTime().getSeconds());
    }

    @Test
    public void getDuration() {
        Assert.assertEquals(new Integer(4), runner.getDuration().getHours());
        Assert.assertEquals(new Integer(45), runner.getDuration().getMinutes());
        Assert.assertEquals(new Integer(40), runner.getDuration().getSeconds());
    }

    @Test
    public void getEndTime(){
        Assert.assertEquals(new Integer(17), runner.getEndTime().getHours());
        Assert.assertEquals(new Integer(9), runner.getEndTime().getMinutes());
        Assert.assertEquals(new Integer(10), runner.getEndTime().getSeconds());
    }
}