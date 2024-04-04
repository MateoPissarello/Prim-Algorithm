package DTO;

/**
 * La clase Edge representa una arista en un gráfico.
 * Una arista tiene un vértice de origen, un vértice de destino, un peso y un estado que indica si está activo o no.
 */
public class Edge {
    private Vertice source; // El vértice de origen de la arista
    private Vertice target; // El vértice de destino de la arista
    private boolean active; // El estado de la arista, verdadero si está activo, falso en caso contrario
    private int weight; // El peso de la arista

    /**
     * Constructor para la clase Edge.
     * @param source El vértice de origen de la arista.
     * @param target El vértice de destino de la arista.
     * @param weight El peso de la arista.
     */
    public Edge(Vertice source, Vertice target, int weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
        this.active = false;
    }

    /**
     * Devuelve el vértice de origen de la arista.
     * @return El vértice de origen de la arista.
     */
    public Vertice getSource() {
        return source;
    }

    /**
     * Establece el vértice de origen de la arista.
     * @param source El nuevo vértice de origen de la arista.
     */
    public void setSource(Vertice source) {
        this.source = source;
    }

    /**
     * Devuelve el vértice de destino de la arista.
     * @return El vértice de destino de la arista.
     */
    public Vertice getTarget() {
        return target;
    }

    /**
     * Establece el vértice de destino de la arista.
     * @param target El nuevo vértice de destino de la arista.
     */
    public void setTarget(Vertice target) {
        this.target = target;
    }

    /**
     * Devuelve el peso de la arista.
     * @return El peso de la arista.
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Establece el peso de la arista.
     * @param weight El nuevo peso de la arista.
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * Devuelve el estado de la arista.
     * @return Verdadero si el arista está activo, falso en caso contrario.
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Establece el estado de la arista.
     * @param active El nuevo estado de la arista.
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Devuelve una representación de cadena de la arista.
     * @return Una representación de cadena de la arista.
     */
    @Override
    public String toString() {
        return "{source=" + source +
                ", target=" + target +
                ", weight=" + weight +
                ", active=" + active +
                '}';
    }
}