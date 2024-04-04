package CONTROLLERS;

import DTO.Edge;
import DTO.Prim;
import VIEWS.CreateEdgeView;
import VIEWS.CreateVerticeView;
import VIEWS.mainView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import DTO.Graph;

/**
 * La clase ControllerMain implementa ActionListener para manejar los eventos de acción.
 * Esta clase se utiliza para controlar las interacciones entre la vista principal y el modelo.
 */
public class ControllerMain implements ActionListener {
    private mainView view; // La vista principal
    private Graph graph = new Graph(); // El gráfico que se manipulará

    /**
     * Constructor para la clase ControllerMain.
     * @param view La vista principal.
     */
    public ControllerMain(mainView view) {
        this.view = view;
        this.view.addVerticeBtn.addActionListener(this);
        this.view.addEdgeBtn.addActionListener(this);
        this.view.calculatePrimBtn.addActionListener(this);
        this.view.setVisible(true);
        this.view.loadTable();
    }

    /**
     * Maneja los eventos de los botones.
     * @param actionEvent El evento de acción.
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == view.addVerticeBtn) {
            // Crear un nuevo controlador para agregar un vértice
            ControllerCreateVertice controllerCreateVertice = new ControllerCreateVertice(new CreateVerticeView(), graph);
        }
        if (actionEvent.getSource() == view.addEdgeBtn) {
            // Crear un nuevo controlador para agregar una arista
            ControllerEdge controllerEdge = new ControllerEdge(new CreateEdgeView(), graph);
        }
        if (actionEvent.getSource() == view.calculatePrimBtn) {
            // Calcular el árbol de expansión mínima usando el algoritmo de Prim
            Prim prim = new Prim(graph);
            prim.calculate();
            ArrayList<Edge> result = prim.getMinimumSpanningTree();
            // Agregar el resultado a la vista
            for (Edge edge : result) {
                view.addRow(edge.getSource().getLabel(), edge.getTarget().getLabel(), edge.getWeight());
            }
        }
    }
}