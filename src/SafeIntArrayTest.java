import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SafeIntArrayTest {
  SafeIntArray sa;

  @BeforeEach
    void setUp() {
      sa = new SafeIntArray(10);
  }

  @Test
  void loopTest() {
    for (Object i: sa) {
      System.out.println(i);
    }
  }


}