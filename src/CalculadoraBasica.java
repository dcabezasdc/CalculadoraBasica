import javax.swing.*;
        import java.awt.*;
        import java.awt.event.*;

public class CalculadoraBasica extends JFrame implements ActionListener {
    private JTextField textFieldOperando1, textFieldOperando2;
    private JButton btnSuma, btnResta;
    private JTextArea textAreaResultado;

    public CalculadoraBasica() {
        setTitle("Calculadora Básica");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new GridLayout(4, 2));

        textFieldOperando1 = new JTextField();
        textFieldOperando2 = new JTextField();

        btnSuma = new JButton("Sumar");
        btnResta = new JButton("Restar");

        textAreaResultado = new JTextArea();
        textAreaResultado.setEditable(false);

        add(new JLabel("Operando 1:"));
        add(textFieldOperando1);
        add(new JLabel("Operando 2:"));
        add(textFieldOperando2);
        add(btnSuma);
        add(btnResta);
        add(new JLabel("Resultado:"));
        add(new JScrollPane(textAreaResultado));

        btnSuma.addActionListener(this);
        btnResta.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double operando1 = Double.parseDouble(textFieldOperando1.getText());
            double operando2 = Double.parseDouble(textFieldOperando2.getText());
            double resultado = 0;

            if (e.getSource() == btnSuma) {
                resultado = operando1 + operando2;
            } else if (e.getSource() == btnResta) {
                resultado = operando1 - operando2;
            }

            textAreaResultado.setText(String.valueOf(resultado));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, introduce valores numéricos válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CalculadoraBasica calculadora = new CalculadoraBasica();
                calculadora.setVisible(true);
            }
        });
    }
}

