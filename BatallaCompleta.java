package rpgmanager.model;
 
import rpgmanager.model.Personaje;
import rpgmanager.model.Guerrero;
import rpgmanager.model.Mago;
import rpgmanager.model.Arquero;
import rpgmanager.interfaces.Equipable;
import rpgmanager.interfaces.Habilidoso;
import rpgmanager.interfaces.Sanador;
import java.util.ArrayList;
 
public class BatallaCompleta extends Personaje {
 
    public BatallaCompleta(String nombre, int nivel, int puntosVidaMax) {
        super(nombre, nivel, puntosVidaMax);
    }
 
    @Override
    public void atacar(Personaje objetivo) {}
 
    @Override
    public String getTipoPersonaje() { return ""; }
 
    public static void main(String[] args) {
        ArrayList<Personaje> heroes = new ArrayList<>();
        heroes.add(new Guerrero("Thorin", 3));
        heroes.add(new Mago("Gandalf", 5));
        heroes.add(new Arquero("Legolas", 4));
 
        Personaje orco = new Guerrero("Orco", 1);
 
        System.out.println("=== FASE 1: EQUIPAR ===\n");
 
        for (Personaje h : heroes) {
            if (h instanceof Equipable) {
                if (h instanceof Guerrero) {
                    ((Equipable) h).equiparItem("Espada Legendaria");
                } else if (h instanceof Arquero) {
                    ((Equipable) h).equiparItem("Arco Elfico");
                }
            }
        }
 
        System.out.println("\n=== FASE 2: BATALLA POR TURNOS ===\n");
        System.out.println("Heroes:");
        for (Personaje h : heroes) {
            System.out.println("  " + h);
        }
        System.out.println("Enemigo:");
        System.out.println("  " + orco);
        System.out.println();
 
        int turno = 1;
 
        while (orco.estaVivo()) {
            System.out.println("--- Turno " + turno + " ---");
 
            if (turno == 2) {
                System.out.println(">> Habilidades especiales activadas!\n");
                for (Personaje h : heroes) {
                    if (h instanceof Habilidoso) {
                        ((Habilidoso) h).usarHabilidadEspecial(orco);
                    }
                }
            } else {
                for (Personaje h : heroes) {
                    if (orco.estaVivo()) {
                        h.atacar(orco);
                    }
                }
            }
 
            turno++;
        }
 
        System.out.println("\n=== BATALLA TERMINADA ===\n");
        System.out.println("=== FASE 3: SANACION POST-BATALLA ===\n");
 
        Personaje heroeConMenosVida = heroes.get(0);
        for (Personaje h : heroes) {
            if (h.puntosVida < heroeConMenosVida.puntosVida) {
                heroeConMenosVida = h;
            }
        }
 
        for (Personaje h : heroes) {
            if (h instanceof Sanador) {
                ((Sanador) h).sanar(heroeConMenosVida);
            }
        }
 
        System.out.println("\n=== ESTADO FINAL ===\n");
        for (Personaje h : heroes) {
            System.out.println("  " + h);
        }
        System.out.println("  " + orco);
    }
}