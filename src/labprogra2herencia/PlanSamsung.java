
package labprogra2herencia;

import java.util.ArrayList;

public class PlanSamsung extends Plan {

    private String pin;
    private ArrayList<String> bbm;

    public PlanSamsung(String numeroTel, String nombre, String pin) {
        super(numeroTel, nombre);
        this.pin = pin;
        this.bbm = new ArrayList<>();
    }

    public double pagoMensual(int mins, int msgs) {
        double baseFee = 40;
        int freeMinutes = 200;
        int freeMsgs = 300;
        double extraMinuteCost = 0.8;
        double extraMsgCost = 0.2;

        double extraMinutes = Math.max(0, mins - freeMinutes);
        double extraMsgs = Math.max(0, msgs - freeMsgs);

        return baseFee + (extraMinutes * extraMinuteCost) + (extraMsgs * extraMsgCost);
    }

    public void imprimir() {
        super.imprimir();
        System.out.println("PIN: " + pin);
    }

    public String toString() {
        return super.toString() + "\nPIN: " + pin + "\n --------------------------------" + "\n";
    }

    public void agregarPinAmigo(String pin) {
        if (!bbm.contains(pin)) {
            bbm.add(pin);
        }
    }

    public String getPin() {
        return pin;
    }
}