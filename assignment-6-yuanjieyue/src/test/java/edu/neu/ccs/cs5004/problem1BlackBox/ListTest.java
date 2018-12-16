package edu.neu.ccs.cs5004.problem1BlackBox;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.problem1.EmptyListException;
import edu.neu.ccs.cs5004.problem1.LinkedList;
import edu.neu.ccs.cs5004.problem1.List;

public class ListTest {
  private List<String> stringList;
  private List<String> emptyStringList;
  private List<String> singleElemList;

  private List<Integer> integerList;
  private List<Integer> emptyIntegerList;
  private List<Integer> singleIntegerList;

  private List<Character> characterList;
  private List<Character> emptyCharacterList;
  private List<Character> singleCharacterList;

  private List<Boolean> booleanList;
  private List<Boolean> emptyBooleanList;
  private List<Boolean> singleBooleanList;

  private List<String> testStringList;
  private List<Integer> testIntegerList;
  private List<Character> testCharacterList;
  private List<Boolean> testBooleanList;


  @Before
  public void setUp() throws Exception {
    emptyStringList = List.createEmptyList();
    stringList = List.createEmptyList();
    singleElemList = List.createEmptyList();

    stringList.add("a");
    stringList.add("b");
    stringList.add("z");

    singleElemList.add("a");

    emptyIntegerList = List.createEmptyList();
    integerList = List.createEmptyList();
    singleIntegerList = List.createEmptyList();

    integerList.add(100);
    integerList.add(40);
    integerList.add(30);

    singleIntegerList.add(100);

    emptyCharacterList = List.createEmptyList();
    characterList = List.createEmptyList();
    singleCharacterList = List.createEmptyList();

    characterList.add('o');
    characterList.add('g');
    characterList.add('f');

    singleCharacterList.add('o');

    emptyBooleanList = List.createEmptyList();
    booleanList = List.createEmptyList();
    singleBooleanList = List.createEmptyList();

    booleanList.add(true);
    booleanList.add(false);
    booleanList.add(false);

    singleBooleanList.add(true);

    testStringList = List.createEmptyList();
    testIntegerList = List.createEmptyList();
    testCharacterList = List.createEmptyList();
    testBooleanList = List.createEmptyList();
  }

  @Test
  public void add() throws Exception {
    testStringList.add("a");
    Assert.assertEquals(testStringList, singleElemList);

    testIntegerList.add(100);
    Assert.assertEquals(testIntegerList, singleIntegerList);

    testCharacterList.add('o');
    Assert.assertEquals(testCharacterList, singleCharacterList);

    testBooleanList.add(true);
    Assert.assertEquals(testBooleanList, singleBooleanList);

  }

  @Test(expected = IllegalArgumentException.class)
  public void addNullElements() throws Exception {
    emptyStringList.add(null);
  }

  @Test
  public void addAtIndex() throws Exception {
    testStringList.add("a");
    emptyStringList.add(0, "a");
    Assert.assertEquals(testStringList, emptyStringList);

    testStringList.add("k");
    testStringList.add("b");
    testStringList.add("z");
    stringList.add(2, "k");
    Assert.assertEquals(testStringList, stringList);



    testIntegerList.add(100);
    emptyIntegerList.add(0, 100);
    Assert.assertEquals(testIntegerList, emptyIntegerList);

    testIntegerList.add(40);
    testIntegerList.add(30);
    testIntegerList.add(20);
    integerList.add(0, 20);
    Assert.assertEquals(testIntegerList, integerList);


    testCharacterList.add('o');
    emptyCharacterList.add(0, 'o');
    Assert.assertEquals(testCharacterList, emptyCharacterList);

    testCharacterList.add('g');
    testCharacterList.add(' ');
    testCharacterList.add('f');
    characterList.add(1, ' ');
    Assert.assertEquals(testCharacterList, characterList);

    testBooleanList.add(false);
    testBooleanList.add(true);
    testBooleanList.add(false);
    testBooleanList.add(false);
    booleanList.add(3, false);
    Assert.assertEquals(testBooleanList, booleanList);


  }

