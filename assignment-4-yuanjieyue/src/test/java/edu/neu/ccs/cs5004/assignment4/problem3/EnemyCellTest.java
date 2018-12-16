package edu.neu.ccs.cs5004.assignment4.problem3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EnemyCellTest {
  private Boolean hit;
  private Boolean notHit;
  private Boolean sunk;
  private Boolean notSunk;
  private EnemyCell cell1;
  private EnemyCell cell2;

  @Before
  public void setUp() throws Exception {
    hit = new Boolean(true);
    notHit = new Boolean(false);
    sunk = new Boolean(true);
    notSunk = new Boolean(false);
    cell1 = new EnemyCell(hit, notSunk);
    cell2 = new EnemyCell(notHit, sunk);
  }

  @Test
  public void resultOfAttack() {
    Assert.assertEquals(cell1.attackResult(), new Miss());
    Assert.assertEquals(cell2.attackResult(), new Miss());
  }

  @Test
  public void testToString() {
    String tempStr = new String("EnemyCell{isHit=true, belongToSunk=false}");
    Assert.assertEquals(cell1.toString(), tempStr);

  }
}