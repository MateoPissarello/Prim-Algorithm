package VIEWS;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * La clase CreateVerticeView proporciona la interfaz de usuario para crear un vértice.
 * Extiende JFrame para proporcionar la funcionalidad de la ventana.
 */
public class CreateVerticeView extends JFrame {
    private JLabel createVerticeLbl;
    public JTextField verticeLabeltxt;
    private JPanel mainPanel;
    private JLabel labelLbl;
    public JButton createVerticeBtn;
    private JLabel verticesLbl;
    private JTable verticesTbl;

    /**
     * Constructor para la clase CreateVerticeView.
     * Configura la ventana y crea la tabla.
     */
    public CreateVerticeView(){
        setContentPane(mainPanel);
        this.setTitle("Create Vertice");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setVisible(true);
        createTable();
    }

    /**
     * Crea la tabla en la interfaz de usuario.
     */
    private void createTable(){
        verticesTbl.setModel(new DefaultTableModel(null, new String[]{"Vertice"}));
    }

    /**
     * Añade una fila a la tabla con la etiqueta del vértice.
     * @param verticeLabel La etiqueta del vértice.
     */
    public void addRow(String verticeLabel){
        DefaultTableModel model = (DefaultTableModel) verticesTbl.getModel();
        model.addRow(new Object[]{verticeLabel});
    }

    /**
     * Recarga la tabla, eliminando todas las filas existentes.
     */
    public void reloadTable(){
        DefaultTableModel model = (DefaultTableModel) verticesTbl.getModel();
        model.setRowCount(0);
    }
}