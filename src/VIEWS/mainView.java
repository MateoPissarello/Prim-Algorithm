package VIEWS;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class mainView extends JFrame {

    private JPanel mainPanel;
    private JLabel titleLbl;
    public JButton addVerticeBtn;
    public JButton addEdgeBtn;
    public JButton calculatePrimBtn;
    private JTable mainTbl;

    public mainView(){
        setContentPane(mainPanel);
        this.setTitle("Menú principal");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);
        createTable();
    }
    private void createTable(){
        mainTbl.setModel(new DefaultTableModel(null, new String[]{"Vertice A", "Vertice B", "Peso"}));
    }
    public void loadTable(){
        DefaultTableModel model = (DefaultTableModel) mainTbl.getModel();
        model.setRowCount(0);
    }
    public void addRow(String verticeALbl, String verticeBLbl, int weight){
        DefaultTableModel model = (DefaultTableModel) mainTbl.getModel();
        model.addRow(new Object[]{verticeALbl, verticeBLbl, weight});
    }
}
