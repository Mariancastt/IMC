import javax.swing.*;

public class IMC extends JFrame {
    private JLabel pesoLabel, estaturaLabel, resultadoLabel;
    private JTextField pesoTextField, estaturaTextField;
    private JButton calcularButton;

    public IMC() {
        super("Calculadora de IMC");

        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        pesoLabel = new JLabel("PESO (kg):");
        pesoLabel.setBounds(20, 20, 100, 20);
        add(pesoLabel);

        pesoTextField = new JTextField();
        pesoTextField.setBounds(120, 20, 150, 20);
        add(pesoTextField);

        estaturaLabel = new JLabel("ALTURA (m):");
        estaturaLabel.setBounds(20, 50, 100, 20);
        add(estaturaLabel);

        estaturaTextField = new JTextField();
        estaturaTextField.setBounds(120, 50, 150, 20);
        add(estaturaTextField);

        calcularButton = new JButton("Calcular");
        calcularButton.setBounds(100, 80, 100, 30);
        calcularButton.addActionListener(e -> calcularIMC());
        add(calcularButton);

        resultadoLabel = new JLabel("");
        resultadoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultadoLabel.setVerticalAlignment(SwingConstants.CENTER);
    }

    private void mostrarResultado(String mensaje) {
        resultadoLabel.setText(mensaje);
        JOptionPane.showMessageDialog(this, resultadoLabel, "Resultados", JOptionPane.PLAIN_MESSAGE);
    }

    private void calcularIMC() {
        try {
            double peso = Double.parseDouble(pesoTextField.getText());
            double estatura = Double.parseDouble(estaturaTextField.getText());

            double imc = peso / (estatura * estatura);
            String resultado;

            if (imc < 16.00) {
                resultado = "Infrapeso: Delgadez severa";
            } else if (imc >= 16.00 && imc <= 16.99) {
                resultado = "Infrapeso: Delgadez moderada";
            } else if (imc >= 17.00 && imc <= 18.49) {
                resultado = "Infrapeso: Delgadez aceptable";
            } else if (imc >= 18.50 && imc <= 24.99) {
                resultado = "Peso normal";
            } else if (imc >= 25.00 && imc <= 29.99) {
                resultado = "Sobrepeso";
            } else if (imc >= 30.00 && imc <= 34.99) {
                resultado = "Obeso: Tipo 1";
            } else if (imc >= 35.00 && imc <= 40.00) {
                resultado = "Obeso: Tipo 2";
            } else {
                resultado = "Obeso: Tipo 3";
            }

            mostrarResultado("Tu IMC es de: " + String.format("%.2f", imc) + "\n    Atendiendo al IMC, tienes: " + resultado);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese valores numéricos válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            IMC ventana = new IMC();
            ventana.setVisible(true);
        });
    }
}