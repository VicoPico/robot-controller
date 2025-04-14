package com.example.robotcontroller;

/**
 * Handles the visualization of the room and the robot's position in the terminal.
 */
public class GridRenderer {

  /**
   * Renders the grid with the robot's current position and orientation.
   *
   * @param room  The room to render
   * @param robot The robot to display on the grid
   */
  public static void renderGrid(Room room, Robot robot) {
    for (int y = room.getHeight() - 1; y >= 0; y--) { // Print from top to bottom
      for (int x = 0; x < room.getWidth(); x++) {
        if (x == robot.getX() && y == robot.getY()) {
          System.out.print(getRobotSymbol(robot.getDirection()));
        } else {
          System.out.print("[  ]");
        }
      }
      System.out.println(); // New line after each row
    }
    System.out.println(); // Extra line for spacing
  }

  /**
   * Returns the symbol representing the robot's orientation.
   *
   * @param direction The direction the robot is facing (N, E, S, W)
   * @return A string representing the robot's orientation
   */
  private static String getRobotSymbol(char direction) {
    switch (direction) {
      case 'N':
        return "[↑]";
      case 'E':
        return "[→]";
      case 'S':
        return "[↓]";
      case 'W':
        return "[←]";
      default:
        return "[R]";
    }
  }
}
