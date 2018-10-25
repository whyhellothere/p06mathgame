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
 * This class creates a node containing a random value from 1-9 and a pointer to the next node. It
 * contains methods for changing its pointer and accessing or changing the value it holds.
 */
public class GameNode {
  
  private int number; // the number held within this node
  private GameNode next; // the next GameNode in the list, or null for the last node

  /** 
   * initializes number randomly from 1-9, and next to null
   * 
   * @param rng the Random object used to generate random numbers
   */
  public GameNode(Random rng) {
    number = (rng.nextInt(8) + 1);
    next = null;
  }

  /** 
   * accessor for the number field
   * 
   * @return the number value of this node
   */
  public int getNumber() {
    return number;
  }

  /** 
   * accessor for the next field
   * 
   * @return the node this node points to next
   */
  public GameNode getNext() {
    return next;
  }

  /**
   * mutator for the next field
   * 
   * @param next is the GameNode that this node should point to next
   */
  public void setNext(GameNode next) {
    this.next = next;
  } 

  /**
   * This method applies an operation to the number and then sets the current pointer to
   * that node's next.
   * 
   * @param operator is the class used to operations to the value
   */
  public void applyOperator(GameOperator operator) {
    if (next == null) {
      throw new NullPointerException();
    }
    number = operator.apply(number, next.getNumber());
    next = next.getNext();
  } 
}