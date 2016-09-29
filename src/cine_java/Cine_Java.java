package cine_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Cine_Java {

    private static ArrayList<Pelicula> misPeliculas = new ArrayList<>();

    public static void main(String[] args) {
        misPeliculas = new ArrayList<>();
        int opcion;
        do {
            mostrarmenu();
            opcion = pedirOpcion("Selecciona una de las opciones del menú:");
            switch (opcion) {
                case 1:
                    nuevaPelicula();
                    break;

                case 2:
                    mostrarPelicula();
                    break;

                case 3:
                    listaPeliculaGeneros();
                    break;

                case 4:
                    peliculaFavorita();
                    break;

                case 5:
                    Totales();
                    break;

                case 6:
                    System.out.println("Has salido del menú");
                    break;
            }
        } while (opcion != 6);
    }

    private static void mostrarmenu() {
        System.out.println("---Cine---");
        System.out.println("1- Añadir pelicula a la coleccion");
        System.out.println("2- Consultar pelicula");
        System.out.println("3- Listado de películas de un género");
        System.out.println("4- Pelicula favorita");
        System.out.println("5- Totales");
        System.out.println("6- Salir");
    }

    private static void nuevaPelicula() {
        String titulo = pedirInformacion("Escribe el titulo de la pelicula:");
        boolean a = ComprobarTitulo(titulo);
        if(a == true){
            String director = pedirInformacion("Escribe el director de la pelicula");
        double duracion = pedirDuracion("Escribe la duracion de la pelicula(en minutos)");
        String genero = pedirInformacion("Escribe el genero de la pelicula");
        float valoracion = pedirValoracion("Escribe la valoracion de la pelicula");
        String visto_pelicula = pedirInformacion("¿Has visto la pelicula?(S/N)");
        boolean visto;
        if (visto_pelicula.equalsIgnoreCase("S")) {
            visto = true;
        } else {
            visto = false;
        }
        Pelicula p = new Pelicula(titulo, director, duracion, genero, valoracion, visto);
        misPeliculas.add(p);
        }else{
            System.out.println("Este titulo ya existe");
        }
        
    }

    private static String pedirInformacion(String mensaje) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String cadena = "";
        boolean error;
        try {
            System.out.println(mensaje);
            cadena = br.readLine();
            error = false;
        } catch (IOException ex) {
            System.out.println("Error de entrada");
            error = true;

        }
        while (error);

        return cadena;
    }

    private static double pedirDuracion(String mensaje) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double duracion = 0;
        boolean error;
        try {
            System.out.println(mensaje);
            duracion = Double.parseDouble(br.readLine());
            error = false;
        } catch (IOException ex) {
            System.out.println("Error de entrada");
            error = true;

        }
        while (error);

        return duracion;
    }

    private static float pedirValoracion(String mensaje) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double valoracion = 0;
        boolean error;
        try {
            System.out.println(mensaje);
            valoracion = Double.parseDouble(br.readLine());
            error = false;
        } catch (IOException ex) {
            System.out.println("Error de entrada");
            error = true;

        }
        while (error);

        return (float) valoracion;
    }

    private static int pedirOpcion(String mensaje) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numero = 0;
        boolean error;
        try {
            System.out.println(mensaje);
            numero = Integer.parseInt(br.readLine());
            error = false;
        } catch (IOException ex) {
            System.out.println("Error de entrada");
            error = true;
        } catch (NumberFormatException ex) {
            System.out.println("Escribe un numero");
            error = true;

        }
        while (error);

        return numero;
    }

    private static void mostrarPelicula() {
        String titulo = pedirInformacion("Escribe el titulo de la pelicula:");
        int contador = 1;
        for (Pelicula p : misPeliculas) {
            if (titulo.equalsIgnoreCase(titulo)) {
                System.out.println(contador + " " + p.toString());
            }
            contador++;
        }

    }

    private static void listaPeliculaGeneros() {
        String genero = pedirInformacion("Escribe el genero de la pelicula que quieres buscar:");
        int contador = 1;
        for (Pelicula p : misPeliculas) {
            if (genero.equalsIgnoreCase(genero)) {
                System.out.println(contador + " " + p.toString());
                contador++;
            }
        }
    }

    private static void peliculaFavorita() {
        if (misPeliculas.isEmpty()) {
            System.out.println("No hay pelicula favorita");
        } else {
            Pelicula favorita;
            favorita = misPeliculas.get(0);
            for (Pelicula p : misPeliculas) {
                if (p.getValoracion() > favorita.getValoracion()) {
                    favorita = p;
                }
            }
            System.out.println("La pelicula favorita es " + " " + favorita.getTitulo());
        }

    }

    private static void Totales() {
        if (misPeliculas.isEmpty()) {
            System.out.println("No tienes peliculas");
        } else {
            int contador = 0;
            int contador2 = 0;
            int a = 0;
            double suma_minutos = 0;
            for (Pelicula p : misPeliculas) {
                if (p.isVisto() == true) {
                    contador++;
                } else if (p.isVisto() == false) {
                    contador2++;
                }
                suma_minutos = suma_minutos + p.getDuracion();
            }
            a = contador + contador2;
            System.out.println("Te quedan por ver " + " " + (a - contador) + " peliculas ");
            System.out.println("Tienes" + " " + a + " peliculas ");
            System.out.println("Tu colección es de " + suma_minutos + " minutos ");
        }
    }

    private static boolean ComprobarTitulo(String titulo) {
        for (Pelicula p : misPeliculas) {
            if (titulo.equalsIgnoreCase(titulo)) {
                return true;
            }
        }
        return false;
    }
}
