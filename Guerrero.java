package rpgmanager.model;

import rpgmanager.interfaces.Habilidoso;
import rpgmanager.interfaces.Equipable;

public class Guerrero extends Personaje implements Habilidoso, Equipable {
    private int fuerza;
    private int defensa;
    private String itemEquipado = "Sin equipo";
    private int costoHabilidad = 30;
    
    public Guerrero(String nombre, int nivel) {
        super(nombre, nivel, 100 + nivel * 10);
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
    
    public void usarEscudo() {
        System.out.println(this.nombre + " bloquea con defensa " + defensa + "!");
    }
    
    // ===== INTERFACE HABILIDOSO =====
    @Override
    public void usarHabilidadEspecial(Personaje objetivo) {
        System.out.println(this.nombre + " usa Golpe Devastador! Daño: 50");
        objetivo.recibirDano(50);
    }
    
    @Override
    public int getCostoHabilidad() {
        return costoHabilidad;
    }
    
    @Override
    public String getNombreHabilidad() {
        return "Golpe Devastador";
    }
    
    // ===== INTERFACE EQUIPABLE =====
    @Override
    public void equiparItem(String item) {
        this.itemEquipado = item;
        System.out.println(this.nombre + " equipa " + item + "!");
    }
    
    @Override
    public String getItemEquipado() {
        return itemEquipado;
    }
}