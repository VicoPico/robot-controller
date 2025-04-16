package com.example.robotcontroller;

import java.util.Scanner;

/**
 * Handles user input and validation for the application.
 */
public class InputHandler {

  private final Scanner scanner;

  /**
   * Constructor to initialize the InputHandler with a Scanner object.
   *
   * @param scanner The Scanner object used to read user input.
   */
  public InputHandler(Scanner scanner) {
    this.scanner = scanner;
  }

  /**
   * Prompts the user to enter the room dimensions with validation.
   * Ensures the dimensions are positive integers.
   *
   * @return A Room object with the specified dimensions.
   */
  public Room getRoomDimensions() {
    int width = 0, height = 0;
    boolean validInput = false;

    System.out.println("Step 1: Define the room dimensions.");
    while (!validInput) {
      try {
        // Prompt the user for the width of the room
        System.out.println(
          "Enter an integer (a whole and positive number) to definfe the width of the room:"
        );
        width = scanner.nextInt();

        // Prompt the user for the height of the room
        System.out.println(
          "Enter an integer (a whole and positive number) to definfe the height of the room:"
        );
        height = scanner.nextInt();

        // Validate that both dimensions are positive integers
        if (width > 0 && height > 0) {
          validInput = true;
        } else {
          System.out.println(
            "Error: Dimensions must be positive integers (positive whole numbers). Please try again."
          );
        }
      } catch (Exception e) {
        // Handle invalid input (e.g., non-integer values)
        System.out.println(
          "Error: Invalid input. Please enter positive integers (positive whole numbers) only."
        );
        scanner.nextLine(); // Clear the invalid input
      }
    }
    return new Room(width, height);
  }

  /**
   * Prompts the user to enter the robot's starting position and orientation with validation.
   * Ensures the position is within the room's bounds and the direction is valid.
   *
   * @param room The room to validate the robot's starting position.
   * @return A Robot object with the specified position and orientation.
   */
  public Robot getRobotStartingPosition(Room room) {
    int startX = 0, startY = 0;
    char startDirection = 'N';
    boolean validInput = false;

    System.out.println(
      "\nStep 2: Set the robot's starting position and orientation."
    );
    while (!validInput) {
      try {
        // Prompt the user for the x-coordinate of the robot
        System.out.println(
          "Enter an integer to set the robot's starting x-coordinate:"
        );
        startX = scanner.nextInt();

        // Prompt the user for the y-coordinate of the robot
        System.out.println(
          "Enter an integer to set the robot's starting y-coordinate:"
        );
        startY = scanner.nextInt();

        // Prompt the user for the direction the robot is facing
        System.out.println(
          "Enter the robot's starting direction (N, E, S, W):"
        );
        startDirection = scanner.next().toUpperCase().charAt(0);

        // Validate that the position is within bounds and the direction is valid
        if (
          room.isWithinBounds(startX, startY) &&
          "NESW".indexOf(startDirection) != -1
        ) {
          validInput = true;
        } else {
          System.out.println(
            "Error: Invalid position or direction. Ensure the position is within bounds and the direction is N, E, S, or W."
          );
        }
      } catch (Exception e) {
        // Handle invalid input (e.g., non-integer values for coordinates)
        System.out.println(
          "Error: Invalid input. Please enter integers (whole numbers) for coordinates and a valid direction (only letters N, E, S, W)."
        );
        scanner.nextLine(); // Clear the invalid input
      }
    }
    return new Robot(startX, startY, startDirection);
  }

  /**
   * Prompts the user to enter a sequence of commands for the robot.
   * Ensures the commands only contain valid characters (L, R, F).
   *
   * @return A string representing the sequence of commands.
   */
  public String getCommands() {
    String commands = "";
    boolean validInput = false;

    System.out.println("\nStep 4: Issue commands to move the robot.");
    while (!validInput) {
      try {
        // Prompt the user for a sequence of commands
        System.out.println(
          "Enter a sequence of commands (L for left, R for right, F for forward):"
        );
        commands = scanner.next().toUpperCase();

        // Validate that the commands only contain L, R, or F
        if (commands.matches("[LRF]+")) {
          validInput = true;
        } else {
          System.out.println(
            "Error: Commands must only contain the letters L, R, or F. Please try again."
          );
        }
      } catch (Exception e) {
        // Handle invalid input (e.g., non-string values)
        System.out.println(
          "Error: Invalid input. Please enter a valid sequence of commands (only letters N, E, S, W)."
        );
        scanner.nextLine(); // Clear the invalid input
      }
    }
    return commands;
  }
}
