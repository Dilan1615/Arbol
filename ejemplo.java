package javaapplication1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Color;

public class ejemplo {

    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        arbol.agregarNodo(18);
        arbol.agregarNodo(12);
        arbol.agregarNodo(25);
        arbol.agregarNodo(17);
        arbol.agregarNodo(54);
        arbol.agregarNodo(92);
        arbol.agregarNodo(1);
        arbol.agregarNodo(7);

        System.out.println("\nRecorrido PreOrden: ");
        System.out.println(arbol.recorrerPreOrdenString());
        System.out.println("\nRecorrido InOrden: ");
        System.out.println(arbol.recorrerInOrdenString());
        System.out.println("\nRecorrido PostOrden: ");
        System.out.println(arbol.recorrerPostOrdenString());

        System.out.println("Eliminando nodo con valor de 17");
        arbol.borrarNodo(17);

        JFrame frame = new JFrame("Árbol Binario");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        VistaArbol vistaArbol = new VistaArbol(arbol);
        frame.add(vistaArbol, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel(new GridBagLayout());
        controlPanel.setBackground(new Color(173, 216, 230));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel titleLabel = new JLabel("Gestión del Árbol Binario");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 20));
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        controlPanel.add(titleLabel, gbc);

        JTextField valorField = new JTextField(5);
        JButton addButton = new JButton("Añadir Nodo");
        JButton deleteButton = new JButton("Eliminar Nodo");
        JTextArea recorridosTextArea = new JTextArea(10, 30);
        recorridosTextArea.setEditable(false);

        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        controlPanel.add(new JLabel("Valor:"), gbc);

        gbc.gridx = 1;
        controlPanel.add(valorField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        controlPanel.add(addButton, gbc);

        gbc.gridx = 1;
        controlPanel.add(deleteButton, gbc);

        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 3;
        controlPanel.add(new JLabel("Recorridos:"), gbc);

        gbc.gridy = 4;
        controlPanel.add(new JScrollPane(recorridosTextArea), gbc);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int valor = Integer.parseInt(valorField.getText());
                    arbol.agregarNodo(valor);
                    valorField.setText("");
                    actualizarRecorridos(recorridosTextArea, arbol);
                    vistaArbol.repaint(); // Actualiza la vista del árbol
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, ingrese un valor válido.");
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int valor = Integer.parseInt(valorField.getText());
                    arbol.borrarNodo(valor);
                    valorField.setText("");
                    actualizarRecorridos(recorridosTextArea, arbol);
                    vistaArbol.repaint(); // Actualiza la vista del árbol
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, ingrese un valor válido.");
                }
            }
        });

        frame.add(controlPanel, BorderLayout.NORTH);
        frame.setVisible(true);

        // Mostrar los recorridos iniciales
        actualizarRecorridos(recorridosTextArea, arbol);
    }

    // Método para actualizar el JTextArea con los recorridos actuales del árbol
    private static void actualizarRecorridos(JTextArea textArea, ArbolBinario arbol) {
        String preOrden = arbol.recorrerPreOrdenString();
        String inOrden = arbol.recorrerInOrdenString();
        String postOrden = arbol.recorrerPostOrdenString();
        textArea.setText("PreOrden: " + preOrden + "\n"
                        + "InOrden: " + inOrden + "\n"
                        + "PostOrden: " + postOrden);
    }
}
