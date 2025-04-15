package com.example.robotcontroller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class CommandProcessorTest {

  @Test
  void testProcessCommandsValid() {
    Room room = new Room(5, 5);
    Robot robot = new Robot(2, 2, 'N');
    CommandProcessor processor = new CommandProcessor(room, robot);

    // Process commands step by step
    processor.processCommands("L");
    System.out.println(
      "After L: " +
      robot.getX() +
      ", " +
      robot.getY() +
      ", " +
      robot.getDirection()
    );

    processor.processCommands("F");
    System.out.println(
      "After F: " +
      robot.getX() +
      ", " +
      robot.getY() +
      ", " +
      robot.getDirection()
    );

    processor.processCommands("F");
    System.out.println(
      "After F: " +
      robot.getX() +
      ", " +
      robot.getY() +
      ", " +
      robot.getDirection()
    );

    processor.processCommands("R");
    System.out.println(
      "After R: " +
      robot.getX() +
      ", " +
      robot.getY() +
      ", " +
      robot.getDirection()
    );

    // Add the missing forward command
    processor.processCommands("F");
    System.out.println(
      "After F: " +
      robot.getX() +
      ", " +
      robot.getY() +
      ", " +
      robot.getDirection()
    );

    // Verify final position and direction
    assertEquals(0, robot.getX());
    assertEquals(3, robot.getY());
    assertEquals('N', robot.getDirection());
  }

  @Test
  void testProcessCommandsOutOfBounds() {
    // Create a room and a robot
    Room room = new Room(5, 5);
    Robot robot = new Robot(0, 0, 'S');
    CommandProcessor processor = new CommandProcessor(room, robot);

    // Verify that an exception is thrown for out-of-bounds movement
    Exception exception = assertThrows(
      IllegalStateException.class,
      () -> {
        processor.processCommands("F");
      }
    );

    // Verify the exception message
    assertEquals("Robot moved out of bounds!", exception.getMessage());
  }
}
