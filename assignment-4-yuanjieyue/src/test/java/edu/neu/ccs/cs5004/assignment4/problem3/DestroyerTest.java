package edu.neu.ccs.cs5004.assignment4.problem3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DestroyerTest {

  private Integer size1;
  private Integer size2;
  private Integer numberOfHitCells1;
  private Integer numberOfHitCells2;

  private Ship ship1;
  private Ship ship2;
  private Ship ship3;
  private Ship sameRefShip;
  private Ship sameAsStateShip;
  private Ship yetAnotherShip;
  private Ship nullShip;

  @Before
  public void setUp() throws Exception {
    size1 = new Integer(1);
    numberOfHitCells1 = new Integer(0);
    size2 = new Integer(3);
    numberOfHitCells2 = new Integer(1);
    ship1 = new Destroyer(size1, numberOfHitCells1);
    ship2 = new Destroyer(size2, numberOfHitCells1);
    ship3 = new Destroyer(size1, numberOfHitCells2);
    sameRefShip = ship1;
    sameAsStateShip = new Destroyer(size1, numberOfHitCells1);
    yetAnotherShip = new Destroyer(size1, numberOfHitCells1);
  }

  @Test
  public void testToString() {
    String tempStr = new String("Destroyer{size=1, numberOfHitCells=0}");
    Assert.assertEquals(ship1.toString(), tempStr);
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(ship1.equals(ship1));
    Assert.assertTrue(ship1.equals(sameRefShip));
    Assert.assertTrue(ship1.equals(sameAsStateShip));
    Assert.assertEquals(ship1.equals(sameAsStateShip) && sameAsStateShip.equals
        (yetAnotherShip), yetAnotherShip.equals(ship1));
    Assert.assertFalse(ship1.equals(ship2));
    Assert.assertFalse(ship1.equals(ship3));
    Assert.assertFalse(ship1.equals(nullShip));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(ship1.equals(sameAsStateShip), ship1.hashCode() == sameAsStateShip
        .hashCode());
    Assert.assertEquals(ship1.equals(ship2), ship1.hashCode() == ship2.hashCode());
    Assert.assertEquals(ship1.equals(ship3), ship1.hashCode() == ship3.hashCode());
  }

}