package com.gameshop;

public class GestorInventario {

    public static final int stockMinimo = 5;

    public void MostrarStock(String[] n, int[] c) {
        int TotalJuegos = 0;

        TotalJuegos = getJuegos(n, c, TotalJuegos);
        System.out.println("Total de juegos en el almacén: " + TotalJuegos);
    }

    private static int getJuegos(String[] n, int[] c, int TotalJuegos) {

        for (int i = 0; i < n.length; i++) {
            System.out.println("Revisando stock de: " + n[i]);

            if (c[i] <= stockMinimo) {
                System.out.println("¡ALERTA! Pedir más copias de " + n[i]);
            }

            TotalJuegos = TotalJuegos + c[i];
        }
        return TotalJuegos;
    }
}