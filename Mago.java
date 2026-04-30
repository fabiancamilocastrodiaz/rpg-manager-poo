package rpgmanager.model;

import rpgmanager.interfaces.Habilidoso;
import rpgmanager.interfaces.Sanador;

public class Mago extends Personaje implements Habilidoso, Sanador {
    private int mana;
    private int manaMax;
    
    public Mago(String nombre, int nivel) {
        super(nombre, nivel, 60 + nivel * 5);
        this.manaMax = 80 + nivel * 10;
        this.mana = this.manaMax;
    }
    
    @Override
    public void atacar(Personaje objetivo) {
        if (mana >= 20) {
            int dano = 25 + nivel * 5;
            System.out.println(this.nombre + " (Mago) lanza hechizo. Daño: " + dano + " | Mana: -20");
            objetivo.recibirDano(dano);
            mana -= 20;
        } else {
            System.out.println(this.nombre + " (Mago) ¡Mana insuficiente! No puede atacar.");
        }
    }
    
    @Override
    public String getTipoPersonaje() {
        return "Mago";
    }
    
    public void recuperarMana(int cantidad) {
        mana += cantidad;
        if (mana > manaMax) {
            mana = manaMax;
        }
        System.out.println(this.nombre + " recupera mana. Mana actual: " + mana + "/" + manaMax);
    }
    
    // ===== INTERFACE HABILIDOSO =====
    @Override
    public void usarHabilidadEspecial(Personaje objetivo) {
        if (mana >= 20) {
            System.out.println(this.nombre + " lanza Bola de Fuego! Daño: 40 | Mana: -20");
            objetivo.recibirDano(40);
            mana -= 20;
        } else {
            System.out.println(this.nombre + " ¡Mana insuficiente para Bola de Fuego!");
        }
    }
    
    @Override
    public int getCostoHabilidad() {
        return 20;
    }
    
    @Override
    public String getNombreHabilidad() {
        return "Bola de Fuego";
    }
    
    // ===== INTERFACE SANADOR =====
    @Override
    public void sanar(Personaje objetivo) {
        System.out.println(this.nombre + " sana a " + objetivo.nombre + ". HP restaurado: 25");
        objetivo.puntosVida += 25;
        if (objetivo.puntosVida > objetivo.puntosVidaMax) {
            objetivo.puntosVida = objetivo.puntosVidaMax;
        }
    }
    
    @Override
    public int getPotenciaSanacion() {
        return 25;
    }
}