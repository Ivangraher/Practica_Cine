package practica_cine;
 

public class Pelicula {
    
    private String titulo;
    private String director;
    private double duracion;
    private String genero;
    private float valoracion;
    private boolean visto;

    public Pelicula(String titulo, String director, double duracion, String genero, float valoracion, boolean visto) {
        this.titulo = titulo;
        this.director = director;
        this.duracion = duracion;
        this.genero = genero;
        this.valoracion = valoracion;
        this.visto = visto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public float getValoracion() {
        return valoracion;
    }

    public void setValoracion(float valoracion) {
        this.valoracion = valoracion;
    }

    public boolean isVisto() {
        return visto;
    }

    public void setVisto(boolean visto) {
        this.visto = visto;
    }



    @Override
    public String toString() {
        return "Pelicula{" + "titulo=" + titulo + ", director=" + director + ", duracion=" + duracion + ", genero=" + genero + ", valoracion=" + valoracion + ", visto=" + visto + '}';
    }

   
    
    
    
}
