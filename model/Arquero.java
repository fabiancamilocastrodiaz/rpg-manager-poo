package rpgmanager.model;

public class Arquero extends Personaje {
    private int flechas;
    private int alcance;
    
    public Arquero(String nombre, int nivel) {
        super(nombre, nivel, 75 + nivel * 7);  // vidaMax = 75 + nivel*7
        this.flechas = 10 + nivel * 2;
        this.alcance = 30;
    }
    
    @Override
    public void atacar(Personaje objetivo) {
        if (flechas > 0) {
            int dano = 12 + nivel * 4;
            System.out.println(this.nombre + " (Arquero) dispara flecha. Daño: " + dano + " | Flechas restantes: " + (flechas - 1));
            objetivo.recibirDano(dano);
            flechas--;
        } else {
            System.out.println(this.nombre + " (Arquero) ¡Sin flechas! No puede atacar.");
        }
    }
    
    @Override
    public String getTipoPersonaje() {
        return "Arquero";
    }
    
    // Método propio
    public void recargarFlechas(int cantidad) {
        flechas += cantidad;
        System.out.println(this.nombre + " recarga flechas. Flechas actuales: " + flechas);
    }
}
