package org.pg4200.ex01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.pg4200.ex01.TriangleClassification.Classification.*;

public class TriangleClassificationTest {
    @Test
    public void testNOT_A_TRIANGLE1() {
        Enum myTri = TriangleClassification.classify(-2,2,2);

        assertEquals(NOT_A_TRIANGLE, myTri);
    }

    @Test
    public void testNOT_A_TRIANGLE2() {
        Enum myTri = TriangleClassification.classify(10,5,2);

        assertEquals(NOT_A_TRIANGLE, myTri);
    }

    @Test
    public void testEQUILATERAL() {
        Enum myTri = TriangleClassification.classify(2,2,2);

        assertEquals(EQUILATERAL, myTri);
    }

    @Test
    public void testISOSCELES() {
        Enum myTri = TriangleClassification.classify(2,3,2);

        assertEquals(ISOSCELES, myTri);
    }

    @Test
    public void testSCALENE() {
        Enum myTri = TriangleClassification.classify(2,3,4);

        assertEquals(SCALENE, myTri);
    }
}
