package com.example.robotcontroller;

import java.util.Scanner;

/**
 * Handles user input and validation for the application.
 */
public class InputHandler {

  private final Scanner scanner;

  public InputHandler(Scanner scanner) {
    this.scanner = scanner;
  }

  /**
   * Prompts the user to enter the room dimensions.
   *
   * @return A Room object with the specified dimensions.
   */
  public Room getRoomDimensions() {
    System.out.println("Step 1: Define the room dimensions.");
    System.out.println("Enter the width of the room:");
    int width = scanner.nextInt();
    System.out.println("Enter the height of the room:");
    int height = scanner.nextInt();
    return new Room(width, height);
  }

  /**
   * Prompts the user to enter the robot's starting position and orientation.
   *
   * @param room The room to validate the robot's starting position.
   * @return A Robot object with the specified position and orientation.
   */
  public Robot getRobotStartingPosition(Room room) {
    System.out.println(
      "\nStep 2: Set the robot's starting position and orientation."
    );
    System.out.println("Enter the robot's starting x-coordinate:");
    int startX = scanner.nextInt();
    System.out.println("Enter the robot's starting y-coordinate:");
    int startY = scanner.nextInt();
    System.out.println("Enter the robot's starting direction (N, E, S, W):");
    char startDirection = scanner.next().toUpperCase().charAt(0);

    if (!room.isWithinBounds(startX, startY)) {
      throw new IllegalArgumentException(
        "Error: Starting position is out of bounds!"
      );
    }

    return new Robot(startX, startY, startDirection);
  }

  /**
   * Prompts the user to enter a sequence of commands for the robot.
   *
   * @return A string representing the sequence of commands.
   */
  public String getCommands() {
    System.out.println("\nStep 4: Issue commands to move the robot.");
    System.out.println(
      "Enter a sequence of commands (L for left, R for right, F for forward)."
    );
    System.out.println(
      "For example, 'LFFR' will turn the robot left, move forward twice, and then turn right:"
    );
    return scanner.next().toUpperCase();
  }
}
