package edu.neu.ccs.cs5004.problem_2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AbstractShipCellTest {

    private Hitable hit;
    private Hitable notHit;

    private Sunkable sunk;
    private Sunkable notSunk;

    private AbstractShipCell cell1;
    private AbstractShipCell cell2;
    private AbstractShipCell sameAsRefSC;
    private AbstractShipCell sameAsStateSC;
    private AbstractShipCell yetAnotherSC;
    private AbstractShipCell nullSC;

    @Before
    public void setUp() throws Exception {
        hit = new BeingHit();
        notHit = new NotBeingHit();
        sunk = new BelongToSunk();
        notSunk = new NotBelongToSunk();

        cell1 = new SpecifiedCell(hit, sunk);
        cell2 = new EnemyCell(notHit, notSunk);
        sameAsRefSC = cell1;
        sameAsStateSC = new SpecifiedCell(hit, sunk);
        yetAnotherSC = new SpecifiedCell(hit, sunk);
    }

    @Test
    public void isPlacable() {
        Assert.assertEquals(cell1.isPlacable(), new Boolean(false));
    }

    @Test
    public void getBelongToSunk() {
        Assert.assertEquals(cell1.getBelongToSunk(), new BelongToSunk());
    }

    @Test
    public void testEquals() {
        Assert.assertTrue(cell1.equals(cell1));
        Assert.assertTrue(cell1.equals(sameAsRefSC));
        Assert.assertTrue(cell1.equals(sameAsStateSC));
        Assert.assertNull(nullSC);
        Assert.assertFalse(cell1.equals(cell2));
        Assert.assertEquals(cell1.equals(sameAsStateSC) && sameAsStateSC.equals(yetAnotherSC),
                yetAnotherSC.equals(cell1));
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(cell1.equals(sameAsStateSC), cell1.hashCode() == sameAsStateSC
                .hashCode());
        Assert.assertEquals(cell1.equals(cell2), cell1.hashCode() == cell2.hashCode());
    }
}