package com.example.robotcontroller;

/**
 * Handles the visualization of the room and the robot's position in the terminal.
 */
public class GridRenderer {

  // Private constructor to prevent instantiation
  private GridRenderer() {
    throw new UnsupportedOperationException(
      "This is a utility class and cannot be instantiated"
    );
  }

  /**
   * Renders the grid with the robot's current position and orientation.
   *
   * @param room  The room to render
   * @param robot The robot to display on the grid
   */
  public static void renderGrid(Room room, Robot robot) {
    for (int y = room.getHeight() - 1; y >= 0; y--) { // Print from top to bottom
      for (int x = 0; x < room.getWidth(); x++) {
        if (robot != null && x == robot.getX() && y == robot.getY()) {
          System.out.print(getRobotSymbol(robot.getDirection())); // Render robot with color
        } else {
          System.out.print("[ ]"); // Render empty space
        }
      }
      System.out.println(); // New line after each row
    }
    System.out.println(); // Extra line for spacing
  }

  /**
   * Returns the symbol representing the robot's orientation with ANSI color.
   *
   * @param direction The direction the robot is facing (N, E, S, W)
   * @return A string representing the robot's orientation
   */
  private static String getRobotSymbol(char direction) {
    final String PURPLE_ANSI = "\u001B[1;35m"; // ANSI escape code for purple (Bold)
    final String RESET = "\u001B[0m"; // ANSI escape code to reset color
    return switch (direction) {
      case 'N' -> "[" + PURPLE_ANSI + "↑" + RESET + "]";
      case 'E' -> "[" + PURPLE_ANSI + "→" + RESET + "]";
      case 'S' -> "[" + PURPLE_ANSI + "↓" + RESET + "]";
      case 'W' -> "[" + PURPLE_ANSI + "←" + RESET + "]";
      default -> "[" + PURPLE_ANSI + "R" + RESET + "]";
    }; // Default case for invalid direction
  }
}
