package edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PosnTest {
  private Posn posn1;
  private Posn posn2;
  private Posn posn3;
  private Posn sameAsRefPosn;
  private Posn sameAsStatePosn;
  private Posn yetAnotherPosn;
  private Posn nullPosn;

  @Before
  public void setUp() throws Exception {
    posn1 = new Posn(1, 2);
    posn2 = new Posn(1, 3);
    posn3 = new Posn(2,2);
    sameAsRefPosn = posn1;
    sameAsStatePosn = new Posn(1, 2);
    yetAnotherPosn = new Posn(1,2 );
  }

  @Test
  public void getX() {
    Assert.assertEquals(posn1.getX(), new Integer(1));
    Assert.assertEquals(posn2.getX(), new Integer(1));
    Assert.assertEquals(posn3.getX(), new Integer(2));
  }

  @Test
  public void getY() {
    Assert.assertEquals(posn1.getY(), new Integer(2));
    Assert.assertEquals(posn2.getY(), new Integer(3));
    Assert.assertEquals(posn3.getY(), new Integer(2));
  }

  @Test
  public void moveX() {
    Assert.assertEquals(posn1.moveX(1), new Posn(2, 2));
    Assert.assertEquals(posn2.moveX(-2), new Posn(-1, 3));
  }

  @Test
  public void moveY() {
    Assert.assertEquals(posn1.moveY(1), new Posn(1, 3));
    Assert.assertEquals(posn2.moveY(-3), new Posn(1, 0));
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(posn1.equals(posn1));
    Assert.assertTrue(posn1.equals(sameAsRefPosn));
    Assert.assertTrue(posn1.equals(sameAsStatePosn));
    Assert.assertEquals(posn1.equals(sameAsStatePosn) && sameAsStatePosn.equals(yetAnotherPosn),
        yetAnotherPosn.equals(posn1));
    Assert.assertFalse(posn1.equals(posn2));
    Assert.assertFalse(posn1.equals(nullPosn));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(posn1.equals(sameAsStatePosn), posn1.hashCode() == sameAsStatePosn
        .hashCode());
    Assert.assertEquals(posn1.equals(posn2), posn1.hashCode() == posn2.hashCode());
  }

  @Test
  public void testToString() {
    String tempStr = ("Posn{coordinateX=1, coordinateY=2}");
    Assert.assertEquals(posn1.toString(), tempStr);
  }
}