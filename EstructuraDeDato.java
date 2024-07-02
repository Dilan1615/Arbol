/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

/**
 *
 * @author Usuario
 */
public abstract class EstructuraDeDato {
    
    private String nombre;
    
    public abstract void agregarNodo(int dato);
    public abstract void insertarNodo(int dato, int posicion);
    public abstract void recorrer();
    public abstract void borrarNodo(int posicion);
    public abstract void limpiar();
    public abstract void modificarNodo(int posicion);
    public abstract void ordenar();
    public abstract void buscarPorDato(int dato);
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
