package com.bsu.by;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void calcMatrix() {
        int[][] arrTest1 = {{1, 2}, {3, 4}};
        int[][] arrTest2 = {{0, 2}, {0, 3}};
        int[][] arrExp = {{2, 4}, {9, 12}};
        assertArrayEquals(arrTest1, arrTest2);
    }
}