package App;
import CONTROLLERS.ControllerMain;
import VIEWS.CreateVerticeView;
import VIEWS.mainView;

public class Main {
    //static Graph graph = new Graph();
    public static void main(String[] args){
        ControllerMain controllerPrim = new ControllerMain(new mainView());

//        Vertice verticeA = new Vertice("A");
//        Vertice verticeB = new Vertice("B");
//        Vertice verticeC = new Vertice("C");
//        Vertice verticeD = new Vertice("D");
//        Vertice verticeE = new Vertice("E");
//        Vertice verticeF = new Vertice("F");
//
//        graph.addVertice(verticeA);
//        graph.addVertice(verticeB);
//        graph.addVertice(verticeC);
//        graph.addVertice(verticeD);
//        graph.addVertice(verticeE);
//        graph.addVertice(verticeF);
//
//        Edge edgeAB = new Edge(verticeA, verticeB, 3);
//        Edge edgeAC = new Edge(verticeA, verticeC, 7);
//        Edge edgeAE = new Edge(verticeA, verticeE, 2);
//        Edge edgeBC = new Edge(verticeB, verticeC, 5);
//        Edge edgeBD = new Edge(verticeB, verticeD, 4);
//        Edge edgeCF = new Edge(verticeC, verticeF, 10);
//        Edge edgeEF = new Edge(verticeE, verticeF, 8);
//        Edge edgeDC = new Edge(verticeD, verticeC, 12);
//
//        graph.addEdge(edgeAB);
//        graph.addEdge(edgeAC);
//        graph.addEdge(edgeAE);
//        graph.addEdge(edgeBC);
//        graph.addEdge(edgeBD);
//        graph.addEdge(edgeCF);
//        graph.addEdge(edgeEF);
//        graph.addEdge(edgeDC);
//
//        System.out.println(graph);
//
//        Prim prim = new Prim(graph);
//        prim.calculate();
//        System.out.println(prim);
    }
}
