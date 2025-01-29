package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import string.task.StringTask;
import util.CustomException;

public class StringTaskTest {

  @Test
  public void areStringsCaseEqualTest() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void areStringsIgnoreCaseEqualTest() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void compareEndCharsTest() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void compareStartCharsTest() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void concatenateMultipleStringsTest() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void convertCharArrayTest() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void convertingToLowerCaseTest() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void convertingToUpperCaseTest() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void encloseInArrayTest() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void getCharOccurrenceTest() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void getFirstNCharTest() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void getGreatestPositionTest() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void getLastNCharTest() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void getLengthTest() throws CustomException {
    Assert.assertEquals(new StringTask().getLength("sakthi") , 6);
    Assert.assertEquals(new StringTask().getLength(null) , 0);
  }

  @Test
  public void getPenultimateCharTest() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void mergeStringWithSymbolTest() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void replaceSubstringTest() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void reversingStringTest() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void trimStringTest() {
    throw new RuntimeException("Test not implemented");
  }
}
