package web.testCases;

import org.testng.annotations.Test;

public class test {

    enum Color {
        ROJO, VERDE, AZUL;
    }

    enum Dia {
        LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO;
    }

    @Test
    public void test1() {
        for (Color color : Color.values()) {
                System.out.println(color);
        }

        Color color1 = Color.VERDE;
        System.out.println(color1);

        Dia dia = Dia.valueOf("LUNES");
        System.out.println("Día seleccionado: " + dia);
    }
}
