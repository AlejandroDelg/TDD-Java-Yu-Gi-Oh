import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import practica.*;
import practica.Carta.Posicion;




class Tests {

    @Test
    void test1() throws IllegalPositionException
    {
        Carta drgBlanco = new Carta("Carta 1", 2000, 2850, Posicion.ATAQUE,null);
        Carta magoOscuro = new Carta("Carta 2", 1500, 1500, Posicion.ATAQUE,null);
        assertNotEquals(null, drgBlanco);
        assertNotEquals(null, magoOscuro);
        String resultado=Combate.combatir(drgBlanco, magoOscuro); //arg1: atacante, arg2: defensor
        assertNotEquals(null, resultado);
        System.out.println(resultado);
        String expetcedSolution = "Carta 1 (2000/2850/Posición:Ataque/Efecto: N/A) vs Carta 2 (1500/1500/Posición:Ataque/Efecto: N/A) -> Gana Carta 1. Defensor pierde 500 puntos. Carta 2 destruido/a";
        assertEquals(expetcedSolution, resultado);
        
    }
    
    @Test
    void test2() throws IllegalPositionException
    {
        Carta carta1 = new Carta("Carta 1", 1200, 1000, Posicion.ATAQUE,null);
        Carta carta2 = new Carta("Carta 2", 1500, 1500, Posicion.ATAQUE,null);
        assertNotEquals(null, carta1);
        assertNotEquals(null, carta2);
        String resultado=Combate.combatir(carta1, carta2); //arg1: atacante, arg2: defensor
        assertNotEquals(null, resultado);
        System.out.println(resultado);
        String expetcedSolution = "Carta 1 (1200/1000/Posición:Ataque/Efecto: N/A) vs Carta 2 (1500/1500/Posición:Ataque/Efecto: N/A) -> Gana Carta 2. Atacante pierde 300 puntos.Carta 1 destruido/a";
        assertEquals(expetcedSolution, resultado);
        
    }
    @Test
    void test3() throws IllegalPositionException
    {
        Carta carta1 = new Carta("Carta 1", 2000, 0, Posicion.ATAQUE,null);
        Carta carta2 = new Carta("Carta 2", 2000, 1500, Posicion.ATAQUE,null);
        assertNotEquals(null, carta1);
        assertNotEquals(null, carta2);
        String resultado=Combate.combatir(carta1, carta2); //arg1: atacante, arg2: defensor
        assertNotEquals(null, resultado);
        System.out.println(resultado);
        String expetcedSolution = "Carta 1 (2000/0/Posición:Ataque/Efecto: N/A) vs Carta 2 (2000/1500/Posición:Ataque/Efecto: N/A) -> Empate. Ambas cartas destruidas.";
        assertEquals(expetcedSolution, resultado);
        
    }

    @Test
    void test4() throws IllegalPositionException
    {
        Carta carta1 = new Carta("Carta 1", 1501, 2850, Posicion.ATAQUE,null);
        Carta carta2 = new Carta("Carta 2", 2000, 1500, Posicion.DEFENSA,null);
        assertNotEquals(null, carta1);
        assertNotEquals(null, carta2);
        String resultado=Combate.combatir(carta1, carta2); //arg1: atacante, arg2: defensor
        assertNotEquals(null, resultado);
        System.out.println(resultado);
        String expetcedSolution = "Carta 1 (1501/2850/Posición:Ataque/Efecto: N/A) vs Carta 2 (2000/1500/Posición:Defensa/Efecto: N/A) -> Gana Carta 1. Carta 2 destruido/a";
        assertEquals(expetcedSolution, resultado);
        
    }
    @Test
    void test5() throws IllegalPositionException
    {
        Carta carta1 = new Carta("Carta 1", 2000, 2850, Posicion.ATAQUE,null);
        Carta carta2 = new Carta("Carta 2", 0, 3000, Posicion.DEFENSA,null);
        assertNotEquals(null, carta1);
        assertNotEquals(null, carta2);
        String resultado=Combate.combatir(carta1, carta2); //arg1: atacante, arg2: defensor
        assertNotEquals(null, resultado);
        System.out.println(resultado);
        String expetcedSolution = "Carta 1 (2000/2850/Posición:Ataque/Efecto: N/A) vs Carta 2 (0/3000/Posición:Defensa/Efecto: N/A) -> Gana Carta 2. Atacante pierde 1000 puntos.";
        assertEquals(expetcedSolution, resultado);
        
    }
    
