package com.example.robotcontroller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Entry point for the application. Orchestrates the logic.
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
    System.out.println(
      "In case you don't want to continue, \u001B[1;37mPress Ctrl + C\u001B[0m at any time \u001B[1;37mto exit the application.\u001B[0m"
    );
    System.out.println();

    Scanner scanner = new Scanner(System.in);
    InputHandler inputHandler = new InputHandler(scanner);

    try {
      // Step 1: Get room dimensions
      Room room = inputHandler.getRoomDimensions();

      // Step 2: Get robot's starting position and orientation
      Robot robot = inputHandler.getRobotStartingPosition(room);

      // Step 3: Render initial grid
      System.out.println("\nStep 3: Initial state of the room and robot:");
      GridRenderer.renderGrid(room, robot);

      // Step 4: Get commands
      String commands = inputHandler.getCommands();

      // Step 5: Process commands
      CommandProcessor processor = new CommandProcessor(room, robot);
      processor.processCommands(commands);

      // Step 6: Render final grid
      System.out.println("\nFinal State:");
      GridRenderer.renderGrid(room, robot);
      System.out.println(
        "Final Position Report: " +
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
