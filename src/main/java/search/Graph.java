package search;

import java.util.LinkedList;
import java.util.List;

public class Graph implements Cloneable{
    private Node[] nodeArray;

    Graph(int size){
        nodeArray = new Node[size];

        for(int i = 0; i < nodeArray.length; i++){
            nodeArray[i] = new Node(i);
        }
    }

    void addEdge(int firstNodeIdx, int secondNodeIdx) {
        Node firstNode = nodeArray[firstNodeIdx];
        Node secondNode = nodeArray[secondNodeIdx];

        if (firstNode.isNotAdjacentNode(secondNode)) {
            firstNode.setAdjacentNode(secondNode);
        }

        if (secondNode.isNotAdjacentNode(firstNode)) {
            secondNode.setAdjacentNode(firstNode);
        }
    }

    Node getNode(int idx){
        return nodeArray[idx];
    }

    @Override
    public Graph clone(){
        try {
            return (Graph) super.clone();
        }catch (CloneNotSupportedException e){
            return null;
        }

    }
}
