package DTO;
import java.util.ArrayList;

/**
 * La clase Graph representa un gráfico que consta de vértices y aristas.
 */
public class Graph {
    ArrayList<Vertice> vertices = new ArrayList<>(); // Lista de vértices en el gráfico
    ArrayList<Edge> edges = new ArrayList<>(); // Lista de aristas en el gráfico

    /**
     * Constructor para la clase Graph.
     */
    public Graph() {
    }

    /**
     * Añade un vértice al gráfico.
     * @param vertice El vértice a añadir.
     */
    public void addVertice(Vertice vertice) {
        vertices.add(vertice);
    }

    /**
     * Añade una arista al gráfico.
     * @param edge La arista a añadir.
     */
    public void addEdge(Edge edge) {
        if (edges.size() == 0) {
            edges.add(edge);
        } else {
            for (Edge e : edges) {
                if (e.getSource().getLabel().equals(edge.getSource().getLabel()) && e.getTarget().getLabel().equals(edge.getTarget().getLabel())) {
                    return;
                } else if (e.getSource().getLabel().equals(edge.getTarget().getLabel()) && e.getTarget().getLabel().equals(edge.getSource().getLabel())) {
                    return;
                }
            }
            edges.add(edge);
        }
    }

    /**
     * Modifica una arista en el gráfico.
     * @param edge La arista a modificar.
     */
    public void modifyEdge(Edge edge) {
        for (int i = 0; i < edges.size(); i++) {
            if (edges.get(i).getSource().getLabel().equals(edge.getSource().getLabel()) && edges.get(i).getTarget().getLabel().equals(edge.getTarget().getLabel())) {
                edges.set(i, edge);
            }
        }
    }

    /**
     * Obtiene la lista de vértices en el gráfico.
     * @return La lista de vértices en el gráfico.
     */
    public ArrayList<Vertice> getVertices() {
        return vertices;
    }

    /**
     * Obtiene la lista de aristas en el gráfico.
     * @return La lista de aristas en el gráfico.
     */
    public ArrayList<Edge> getEdges() {
        return edges;
    }

    /**
     * Obtiene las aristas asociadas a un vértice dado por su etiqueta.
     * @param label La etiqueta del vértice.
     * @return La lista de aristas asociadas al vértice.
     */
    public ArrayList<Edge> getEdgesByVerticeLabel(String label) {
        ArrayList<Edge> edgesByVerticeLabel = new ArrayList<>();
        for (Edge edge : edges) {
            if (edge.getSource().getLabel().equals(label) || edge.getTarget().getLabel().equals(label)) {
                edgesByVerticeLabel.add(edge);
            }
        }
        return edgesByVerticeLabel;
    }

    /**
     * Obtiene las aristas activas en el gráfico.
     * @return La lista de aristas activas en el gráfico.
     */
    public ArrayList<Edge> getActiveEdges() {
        ArrayList<Edge> activeEdges = new ArrayList<>();
        for (Edge edge : edges) {
            if (edge.isActive()) {
                activeEdges.add(edge);
            }
        }
        return activeEdges;
    }

    /**
     * Obtiene un vértice dado por su etiqueta.
     * @param label La etiqueta del vértice.
     * @return El vértice con la etiqueta dada.
     */
    public Vertice getVerticeByLabel(String label) {
        for (Vertice vertice : vertices) {
            if (vertice.getLabel().equals(label)) {
                return vertice;
            }
        }
        return null;
    }

    /**
     * Devuelve una representación en cadena de la clase Graph.
     * @return Una representación en cadena de la clase Graph.
     */
    @Override
    public String toString() {
        return "Graph{" +
                "vertices=" + vertices +
                ", edges=" + edges +
                '}';
    }
}