package com.example.robotcontroller;

/**
 * Handles the processing of commands (L, R, F) and updates the robot's state.
 */
public class CommandProcessor {

  private final Room room; // The room where the robot moves
  private final Robot robot; // The robot being controlled

  /**
   * Constructor to initialize the CommandProcessor with a room and a robot.
   *
   * @param room  The room where the robot moves
   * @param robot The robot being controlled
   */
  public CommandProcessor(Room room, Robot robot) {
    this.room = room;
    this.robot = robot;
  }

  /**
   * Processes a sequence of commands and updates the robot's state.
   *
   * @param commands A string of commands (L, R, F)
   */
  public void processCommands(String commands) {
    for (char command : commands.toCharArray()) {
      switch (command) {
        case 'L' -> turnLeft();
        case 'R' -> turnRight();
        case 'F' -> moveForward();
        default -> throw new IllegalArgumentException(
          "Invalid command: " + command
        );
      }
    }
  }

  /**
   * Turns the robot 90 degrees to the left.
   */
  private void turnLeft() {
    switch (robot.getDirection()) {
      case 'N' -> robot.setDirection('W');
      case 'W' -> robot.setDirection('S');
      case 'S' -> robot.setDirection('E');
      case 'E' -> robot.setDirection('N');
    }
  }

  /**
   * Turns the robot 90 degrees to the right.
   */
  private void turnRight() {
    switch (robot.getDirection()) {
      case 'N' -> robot.setDirection('E');
      case 'E' -> robot.setDirection('S');
      case 'S' -> robot.setDirection('W');
      case 'W' -> robot.setDirection('N');
    }
  }

  /**
   * Moves the robot one step forward in the direction it is facing.
   * Throws an exception if the robot moves out of bounds.
   */
  private void moveForward() {
    int newX = robot.getX();
    int newY = robot.getY();

    // Update position based on the current direction
    switch (robot.getDirection()) {
      case 'N' -> newY++;
      case 'E' -> newX++;
      case 'S' -> newY--;
      case 'W' -> newX--;
    }

    // Validate the new position
    if (room.isWithinBounds(newX, newY)) {
      robot.setX(newX);
      robot.setY(newY);
    } else {
      throw new IllegalStateException("Robot moved out of bounds!");
    }
  }
}
