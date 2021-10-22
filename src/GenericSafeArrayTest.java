import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GenericSafeArrayTest {

    GenericSafeArray<Integer> sa;

        @BeforeEach
        void setUp() {
            sa = new GenericSafeArray<Integer>(10);
        }

        @Test
        void loopTest() {
            for (Integer i: sa) {
                System.out.println(i);
            }
        }

    }