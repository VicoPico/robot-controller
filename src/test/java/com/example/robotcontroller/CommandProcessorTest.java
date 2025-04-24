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
    assertEquals('W', robot.getDirection());

    processor.processCommands("F");
    assertEquals(1, robot.getX());
    assertEquals(2, robot.getY());

    processor.processCommands("F");
    assertEquals(0, robot.getX());
    assertEquals(2, robot.getY());

    processor.processCommands("R");
    assertEquals('N', robot.getDirection());

    processor.processCommands("F");
    assertEquals(0, robot.getX());
    assertEquals(3, robot.getY());

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

  @Test
  void testInvalidCommand() {
    Room room = new Room(5, 5);
    Robot robot = new Robot(2, 2, 'N');
    CommandProcessor processor = new CommandProcessor(room, robot);

    // Verify that an exception is thrown for an invalid command
    Exception exception = assertThrows(
      IllegalArgumentException.class,
      () -> {
        processor.processCommands("X");
      }
    );

    // Verify the exception message
    assertEquals("Invalid command: X", exception.getMessage());
  }

  @Test
  void testEdgeCaseCommands() {
    Room room = new Room(5, 5);
    Robot robot = new Robot(3, 4, 'E');
    CommandProcessor processor = new CommandProcessor(room, robot);

    // Process commands to move to the edge of the room
    processor.processCommands("F");
    assertEquals(4, robot.getX());
    assertEquals(4, robot.getY());
    assertEquals('E', robot.getDirection());

    // Turn and move along the edge
    processor.processCommands("RF");
    assertEquals(4, robot.getX());
    assertEquals(3, robot.getY());
    assertEquals('S', robot.getDirection());
    // Stop further movement to avoid going out of bounds
  }
}
