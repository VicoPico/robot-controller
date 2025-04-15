package com.example.robotcontroller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Entry point for the application. Handles user input and orchestrates the logic.
 */
public class App {

  public static void main(String[] args) {
    // Print the ASCII banner
    printBanner();

    // Display a short description of the application
    System.out.println("Welcome to the Robot Controller Application!");
    System.out.println(
      "This application allows you to control a robot in a grid-based room."
    );
    System.out.println(
      "You can specify the room dimensions, the robot's starting position, and issue commands to move it."
    );
    System.out.println();

    Scanner scanner = new Scanner(System.in);

    // Step 1: Get room dimensions
    System.out.println("Step 1: Define the room dimensions.");
    System.out.println("Enter the width of the room:");
    int width = scanner.nextInt();
    System.out.println("Enter the height of the room:");
    int height = scanner.nextInt();
    Room room = new Room(width, height);

    // Step 2: Get robot's starting position and orientation
    System.out.println(
      "\nStep 2: Set the robot's starting position and orientation."
    );
    System.out.println("Enter the robot's starting x-coordinate:");
    int startX = scanner.nextInt();
    System.out.println("Enter the robot's starting y-coordinate:");
    int startY = scanner.nextInt();
    System.out.println("Enter the robot's starting direction (N, E, S, W):");
    char startDirection = scanner.next().toUpperCase().charAt(0);
    Robot robot = new Robot(startX, startY, startDirection);

    // Validate starting position
    if (!room.isWithinBounds(startX, startY)) {
      System.out.println(
        "Error: Starting position is out of bounds! Please restart the application."
      );
      return;
    }

    // Step 3: Render initial grid
    System.out.println("\nStep 3: Initial state of the room and robot:");
    GridRenderer.renderGrid(room, robot);

    // Step 4: Get commands
    System.out.println("\nStep 4: Issue commands to move the robot.");
    System.out.println(
      "Enter a sequence of commands (L for left, R for right, F for forward)."
    );
    System.out.println(
      "For example, 'LFFR' will turn the robot left, move forward twice, and then turn right:"
    );
    String commands = scanner.next().toUpperCase();

    // Step 5: Process commands
    CommandProcessor processor = new CommandProcessor(room, robot);
    try {
      processor.processCommands(commands);
      System.out.println("\nFinal State:");
      GridRenderer.renderGrid(room, robot);
      System.out.println(
        "Final Position: " +
        robot.getX() +
        " " +
        robot.getY() +
        " " +
        robot.getDirection()
      );
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  /**
   * Reads and prints the ASCII banner from the banner.txt file.
   */
  private static void printBanner() {
    try (
      BufferedReader reader = new BufferedReader(
        new InputStreamReader(App.class.getResourceAsStream("/banner.txt"))
      )
    ) {
      String line;
      while ((line = reader.readLine()) != null) {
        System.out.println(line);
      }
    } catch (Exception e) {
      System.out.println("Error: Unable to load banner.");
    }
  }
}
