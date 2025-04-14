package com.example.robotcontroller;

/**
 * Represents the room (grid) where the robot moves.
 * Handles the dimensions of the room and validates boundaries.
 */
public class Room {

  private final int width; // Width of the room
  private final int height; // Height of the room

  /**
   * Constructor to initialize the room dimensions.
   *
   * @param width  Width of the room
   * @param height Height of the room
   */
  public Room(int width, int height) {
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
   * Checks if a given position (x, y) is within the room's boundaries.
   *
   * @param x X-coordinate
   * @param y Y-coordinate
   * @return true if the position is within bounds, false otherwise
   */
  public boolean isWithinBounds(int x, int y) {
    return x >= 0 && x < width && y >= 0 && y < height;
  }
}
