package DTO;
public class Edge {
    private Vertice source;
    private Vertice target;
    private boolean active;
    private int weight;

    public Edge(Vertice source, Vertice target, int weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
        this.active = false;
    }

    public Vertice getSource() {
        return source;
    }

    public void setSource(Vertice source) {
        this.source = source;
    }

    public Vertice getTarget() {
        return target;
    }

    public void setTarget(Vertice target) {
        this.target = target;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "{source=" + source +
                ", target=" + target +
                ", weight=" + weight +
                ", active=" + active +
                '}';
    }
}
