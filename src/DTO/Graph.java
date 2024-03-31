package DTO;
import java.security.interfaces.EdECKey;
import java.util.ArrayList;
public class Graph {
    ArrayList<Vertice> vertices = new ArrayList<>();
    ArrayList<Edge> edges = new ArrayList<>();

    public Graph() {
    }
    public void addVertice(Vertice vertice) {
        vertices.add(vertice);
    }
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

    public void modifyEdge(Edge edge) {
        for (int i = 0; i < edges.size(); i++) {
            if (edges.get(i).getSource().getLabel().equals(edge.getSource().getLabel()) && edges.get(i).getTarget().getLabel().equals(edge.getTarget().getLabel())) {
                edges.set(i, edge);
            }
        }
    }

    public ArrayList<Vertice> getVertices() {
        return vertices;
    }
    public ArrayList<Edge> getEdges() {
        return edges;
    }
    public ArrayList<Edge> getEdgesByVerticeLabel(String label) {
        ArrayList<Edge> edgesByVerticeLabel = new ArrayList<>();
        for (Edge edge : edges) {
            if (edge.getSource().getLabel().equals(label) || edge.getTarget().getLabel().equals(label)) {
                edgesByVerticeLabel.add(edge);
            }
        }
        return edgesByVerticeLabel;
    }

    public ArrayList<Edge> getActiveEdges() {
        ArrayList<Edge> activeEdges = new ArrayList<>();
        for (Edge edge : edges) {
            if (edge.isActive()) {
                activeEdges.add(edge);
            }
        }
        return activeEdges;
    }

    public Vertice getVerticeByLabel(String label) {
        for (Vertice vertice : vertices) {
            if (vertice.getLabel().equals(label)) {
                return vertice;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Graph{" +
                "vertices=" + vertices +
                ", edges=" + edges +
                '}';
    }
}
