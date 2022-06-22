package search;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;

public class DFS extends Search {
    private Graph graph;

    private Graph tempGraph;
    private ArrayDeque<Node> stack;

    public DFS(Graph graph){
        name = "DFS";
        this.graph = graph;
        stack = new ArrayDeque<>();
        stringBuilder = new StringBuilder();
    }

    @Override
    public void search(int index) {
        System.out.println("스택 사용 DFS");
        dfs(index);
        showResult();

        System.out.println("재귀호출 사용 DFS");
        dfsR(index);
        showResult();
    }

    private void dfs(int index){
        stringBuilder.delete(0, stringBuilder.length());

        Node root = graph.getNode(index);

        stack.push(root);

        root.setVisit(true);

        while(!stack.isEmpty()){
            Node stackTopNode = stack.pop();

            for (Node node : stackTopNode.getAdjacentNodes()){
                if(node.getVisit() == false){
                    node.setVisit(true);
                    stack.push(node);
                }
            }

            nodeVisit(stackTopNode);
        }

        stringBuilder.append("\n");
    }
    private void dfsR(int index){
        stringBuilder.delete(0, stringBuilder.length());

        Node node = graph.getNode(index);

        dfsR(node);

        stringBuilder.append("\n");
    }

    private void dfsR(Node node){
        if (node == null){
            return;
        }

        node.setVisit(true);
        nodeVisit(node);

        for (Node adjacentNode : node.getAdjacentNodes()){
            if(adjacentNode.getVisit() == false){
                    dfsR(adjacentNode);
            }
        }
    }
    private void nodeVisit(Node node){
        stringBuilder.append(node.getData() + " ");
    }

}
