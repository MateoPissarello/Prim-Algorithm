package CONTROLLERS;

import DTO.Graph;
import DTO.Vertice;
import VIEWS.CreateVerticeView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * La clase ControllerCreateVertice controla la lógica para crear un vértice.
 * Implementa ActionListener para manejar los eventos de los botones.
 */
public class ControllerCreateVertice implements ActionListener {
    private final CreateVerticeView view; // La vista para crear un vértice
    private final Graph graph; // El gráfico al que se añadirá el vértice

    /**
     * Constructor para la clase ControllerCreateVertice.
     * @param view La vista para crear un vértice.
     * @param graph El gráfico al que se añadirá el vértice.
     */
    public ControllerCreateVertice(CreateVerticeView view, Graph graph){
        this.view = view;
        this.graph = graph;
        this.view.createVerticeBtn.addActionListener(this);
        this.view.setVisible(true);
        refreshTable();
    }

    /**
     * Maneja los eventos de los botones.
     * @param actionEvent El evento de acción.
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == view.createVerticeBtn) {
            Vertice newVertice = new Vertice(view.verticeLabeltxt.getText().toUpperCase());
            cleanTxtFields();
            ArrayList<Vertice> vertices = graph.getVertices();
            for (Vertice vertice : vertices) {
                if (vertice.getLabel().equals(newVertice.getLabel())) {
                    JOptionPane.showMessageDialog(null, "El vertice ya existe");
                    return;
                }

            }
            graph.addVertice(newVertice);
            refreshTable();
            System.out.println(graph.getVertices());
        }
    }

    /**
     * Limpia los campos de texto de la vista.
     */
    public void cleanTxtFields(){
        view.verticeLabeltxt.setText("");
    }

    /**
     * Actualiza la tabla de la vista con los vértices del gráfico.
     */
    public void refreshTable(){
        view.reloadTable();
        for (Vertice vertice : graph.getVertices()) {
            view.addRow(vertice.getLabel());
        }
    }
}