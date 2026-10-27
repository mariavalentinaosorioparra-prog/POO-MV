/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package musica.modelo;

/**
 *
 * @author Valentina Osorio
 */

public class Cancion {
    private String titulo;
    private String artista;
    private int duracion; // en segundos
    private static int totalCanciones = 0; // Atributo static

    public Cancion(String titulo, String artista, int duracion) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracion = duracion;
        totalCanciones++; // Incrementa cada vez que se crea una canción
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public int getDuracion() {
        return duracion;
    }

    public static int getTotalCanciones() {
        return totalCanciones;
    }
}