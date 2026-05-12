package design.patterns.behavioral.iterator;

public class Pokemon {
    private String nombre;
    private String tipo1;
    private String tipo2;
    private int nPokedex;

    public Pokemon(String nombre, String tipo1, String tipo2, int nPokedex) {
        this.nombre = nombre;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
        this.nPokedex = nPokedex;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipos() {
        return tipo1 + (tipo2 != null ? "/" + tipo2 : "");
    }

    public int getnPokedex() {
        return nPokedex;
    }

    @Override
    public String toString() {
        return String.format("#%03d: %s (Tipo: %s)", nPokedex, nombre, getTipos());
    }
    
}
