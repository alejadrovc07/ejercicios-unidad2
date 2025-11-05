package org.example;

import java.util.Scanner;

class CajeroAutomatico {
    static void main() {
        Scanner sc = new Scanner(System.in);
        double saldo = 1000.0;
        int transacciones = 0;
        boolean salir = false;

        System.out.println("=== Bienvenido al Cajero Automático ===");

        while (!salir) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Salir");
            System.out.print("Opción: ");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Saldo actual: $" + saldo);
                    break;

                case 2:
                    System.out.print("Ingrese cantidad a depositar: $");
                    double deposito = sc.nextDouble();
                    if (deposito > 0) {
                        saldo += deposito;
                        transacciones++;
                        System.out.println("Depósito exitoso. Nuevo saldo: $" + saldo);
                    } else {
                        System.out.println("Cantidad inválida. Intente nuevamente.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese cantidad a retirar: $");
                    double retiro = sc.nextDouble();
                    if (retiro > 0 && retiro <= saldo) {
                        saldo -= retiro;
                        transacciones++;
                        System.out.println("Retiro exitoso. Nuevo saldo: $" + saldo);
                    } else if (retiro > saldo) {
                        System.out.println("Fondos insuficientes.");
                    } else {
                        System.out.println("Cantidad inválida. Intente nuevamente.");
                    }
                    break;

                case 4:
                    salir = true;
                    System.out.println("\n=== Resumen de sesión ===");
                    System.out.println("Transacciones realizadas: " + transacciones);
                    System.out.println("Saldo final: $" + saldo);
                    System.out.println("Gracias por usar el cajero.");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }

        sc.close();
    }
}
