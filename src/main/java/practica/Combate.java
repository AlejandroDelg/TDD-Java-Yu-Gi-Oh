package practica;

import practica.Carta.Posicion;

public class Combate {
    private Combate() {

    }
    
    static final String GANA_STRING = "Gana ";
    static final String ES_DESTRUIDO = " destruido/a";
    static final String INMORTAL = "Inmortal";
    static final String ATAQUE = "Ataque";
    static final String PRESION = "Presión";
    static final String ATACANTE_PIERDE = ". Atacante pierde ";
    static final String PUNTOS_STRING = " puntos.";
    private static final String DEFENSOR_PIERDE = ". Defensor pierde ";
    private static final String TOQUE_MORTAL = "Toque Mortal";

    public static String combatir(Carta atacante, Carta defensor) throws IllegalPositionException {
        atacante.verificarAtaque();
        String posicionDefensor = ATAQUE;
        String posicionAtacante = ATAQUE;

        boolean puedeQuitarPuntos = true;
        int valorDefensor = defensor.getAtaque();
        if (defensor.getPosicion() == Posicion.DEFENSA) {
            valorDefensor = defensor.getDefensa();
            puedeQuitarPuntos = false;
            posicionDefensor = "Defensa";
        }
        String s = atacante.getNombre() + " (" + atacante.getAtaque() + "/" + atacante.getDefensa() + "/Posición:"
                + posicionAtacante + "/Efecto: " + atacante.getEfecto() + ") vs " + defensor.getNombre() + " ("
                + defensor.getAtaque() + "/" + defensor.getDefensa() + "/Posición:" + posicionDefensor + "/Efecto: "
                + defensor.getEfecto() + ") -> ";
        if (atacante.getAtaque() > valorDefensor) {
            return ataqueAtacanteGTvalorDefensor(atacante, defensor, puedeQuitarPuntos, valorDefensor, GANA_STRING,
                    ES_DESTRUIDO, s);
        }
        if (atacante.getAtaque() == valorDefensor) {

            return ataqueAtacanteIgualValorDefensor(atacante, defensor, ATAQUE, posicionDefensor, ES_DESTRUIDO, s);
        }
        return defensorGTAtacante(atacante, defensor, posicionDefensor, valorDefensor, s);
    }

    private static String defensorGTAtacante(Carta atacante, Carta defensor, String posicionDefensor, int valorDefensor,
            String s) 
    {
        String s2 = "";
        
        if(posicionDefensor.equals(ATAQUE))
        {
            
            if (atacante.getAtaque() <= defensor.getAtaque() && atacante.getEfecto().equals(INMORTAL)) 
            {
                    return s + GANA_STRING + defensor.getNombre() + ATACANTE_PIERDE
                            + (valorDefensor - atacante.getAtaque()) + PUNTOS_STRING ;
            }
            if(atacante.getAtaque() <= defensor.getAtaque() && atacante.getEfecto().equals(TOQUE_MORTAL))
            {
                return s + GANA_STRING + defensor.getNombre() + ATACANTE_PIERDE
                + (valorDefensor - atacante.getAtaque()) + PUNTOS_STRING+ " Ambas cartas destruidas.";   
            }
            
            s2 = GANA_STRING + defensor.getNombre() + ATACANTE_PIERDE
                    + (valorDefensor - atacante.getAtaque()) + PUNTOS_STRING + atacante.getNombre() + ES_DESTRUIDO;
        }
        else
        {
            if(atacante.getEfecto().equals(TOQUE_MORTAL))
            {
                return s + GANA_STRING + defensor.getNombre() + ATACANTE_PIERDE
                        + (valorDefensor - atacante.getAtaque()) + PUNTOS_STRING + " " + defensor.getNombre() + ES_DESTRUIDO;
            }
            if(atacante.getEfecto().equals(PRESION))
            {
                return s +  GANA_STRING + defensor.getNombre() + ATACANTE_PIERDE
                + (valorDefensor - atacante.getAtaque())/2 + PUNTOS_STRING;
            }
            else
            {
                return s +  GANA_STRING + defensor.getNombre() + ATACANTE_PIERDE
                + (valorDefensor - atacante.getAtaque()) + PUNTOS_STRING;
            }
        }
        return s + s2;
    }

    private static String ataqueAtacanteGTvalorDefensor(Carta atacante, Carta defensor, boolean puedeQuitarPuntos,
            int valorDefensor,
            String ganaString, String esDestruido, String s) 
            {
        if (puedeQuitarPuntos) 
        {
            String s2 = "";
            if (defensor.getEfecto().equals(INMORTAL))
             {
                s2 = DEFENSOR_PIERDE + (atacante.getAtaque() - valorDefensor) + PUNTOS_STRING;
            }
            else    
            {
                if(defensor.getEfecto().equals(PRESION))
                {
                    s2 = DEFENSOR_PIERDE + (atacante.getAtaque() - valorDefensor)/2 + " puntos. " + defensor.getNombre()
                    + esDestruido;
                }
                else 
                {
                        s2 = DEFENSOR_PIERDE + (atacante.getAtaque() - valorDefensor) + " puntos. " + defensor.getNombre()
                        + esDestruido;
                }
        }
            return s + ganaString + atacante.getNombre() +s2;
        }
        else 
        {
            String s2 = "";
            
            if(defensor.getEfecto().equals(TOQUE_MORTAL))
            {    
                s2 = " Ambas cartas destruidas.";
            return s + ganaString + atacante.getNombre() + "." + s2;
            }
            if(!defensor.getEfecto().equals(INMORTAL))
            {
                s2 =" "+ defensor.getNombre() + esDestruido;
            }
            
            return s + ganaString + atacante.getNombre() + "." + s2;
        }
    }

    private static String ataqueAtacanteIgualValorDefensor(Carta atacante, Carta defensor, String stringAtaque,
            String posicionDefensor,
            String esDestruido, String s) 
    {
        if(atacante.getEfecto().equals(TOQUE_MORTAL) && defensor.getEfecto().equals(TOQUE_MORTAL))
        {
            return s + "Empate. Ambas cartas destruidas.";
        }
        if (posicionDefensor.equals(stringAtaque)) {
            if (atacante.getEfecto().equals(INMORTAL)) {
                return s + "Empate. " + defensor.getNombre() + esDestruido;
            }
            return s + "Empate. Ambas cartas destruidas.";
        } else {
            return s + "Empate.";
        }
    }

}
