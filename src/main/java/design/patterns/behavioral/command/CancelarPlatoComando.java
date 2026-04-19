package design.patterns.behavioral.command;

// ─────────────────────────────────────────────
// CONCRETE COMMAND — Cancelar plato
// Encapsula la acción de quitar un plato del pedido
// ─────────────────────────────────────────────
class CancelarPlatoComando implements Comando {
    private final cocina cocina;
    private final String plato;

    public CancelarPlatoComando(cocina cocina, String plato) {
        this.cocina = cocina;
        this.plato  = plato;
    }

    @Override
    public void ejecutar() {
        cocina.quitarPlato(plato);
    }

    @Override
    public void deshacer() {
        cocina.agregarPlato(plato);
    }

    @Override
    public String descripcion() {
        return "Cancelar: " + plato;
    }
}