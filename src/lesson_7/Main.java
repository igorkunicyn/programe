package lesson_7;



public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(10);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(4,5);
        graph.addEdge(1,8);
        graph.addEdge(8,7);
        graph.addEdge(7,9);
        graph.addEdge(3,6);
        graph.addEdge(9,3);
        graph.addEdge(7,3);
        graph.addEdge(6,9);
        graph.addEdge(3,0);


//        DepthFirstPath dfp = new DepthFirstPath(graph, 1);
//        System.out.println(dfp.hasPathTo(2));
//        System.out.println(dfp.pathTo(2));
//
        int source = 1;
        int to = 6;

//        int source = 4;
//        int to = 7;
        BreadthFirstPath bfp  = new BreadthFirstPath(graph, source);
        if (bfp.hasPathTo(to)){
            System.out.println("Кратчайший путь от вершины " + source+ "  до вершины " +
                    to + " составляет "+ bfp.pathTo(to).size()+ " ребер. И проходит через вершины -"
                    + bfp.pathTo(to));
        }else {
            System.out.println("Путь от вершины " + source+ "  до вершины " +
                    to + " отсутствует");

        }

    }
}

