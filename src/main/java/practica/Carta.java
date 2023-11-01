package practica;

public class Carta {
    private Posicion posicion;
    private String nombre;
    private int ataque;
    private int defensa;
    private String efecto;
    
    public enum Posicion
    {
        ATAQUE,
        DEFENSA}

    public Carta(String nombre, int ataque, int defensa, Posicion ataque2, String e)
    {
        this.ataque = ataque;
        this.nombre = nombre;
        this.defensa = defensa;
        this.posicion = ataque2;
        if (e == null)
        {
            this.efecto = "N/A";
        }
        else
        {
        if(e.equals("Inmortal") || e.equals("Toque Mortal") || e.equals("Presión"))
        {
        this.efecto = e;
        }
        else
        {
            this.efecto = "N/A";
        }
    }
    }
    public int getAtaque() {
        return ataque;
    }
    public int getDefensa() {
        return defensa;
    }
    public String getNombre() {
        return nombre;
    }
    public Posicion getPosicion() {
        return posicion;
    }

    public void verificarAtaque() throws IllegalPositionException
    {
        if(posicion != Posicion.ATAQUE)
        {
            throw new IllegalPositionException("la carta atacante no puede estar en posicion de defensa");
        }
    }

    public String getEfecto() {
        return efecto;
    }
}

