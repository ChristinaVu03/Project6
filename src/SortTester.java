//Author: Christina Vu
//This program has five test cases for Sorter<T> objects.

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import java.math.BigInteger;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**
 * Tests of Sorter objects.
 *
 * @author Your Name
 */
public class SortTester {

  // +---------+-----------------------------------------------------
  // | Globals |
  // +---------+

  Sorter sorter;

  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+

  @Test
  public void fakeTest() {
    assertTrue(true);
  } // fakeTest()

  @Test
  public void orderedStringTest() {
    String[] original = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    String[] expected = original.clone();
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest

  @Test
  public void reverseOrderedStringTest() {
    String[] original = { "foxtrot", "delta", "charlie", "bravo", "alpha" };
    String[] expected = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest
   @Test
  public void randomIntegerTest() {
    Integer[] original = { 5, 2, 8, 1, 7 };
    Integer[] expected = { 1, 2, 5, 7, 8 };
    sorter.sort(original, Integer::compareTo);
    assertArrayEquals(expected, original);
  } // randomIntegerTest

  @Test
  public void duplicateValuesTest() {
    Integer[] original = { 3, 1, 4, 1, 5, 9, 2, 6, 5 };
    Integer[] expected = { 1, 1, 2, 3, 4, 5, 5, 6, 9 };
    sorter.sort(original, Integer::compareTo);
    assertArrayEquals(expected, original);
  } // duplicateValuesTest

  @Test
  public void emptyArrayTest() {
    // Test sorting an empty array.
    String[] original = {};
    String[] expected = {};
    sorter.sort(original, String::compareTo);
    assertArrayEquals(expected, original);
  } // emptyArrayTest

  @Test
  public void largeRandomArrayTest() {
    // Test sorting a large array of random integers.
    Integer[] original = { 5, 8, 1, 3, 6, 2, 7, 4, 9, 10, 15, 12, 11, 13, 14 };
    Integer[] expected = Arrays.copyOf(original, original.length);
    Arrays.sort(expected);
    sorter.sort(original, Integer::compareTo);
    assertArrayEquals(expected, original);
  } // largeRandomArrayTest

  @Test
  public void descendingOrderArrayTest() {
    // Test sorting an array in descending order.
    Integer[] original = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
    Integer[] expected = Arrays.copyOf(original, original.length);
    Arrays.sort(expected);
    sorter.sort(original, Integer::compareTo);
    assertArrayEquals(expected, original);
  } // descendingOrderArrayTest

} // class SortTester
