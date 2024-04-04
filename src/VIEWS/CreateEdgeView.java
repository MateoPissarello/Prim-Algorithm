package VIEWS;

import DTO.Vertice;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

/**
 * La clase CreateEdgeView proporciona la interfaz de usuario para crear un borde.
 * Hereda de JFrame y contiene varios componentes de Swing para la entrada del usuario.
 */
public class CreateEdgeView extends JFrame {
    private JLabel createEdgeTitle; // Título de la ventana
    public JComboBox verticeACombo; // ComboBox para seleccionar el vértice de origen
    public JComboBox verticeBCombo; // ComboBox para seleccionar el vértice de destino
    public JButton addEdgeBtn; // Botón para agregar el borde
    public JTable edgesTbl; // Tabla para mostrar los bordes
    private JLabel verticeALbl; // Etiqueta para el vértice de origen
    private JLabel verticeBLbl; // Etiqueta para el vértice de destino
    private JPanel mainPanel; // Panel principal
    private JLabel weightLbl; // Etiqueta para el peso del borde
    public JTextField weightTxt; // Campo de texto para ingresar el peso del borde

    /**
     * Constructor para la clase CreateEdgeView.
     * Inicializa la interfaz de usuario y configura los componentes de Swing.
     */
    public CreateEdgeView() {
        setContentPane(mainPanel);
        this.setTitle("Create Vertice");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(700, 400);
        setLocationRelativeTo(null);
        setVisible(true);
        createTable();
    }

    /**
     * Crea la tabla para mostrar los bordes.
     */
    private void createTable(){
        edgesTbl.setModel(new DefaultTableModel(null, new String[]{"Vertice A", "Vertice B", "Peso"}));
    }

    /**
     * Crea los modelos para los ComboBoxes y los llena con los vértices proporcionados.
     * @param vertices Una lista de vértices para llenar los ComboBoxes.
     */
    public void createComboBoxModel(ArrayList<Vertice> vertices){
        verticeACombo.setModel(new DefaultComboBoxModel(new String[]{"Seleccione un vertice"}));
        verticeBCombo.setModel(new DefaultComboBoxModel(new String[]{"Seleccione un vertice"}));
        for (Vertice vertice : vertices) {
            verticeACombo.addItem(vertice.getLabel());
            verticeBCombo.addItem(vertice.getLabel());
        }
    }

    /**
     * Agrega una fila a la tabla con la información del borde proporcionada.
     * @param verticeALbl La etiqueta del vértice de origen.
     * @param verticeBLbl La etiqueta del vértice de destino.
     * @param weight El peso del borde.
     */
    public void addRow(String verticeALbl, String verticeBLbl, int weight) {
        DefaultTableModel model = (DefaultTableModel) edgesTbl.getModel();
        model.addRow(new Object[]{verticeALbl, verticeBLbl, weight});
    }

    /**
     * Limpia la tabla eliminando todas las filas.
     */
    public void reloadTable(){
        DefaultTableModel model = (DefaultTableModel) edgesTbl.getModel();
        model.setRowCount(0);
    }
}