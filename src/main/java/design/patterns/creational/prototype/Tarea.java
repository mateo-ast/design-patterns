package design.patterns.creational.prototype;

public class Tarea implements TareaPrototype {
  // atributos de mi clase tarea

  private String nombre;
  private String descripcion;

  // contructor para crea una tarea

  public Tarea(String nombre, String descripcion) {
    this.nombre = nombre;
    this.descripcion = descripcion;
  }

  // metodo para clonar el objeto

  public TareaPrototype clonar() {
    // crea una nueva intancia copiando los valores actuales
    return new Tarea(this.nombre, this.descripcion);
  }

  // metodos para mostrar las tareas
  public void mostrar() {
    System.out.println("Tarea " + nombre + " - " + descripcion);

  }

  // metodo para modificar nombre (para demostrar que es una copia)
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
}
