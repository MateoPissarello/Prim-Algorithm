package VIEWS;

import DTO.Vertice;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class CreateEdgeView extends JFrame {
    private JLabel createEdgeTitle;
    public JComboBox verticeACombo;
    public JComboBox verticeBCombo;
    public JButton addEdgeBtn;
    public JTable edgesTbl;
    private JLabel verticeALbl;
    private JLabel verticeBLbl;
    private JPanel mainPanel;
    private JLabel weightLbl;
    public JTextField weightTxt;

    public CreateEdgeView() {
        setContentPane(mainPanel);
        this.setTitle("Create Vertice");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(700, 400);
        setLocationRelativeTo(null);
        setVisible(true);
        createTable();

    }
    private void createTable(){
        edgesTbl.setModel(new DefaultTableModel(null, new String[]{"Vertice A", "Vertice B", "Peso"}));
    }

    public void createComboBoxModel(ArrayList<Vertice> vertices){
        verticeACombo.setModel(new DefaultComboBoxModel(new String[]{"Seleccione un vertice"}));
        verticeBCombo.setModel(new DefaultComboBoxModel(new String[]{"Seleccione un vertice"}));
        for (Vertice vertice : vertices) {
            verticeACombo.addItem(vertice.getLabel());
            verticeBCombo.addItem(vertice.getLabel());
        }
    }

    public void addRow(String verticeALbl, String verticeBLbl, int weight) {
        DefaultTableModel model = (DefaultTableModel) edgesTbl.getModel();
        model.addRow(new Object[]{verticeALbl, verticeBLbl, weight});
    }

    public void reloadTable(){
        DefaultTableModel model = (DefaultTableModel) edgesTbl.getModel();
        model.setRowCount(0);

    }

}
