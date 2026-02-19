package com.gameshop;

/**
 * Clase para procesar ventas de la tienda de juegos
 * @author Fran
 * @version 1.0
 */
public class ProcesadorVentas {

    public static final double Descuento = 0.15;
    public static final double IVA = 1.21;
    // VULNERABILIDAD SONARLINT: Contraseña en texto plano

    /**
     * Calcula el precio final con descuento VIP (15%) e IVA (21%)
     *
     * @param precio El precio base del juego
     * @param venta  true si el cliente es VIP, false si es normal
     * @return       El precio final ya con impuestos aplicados
     */
    public double c(double precio, boolean venta) {
        double d = 0;

        if (venta) {
            // CODE SMELL: Magic Number (0.15 representa el 15% de descuento)
            d = Descuento(precio);
        }

        // BUG LÓGICO: Al VIP se le está RESTANDO el descuento al precio original (CORREGIDO)
        double precioFinal = precio - d;

        // CODE SMELL: Magic Number (1.21 representa el 21% de IVA)
        precioFinal = CalculoIva(precioFinal);

        return precioFinal;
    }

    private static double CalculoIva(double precioFinal) {
        return precioFinal * IVA;
    }

    private static double Descuento(double precio) {
        double d;
        d = precio * Descuento;
        return d;
    }
}