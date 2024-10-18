package labprogra2herencia;

import java.util.ArrayList;

public class Tigo {

    private ArrayList<Plan> planes;

    public Tigo() {
        this.planes = new ArrayList<>();
    }

    public void agregarPlan(String numeroTel, String nombre, String extra, String tipo) {
        if (!busquedaPorNumero(numeroTel)) {
            if (tipo.equalsIgnoreCase("IPHONE")) {
                PlanIPhone nuevoPlan = new PlanIPhone(numeroTel, nombre, extra);
                planes.add(nuevoPlan);
            } else if (tipo.equalsIgnoreCase("SAMSUNG")) {
                PlanSamsung nuevoPlan = new PlanSamsung(numeroTel, nombre, extra);
                planes.add(nuevoPlan);
            }
        }
    }

    public boolean busquedaPorNumero(String numeroTel) {
        for (Plan plan : planes) {
            if (plan.getNumeroTel().equals(numeroTel)) {
                return true;
            }
        }
        return false;
    }

    public Plan obtenerPlanPorNumero(String numeroTel) {
        for (Plan plan : planes) {
            if (plan.getNumeroTel().equals(numeroTel)) {
                return plan;
            }
        }
        return null;
    }

    public double pagoPlan(int numeroTel, int mins, int msgs) {
        for (Plan plan : planes) {
            if (plan.getNumeroTel().equals(String.valueOf(numeroTel))) {
                return plan.pagoMensual(mins, msgs);
            }
        }
        return 0.0;
    }

    public void agregarAmigo(int numeroTel, String pin) {
        for (Plan plan : planes) {
            if (plan.getNumeroTel().equals(String.valueOf(numeroTel)) && plan instanceof PlanSamsung) {
                ((PlanSamsung) plan).agregarPinAmigo(pin);
            }
        }
    }

    public ArrayList<Plan> getPlanes() {
        return planes;
    }
}