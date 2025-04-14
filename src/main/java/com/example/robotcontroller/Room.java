package com.example.robotcontroller;

public class Room {

  private final int width;
  private final int height;

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

  public boolean isWithinBounds(int x, int y) {
    return x >= 0 && x < width && y >= 0 && y < height;
  }
}
