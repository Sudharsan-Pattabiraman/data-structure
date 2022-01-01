package com.datastructures.graph.search;

import com.datastructures.graph.AdjacencySetGraph;
import com.datastructures.graph.Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.stream.IntStream;

public class Traversal {

    public static void depthFirstTraversal(final Graph graph, final int currentVertex, final boolean[] visited) {

        if (visited[currentVertex]) {
            return;
        }

        visited[currentVertex] = true;

//        graph.getAdjacentVertices(currentVertex).forEach(vertex -> depthFirstTraversal(graph, currentVertex, visited));

        Set<Integer> adjacentVertices = graph.getAdjacentVertices(currentVertex);

        System.out.print(currentVertex + " --> ");

        for (int vertex : adjacentVertices) {
            depthFirstTraversal(graph, vertex, visited);
        }
    }

    public static void breadthFirstTraversal(final Graph graph, final int currentVertex, final boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(currentVertex);

        while (!queue.isEmpty()) {

            final Integer vertex = queue.poll();
            if (visited[vertex]){
                continue;
            }
            visited[vertex] = true;
            System.out.print(vertex + " -> ");

            Set<Integer> adjacentVertices = graph.getAdjacentVertices(vertex);
            for (int adjacentVertex : adjacentVertices){
                if (!visited[adjacentVertex]){
                    queue.add(adjacentVertex);
                }
            }
        }
    }

    public static void main(String[] args) {

        final int vertices = 5;
        final Graph graph = new AdjacencySetGraph(vertices, Graph.GraphType.UNDIRECTED);

        graph.addEdge(1, 4);
        graph.addEdge(1, 2);
        graph.addEdge(2, 4);
        graph.addEdge(3, 1);
        graph.addEdge(3, 4);
        graph.addEdge(3, 2);
        graph.addEdge(0, 4);

        boolean[] visited = new boolean[vertices];
        IntStream.range(0, vertices).forEach(vertex -> visited[vertex] = false);

//        IntStream.range(0, vertices).forEach(vertex -> depthFirstTraversal(graph, vertex, visited));
        IntStream.range(0, vertices).forEach(vertex -> breadthFirstTraversal(graph, vertex, visited));
    }
}
