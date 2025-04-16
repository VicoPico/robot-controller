package com.example.robotcontroller;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class InputHandlerTest {

  @Test
  void testGetRoomDimensionsValidInput() {
    // Simulate user input for valid room dimensions
    String input = "5\n5\n"; // User enters width=5 and height=5
    Scanner scanner = new Scanner(input);
    InputHandler inputHandler = new InputHandler(scanner);

    // Get room dimensions
    Room room = inputHandler.getRoomDimensions();

    // Verify the room dimensions
    assertEquals(5, room.getWidth());
    assertEquals(5, room.getHeight());
  }

  @Test
  void testGetRoomDimensionsInvalidInput() {
    // Simulate user input with invalid dimensions followed by valid dimensions
    String input = "-1\n0\n5\n5\n"; // Invalid inputs (-1, 0) followed by valid inputs (5, 5)
    Scanner scanner = new Scanner(input);
    InputHandler inputHandler = new InputHandler(scanner);

    // Get room dimensions
    Room room = inputHandler.getRoomDimensions();

    // Verify the room dimensions
    assertEquals(5, room.getWidth());
    assertEquals(5, room.getHeight());
  }

  @Test
  void testGetRobotStartingPositionValidInput() {
    // Simulate user input for valid robot starting position
    String input = "2\n3\nN\n"; // User enters x=2, y=3, direction=N
    Scanner scanner = new Scanner(input);
    InputHandler inputHandler = new InputHandler(scanner);
    Room room = new Room(5, 5);

    // Get robot starting position
    Robot robot = inputHandler.getRobotStartingPosition(room);

    // Verify the robot's starting position and direction
    assertEquals(2, robot.getX());
    assertEquals(3, robot.getY());
    assertEquals('N', robot.getDirection());
  }

  @Test
  void testGetCommandsValidInput() {
    // Simulate user input for valid commands
    String input = "LFFR\n"; // User enters a valid command sequence
    Scanner scanner = new Scanner(input);
    InputHandler inputHandler = new InputHandler(scanner);

    // Get commands
    String commands = inputHandler.getCommands();

    // Verify the commands
    assertEquals("LFFR", commands);
  }

  @Test
  void testGetCommandsInvalidInput() {
    // Simulate user input with invalid commands followed by valid commands
    String input = "INVALID\nLFFR\n"; // Invalid input followed by valid input
    Scanner scanner = new Scanner(input);
    InputHandler inputHandler = new InputHandler(scanner);

    // Get commands
    String commands = inputHandler.getCommands();

    // Verify the commands
    assertEquals("LFFR", commands);
  }

  @Test
  void testGetCommandsEmptyInput() {
    // Simulate user input with an empty command
    String input = "\nLFFR\n"; // Empty input followed by valid input
    Scanner scanner = new Scanner(input);
    InputHandler inputHandler = new InputHandler(scanner);

    // Get commands
    String commands = inputHandler.getCommands();

    // Verify the commands
    assertEquals("LFFR", commands);
  }
}
