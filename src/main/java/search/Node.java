package search;

import java.util.LinkedList;
import java.util.List;

public class Node {
    private int data;
    private List<Node> adjacentNodes;
    private boolean isVisit;

    public Node(int data){
        this.data = data;
        adjacentNodes = new LinkedList<>();
        isVisit = false;
    }

    public int getData(){
        return data;
    }

    public boolean isNotAdjacentNode(Node node){
        return !adjacentNodes.contains(node);
    }

    public List<Node> getAdjacentNodes(){
        return adjacentNodes;
    }

    public void setAdjacentNode(Node node){
        adjacentNodes.add(node);
    }

    public void setVisit(boolean isVisit){
        this.isVisit = isVisit;
    }

    public boolean getVisit(){
        return isVisit;
    }
}
