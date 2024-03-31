package CONTROLLERS;

import DTO.Graph;
import DTO.Vertice;
import VIEWS.CreateVerticeView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControllerCreateVertice implements ActionListener {
    private CreateVerticeView view;
    private Graph graph;
    public ControllerCreateVertice(CreateVerticeView view, Graph graph){
        this.view = view;
        this.graph = graph;
        this.view.createVerticeBtn.addActionListener(this);
        this.view.setVisible(true);
        refreshTable();
    }

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

    public void cleanTxtFields(){
        view.verticeLabeltxt.setText("");
    }
    public void refreshTable(){
        view.reloadTable();
        for (Vertice vertice : graph.getVertices()) {
            view.addRow(vertice.getLabel());
        }
    }
}



