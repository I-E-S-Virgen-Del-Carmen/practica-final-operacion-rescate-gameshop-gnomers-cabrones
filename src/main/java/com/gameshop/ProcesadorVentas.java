package com.gameshop;

public class ProcesadorVentas {
    private static final double PORCENTAJE_DESCUENTO_VIP = 0.15;
    private static final double FACTOR_IVA = 1.21;
    // VULNERABILIDAD SONARLINT: Contraseña en texto plano
    private String dbClave = "admin_super_secreto_123";

    public double c(double precioBase, boolean esVIP) {

        // 1️⃣ Aplicar descuento si es VIP
        double precioConDescuento = precioBase;
        if (esVIP) {
            double montoDescuento = precioBase * PORCENTAJE_DESCUENTO_VIP;
            precioConDescuento = precioBase - montoDescuento; // 🐛 BUG FIX: Restar, no sumar
        }

        // 2️⃣ Aplicar IVA al precio ya descontado
        double precioFinal = precioConDescuento * FACTOR_IVA;

        return precioFinal;
    }
}