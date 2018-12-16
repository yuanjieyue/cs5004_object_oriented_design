package edu.neu.ccs.cs5004.problem_2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EnemyCellTest {
  private Hitable hit;
  private Hitable notHit;
  private Sunkable sunk;
  private Sunkable notSunk;
  private EnemyCell cell1;
  private EnemyCell cell2;

  @Before
  public void setUp() throws Exception {
    hit = new BeingHit();
    notHit = new NotBeingHit();
    sunk = new BelongToSunk();
    notSunk = new NotBelongToSunk();
    cell1 = new EnemyCell(hit, notSunk);
    cell2 = new EnemyCell(notHit, sunk);
  }

  @Test
  public void resultOfAttack() {
    Assert.assertEquals(cell1.resultOfAttack(), new Miss());
    Assert.assertEquals(cell2.resultOfAttack(), new Miss());
  }

  @Test
  public void testToString() {
    String tempStr = new String("EnemyCell{isHit=Being hit, belongToSunk=Not belong to Sunk}");
    Assert.assertEquals(cell1.toString(), tempStr);

  }
}