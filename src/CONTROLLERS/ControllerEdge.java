package CONTROLLERS;

import DTO.Edge;
import DTO.Graph;
import DTO.Vertice;
import VIEWS.CreateEdgeView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * La clase ControllerEdge implementa ActionListener para manejar los eventos de acción.
 * Esta clase se utiliza para controlar las interacciones entre la vista y el modelo en el contexto de los bordes en un gráfico.
 */
public class ControllerEdge implements ActionListener {
    private CreateEdgeView view;
    private Graph graph;

    /**
     * Constructor para la clase ControllerEdge.
     * @param view La vista para crear una arista.
     * @param graph El gráfico al que se añadirá la arista.
     */
    public ControllerEdge(CreateEdgeView view, Graph graph) {
        this.view = view;
        this.graph = graph;
        this.view.addEdgeBtn.addActionListener(this);
        this.view.setVisible(true);
        this.view.createComboBoxModel(graph.getVertices());
        refreshTable();

    }
    /**
     * Maneja los eventos de los botones.
     * @param actionEvent El evento de acción.
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == view.addEdgeBtn) {
            if (view.verticeACombo.getSelectedItem().equals(view.verticeBCombo.getSelectedItem()) && !view.verticeACombo.getSelectedItem().equals("Seleccione un vertice") && !view.verticeBCombo.getSelectedItem().equals("Seleccione un vertice")) {
                JOptionPane.showMessageDialog(null, "No se puede conectar un vertice consigo mismo");
                return;
            }
            if (view.verticeACombo.getSelectedItem().equals("Seleccione un vertice") || view.verticeBCombo.getSelectedItem().equals("Seleccione un vertice")) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un vertice");

                return;
            }
            if (view.weightTxt.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El peso no puede estar vacio");
                return;
            }
            String verticeALbl = view.verticeACombo.getSelectedItem().toString();
            String verticeBLbl = view.verticeBCombo.getSelectedItem().toString();
            int weight = Integer.parseInt(view.weightTxt.getText());
            Edge edge = new Edge(graph.getVerticeByLabel(verticeALbl), graph.getVerticeByLabel(verticeBLbl), weight);

            Edge alterEdge = new Edge(graph.getVerticeByLabel(verticeBLbl), graph.getVerticeByLabel(verticeALbl), weight);
            if (edgeAlterExists(edge, view.edgesTbl)) {
                JOptionPane.showMessageDialog(null, "La arista ya existe");
            } else {
                graph.addEdge(edge);
                refreshTable();


            }

        }

    }
    /**
     * Comprueba si existe una arista alterna.
     * @param edge La arista a comprobar.
     * @param table La tabla donde buscar la arista.
     * @return Verdadero si la arista alterna existe, falso en caso contrario.
     */
    public static boolean edgeAlterExists(Edge edge, JTable table){
        String verticeA = edge.getSource().getLabel();
        String verticeB = edge.getTarget().getLabel();
        for (int i = 0; i < table.getRowCount(); i++) {
            if (table.getValueAt(i, 0).equals(verticeB) && table.getValueAt(i, 1).equals(verticeA)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Actualiza la tabla de la vista con las aristas del gráfico.
     */
    public void refreshTable(){
        view.reloadTable();
        for (Edge edge : graph.getEdges()) {
            view.addRow(edge.getSource().getLabel(), edge.getTarget().getLabel(), edge.getWeight());

        }
    }
}

