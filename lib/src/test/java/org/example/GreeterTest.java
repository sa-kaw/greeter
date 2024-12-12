package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GreeterTest {
  @Test
  void someLibraryMethodReturnsTrue() {
    final var greeter = new Greeter();
    assertEquals(greeter.greeting(), "hello");
  }
}