    @Test
    void test6() throws IllegalPositionException
    {
        Carta carta1 = new Carta("Carta 1", 1500, 2850, Posicion.ATAQUE,null);
        Carta carta2 = new Carta("Carta 2", 2000, 1500, Posicion.DEFENSA,null);
        assertNotEquals(null, carta1);
        assertNotEquals(null, carta2);
        String resultado=Combate.combatir(carta1, carta2); //arg1: atacante, arg2: defensor
        assertNotEquals(null, resultado);
        System.out.println(resultado);
        String expetcedSolution = "Carta 1 (1500/2850/Posición:Ataque/Efecto: N/A) vs Carta 2 (2000/1500/Posición:Defensa/Efecto: N/A) -> Empate.";
        assertEquals(expetcedSolution, resultado);
    }

    
    @Test
    void test7()
    {
        Carta carta1 = new Carta("Carta 1", 1500, 2850, Posicion.DEFENSA, null);
        Carta carta2 = new Carta("Carta 2", 2000, 1500, Posicion.DEFENSA, null);
        assertNotEquals(null, carta1);
        assertNotEquals(null, carta2);
        IllegalPositionException ex = assertThrows(IllegalPositionException.class, () -> Combate.combatir(carta1, carta2), "la carta atacante no puede estar en posicion de defensa");
        
        assertEquals("la carta atacante no puede estar en posicion de defensa", ex.getMessage());
    }
    @Test
    void test8() throws IllegalPositionException
    {
        Carta carta1 = new Carta("Carta 1", 2000, 2850, Posicion.ATAQUE, "Inmortal");
        Carta carta2 = new Carta("Carta 2", 2000, 1500, Posicion.ATAQUE, null);
        assertNotEquals(null, carta1);
        assertNotEquals(null, carta2);
        String resultado=Combate.combatir(carta1, carta2); //arg1: atacante, arg2: defensor
        assertNotEquals(null, resultado);
        System.out.println(resultado);
        String expetcedSolution = "Carta 1 (2000/2850/Posición:Ataque/Efecto: Inmortal) vs Carta 2 (2000/1500/Posición:Ataque/Efecto: N/A) -> Empate. Carta 2 destruido/a";
        assertEquals(expetcedSolution, resultado);
    }
    @Test
    void test9() throws IllegalPositionException
    {
        Carta carta1 = new Carta("Carta 1", 1800, 2850, Posicion.ATAQUE, "Inmortal");
        Carta carta2 = new Carta("Carta 2", 2000, 1500, Posicion.ATAQUE, null);
        assertNotEquals(null, carta1);
        assertNotEquals(null, carta2);
        String resultado=Combate.combatir(carta1, carta2); //arg1: atacante, arg2: defensor
        assertNotEquals(null, resultado);
        System.out.println(resultado);
        String expetcedSolution = "Carta 1 (1800/2850/Posición:Ataque/Efecto: Inmortal) vs Carta 2 (2000/1500/Posición:Ataque/Efecto: N/A) -> Gana Carta 2. Atacante pierde 200 puntos.";
        assertEquals(expetcedSolution, resultado);
    }
    
