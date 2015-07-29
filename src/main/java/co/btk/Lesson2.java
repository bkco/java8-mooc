/**
 * Copyright © 2014, Oracle and/or its affiliates. All rights reserved.
 *
 * JDK 8 MOOC Lesson 2 homework
 */
package co.btk;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * REFERENCE READING:
 *  https://docs.oracle.com/javase/8/docs/api/index.html?java/util/stream/package-summary.html
 *
 *  http://howtodoinjava.com/2014/04/13/java-8-tutorial-streams-by-examples/
 *  http://stackoverflow.com/questions/18552005/is-there-a-concise-way-to-iterate-over-a-stream-with-indices-in-java-8
 */
public class Lesson2 {


  private static final String WORD_REGEXP = "[- .:,]+";


  /**
   * Main entry point for application
   *
   * @param args the command line arguments
   * @throws IOException If file access does not work
   */
  public static void main(String[] args) throws IOException {
    Lesson2 lesson = new Lesson2();
    lesson.runExercises();
  }

  /**
   * Run the exercises to ensure we got the right answers
   *
   * @throws java.io.IOException
   */
  public void runExercises() throws IOException {
    System.out.println("JDK 8 Lambdas and Streams MOOC Lesson 2");
    System.out.println("Running exercise 1 solution...");
    exercise1();
    System.out.println("Running exercise 2 solution...");
    exercise2();
    System.out.println("Running exercise 3 solution...");
    exercise3();
    System.out.println("Running exercise 4 solution...");
    exercise4();
    System.out.println("Running exercise 5 solution...");
    exercise5();
    System.out.println("Running exercise 6 solution...");
    exercise6();
    System.out.println("Running exercise 7 solution...");
    exercise7();
  }

  /**
   * Exercise 1
   *
   * Create a new list with all the strings from original list converted to 
   * lower case and print them out.
   */
  private void exercise1() {
    List<String> list = Arrays.asList(
        "The", "Quick", "BROWN", "Fox", "Jumped", "Over", "The", "LAZY", "DOG");

    /* YOUR CODE HERE */
    List<String> target = list.stream().map(String::toLowerCase).collect(Collectors.toList());
    System.out.println("exercise 1 - lowercase items: " + target);
  }

  /**
   * Exercise 2
   *
   * Modify exercise 1 so that the new list only contains strings that have an
   * odd length
   */
  private void exercise2() {
    List<String> list = Arrays.asList(
        "The", "Quick", "BROWN", "Fox", "Jumped", "Over", "The", "LAZY", "DOG");

    /* YOUR CODE HERE */
    List<String> target = list.stream()
            .map(String::toLowerCase)
            .filter(item -> (item.length() % 2 == 1))
            .collect(Collectors.toList());
    System.out.println("exercise 2 - lowercase items that are odd lengths: " + target);
  }

  /**
   * Exercise 3
   *
   * Join the second, third and forth strings of the list into a single string,
   * where each word is separated by a hyphen (-). Print the resulting string.
   */
  private void exercise3() {
    List<String> list = Arrays.asList(
        "The", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dog");

    // The Java 8 streams API lacks the features of getting the "index" of a stream element.
    // There are often workarounds, however. Usually this can be done by "driving" the stream with an integer range,
    // and taking advantage of the fact that the elements are often in an array or in a collection accessible by index.
    String target =
            IntStream.range(0, list.size())
                    .filter(i -> i == 2 || i == 3 | i == 4)
                    .mapToObj(i -> list.get(i))
                    .collect(Collectors.joining("-"));
    System.out.println("exercise 3 - filtered and joined items: " + target);
  }

  /**
   * Count the number of lines in the file using the BufferedReader provided
   */
  private void exercise4() throws IOException {

    long count = 0;
    try {
      BufferedReader reader = Files.newBufferedReader(
              Paths.get(ClassLoader.getSystemClassLoader().getResource("./poem.txt").toURI()), StandardCharsets.UTF_8);
      count = reader.lines().count();
    } catch (Exception e) {}
    System.out.println("exercise 4 - line count: " + count);
  }
  
  /**
   * Using the BufferedReader to access the file, create a list of words with
   * no duplicates contained in the file.  Print the words.
   * 
   * HINT: A regular expression, WORD_REGEXP, is already defined for your use.
   */
  private void exercise5() throws IOException {
    try {
      BufferedReader reader = Files.newBufferedReader(
              Paths.get(ClassLoader.getSystemClassLoader().getResource("./poem.txt").toURI()), StandardCharsets.UTF_8);

      List<String> target = reader.lines().filter(s -> s.matches(WORD_REGEXP)).collect(Collectors.toList());
      System.out.println("exercise 5 - lowercase items that are odd lengths: " + target);
    } catch (Exception e) {}
    //http://stackoverflow.com/questions/24660888/collect-hashset-java-8-regex-pattern-stream-api
    // http://stackoverflow.com/questions/29806558/regex-not-working-with-stream-filter
    // http://www.shredzone.de/cilla/page/380/little-java-regex-cookbook.html



  }
  
  /**
   * Using the BufferedReader to access the file create a list of words from 
   * the file, converted to lower-case and with duplicates removed, which is
   * sorted by natural order.  Print the contents of the list.
   */
  private void exercise6() throws IOException {
    try (BufferedReader reader = Files.newBufferedReader(
        Paths.get("poem.txt"), StandardCharsets.UTF_8)) {
      /* YOUR CODE HERE */
    }
  }
  
  /**
   * Modify exercise6 so that the words are sorted by length
   */
  private void exercise7() throws IOException {
    try (BufferedReader reader = Files.newBufferedReader(
        Paths.get("poem.txt"), StandardCharsets.UTF_8)) {
      /* YOUR CODE HERE */
    }
  }

}

