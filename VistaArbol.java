/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class VistaArbol extends JPanel {

    private ArbolBinario arbol;
    private int radio = 20;
    private int verticalSeparation = 50;

    public VistaArbol(ArbolBinario arbol) {
        this.arbol = arbol;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (arbol.getNodoRaiz() != null) {
            dibujarNodo(g, arbol.getNodoRaiz(), getWidth() / 2, 30, getWidth() / 4);
        }
    }

    private void dibujarNodo(Graphics g, NodoArbol nodo, int x, int y, int hSeparation) {
        if (nodo == null) {
            return;
        }

        g.setColor(java.awt.Color.BLACK);
        g.fillOval(x - radio, y - radio, 2 * radio, 2 * radio);
        g.setColor(java.awt.Color.GREEN);
        g.drawString(Integer.toString(nodo.valor), x - 6, y + 4);

        if (nodo.getNodoIzquierdo() != null) {
            g.drawLine(x - radio, y + radio, x - hSeparation + radio, y + verticalSeparation - radio);
            dibujarNodo(g, nodo.getNodoIzquierdo(), x - hSeparation, y + verticalSeparation, hSeparation / 2);
        }

        if (nodo.getNodoDerecho() != null) {
            g.drawLine(x + radio, y + radio, x + hSeparation - radio, y + verticalSeparation - radio);
            dibujarNodo(g, nodo.getNodoDerecho(), x + hSeparation, y + verticalSeparation, hSeparation / 2);
        }
    }

}
