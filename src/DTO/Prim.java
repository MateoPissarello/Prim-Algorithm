package DTO;
import java.util.ArrayList;

/**
 * La clase Prim implementa el algoritmo de Prim para encontrar el árbol de expansión mínima en un gráfico.
 */
public class Prim {
    Graph graph; // El gráfico en el que se calculará el árbol de expansión mínima
    ArrayList<Vertice> evaluatedVertices = new ArrayList<>(); // Lista de vértices evaluados
    ArrayList<Edge> minimumSpanningTree = new ArrayList<>(); // Árbol de expansión mínima

    /**
     * Constructor para la clase Prim.
     * @param graph El gráfico en el que se calculará el árbol de expansión mínima.
     */
    public Prim(Graph graph) {
        this.graph = graph;
    }

    /**
     * Calcula el árbol de expansión mínima en el gráfico.
     */
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

    /**
     * Establece las aristas activas para un vértice dado.
     * @param vertice El vértice para el que se establecerán las aristas activas.
     */
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

    /**
     * Obtiene la arista de menor peso de una lista de aristas.
     * @param edges La lista de aristas de la que se obtendrá la arista de menor peso.
     * @return La arista de menor peso.
     */
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

    /**
     * Asigna un vértice temporal basado en un vértice y una arista dados.
     * @param vertice El vértice base.
     * @param minEdge La arista base.
     * @return El vértice temporal.
     */
    private Vertice assignTempVertice(Vertice vertice, Edge minEdge){
        if (minEdge.getSource().getLabel().equals(vertice.getLabel())|| minEdge.getTarget().equals((vertice.getLabel()))){
            return minEdge.getSource().getLabel().equals(vertice.getLabel()) ? minEdge.getTarget() : minEdge.getSource();
        }

        return evaluatedVertices.contains(minEdge.getSource()) ? minEdge.getTarget() : minEdge.getSource();
    }

    /**
     * Obtiene la lista de vértices evaluados.
     * @return La lista de vértices evaluados.
     */
    public ArrayList<Vertice> getEvaluatedVertices() {
        return evaluatedVertices;
    }

    /**
     * Obtiene el árbol de expansión mínima.
     * @return El árbol de expansión mínima.
     */
    public ArrayList<Edge> getMinimumSpanningTree() {
        return minimumSpanningTree;
    }

    /**
     * Devuelve una representación en cadena de la clase Prim.
     * @return Una representación en cadena de la clase Prim.
     */
    @Override
    public String toString() {
        return "Prim{" +
                "evaluatedVertices=" + evaluatedVertices +
                ", minimumSpanningTree=" + minimumSpanningTree +
                '}';
    }
}