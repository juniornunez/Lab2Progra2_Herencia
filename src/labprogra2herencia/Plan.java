/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labprogra2herencia;

/**
 *
 * @author Junior Nuñes
 */
    public abstract class Plan {

    private String numeroTel;
    private String nombre;

    public Plan(String numeroTel, String nombre) {
        this.numeroTel = numeroTel;
        this.nombre = nombre;
    }

    public String getNumeroTel() {
        return numeroTel;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract double pagoMensual(int mins, int msgs);

    public void imprimir() {
        System.out.println("Número de Teléfono: " + numeroTel);
        System.out.println("Nombre: " + nombre);
    }

    public String toString() {
        return "Número de Teléfono: " + numeroTel + "\nNombre: " + nombre;
    }
}