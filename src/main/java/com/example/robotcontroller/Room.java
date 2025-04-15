package com.example.robotcontroller;

/**
 * Represents a grid-based room where the robot operates.
 */
public class Room {

  private final int width;
  private final int height;

  /**
   * Constructor for the Room class.
   *
   * @param width  The width of the room (must be positive).
   * @param height The height of the room (must be positive).
   * @throws IllegalArgumentException if width or height is not positive.
   */
  public Room(int width, int height) {
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("Room dimensions must be positive.");
    }
    this.width = width;
    this.height = height;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  /**
   * Checks if a given position is within the bounds of the room.
   *
   * @param x The x-coordinate.
   * @param y The y-coordinate.
   * @return True if the position is within bounds, false otherwise.
   */
  public boolean isWithinBounds(int x, int y) {
    return x >= 0 && x < width && y >= 0 && y < height;
  }
}