  @Test(expected = IllegalArgumentException.class)
  public void addNullElementsAtIndex() throws Exception {
   stringList.add(1, null);
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void addElementsAtIndex() throws Exception {
    integerList.add(4, 67);
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void addElementsAtIndexFront() throws Exception {
    integerList.add(-3, 56);
  }

  @Test
  public void get() throws Exception {
    String testZero = "z";
    Assert.assertEquals(testZero, stringList.get(0));
    Integer testOne = 40;
    Assert.assertEquals(testOne, integerList.get(1));
    Character testTwo = 'o';
    Assert.assertEquals(testTwo, characterList.get(2));

  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void getAtIndex() throws Exception {
    integerList.get(-5);
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void getAtIndexAfter() throws Exception {
    integerList.get(90);
  }

  @Test
  public void indexOf() throws Exception {
    Assert.assertEquals(-1, stringList.indexOf("esfef"));
    Assert.assertEquals(0, characterList.indexOf('f'));
    Assert.assertEquals(0, booleanList.indexOf(false));
  }

  @Test(expected = IllegalArgumentException.class)
  public void indexOfNullElem() throws Exception {
    integerList.indexOf(null);
  }

  @Test(expected = EmptyListException.class)
  public void indexOfEmptyList() throws Exception {
    emptyBooleanList.indexOf(true);
  }

  @Test
  public void isEmpty() throws Exception {
    Assert.assertTrue(emptyStringList.isEmpty());
    Assert.assertTrue(emptyIntegerList.isEmpty());
    Assert.assertTrue(emptyCharacterList.isEmpty());
    Assert.assertTrue(emptyBooleanList.isEmpty());

    Assert.assertFalse(stringList.isEmpty());
    Assert.assertFalse(integerList.isEmpty());
    Assert.assertFalse(characterList.isEmpty());
    Assert.assertFalse(booleanList.isEmpty());

  }

  @Test
  public void remove() throws Exception {
    testStringList.add("b");
    testStringList.add("z");
    stringList.remove(2);
    Assert.assertEquals(testStringList, stringList);

    testCharacterList.add('o');
    testCharacterList.add('g');
    characterList.remove(0);
    Assert.assertEquals(characterList, testCharacterList);

    testIntegerList.add(100);
    testIntegerList.add(30);
    integerList.remove(1);
    Assert.assertEquals(testIntegerList, integerList);

  }

  @Test(expected = EmptyListException.class)
  public void removeFromEmpty() throws Exception {
    emptyStringList.remove(0);
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void removeIndexOutBound() throws Exception {
    booleanList.remove(-1);
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void removeIndexOutBoundAfter() throws Exception {
    booleanList.remove(5);
  }

  @Test
  public void size() throws Exception {
    Assert.assertEquals(0, emptyIntegerList.size());
    Assert.assertEquals(3, stringList.size());
    characterList.remove(2);
    Assert.assertEquals(2, characterList.size());
    singleBooleanList.remove(0);
    Assert.assertEquals(0, singleBooleanList.size());
  }

  @Test
  public void contains() throws Exception {
    Assert.assertTrue(stringList.contains("z"));
    Assert.assertTrue(characterList.contains('f'));
    Assert.assertTrue(singleIntegerList.contains(100));
    Assert.assertTrue(singleBooleanList.contains(true));

    Assert.assertFalse(emptyStringList.contains("f"));
    Assert.assertFalse(stringList.contains("f"));
    Assert.assertFalse(emptyCharacterList.contains('y'));
    Assert.assertFalse(characterList.contains(' '));

    integerList.remove(1);
    Assert.assertFalse(integerList.contains(40));
  }

  @Test(expected = IllegalArgumentException.class)
  public void containsNullElem() throws Exception {
    emptyCharacterList.contains(null);
  }

}