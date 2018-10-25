//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Access Control
// Files: User.Java, AccessControlTest.java, AccessControl.java
// Course: CS300, Fall, 2018
//
// Author: Daniel Chu
// Email: dchu22@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Tolga Beser
// Partner Email: tbeser@wisc.edu
// Partner Lecturer's Name: Gary Dahl
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// _x_ Write-up states that pair programming is allowed for this assignment.
// _x_ We have both read and understand the course Pair Programming Policy.
// _x_ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: N/A
// Online Sources: N/A
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.Random;

/**
 * This class tests functions from the GameNode and GameList class.
 *
 */
public class GameTests {

  /**
   * This class runs the test functions and keeps track of how many fail.
   * @param args the string of commands that runs the code
   */
  public static void main(String[] args) {
    int error = 0; // keeps track of number of failed tests
    if (testNode1() == false) { // returns false if test failed
      System.out.println("testNode1 failed");
      error++;
    }
    if(testNode2() == false) { // returns false if test failed
      System.out.println("testNode2 failed");
      error++;
    }
    if(testList1() == false) { // returns false if test failed
      System.out.println("testNode2 failed");
      error++;
    }
    if(testList2() == false) { // returns false if test failed
      System.out.println("testNode2 failed");
      error++;
    }

    if (error == 0) { // checks for no errors
      System.out.println("ALL TESTS PASSED");
    }

    //NEED TWO MORE TESTS
  }


  public static boolean testNode1() {

    GameNode testList1 = new GameNode(new Random()); // creates one GameNode
    GameNode testList2 = new GameNode(new Random()); // creates another GameNode
    testList1.setNext(testList2); // sets pointer for first node to second node
    if (testList1.getNext() == testList2) { // checks if method returns correct next node
      return true; // returns true if getNext() points to second node
    }
    return false; // returns false if getNext() does not point to second node
  }

  /**
   * Checks to see if the applOperator() method workds properly
   * 
   * @return boolean describing if test is passed
   */
  public static boolean testNode2() {
    GameNode testList1 = new GameNode(new Random()); // creates one GameNode
    GameNode testList2 = new GameNode(new Random()); // creates another GameNode
    testList1.setNext(testList2); // sets pointer for first node to second node
    int correctAdd = testList1.getNumber() + testList2.getNumber(); // finds proper value of method
    testList1.applyOperator(GameOperator.getFromChar('+')); // runs function applyOperator
    if (correctAdd == testList1.getNumber()) { // checks to see if values match
      return true; // returns true if values match
    }
    return false; // returns false if values do not match
  }

  /**
   * 
   * 
   * @return boolean describing if test is passed
   */
  public static boolean testList1() {
    GameList list = new GameList(); // creates a GameList
    GameNode node1 = new GameNode(new Random()); // creates a node to be added to list
    GameNode node2 = new GameNode(new Random()); // creates a second node to be added to list
    int number1 = node1.getNumber(); // stores the value of the node1 number for checking
    int number2 = node2.getNumber(); // stores the value of the node2 number for checking

    list.addNode(node1); // adds node to list
    // checks if the list does not contain a node with the value of node1
    if(!list.contains(number1)) { 
      return false;
    }

    list.addNode(node2); // adds second node to list
    // checks if the list does not contain a node with the value of node2
    if(!list.contains(number2)) { 
      return false;
    }
    // checks that the first node points to the second
    if(node1.getNext() != node2) {
      return false;
    }
    return true; // true if all checks passed
  }

  public static boolean testList2() {
    GameList list = new GameList(); // creates a GameList
    GameNode node1 = new GameNode(new Random()); // creates a node to be added to list
    GameNode node2 = new GameNode(new Random()); // creates a second node to be added to list
    int number1 = node1.getNumber(); // stores the value of the node1 number for checking
    int number2 = node2.getNumber(); // stores the value of the node2 number for checking
    
    // adds nodes to list
    list.addNode(node1);
    list.addNode(node2);
    
    int expected = node1.getNumber() + node2.getNumber(); // the expected value
    
    list.applyOperatorToNumber(number1, GameOperator.getFromChar('+')); // applies operation
    if(node1.getNumber() != expected) { // checks the new value of number
      return false;
    }
    if(node1.getNext() != null) { // makes sure the next pointer is removed
      return false;
    }
    
    return true; // true if all checks passed
  }

}