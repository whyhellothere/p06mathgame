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
import java.util.Scanner;

/**
 * This class controls the actions the game makes. It reads inputs from the user and updates
 * the game accordingly
 */
public class GameApplication {

  /**
   * The main driver method for the game. It holds all the variables and logic that the game
   * requires to interact with user actions and manages the game state.
   * 
   * @param args is the array of string commands that run the code
   */
  public static void main(String[] args) {

    Random rdm = new Random(); // the Random object used as a parameter in addNode
    Scanner scn = new Scanner(System.in); // the Scanner for reading user inputs
    boolean quit = false; // controls activity of the GameApplication
    int goal = rdm.nextInt(88) + 10; // randomly generates goal for game
    int moves = 0; // counter for number of moves player has made
    GameList list = new GameList(); // creates a new GameList for the game

    for (int i = 0; i < 8; i++) { // creates 8 GameNodes
      list.addNode(new GameNode(rdm));
    }

    while (!quit) { // runs as long as boolean quit determines the game is still active

      if (list.contains(goal)) {
        System.out.println("Congratulations, you won in " + moves + " moves.");
        System.out.println("Solution: " + list.toString());
        quit = true;
      }

      System.out.println("Goal: " + goal + " Moves Taken: " + moves);
      System.out.println("Puzzle: " + list.toString());
      System.out.print("Number and Operation " + GameOperator.ALL_OPERATORS.toString() 
      + " to Apply: ");

      while (scn.hasNext()) { // runs if there are more lines to read

        try {
          String inputNoWhite = scn.next().trim(); // cuts off white-spaces in user input
          if (inputNoWhite.equalsIgnoreCase("quit")) { // checks to see if user quits application
            quit = true;
            System.out.println("Goodbye user");
            break; // breaks out of current while loop and then outer while loop
          }
          list.addNode(new GameNode(rdm)); // adds a new node
          // assigns final char of string for operator
          char charOp = inputNoWhite.charAt(inputNoWhite.length() - 1); 
          if (GameOperator.getFromChar(charOp) == null) { // checks to see if operator exists
            System.out.println("WARNING: EXCEPTED LAST CHAR TO BE OPERATOR INSTEAD GOT: " 
                + charOp);
            System.out.println("");
            break;
          }
          // parses integer part of user input
          Integer number = Integer.parseInt(inputNoWhite.substring(0, inputNoWhite.length() - 1));
          if (!list.contains(number)) {
            System.out.println(
                "WARNING: EXCEPTED A VALID NUMBER INPUT INSTEAD GOT: " + number.toString());
            System.out.println("");
            break;
          }
          // applies operation to node
          list.applyOperatorToNumber(number, GameOperator.getFromChar(charOp));
          moves++;
          System.out.println("");
          break;
        } catch (NumberFormatException e) { // if the value is not a number
          System.out.println("WARNING: EXPECTED A NUMBER BUT WAS GIVEN ANOTHER INPUT");
          System.out.println("");
          break;
        }

      }
    }
  }
}