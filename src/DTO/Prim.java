package DTO;
import java.util.ArrayList;
public class Prim {
    Graph graph;
    ArrayList<Vertice> evaluatedVertices = new ArrayList<>();
    ArrayList<Edge> minimumSpanningTree = new ArrayList<>();


    public Prim(Graph graph) {
        this.graph = graph;
    }

    public void calculate(){
        Vertice tempVertice = graph.getVertices().get(0);
        evaluatedVertices.add(tempVertice);

        while(evaluatedVertices.size() != graph.getVertices().size()) {
            setActiveEdges(tempVertice);
            ArrayList<Edge> activeEdges = graph.getActiveEdges();
            Edge minEdge = getLowestWeightEdge(activeEdges);
            tempVertice = assignTempVertice(tempVertice, minEdge);
            evaluatedVertices.add(tempVertice);
            minimumSpanningTree.add(minEdge);

        }


    }
    private void setActiveEdges(Vertice vertice) {
        ArrayList<Edge> edges = graph.getEdgesByVerticeLabel(vertice.getLabel());
        for (Edge edge : edges) {
            if (evaluatedVertices.contains(edge.getSource()) && evaluatedVertices.contains(edge.getTarget())) {
                edge.setActive(false);
                graph.modifyEdge(edge);
                continue;
            }
            edge.setActive(true);
            graph.modifyEdge(edge);
        }
    }

    private Edge getLowestWeightEdge(ArrayList<Edge> edges) {
        Edge minEdge = null;
        for (Edge edge : edges) {
            if (minEdge == null) {
                minEdge = edge;
            } else {
                if (edge.getWeight() < minEdge.getWeight()) {
                    if (evaluatedVertices.contains(edge.getSource()) && evaluatedVertices.contains(edge.getTarget())) {
                        continue;
                    }
                    minEdge = edge;
                }
            }
        }
        graph.edges.remove(minEdge);
        return minEdge;
    }

    private Vertice assignTempVertice(Vertice vertice, Edge minEdge){
        if (minEdge.getSource().getLabel().equals(vertice.getLabel())|| minEdge.getTarget().equals((vertice.getLabel()))){
            return minEdge.getSource().getLabel().equals(vertice.getLabel()) ? minEdge.getTarget() : minEdge.getSource();
        }

        return evaluatedVertices.contains(minEdge.getSource()) ? minEdge.getTarget() : minEdge.getSource();

    }

    public ArrayList<Vertice> getEvaluatedVertices() {
        return evaluatedVertices;
    }

    public ArrayList<Edge> getMinimumSpanningTree() {
        return minimumSpanningTree;
    }

    @Override
    public String toString() {
        return "Prim{" +
                "evaluatedVertices=" + evaluatedVertices +
                ", minimumSpanningTree=" + minimumSpanningTree +
                '}';
    }
}
