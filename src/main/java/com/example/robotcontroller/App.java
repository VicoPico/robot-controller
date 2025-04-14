package com.example.robotcontroller;

import java.util.Scanner;

/**
 * Entry point for the application. Handles user input and orchestrates the logic.
 */
public class App {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Step 1: Get room dimensions
    System.out.println("Enter room dimensions (width height):");
    int width = scanner.nextInt();
    int height = scanner.nextInt();
    Room room = new Room(width, height);

    // Step 2: Get robot's starting position and orientation
    System.out.println(
      "Enter robot's starting position and orientation (x y direction):"
    );
    int startX = scanner.nextInt();
    int startY = scanner.nextInt();
    char startDirection = scanner.next().toUpperCase().charAt(0);
    Robot robot = new Robot(startX, startY, startDirection);

    // Validate starting position
    if (!room.isWithinBounds(startX, startY)) {
      System.out.println("Error: Starting position is out of bounds!");
      return;
    }

    // Step 3: Render initial grid
    System.out.println("Initial State:");
    GridRenderer.renderGrid(room, robot);

    // Step 4: Get commands
    System.out.println("Enter commands (L, R, F):");
    String commands = scanner.next().toUpperCase();

    // Step 5: Process commands
    CommandProcessor processor = new CommandProcessor(room, robot);
    try {
      processor.processCommands(commands);
      System.out.println("Final State:");
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
      System.out.println(e.getMessage());
    }
  }
}
