package rpgmanager.model;

import rpgmanager.interfaces.Equipable;

public class Arquero extends Personaje implements Equipable {
    private int flechas;
    private int alcance;
    private String itemEquipado = "Arco basico";
    
    public Arquero(String nombre, int nivel) {
        super(nombre, nivel, 75 + nivel * 7);
        this.flechas = 10 + nivel * 2;
        this.alcance = 30;
    }
    
    @Override
    public void atacar(Personaje objetivo) {
        if (flechas > 0) {
            int dano = 12 + nivel * 4;
            // Si tiene un arco mejorado, +5 de daño
            if (!itemEquipado.equals("Arco basico")) {
                dano += 5;
                System.out.println(this.nombre + " (Arquero) dispara flecha con " + itemEquipado + ". Daño: " + dano + " (+5 bonus) | Flechas restantes: " + (flechas - 1));
            } else {
                System.out.println(this.nombre + " (Arquero) dispara flecha. Daño: " + dano + " | Flechas restantes: " + (flechas - 1));
            }
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
    
    public void recargarFlechas(int cantidad) {
        flechas += cantidad;
        System.out.println(this.nombre + " recarga flechas. Flechas actuales: " + flechas);
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
