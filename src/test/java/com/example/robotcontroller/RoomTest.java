package com.example.robotcontroller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class RoomTest {

  @Test
  void testIsWithinBounds() {
    Room room = new Room(5, 5);

    // Valid positions
    assertTrue(room.isWithinBounds(0, 0)); // Lower-left corner
    assertTrue(room.isWithinBounds(4, 4)); // Upper-right corner

    // Invalid positions
    assertFalse(room.isWithinBounds(-1, 0)); // Negative x-coordinate
    assertFalse(room.isWithinBounds(0, 5)); // y-coordinate equal to height
  }

  @Test
  void testEdgeCases() {
    Room room = new Room(1, 1);

    // Valid position for a 1x1 room
    assertTrue(room.isWithinBounds(0, 0));

    // Invalid positions for a 1x1 room
    assertFalse(room.isWithinBounds(1, 0));
    assertFalse(room.isWithinBounds(0, 1));
  }

  @Test
  void testLargeDimensions() {
    Room room = new Room(1000, 1000);

    // Valid positions in a large room
    assertTrue(room.isWithinBounds(999, 999));
    assertTrue(room.isWithinBounds(0, 0));

    // Invalid positions in a large room
    assertFalse(room.isWithinBounds(1000, 1000)); // Out of bounds
    assertFalse(room.isWithinBounds(-1, -1)); // Negative coordinates
  }

  @Test
  void testInvalidRoomInitialization() {
    // Test for invalid room dimensions
    Exception exception = assertThrows(
      IllegalArgumentException.class,
      () -> {
        new Room(-5, 5); // Negative width
      }
    );
    assertEquals("Room dimensions must be positive.", exception.getMessage());

    exception =
      assertThrows(
        IllegalArgumentException.class,
        () -> {
          new Room(5, -5); // Negative height
        }
      );
    assertEquals("Room dimensions must be positive.", exception.getMessage());
  }
}
