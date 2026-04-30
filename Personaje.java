package rpgmanager.model;

public abstract class Personaje {
    // Atributos protegidos
    protected String nombre;
    protected int nivel;
    protected int puntosVida;
    protected int puntosVidaMax;
    
    // Constructor
    public Personaje(String nombre, int nivel, int puntosVidaMax) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.puntosVidaMax = puntosVidaMax;
        this.puntosVida = puntosVidaMax;  // Comienza con vida al máximo
    }
    
    // Método concreto: recibir daño
    public void recibirDano(int dano) {
        this.puntosVida -= dano;
        if (this.puntosVida < 0) {
            this.puntosVida = 0;  // No puede bajar de 0
        }
        System.out.println(this.nombre + " recibe " + dano + " de daño. HP: " 
                          + this.puntosVida + "/" + this.puntosVidaMax);
    }
    
    // Método concreto: verificar si está vivo
    public boolean estaVivo() {
        return this.puntosVida > 0;
    }
    
    // Métodos abstractos (las subclases DEBEN implementarlos)
    public abstract void atacar(Personaje objetivo);
    
    public abstract String getTipoPersonaje();
    
    // Método toString
    @Override
    public String toString() {
        return "[" + getTipoPersonaje() + "] " + nombre + " Nv." + nivel 
               + " | HP: " + puntosVida + "/" + puntosVidaMax;
    }
}
