/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package musica.app;

/**
 *
 * @author Valentina Osorio
 */

import java.util.ArrayList;
import musica.modelo.Cancion;
import musica.modelo.Playlist;

public class Reproductor {
    public static void main(String[] args) {
        Cancion c1 = new Cancion("Lluvia en Manizales", "Nevado", 200);
        Cancion c2 = new Cancion("Bajo el guadual", "Café Trío", 245);
        Cancion c3 = new Cancion("Noche en Chipre", "Nevado", 185);

        Playlist favoritas = new Playlist("Favoritas");
        
        System.out.println(favoritas.agregar(c1));
        favoritas.agregar(c2);
        favoritas.agregar(c3);
        System.out.println(favoritas.agregar(c1)); // Intenta agregar c1 otra vez

        favoritas.mostrar();
        System.out.println(favoritas.duracionTotal());

        // Etapa 3
        Playlist viaje = new Playlist("Viaje");
        viaje.agregar(c1);
        viaje.agregar(c2);

        System.out.println(favoritas.eliminarArtista("Nevado"));
        favoritas.mostrar();
        viaje.mostrar();

        System.out.println(favoritas.buscar("bajo el guadual").getArtista());
        System.out.println(favoritas.buscar("Lluvia en Manizales"));

        // Etapa 4
        Cancion c4 = new Cancion("Río Chinchiná", "Nevado", 230);
        System.out.println(viaje.agregar(c3));
        System.out.println(viaje.agregar(c4));
        System.out.println(Cancion.getTotalCanciones());
        System.out.println(Playlist.MAX_CANCIONES);

        // Demostración Reto 3 (copia de la lista y clear)
        ArrayList<Cancion> copiaLista = favoritas.getCanciones();
        copiaLista.clear();
        System.out.println("Tamaño de favoritas después de limpiar la copia: " + favoritas.getCanciones().size());

        // Reto 5 (Predicción)
        ArrayList<Cancion> listaReto = new ArrayList<>();
        Cancion x = new Cancion("A", "Uno", 100);
        listaReto.add(x);
        listaReto.add(x);
        listaReto.add(new Cancion("A", "Uno", 100));
        System.out.println(listaReto.size());
        System.out.println(listaReto.get(0) == listaReto.get(1));
        System.out.println(listaReto.get(0) == listaReto.get(2));
        listaReto.remove(x);
        System.out.println(listaReto.size());
        System.out.println(listaReto.contains(x));
    }
}
