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

public class ControllerMain implements ActionListener {
    private mainView view;
    private Graph graph = new Graph();


    public ControllerMain(mainView view) {
        this.view = view;
        this.view.addVerticeBtn.addActionListener(this);
        this.view.addEdgeBtn.addActionListener(this);
        this.view.calculatePrimBtn.addActionListener(this);
        this.view.setVisible(true);
        this.view.loadTable();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == view.addVerticeBtn) {
            ControllerCreateVertice controllerCreateVertice = new ControllerCreateVertice(new CreateVerticeView(), graph);
        }
        if (actionEvent.getSource() == view.addEdgeBtn) {
            ControllerEdge controllerEdge = new ControllerEdge(new CreateEdgeView(), graph);
        }
        if (actionEvent.getSource() == view.calculatePrimBtn) {
            Prim prim = new Prim(graph);
            prim.calculate();
            ArrayList<Edge> result = prim.getMinimumSpanningTree();
            for (Edge edge : result) {
                view.addRow(edge.getSource().getLabel(), edge.getTarget().getLabel(), edge.getWeight());
            }
        }

    }
}
