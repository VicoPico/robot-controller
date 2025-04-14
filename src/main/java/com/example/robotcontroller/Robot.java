package com.example.robotcontroller;

/**
 * Represents the robot's state, including its position and orientation.
 */
public class Robot {

  private int x; // X-coordinate of the robot
  private int y; // Y-coordinate of the robot
  private char direction; // Direction the robot is facing (N, E, S, W)

  /**
   * Constructor to initialize the robot's position and orientation.
   *
   * @param x         Initial X-coordinate
   * @param y         Initial Y-coordinate
   * @param direction Initial direction (N, E, S, W)
   */
  public Robot(int x, int y, char direction) {
    this.x = x;
    this.y = y;
    this.direction = direction;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public char getDirection() {
    return direction;
  }

  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }

  public void setDirection(char direction) {
    this.direction = direction;
  }
}
