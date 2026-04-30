package rpgmanager.model;

public class Guerrero extends Personaje {
    private int fuerza;
    private int defensa;
    
    public Guerrero(String nombre, int nivel) {
        super(nombre, nivel, 100 + nivel * 10);  // vidaMax = 100 + nivel*10
        this.fuerza = 15 + nivel * 3;
        this.defensa = 10 + nivel * 2;
    }
    
    @Override
    public void atacar(Personaje objetivo) {
        System.out.println(this.nombre + " (Guerrero) golpea con fuerza " + fuerza);
        objetivo.recibirDano(fuerza);
    }
    
    @Override
    public String getTipoPersonaje() {
        return "Guerrero";
    }
    
    // Método propio
    public void usarEscudo() {
        System.out.println(this.nombre + " bloquea con defensa " + defensa + "!");
    }
}
