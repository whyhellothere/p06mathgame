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

/**
 * Class for the list that holds the head node. Can search for and modify other nodes in list
 *
 */
public class GameList {

  private GameNode list; // reference to the first GameNode in this list

  /**
   * Constructor for the class. It initializes list to start out empty
   */
  public GameList() {
    list = null;
  } 

  /**
   * adds the new node to the end of this list
   * @param newNode is the node that will be added to the end of the list
   */
  public void addNode(GameNode newNode) {
    if (list == null) {
      list = newNode;
    } else {
      GameNode curr = list;
      while (curr.getNext() != null) {
        curr = curr.getNext();
      }
      curr.setNext(newNode);
    }
  }

  /**
   *  only returns true when this list contains a node with the specified number
   * @param number is the number of the node being checked for
   * @return returns boolean describing if the list contains the node
   */
  public boolean contains(int number) {
    //Could possibly implement this recursively?
    GameNode listCopy = list;
    while (listCopy != null) {
      if (listCopy.getNumber() == number) {
        return true;
      }
      listCopy = listCopy.getNext();
    }
    return false;
  }

  /**
   * Overrides the toString method for this class. It returns a string of all nodes in the game
   * list with " -> " in between each node, followed by " -> END"
   */
  public String toString() {
    GameNode current = list;
    String listString = "";
    while (current.getNext() != null) {
      listString = listString + current.getNumber();
      listString = listString + " -> ";
      current = current.getNext();
    }
    listString = listString + "END";
    return listString;
  } 

  /**
   * applies an operation to the first node with the correct number value
   * 
   * @param number the number held by the node which is being changed
   * @param operator the operation that will be applied to the node
   */
  public void applyOperatorToNumber(int number, GameOperator operator) {

    GameNode current = list; // holds reference to current game node being checked

    while (current.getNext() != null) { // checks to see if there is a next value
      if (current.getNumber() == number) { // checks for the node with the correct number
        current.applyOperator(operator); // applies operation to that node
        return; // returns if the node with the correct number is found
      }
      current = current.getNext();
    }

    // if the next node is null and the function has not yet been returned, throw null pointer
    throw new NullPointerException(); 

  }
}