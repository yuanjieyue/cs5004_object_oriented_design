package edu.neu.ccs.cs5004.assignment5.battleship.model.ship;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SubmarineTest {
  private Integer numberOfHitCells1;
  private Integer numberOfHitCells2;

  private Submarine ship1;
  private Submarine ship2;
  private BattleShip ship3;
  private Submarine sameRefShip;
  private Submarine sameAsStateShip;
  private Submarine yetAnotherShip;
  private Submarine nullShip;
  private Submarine ship4;
  private Submarine ship5;

  @Before
  public void setUp() throws Exception {
    numberOfHitCells1 = new Integer(3);
    numberOfHitCells2 = new Integer(2);
    ship1 = new Submarine(numberOfHitCells1);
    ship2 = new Submarine(numberOfHitCells2);
    ship3 = new BattleShip(numberOfHitCells1);
    sameRefShip = ship1;
    sameAsStateShip = new Submarine(numberOfHitCells1);
    yetAnotherShip = new Submarine(numberOfHitCells1);
    ship4 = new Submarine(2);
    ship5 = new Submarine(0);
  }


  @Test
  public void testToString() {
    String str = ("Submarine{size=2, numberOfHitCells=3}");
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