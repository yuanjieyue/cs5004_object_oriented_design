package edu.neu.ccs.cs5004.assignment5.battleship.model.ship;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import edu.neu.ccs.cs5004.assignment5.battleship.model.cell.SpecifiedCell;
import edu.neu.ccs.cs5004.assignment5.battleship.model.gameconstants.Posn;

public class ShipSubjectTest {

  private Ship ship1;
  private Ship ship2;
  private ShipObserver cell1;
  private ShipObserver cell2;
  private ShipObserver cell3;
  private ShipObserver cell4;
  private List<ShipObserver> observers1;
  private List<ShipObserver> observers2;
  private ShipSubject shipSubject1;
  private ShipSubject shipSubject2;
  private ShipSubject sameRefShipSubject;
  private ShipSubject sameAsStateShipSubject;
  private ShipSubject yetAnotherShipSubject;
  private ShipSubject nullShipSubject2;

  @Before
  public void setUp() throws Exception {
    ship1 = new BattleShip(0);
    ship2 = new Cruiser(3);
    cell1 = new SpecifiedCell(false, new Posn(2,1), false, shipSubject1);
    cell2 = new SpecifiedCell(false, new Posn(2,2), false, shipSubject1);
    cell3 = new SpecifiedCell(false, new Posn(2,3), false, shipSubject1);
    cell4 = new SpecifiedCell(false, new Posn(2,4), false, null);

    observers1 = new ArrayList<>();
    observers1.add(cell1);
    observers1.add(cell2);
    observers1.add(cell3);

    observers2 = new ArrayList<>();
    observers2.add(cell1);
    observers2.add(cell2);
    observers2.add(cell3);


    shipSubject1 = new ShipSubject(ship1, observers1);
    shipSubject2 = new ShipSubject(ship2, observers2);
    sameRefShipSubject = shipSubject1;
    sameAsStateShipSubject = new ShipSubject(ship1, observers1);
    yetAnotherShipSubject = new ShipSubject(ship1, observers1);
  }

  @Test
  public void getShip() {
    Assert.assertEquals(shipSubject1.getShip(), ship1);
    Assert.assertEquals(shipSubject2.getShip(), ship2);
  }

  @Test
  public void setShip() {
    shipSubject1.setShip(ship2);
    Assert.assertEquals(shipSubject1.getShip(), ship2);
    shipSubject2.setShip(ship1);
    Assert.assertEquals(shipSubject2.getShip(), ship1);
  }

  @Test
  public void registerObserver() {
    List<ShipObserver> tmp = new ArrayList<>();
    tmp.add(cell1);
    tmp.add(cell2);
    tmp.add(cell3);
    tmp.add(cell4);
    shipSubject1.registerObserver(cell4);
    Assert.assertEquals(shipSubject1, new ShipSubject(ship1, tmp));
    Assert.assertEquals(((SpecifiedCell)cell4).getShipSubject(), null);
  }

  @Test
  public void removeObserver() {
    List<ShipObserver> tmp = new ArrayList<>();
    tmp.add(cell2);
    tmp.add(cell3);
    shipSubject1.removeObserver(cell1);
    Assert.assertEquals(shipSubject1, new ShipSubject(ship1, tmp));
  }

  @Test
  public void notifyObserver() {
    shipSubject2.notifyObserver();
    Assert.assertEquals(((SpecifiedCell)cell1).isSunk(), new Boolean(true));
    Assert.assertEquals(((SpecifiedCell)cell2).isSunk(), new Boolean(true));
    Assert.assertEquals(((SpecifiedCell)cell3).isSunk(), new Boolean(true));
  }

  @Test
  public void updateShip() {
    shipSubject2.updateShip(ship1);
    Assert.assertEquals(((SpecifiedCell)cell1).getShipSubject(), null);
    Assert.assertEquals(((SpecifiedCell)cell2).getShipSubject(), null);
    Assert.assertEquals(((SpecifiedCell)cell3).getShipSubject(), null);
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(shipSubject1.equals(shipSubject1));
    Assert.assertTrue(shipSubject1.equals(sameRefShipSubject));
    Assert.assertTrue(shipSubject1.equals(sameAsStateShipSubject));
    Assert.assertEquals(shipSubject1.equals(sameAsStateShipSubject) && sameAsStateShipSubject
        .equals(yetAnotherShipSubject), yetAnotherShipSubject.equals(shipSubject1));
    Assert.assertFalse(shipSubject1.equals(shipSubject2));
    Assert.assertFalse(shipSubject1.equals(nullShipSubject2));
    Assert.assertFalse(shipSubject1.equals(ship1));
    Assert.assertFalse(shipSubject1.equals(new ShipSubject(ship2, observers1)));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(shipSubject1.equals(sameAsStateShipSubject), shipSubject1.hashCode() ==
        sameAsStateShipSubject.hashCode());
    Assert.assertEquals(shipSubject1.equals(shipSubject2), shipSubject1.hashCode() ==
        shipSubject2.hashCode());
  }

  @Test
  public void testToString() {
    String str = ("ShipSubject{ship=BattleShip{size=4, numberOfHitCells=0}, observers="
        + "[SpecifiedCell{isHit=false, position=Posn{coordinateX=2, coordinateY=1}, belongToSunk="
        + "false}, SpecifiedCell{isHit=false, position=Posn{coordinateX=2, coordinateY=2}, "
        + "belongToSunk=false}, SpecifiedCell{isHit=false, position=Posn{coordinateX=2, "
        + "coordinateY=3}, belongToSunk=false}]}");
    Assert.assertEquals(shipSubject1.toString(), str);
  }
}