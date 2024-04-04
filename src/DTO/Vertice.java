package DTO;

/**
 * La clase Vertice representa un vértice en un gráfico.
 * Cada vértice tiene una etiqueta que lo identifica.
 */
public class Vertice {
    private String label; // La etiqueta del vértice

    /**
     * Constructor para la clase Vertice.
     * @param label La etiqueta del vértice.
     */
    public Vertice(String label) {
        this.label = label;
    }

    /**
     * Obtiene la etiqueta del vértice.
     * @return La etiqueta del vértice.
     */
    public String getLabel() {
        return label;
    }

    /**
     * Establece la etiqueta del vértice.
     * @param label La nueva etiqueta del vértice.
     */
    public void setId(String label) {
        this.label = label;
    }

    /**
     * Devuelve una representación en cadena de la clase Vertice.
     * @return Una representación en cadena de la clase Vertice.
     */
    @Override
    public String toString() {
        return label;
    }
}