package com.gameshop;

/**
 * Clase que gestiona el inventario de juegos en un almacén.
 * Permite mostrar el stock actual y verificar si es necesario reabastecer.
 * @author Diego Fernández Arenas
 * @version 1.0
 */
public class GestorInventario {
    /**
     * Constante que define el stock mínimo permitido antes de generar una alerta.
     */
    public static final int STOCK_MINIMO = 5;

    /**
     * Muestra el stock actual de los juegos en el almacén.
     *
     * @param nombre   Un array con los nombres de los juegos.
     * @param cantidad Un array con las cantidades disponibles de cada juego.
     */
    public void mostrarStock(String[] nombre, int[] cantidad) {
        int totalJuegos = 0;

        totalJuegos = getJuegos(nombre, cantidad, totalJuegos);

        System.out.println("Total de juegos en el almacén: " + totalJuegos);
    }

    /**
     * Calcula el total de juegos en el almacén y verifica si algún juego tiene
     * un stock por debajo del mínimo permitido.
     * @param nombre      Un array con los nombres de los juegos.
     * @param cantidad    Un array con las cantidades disponibles de cada juego.
     * @param totalJuegos El total acumulado de juegos.
     * @return El total de juegos en el almacén.
     */
    private static int getJuegos(String[] nombre, int[] cantidad, int totalJuegos) {
        for (int i = 0; i < nombre.length; i++) {

            System.out.println("Revisando stock de: " + nombre[i]);

            if (cantidad[i] <= STOCK_MINIMO) {
                System.out.println("¡ALERTA! Pedir más copias de " + nombre[i]);
            }

            totalJuegos = totalJuegos + cantidad[i];
        }
        return totalJuegos;
    }
}
