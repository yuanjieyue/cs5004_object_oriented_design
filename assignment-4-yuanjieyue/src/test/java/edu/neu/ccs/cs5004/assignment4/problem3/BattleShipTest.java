package edu.neu.ccs.cs5004.assignment4.problem3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BattleShipTest {

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
    size1 = new Integer(4);
    numberOfHitCells1 = new Integer(3);
    size2 = new Integer(2);
    numberOfHitCells2 = new Integer(2);
    ship1 = new BattleShip(size1, numberOfHitCells1);
    ship2 = new BattleShip(size1, numberOfHitCells2);
    ship3 = new BattleShip(size2, numberOfHitCells1);
    sameRefShip = ship1;
    sameAsStateShip = new BattleShip(size1, numberOfHitCells1);
    yetAnotherShip = new BattleShip(size1, numberOfHitCells1);
  }

  @Test
  public void testToString() {
    String tempStr = new String("BattleShip{size=4, numberOfHitCells=3}");
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