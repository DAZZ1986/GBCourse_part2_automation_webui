package com.geekbrains.lesson5.DZ4;

import com.geekbrains.lesson4.DZ.TriangleArea;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static com.geekbrains.lesson4.DZ.TriangleArea.calculateArea;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class TriangleTest {

    @Test
    void triangleTest() throws Exception {
        Assertions.assertEquals(calculateArea(2,2,2), 1.73205, 0.001);
    }

    @Test
    void triangleNegativeTest() {
        assertThrows(Exception.class, () -> TriangleArea.calculateArea(-2,2,2));
    }

}
