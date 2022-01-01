package com.datastructures.graph.sort;

import com.datastructures.graph.AdjacencySetGraph;
import com.datastructures.graph.Graph;

import java.util.*;

public class TopologicalSort {

    public static void topologicalSort(final Graph graph, final int vertices) {

        final Queue<Integer> queue = new LinkedList<>();
        final Map<Integer, Integer> inDegreeMap = new HashMap<>();

        for (int i = 0; i < vertices; i++) {
            final int inDegree = graph.getIndegree(i);
            inDegreeMap.put(i, inDegree);
            if (inDegree == 0) {
                queue.add(i);
            }
        }

        if (queue.isEmpty()) {
            throw new IllegalStateException("Topological sort not possible for the provided Graph");
        }

        while (!queue.isEmpty()) {
            final Integer currentVertex = queue.poll();
            System.out.print(currentVertex + " -> ");

            final Set<Integer> adjacentVertices = graph.getAdjacentVertices(currentVertex);
            for (Integer adjacentVertex : adjacentVertices) {
                final int updatedIndegree = inDegreeMap.get(adjacentVertex) - 1;
                inDegreeMap.remove(adjacentVertex);
                inDegreeMap.put(adjacentVertex, updatedIndegree);

                if (updatedIndegree == 0){
                    queue.add(adjacentVertex);
                }
            }
        }
    }

    public static void main(String[] args) {
        final AdjacencySetGraph adjacencySetGraph = new AdjacencySetGraph(5, Graph.GraphType.DIRECTED);

        adjacencySetGraph.addEdge(1, 4);
        adjacencySetGraph.addEdge(1, 2);
        adjacencySetGraph.addEdge(2, 4);
        adjacencySetGraph.addEdge(3, 1);
        adjacencySetGraph.addEdge(3, 4);
        adjacencySetGraph.addEdge(3, 2);
        adjacencySetGraph.addEdge(0, 4);

        topologicalSort(adjacencySetGraph, 5);
    }
}
