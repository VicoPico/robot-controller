package com.example.robotcontroller;

public class Robot {

  private int x;
  private int y;
  private char direction; // N, E, S, W

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
