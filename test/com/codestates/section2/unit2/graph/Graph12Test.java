package com.codestates.section2.unit2.graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 2023.7.16(일) 12h25
public class Graph12Test {

    @Test
    void testCase1() {
        // given
        int[][] edges = {
                {0, 1},
                {2, 3},
                {4, 5}
        };

        // when
        Graph12Draft3 graph12Draft3 = new Graph12Draft3();
        int result = graph12Draft3.connectedVertices(edges);

        // then
        assertEquals(result, 3);
    }

    @Test
    void testCase2() {
        // given
        int[][] edges = {
                {0, 1},
                {2, 3},
                {3, 4},
                {3, 5}
        };

        // when
        Graph12Draft3 graph12Draft3 = new Graph12Draft3();
        int result = graph12Draft3.connectedVertices(edges);

        // then
        assertEquals(result, 2);
    }
}
