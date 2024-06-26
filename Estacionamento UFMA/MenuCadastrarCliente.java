import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import static java.lang.Long.parseLong;

public class MenuCadastrarCliente extends JFrame implements ActionListener {
    private JLabel msgEmail = new JLabel("Email:");
    private JLabel msgNumero = new JLabel("Número:");
    private JLabel msgVeiculo = new JLabel("Quantidade de Veículos:");
    private JTextField emailField = new JTextField(20);
    private JTextField numeroField = new JTextField(20);
    private JTextField veiculoField = new JTextField(20);
    private JButton okButton = new JButton("OK!");
    private long numero;
    private String email;
    private int count;
    private Cliente cliente;
    private JFrame app;
    private ArrayList<Veiculo> veiculos = new ArrayList<>();

    public MenuCadastrarCliente() {
        super("Cadastro Cliente");
        this.setSize(600, 300);
        SpringLayout layout = new SpringLayout();
        this.setLayout(layout);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        add(msgEmail);
        add(msgNumero);
        add(msgVeiculo);
        add(emailField);
        add(numeroField);
        add(veiculoField);
        add(okButton);
        okButton.addActionListener(this);

        layout.putConstraint(SpringLayout.WEST, msgEmail, 5, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, msgEmail, 5, SpringLayout.NORTH, getContentPane());

        layout.putConstraint(SpringLayout.WEST, emailField, 5, SpringLayout.EAST, msgEmail);
        layout.putConstraint(SpringLayout.NORTH, emailField, 5, SpringLayout.NORTH, getContentPane());

        layout.putConstraint(SpringLayout.WEST, msgNumero, 5, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, msgNumero, 20, SpringLayout.SOUTH, msgEmail);

        layout.putConstraint(SpringLayout.WEST, numeroField, 5, SpringLayout.EAST, msgNumero);
        layout.putConstraint(SpringLayout.NORTH, numeroField, 20, SpringLayout.SOUTH, emailField);

        layout.putConstraint(SpringLayout.WEST, msgVeiculo, 5, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, msgVeiculo, 20, SpringLayout.SOUTH, msgNumero);

        layout.putConstraint(SpringLayout.WEST, veiculoField, 5, SpringLayout.EAST, msgVeiculo);
        layout.putConstraint(SpringLayout.NORTH, veiculoField, 20, SpringLayout.SOUTH, numeroField);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, okButton, 0, SpringLayout.HORIZONTAL_CENTER, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, okButton, 20, SpringLayout.SOUTH, veiculoField);

        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            numero = parseLong(numeroField.getText());
            email = emailField.getText();
            count = Integer.parseInt(veiculoField.getText());
            cliente = new Cliente(numero,email);
            if (count > 0) {
                MenuCadastrarVeiculo app = new MenuCadastrarVeiculo(count,cliente);
                app.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "O cliente precisa ter algum veículo", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(this, "Ocorreu um erro: " + exception.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}