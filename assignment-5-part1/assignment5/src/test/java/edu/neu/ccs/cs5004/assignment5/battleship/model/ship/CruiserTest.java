package edu.neu.ccs.cs5004.assignment4.problem3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CruiserTest {
  private Integer size1;
  private Integer size2;
  private Integer numberOfHitCells1;
  private Integer numberOfHitCells2;
  private Cruiser cruiser1;
  private Cruiser cruiser2;
  private Cruiser cruiser3;
  private Cruiser sameRefCrusier;
  private Cruiser sameAsStateCruiser;
  private Cruiser yetAnotherCruiser;
  private Cruiser nullCruiser;


  @Before
  public void setUp() throws Exception {
    size1 = new Integer(3);
    numberOfHitCells1 = new Integer(1);
    size2 = new Integer(2);
    numberOfHitCells2 = new Integer(0);
    cruiser1 = new Cruiser(size1, numberOfHitCells1);
    cruiser2 = new Cruiser(size2, numberOfHitCells1);
    cruiser3 = new Cruiser(size1, numberOfHitCells2);
    sameRefCrusier = cruiser1;
    sameAsStateCruiser = new Cruiser(size1, numberOfHitCells1);
    yetAnotherCruiser = new Cruiser(size1, numberOfHitCells1);
  }


  @Test
  public void testToString() {
    String tempStr = new String("Cruiser{size=3, numberOfHitCells=1}");
    Assert.assertEquals(cruiser1.toString(), tempStr);
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(cruiser1.equals(cruiser1));
    Assert.assertTrue(cruiser1.equals(sameRefCrusier));
    Assert.assertTrue(cruiser1.equals(sameAsStateCruiser));
    Assert.assertEquals(cruiser1.equals(sameAsStateCruiser) && sameAsStateCruiser.equals
        (yetAnotherCruiser), yetAnotherCruiser.equals(cruiser1));
    Assert.assertFalse(cruiser1.equals(cruiser2));
    Assert.assertFalse(cruiser1.equals(cruiser3));
    Assert.assertFalse(cruiser1.equals(nullCruiser));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(cruiser1.equals(sameAsStateCruiser), cruiser1.hashCode() ==
        sameAsStateCruiser.hashCode());
    Assert.assertEquals(cruiser1.equals(cruiser2), cruiser1.hashCode()
        == cruiser2.hashCode());
    Assert.assertEquals(cruiser1.equals(cruiser3), cruiser1.hashCode()
        == cruiser3.hashCode());
  }
}