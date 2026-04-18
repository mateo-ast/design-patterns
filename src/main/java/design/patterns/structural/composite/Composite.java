package design.patterns.structural.composite;

import design.patterns.DesignPattern;

public class Composite implements DesignPattern {
    @Override
    public void run() {

        // Crear algunos archivos (hojas)
        Componente archivo1 = new Archivo("documento.txt");
        Componente archivo2 = new Archivo("imagen.jpg");
        Componente archivo3 = new Archivo("video.mp4");

        // Crear carpetas (compuestos)
        Carpeta carpetaRaiz = new Carpeta("Mi Disco");
        Carpeta carpetaFotos = new Carpeta("Fotos");
        Carpeta carpetaVideos = new Carpeta("Videos");

        // Agregar archivos a las carpetas
        carpetaFotos.agregar(archivo1);
        carpetaFotos.agregar(archivo2);
        carpetaVideos.agregar(archivo3);

        // Agregar carpetas a la raíz
        carpetaRaiz.agregar(carpetaFotos);
        carpetaRaiz.agregar(carpetaVideos);

        // Mostrar la estructura completa
        carpetaRaiz.mostrar(0);
    }
}
