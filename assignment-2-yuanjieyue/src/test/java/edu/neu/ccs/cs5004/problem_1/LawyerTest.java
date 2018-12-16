package edu.neu.ccs.cs5004.problem_1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LawyerTest {
    private Person name;
    private Person name2;
    private WorkLoad workLoad;
    private Salary salary;
    private VocationDays vocationDays;
    private ID id = new ID("FFDJ75");
    private Seniority seniority;
    private Double saIncreFactor;
    private Double saIncreFactor2;
    private Lawyer layer;
    private Lawyer sameRefLayer;
    private Lawyer sameAsStateLayer;
    private Lawyer yetAnotherLayer;
    private Lawyer diffLayer;
    private Lawyer nullLayer;

    @Before
    public void setUp() throws Exception {
        name = new Person("John", "Kelly");
        name2= new Person("Brain", "Stark");
        workLoad = new WorkLoad(40);
        salary = new Salary(40000.0);
        vocationDays = new VocationDays(14);
        id = new ID("FFDJ75");
        seniority = new Seniority(10, 8, 20);
        saIncreFactor = 2.0;
        saIncreFactor2= 4.0;
        layer = new Lawyer(name, workLoad, salary, vocationDays, id, seniority, saIncreFactor);
        sameRefLayer = layer;
        sameAsStateLayer = new Lawyer(name, workLoad, salary, vocationDays, id, seniority,
            saIncreFactor);
        yetAnotherLayer = new Lawyer(name, workLoad, salary, vocationDays, id, seniority,
            saIncreFactor);
        diffLayer = new Lawyer(name2, workLoad, salary, vocationDays, id, seniority,
            saIncreFactor2);
    }

    @Test
    public void getSalaryIncreFactor() {
        Assert.assertEquals(layer.getExtraSalaryRate(), new Double(2));
    }

    @Test
    public void sue() {
        String tempStr = new String("Let's sue!");
        Assert.assertEquals(layer.sue(), tempStr);
    }

    @Test
    public void testEquals() {
        Assert.assertTrue(layer.equals(layer));
        Assert.assertTrue(layer.equals(sameRefLayer));
        Assert.assertTrue(layer.equals(sameAsStateLayer));
        Assert.assertFalse(layer.equals(diffLayer));
        Assert.assertFalse(layer.equals(nullLayer));
        Assert.assertNull(nullLayer);
        Assert.assertEquals(layer.equals(sameAsStateLayer) && sameAsStateLayer.equals
                (yetAnotherLayer), yetAnotherLayer.equals(layer));
    }

    @Test
    public void testHashCode() {
        Assert.assertEquals(layer.equals(sameAsStateLayer), layer.hashCode() == sameAsStateLayer
                .hashCode());
        Assert.assertEquals(layer.equals(diffLayer), layer.hashCode() == diffLayer.hashCode());
    }

    @Test
    public void testToString() {
        String tempStr = new String("Layer{name=Person{first='John', last='Kelly'}, " +
                "workLoad=WorkLoad{workLoad=40}, salary=Salary{salary=80000.0}, " +
                "vocationDays=VocationDays{vocationDays=14}, " +
                "id=ID{id='FFDJ75'}, seniority=Seniority{year=10, month=8, day=20}, " +
                "extraSalaryRate=2.0}");
        Assert.assertEquals(layer.toString(), tempStr);
    }
}