package DTO;

public class Vertice {
    private String label;

    public Vertice(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setId(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
