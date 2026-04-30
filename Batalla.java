package rpgmanager.model;

import java.util.ArrayList;

public class Batalla {
    
    public static void main(String[] args) {
        // Crear 3 héroes
        ArrayList<Personaje> heroes = new ArrayList<>();
        heroes.add(new Guerrero("Thorin", 3));
        heroes.add(new Mago("Gandalf", 5));
        heroes.add(new Arquero("Legolas", 4));
        
        // Crear 1 enemigo
        Personaje orco = new Guerrero("Orco", 1);
        
        System.out.println("=== INICIA LA BATALLA ===\n");
        System.out.println("Héroes:");
        for (Personaje h : heroes) {
            System.out.println("  " + h);
        }
        System.out.println("Enemigo:");
        System.out.println("  " + orco);
        System.out.println();
        
        // Bucle de batalla
        int turno = 1;
        
        while (orco.estaVivo()) {
            System.out.println("--- Turno " + turno + " ---");
            
            for (Personaje h : heroes) {
                if (orco.estaVivo()) {
                    h.atacar(orco);
                }
            }
            
            turno++;
        }
        
        // Resultado final
        System.out.println("\n=== BATALLA TERMINADA ===");
        System.out.println("Duración: " + (turno - 1) + " turnos\n");
        System.out.println("Estado final:");
        for (Personaje h : heroes) {
            System.out.println("  " + h);
        }
        System.out.println("  " + orco);
    }
}