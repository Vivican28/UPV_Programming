package actorPelicules;

/**
 * Classe Pelicules
 * 
 * @author PRG
 * @version Curs 2019/20
 */
public class Pelicules {
    /** No hi ha objectes d'aquesta classe. */
    private Pelicules() { }
    
    /**
     * Mostra, donat un llistat d'actors i una pel.licula,
     * el repartiment d'actors de la pel.licula.
     * @param llista Actor[] amb una llista d'actors.
     * @param pelicula String amb el titol d'una pel.licula.
     */
    public static void mostrarRepartiment(Actor[] llista, String pelicula) {
        for (int i = 0; i < llista.length; i++) {
            if (llista[i].getPelicula().equals(pelicula)) {
                System.out.println(llista[i].toString());
            }
        }
    }   
    
    public static void main(String[] args) {
        Actor a1 = new Actor("Javier Gutiérrez", "Campeones");
        Actor a2 = new Actor("Joaquin Phoenix", "Joker");
        Actor a3 = new Actor("Carmen Arrufat", "La inocencia");
        Actor[] llistaActors = {a1, a2, a3};        
        mostrarRepartiment(llistaActors, "Joker");
    }
}