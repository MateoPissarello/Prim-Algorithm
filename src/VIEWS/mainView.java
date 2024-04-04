package VIEWS;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * La clase mainView representa la vista principal de la aplicación.
 * Esta clase extiende JFrame y contiene los componentes de la interfaz de usuario.
 */
public class mainView extends JFrame {

    private JPanel mainPanel; // El panel principal de la vista
    private JLabel titleLbl; // La etiqueta del título
    public JButton addVerticeBtn; // El botón para añadir un vértice
    public JButton addEdgeBtn; // El botón para añadir una arista
    public JButton calculatePrimBtn; // El botón para calcular el árbol de expansión mínima
    private JTable mainTbl; // La tabla principal para mostrar los resultados

    /**
     * Constructor para la clase mainView.
     */
    public mainView(){
        setContentPane(mainPanel);
        this.setTitle("Menú principal");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);
        createTable();
    }

    /**
     * Crea la tabla principal.
     */
    private void createTable(){
        mainTbl.setModel(new DefaultTableModel(null, new String[]{"Vertice A", "Vertice B", "Peso"}));
    }

    /**
     * Carga la tabla principal.
     */
    public void loadTable(){
        DefaultTableModel model = (DefaultTableModel) mainTbl.getModel();
        model.setRowCount(0);
    }

    /**
     * Añade una fila a la tabla principal.
     * @param verticeALbl La etiqueta del vértice A.
     * @param verticeBLbl La etiqueta del vértice B.
     * @param weight El peso de la arista entre el vértice A y el vértice B.
     */
    public void addRow(String verticeALbl, String verticeBLbl, int weight){
        DefaultTableModel model = (DefaultTableModel) mainTbl.getModel();
        model.addRow(new Object[]{verticeALbl, verticeBLbl, weight});
    }
}