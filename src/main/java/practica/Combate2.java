package practica;

import practica.Carta.Posicion;

public class Combate2 {
    private Combate2()
 {
 }
 public static String combatir(Carta atacante, Carta defensor)
 {
 String s = atacante.getNombre() + " (" + atacante.getAtaque() + "/"
+ atacante.getDefensa() + "/Posición:" + atacante.getPosicion() + ") vs " +
defensor.getNombre() + " (" + defensor.getAtaque() + "/" +
defensor.getDefensa() + "/Posición:" + defensor.getPosicion() + ") -> ";
 
 int valorDefensor = defensor.getAtaque();
 if(defensor.getPosicion()== Posicion.DEFENSA)
 {
 valorDefensor = defensor.getDefensa();
 }
 if (atacante.getAtaque() >= valorDefensor)
 {
 return s + "Gana " + atacante.getNombre() +". Defensor pierde "
+ (atacante.getAtaque() - valorDefensor) + " puntos. " +
defensor.getNombre() + " destruido/a";
 }
 String s2 = "Gana " + defensor.getNombre() +". Atacante pierde " +
(valorDefensor - atacante.getAtaque()) + " puntos. " + atacante.getNombre()
+ " destruido/a";
 return s+s2;
 }

    
}
