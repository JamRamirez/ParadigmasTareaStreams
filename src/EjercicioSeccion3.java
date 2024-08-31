import java.util.*;
import java.util.stream.Collectors;

class Pelicula
{
    private String titulo;
    private String director;
    private int estreno;

    public Pelicula(String titulo, String director, int estreno)
    {
        this.titulo = titulo;
        this.director = director;
        this.estreno = estreno;
    }

    public String getTitulo()
    {
        return titulo;
    }

    public String getDirector()
    {
        return director;
    }

    public int getEstreno()
    {
        return estreno;
    }

    @Override
    public String toString()
    {
        return titulo + " (" + director + ", " + estreno + ")";
    }
}

public class EjercicioSeccion3
{
    public static void main(String[] args)
    {
        List<Pelicula> peliculas = new ArrayList<>();
        peliculas.add(new Pelicula("E.T.", "Steven Spielberg", 1982));
        peliculas.add(new Pelicula("Avatar", "James Cameron", 2009));
        peliculas.add(new Pelicula("Salvar al soldado Ryan", "Steven Spielberg", 1998));
        peliculas.add(new Pelicula("Origen", "Christopher Nolan", 2010));
        peliculas.add(new Pelicula("L.A. Confidential", "Curtis Hanson", 1997));


        //Obtener un sublistado con las películas estrenadas en el siglo XXI (a partir del año 2000, inclusive)

        List<Pelicula> peliculasSigloXXI = peliculas.stream()
                .filter(pelicula -> pelicula.getEstreno() >= 2000)
                .collect(Collectors.toList());


        System.out.println("Obtener un sublistado con las películas estrenadas en el siglo XXI (a partir del año 2000, inclusive):\n\n");
        System.out.println(peliculasSigloXXI);

        //Mostrar por pantalla, separados por comas, los títulos de las películas de Steven Spielberg

        String peliculasSpielberg = peliculas.stream()
                .filter(pelicula -> pelicula.getDirector().equals("Steven Spielberg"))
                .map(pelicula -> pelicula.getTitulo())
                .collect(Collectors.joining(", ",
                        "Películas de Steven Spielberg -> ", ""));

        System.out.println("\n---------\nMostrar por pantalla, separados por comas, los títulos de las películas de Steven Spielberg):\n\n");
        System.out.println(peliculasSpielberg);

        //Obtener un sublistado con los nombres de las películas, ordenados alfabéticamente

        Comparator<Pelicula> cPeliAlfa = (p1, p2) -> p1.getTitulo().compareTo(p2.getTitulo());

        List<Pelicula> peliculasAfabeticas = peliculas.stream()
                .sorted(cPeliAlfa)
                .collect(Collectors.toList());

        System.out.println("\n---------\nObtener un sublistado con los nombres de las películas, ordenados alfabéticamente):\n\n");
        System.out.println(peliculasAfabeticas);

    }
}
