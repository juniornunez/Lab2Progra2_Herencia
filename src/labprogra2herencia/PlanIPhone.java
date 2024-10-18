/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labprogra2herencia;

/**
 *
 * @author Junior Nuñes
 */
public class PlanIPhone extends Plan {

    private String email;

    public PlanIPhone(String numeroTel, String nombre, String email) {
        super(numeroTel, nombre);
        this.email = email;
    }

    public double pagoMensual(int mins, int msgs) {
        return 22 + (0.4 * mins) + (0.1 * msgs);
    }

    public void imprimir() {
        super.imprimir();
        System.out.println("Email iTunes: " + email);
    }

    @Override
    public String toString() {
        return super.toString() + "\nEmail iTunes: " + email + "\n --------------------------------" + "\n";
    }

    public String getEmail() {
        return email;
    }
}