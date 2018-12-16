package edu.neu.ccs.cs5004.problem_2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpecifiedCellTest {

    private Hitable hit;
    private Sunkable sunk;
    private Sunkable notSunk;
    private SpecifiedCell cell1;
    private SpecifiedCell cell2;

    @Before
    public void setUp() throws Exception {
        hit = new BeingHit();
        sunk = new BelongToSunk();
        notSunk = new NotBelongToSunk();
        cell1 = new SpecifiedCell(hit, sunk);
        cell2 = new SpecifiedCell(hit, notSunk);
    }

    @Test
    public void resultOfAttack() {
        Assert.assertEquals(cell1.resultOfAttack(), new Sunk());
        Assert.assertEquals(cell2.resultOfAttack(), new Hit());
    }

    @Test
    public void testToString() {
        String tempStr = new String("SpecifiedCell{isHit=Being hit, belongToSunk=Belong to Sunk}");
        Assert.assertEquals(cell1.toString(), tempStr);
    }
}