package com.datastructures.graph;

public class DistanceInfo {

    private int distanceFromSource;
    private int lastVisitedVertex;

    public DistanceInfo(int distanceFromSource, int lastVisitedVertex) {
        this.distanceFromSource = distanceFromSource;
        this.lastVisitedVertex = lastVisitedVertex;
    }

    public void setDistanceFromSource(int distanceFromSource) {
        this.distanceFromSource = distanceFromSource;
    }

    public void setLastVisitedVertex(int lastVisitedVertex) {
        this.lastVisitedVertex = lastVisitedVertex;
    }

    public int getDistanceFromSource() {
        return distanceFromSource;
    }

    public int getLastVisitedVertex() {
        return lastVisitedVertex;
    }
}