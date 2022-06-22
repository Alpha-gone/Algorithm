package search;

public class SearchMain {
    public static void main(String[] args) {
        Graph graph = new Graph(7);

        graph.addEdge(1, 2);
        graph.addEdge(1, 5);
        graph.addEdge(2, 3);
        graph.addEdge(2, 5);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);

        searcher(new DFS(graph.clone()));
    }

    private static void searcher(Search searchClazz){
        System.out.println("-".repeat(10) + searchClazz.getName() + "-".repeat(10));

        searchClazz.search(1);
    }
}
