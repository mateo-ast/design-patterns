package design.patterns.behavioral.command;
// ─────────────────────────────────────────────
// CONCRETE COMMAND — Agregar plato
// Encapsula la acción de agregar un plato al pedido
// ─────────────────────────────────────────────
class AgregarPlatoComando implements Comando {
    private final cocina cocina;
    private final String plato;

    public AgregarPlatoComando(cocina cocina, String plato) {
        this.cocina = cocina;
        this.plato  = plato;
    }

    @Override
    public void ejecutar() {
        cocina.agregarPlato(plato);
    }

    @Override
    public void deshacer() {
        cocina.quitarPlato(plato);
    }

    @Override
    public String descripcion() {
        return "Agregar: " + plato;
    }
}