package javaapplication1;

public class ArbolBinario extends EstructuraDeDato {

    private int altura;
    private NodoArbol nodoRaiz;

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public NodoArbol getNodoRaiz() {
        return nodoRaiz;
    }

    public void setNodoRaiz(NodoArbol nodoRaiz) {
        this.nodoRaiz = nodoRaiz;
    }

    @Override
    public void agregarNodo(int valor) {
        if (this.nodoRaiz == null) {
            this.nodoRaiz = new NodoArbol(valor);
        } else {
            this.nodoRaiz.insertarNodo(valor);
        }
    }

    @Override
    public void insertarNodo(int dato, int posicion) {
        // Implementación si es necesario para insertar en una posición específica
    }

    @Override
    public void recorrer() {
        // Implementación si es necesario para recorrer de alguna manera específica
    }

    @Override
    public void borrarNodo(int posicion) {
        if (nodoRaiz == null) {
            return;
        }

        nodoRaiz = nodoRaiz.delete(nodoRaiz, posicion);
        recorrerInOrden(); // Actualiza el recorrido después de borrar un nodo
    }

    @Override
    public void limpiar() {
        // Implementación si es necesario para limpiar la estructura de datos
    }

    @Override
    public void modificarNodo(int posicion) {
        // Implementación si es necesario para modificar un nodo específico
    }

    @Override
    public void ordenar() {
        // Implementación si es necesario para ordenar la estructura de datos
    }

    @Override
    public void buscarPorDato(int dato) {
        // Implementación si es necesario para buscar un dato específico
    }

    // Método para obtener el recorrido en PreOrden como String
    public String recorrerPreOrdenString() {
        StringBuilder sb = new StringBuilder();
        recorrerPreOrdenString(this.nodoRaiz, sb);
        return sb.toString().trim(); // Trim para eliminar el último espacio en blanco
    }

    private void recorrerPreOrdenString(NodoArbol nodo, StringBuilder sb) {
        if (nodo != null) {
            sb.append(nodo.getValor()).append(" ");
            recorrerPreOrdenString(nodo.getNodoIzquierdo(), sb);
            recorrerPreOrdenString(nodo.getNodoDerecho(), sb);
        }
    }

    // Método para obtener el recorrido en InOrden como String
    public String recorrerInOrdenString() {
        StringBuilder sb = new StringBuilder();
        recorrerInOrdenString(this.nodoRaiz, sb);
        return sb.toString().trim(); // Trim para eliminar el último espacio en blanco
    }

    private void recorrerInOrdenString(NodoArbol nodo, StringBuilder sb) {
        if (nodo != null) {
            recorrerInOrdenString(nodo.getNodoIzquierdo(), sb);
            sb.append(nodo.getValor()).append(" ");
            recorrerInOrdenString(nodo.getNodoDerecho(), sb);
        }
    }

    // Método para obtener el recorrido en PostOrden como String
    public String recorrerPostOrdenString() {
        StringBuilder sb = new StringBuilder();
        recorrerPostOrdenString(this.nodoRaiz, sb);
        return sb.toString().trim(); // Trim para eliminar el último espacio en blanco
    }

    private void recorrerPostOrdenString(NodoArbol nodo, StringBuilder sb) {
        if (nodo != null) {
            recorrerPostOrdenString(nodo.getNodoIzquierdo(), sb);
            recorrerPostOrdenString(nodo.getNodoDerecho(), sb);
            sb.append(nodo.getValor()).append(" ");
        }
    }

    //PreOrden: Raiz, Izquierdo, Derecho
    public void recorrerPreOrden() {
        this.preOrden(this.nodoRaiz);
        System.out.println();
    }

    private void preOrden(NodoArbol nodo) {
        if (nodo == null) {
            return; //Detener recursividad
        } else {
            System.out.print(nodo.getValor() + " - ");
            preOrden(nodo.getNodoIzquierdo());
            preOrden(nodo.getNodoDerecho());
        }
    }

    //InOrden: Izquierdo, Raiz, Derecho
    public void recorrerInOrden() {
        this.inOrden(this.nodoRaiz);
        System.out.println();
    }

    private void inOrden(NodoArbol nodo) {
        if (nodo == null) {
            return; //Detener recursividad
        } else {
            inOrden(nodo.getNodoIzquierdo());
            System.out.print(nodo.getValor() + " - ");
            inOrden(nodo.getNodoDerecho());
        }
    }

    //PostOrden: Izquierdo, Derecho, Raiz
    public void recorrerPostOrden() {
        this.postOrden(this.nodoRaiz);
        System.out.println();
    }

    public void postOrden(NodoArbol nodo) {
        if (nodo == null) {
            return; //Detener recursividad
        } else {
            postOrden(nodo.getNodoIzquierdo());
            postOrden(nodo.getNodoDerecho());
            System.out.print(nodo.getValor() + " - ");
        }
    }
}
