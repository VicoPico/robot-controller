package com.example.robotcontroller;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GridRendererTest {

  private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;

  @BeforeEach
  void setUp() {
    // Redirect System.out to capture the output
    System.setOut(new PrintStream(outputStream));
  }

  @AfterEach
  void tearDown() {
    // Reset System.out to its original state
    System.setOut(originalOut);
    outputStream.reset(); // Clear the captured output for the next test
  }

  @Test
  void testRenderGridWithRobot() {
    // Create a room and a robot
    Room room = new Room(5, 5);
    Robot robot = new Robot(2, 2, 'N');

    // Render the grid
    GridRenderer.renderGrid(room, robot);

    // Capture the output
    String output = outputStream.toString();
    System.out.println(output); // Debugging: Print the actual output

    // Verify the output contains the robot's position and direction
    String expectedRobotMarker = "[\u001B[1;35m↑\u001B[0m]"; // Robot facing north with ANSI color
    assertTrue(
      output.contains(expectedRobotMarker),
      "Expected robot marker not found in output."
    );
  }

  @Test
  void testRenderEmptyGrid() {
    // Create a room without a robot
    Room room = new Room(5, 5);

    // Render the grid
    GridRenderer.renderGrid(room, null);

    // Capture the output
    String output = outputStream.toString();
    System.out.println(output); // Debugging: Print the actual output

    // Verify the output does not contain any robot marker
    String unexpectedRobotMarker = "[\u001B[1;35m↑\u001B[0m]"; // Robot marker should not exist
    assertFalse(
      output.contains(unexpectedRobotMarker),
      "Unexpected robot marker found in output."
    );
  }
}
