package com.example.robotcontroller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class RobotTest {

  @Test
  void testRobotInitialization() {
    // Initialize the robot with valid position and direction
    Robot robot = new Robot(2, 3, 'N');

    // Verify initial position and direction
    assertEquals(2, robot.getX());
    assertEquals(3, robot.getY());
    assertEquals('N', robot.getDirection());
  }

  @Test
  void testSetPositionAndDirection() {
    // Initialize the robot
    Robot robot = new Robot(0, 0, 'N');

    // Update position and direction
    robot.setX(4);
    robot.setY(4);
    robot.setDirection('E');

    // Verify updated position and direction
    assertEquals(4, robot.getX());
    assertEquals(4, robot.getY());
    assertEquals('E', robot.getDirection());
  }
}
