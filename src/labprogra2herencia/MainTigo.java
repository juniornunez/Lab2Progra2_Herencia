
package labprogra2herencia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainTigo {

    private static Tigo tigo = new Tigo();

    public static void main(String[] args) {
        mostrarMenu();
    }

    private static void mostrarMenu() {
        JFrame frame = new JFrame("Tigo Plan Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.insets = new Insets(10, 10, 10, 10);

        JButton agregarPlanButton = new JButton("Agregar Plan");
        JButton pagoPlanButton = new JButton("Pago Plan");
        JButton agregarAmigoButton = new JButton("Agregar Amigo");
        JButton listarButton = new JButton("Listar");
        JButton salirButton = new JButton("Salir");

        frame.add(agregarPlanButton, gbc);
        frame.add(pagoPlanButton, gbc);
        frame.add(agregarAmigoButton, gbc);
        frame.add(listarButton, gbc);
        frame.add(salirButton, gbc);

        agregarPlanButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarPlan();
            }
        });

        pagoPlanButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pagoPlan();
            }
        });

        agregarAmigoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarAmigo();
            }
        });

        listarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listarPlanes();
            }
        });

        salirButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frame.setVisible(true);
    }

    private static void agregarPlan() {
        String[] tipos = {"IPHONE", "SAMSUNG"};
        String tipo = (String) JOptionPane.showInputDialog(null, "Seleccione el tipo de plan:", 
                "Tipo de Plan", JOptionPane.QUESTION_MESSAGE, null, tipos, tipos[0]);

        if (tipo == null) return;

        String numeroTel = getInput("Ingrese el numero de telefono:");
        if (numeroTel == null) return;

        if (tigo.busquedaPorNumero(numeroTel)) {
            JOptionPane.showMessageDialog(null, "El numero de telefono ya esta registrado. No se puede agregar el plan.");
            return;
        }

        String nombre = getInput("Ingrese el nombre del cliente:");
        if (nombre == null) return;

        String extra;
        if (tipo.equalsIgnoreCase("IPHONE")) {
            extra = getInput("Ingrese el correo electronico para iPhone:");
            if (extra == null) return;
        } else {
            extra = getInput("Ingrese el PIN para Samsung:");
            if (extra == null) return;
        }

        tigo.agregarPlan(numeroTel, nombre, extra, tipo);
        JOptionPane.showMessageDialog(null, "Plan " + tipo + " agregado exitosamente.");
    }

    private static void pagoPlan() {
        String numeroTel = getInput("Ingrese el numero de telefono:");
        if (numeroTel == null) return;

        if (!tigo.busquedaPorNumero(numeroTel)) {
            JOptionPane.showMessageDialog(null, "El numero de telefono no esta registrado. No se puede proceder con el pago.");
            return;
        }

        String minsInput = getInput("Ingrese los minutos consumidos:");
        if (minsInput == null) return;
        int mins = Integer.parseInt(minsInput);

        String msgsInput = getInput("Ingrese los mensajes enviados:");
        if (msgsInput == null) return;
        int msgs = Integer.parseInt(msgsInput);

        double pago = tigo.pagoPlan(Integer.parseInt(numeroTel), mins, msgs);
        JOptionPane.showMessageDialog(null, "Pago mensual: " + pago);
    }

    private static void agregarAmigo() {
        String numeroTel = getInput("Ingrese el numero de telefono (solo para planes Samsung):");
        if (numeroTel == null) return;

        Plan plan = tigo.obtenerPlanPorNumero(numeroTel);
        if (plan == null || !(plan instanceof PlanSamsung)) {
            JOptionPane.showMessageDialog(null, "El numero de telefono no esta registrado o no pertenece a un plan Samsung.");
            return;
        }

        String pinAmigo = getInput("Ingrese el PIN del amigo:");
        if (pinAmigo == null || pinAmigo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se ha ingresado un PIN valido.");
            return;
        }

        tigo.agregarAmigo(Integer.parseInt(numeroTel), pinAmigo);
        JOptionPane.showMessageDialog(null, "Amigo agregado exitosamente al plan Samsung.");
    }

    private static void listarPlanes() {
        if (tigo.getPlanes().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay planes agregados.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Plan plan : tigo.getPlanes()) {
                sb.append(plan.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString(), "Lista de Planes", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static String getInput(String message) {
        return JOptionPane.showInputDialog(null, message);
    }
}
