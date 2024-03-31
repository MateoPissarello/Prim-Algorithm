package VIEWS;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CreateVerticeView extends JFrame {
    private JLabel createVerticeLbl;
    public JTextField verticeLabeltxt;
    private JPanel mainPanel;
    private JLabel labelLbl;
    public JButton createVerticeBtn;
    private JLabel verticesLbl;
    private JTable verticesTbl;

    public CreateVerticeView(){
        setContentPane(mainPanel);
        this.setTitle("Create Vertice");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setVisible(true);
        createTable();

    }


    private void createTable(){
        verticesTbl.setModel(new DefaultTableModel(null, new String[]{"Vertice"}));
    }
    public void addRow(String verticeLabel){
        DefaultTableModel model = (DefaultTableModel) verticesTbl.getModel();
        model.addRow(new Object[]{verticeLabel});
    }

    public void reloadTable(){
        DefaultTableModel model = (DefaultTableModel) verticesTbl.getModel();
        model.setRowCount(0);

    }
}