    @Test
    void test10() throws IllegalPositionException
    {
        Carta carta1 = new Carta("Carta 1", 2100, 2850, Posicion.ATAQUE, null);
        Carta carta2 = new Carta("Carta 2", 2000, 1500, Posicion.ATAQUE, "Inmortal");
        assertNotEquals(null, carta1);
        assertNotEquals(null, carta2);
        String resultado=Combate.combatir(carta1, carta2); //arg1: atacante, arg2: defensor
        assertNotEquals(null, resultado);
        System.out.println(resultado);
        String expetcedSolution = "Carta 1 (2100/2850/Posición:Ataque/Efecto: N/A) vs Carta 2 (2000/1500/Posición:Ataque/Efecto: Inmortal) -> Gana Carta 1. Defensor pierde 100 puntos.";
        assertEquals(expetcedSolution, resultado);
    }
    @Test
    void test11() throws IllegalPositionException
    {
        Carta carta1 = new Carta("Carta 1", 1800, 2850, Posicion.ATAQUE, null);
        Carta carta2 = new Carta("Carta 2", 2000, 1500, Posicion.DEFENSA, "Inmortal");
        assertNotEquals(null, carta1);
        assertNotEquals(null, carta2);
        String resultado=Combate.combatir(carta1, carta2); //arg1: atacante, arg2: defensor
        assertNotEquals(null, resultado);
        System.out.println(resultado);
        String expetcedSolution = "Carta 1 (1800/2850/Posición:Ataque/Efecto: N/A) vs Carta 2 (2000/1500/Posición:Defensa/Efecto: Inmortal) -> Gana Carta 1.";
        assertEquals(expetcedSolution, resultado);
    }
    @Test
    void test12() throws IllegalPositionException
    {
        Carta carta1 = new Carta("Carta 1", 1000, 2850, Posicion.ATAQUE, "Toque Mortal");
        Carta carta2 = new Carta("Carta 2", 2000, 1500, Posicion.DEFENSA, null);
        assertNotEquals(null, carta1);
        assertNotEquals(null, carta2);
        String resultado=Combate.combatir(carta1, carta2); //arg1: atacante, arg2: defensor
        assertNotEquals(null, resultado);
        System.out.println(resultado);
        String expetcedSolution = "Carta 1 (1000/2850/Posición:Ataque/Efecto: Toque Mortal) vs Carta 2 (2000/1500/Posición:Defensa/Efecto: N/A) -> Gana Carta 2. Atacante pierde 500 puntos. Carta 2 destruido/a";
        assertEquals(expetcedSolution, resultado);
    }
    @Test
    void test13() throws IllegalPositionException
    {
        Carta carta1 = new Carta("Carta 1", 2000, 1000, Posicion.ATAQUE,null );
        Carta carta2 = new Carta("Carta 2", 2000, 1500, Posicion.DEFENSA, "Toque Mortal");
        assertNotEquals(null, carta1);
        assertNotEquals(null, carta2);
        String resultado=Combate.combatir(carta1, carta2); //arg1: atacante, arg2: defensor
        assertNotEquals(null, resultado);
        System.out.println(resultado);
        String expetcedSolution = "Carta 1 (2000/1000/Posición:Ataque/Efecto: N/A) vs Carta 2 (2000/1500/Posición:Defensa/Efecto: Toque Mortal) -> Gana Carta 1. Ambas cartas destruidas.";
        assertEquals(expetcedSolution, resultado);
    }
    @Test
    void test14() throws IllegalPositionException
    {
        Carta carta1 = new Carta("Carta 1", 1000, 1000, Posicion.ATAQUE,"Toque Mortal" );
        Carta carta2 = new Carta("Carta 2", 0, 1000, Posicion.DEFENSA, "Toque Mortal");
        assertNotEquals(null, carta1);
        assertNotEquals(null, carta2);
        String resultado=Combate.combatir(carta1, carta2); //arg1: atacante, arg2: defensor
        assertNotEquals(null, resultado);
        System.out.println(resultado);
        String expetcedSolution = "Carta 1 (1000/1000/Posición:Ataque/Efecto: Toque Mortal) vs Carta 2 (0/1000/Posición:Defensa/Efecto: Toque Mortal) -> Empate. Ambas cartas destruidas.";
        assertEquals(expetcedSolution, resultado);
    }
    
    @Test
    void test15() throws IllegalPositionException
    {
        Carta carta1 = new Carta("Carta 1", 1500, 1000, Posicion.ATAQUE,"Toque Mortal" );
        Carta carta2 = new Carta("Carta 2", 2000, 1500, Posicion.ATAQUE, null);
        assertNotEquals(null, carta1);
        assertNotEquals(null, carta2);
        String resultado=Combate.combatir(carta1, carta2); //arg1: atacante, arg2: defensor
        assertNotEquals(null, resultado);
        System.out.println(resultado);
        String expetcedSolution = "Carta 1 (1500/1000/Posición:Ataque/Efecto: Toque Mortal) vs Carta 2 (2000/1500/Posición:Ataque/Efecto: N/A) -> Gana Carta 2. Atacante pierde 500 puntos. Ambas cartas destruidas.";
        assertEquals(expetcedSolution, resultado);
    }

    
    @Test
    void test16() throws IllegalPositionException
    {
        Carta carta1 = new Carta("Carta 1", 1000, 0, Posicion.ATAQUE,"Presión" );
        Carta carta2 = new Carta("Carta 2", 0, 3000, Posicion.DEFENSA, null);
        assertNotEquals(null, carta1);
        assertNotEquals(null, carta2);
        String resultado=Combate.combatir(carta1, carta2); //arg1: atacante, arg2: defensor
        assertNotEquals(null, resultado);
        System.out.println(resultado);
        String expetcedSolution = "Carta 1 (1000/0/Posición:Ataque/Efecto: Presión) vs Carta 2 (0/3000/Posición:Defensa/Efecto: N/A) -> Gana Carta 2. Atacante pierde 1000 puntos.";
        assertEquals(expetcedSolution, resultado);
    }
    
    
    @Test
    void test17() throws IllegalPositionException
    {
        Carta carta1 = new Carta("Carta 1", 2000, 0, Posicion.ATAQUE,null );
        Carta carta2 = new Carta("Carta 2", 1500, 0, Posicion.ATAQUE, "Presión");
        assertNotEquals(null, carta1);
        assertNotEquals(null, carta2);
        String resultado=Combate.combatir(carta1, carta2); //arg1: atacante, arg2: defensor
        assertNotEquals(null, resultado);
        System.out.println(resultado);
        String expetcedSolution = "Carta 1 (2000/0/Posición:Ataque/Efecto: N/A) vs Carta 2 (1500/0/Posición:Ataque/Efecto: Presión) -> Gana Carta 1. Defensor pierde 250 puntos. Carta 2 destruido/a";
        assertEquals(expetcedSolution, resultado);
    }
    
    
}
