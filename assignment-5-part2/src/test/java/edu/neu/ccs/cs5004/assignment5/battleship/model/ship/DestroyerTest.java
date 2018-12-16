package edu.neu.ccs.cs5004.assignment5.battleship.model.ship;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DestroyerTest {
  private Integer numberOfHitCells1;
  private Integer numberOfHitCells2;

  private Destroyer ship1;
  private Destroyer ship2;
  private BattleShip ship3;
  private Destroyer sameRefShip;
  private Destroyer sameAsStateShip;
  private Destroyer yetAnotherShip;
  private Destroyer nullShip;
  private Destroyer ship4;
  private Destroyer ship5;

  @Before
  public void setUp() throws Exception {
    numberOfHitCells1 = new Integer(3);
    numberOfHitCells2 = new Integer(2);
    ship1 = new Destroyer(numberOfHitCells1);
    ship2 = new Destroyer(numberOfHitCells2);
    ship3 = new BattleShip(numberOfHitCells1);
    sameRefShip = ship1;
    sameAsStateShip = new Destroyer(numberOfHitCells1);
    yetAnotherShip = new Destroyer(numberOfHitCells1);
    ship4 = new Destroyer(1);
    ship5 = new Destroyer(0);
  }


  @Test
  public void testToString() {
    String str = ("Destroyer{size=1, numberOfHitCells=3}");
    Assert.assertEquals(ship1.toString(), str);
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

  @Test
  public void afterAttack() {
    ship1.afterAttack();
    Assert.assertEquals(ship1.getNumOfHitCells(), new Integer(3));
    ship2.afterAttack();
    Assert.assertEquals(ship2.getNumOfHitCells(), new Integer(2));
    ship4.afterAttack();
    ship5.afterAttack();
  }
}