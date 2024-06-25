import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuCarro extends JFrame implements ActionListener {
    private JLabel msgCor = new JLabel("Cor:");
    private JLabel msgMarca = new JLabel("Marca:");
    private JLabel msgModelo = new JLabel("Modelo:");
    private JTextField corField = new JTextField(10);
    private JTextField marcaField = new JTextField(10);
    private JTextField modeloField = new JTextField(10);
    private JButton okButton = new JButton("OK!");
    private String cor;
    private String marca;
    private String modelo;
    private Carro veiculo;
    private Cliente cliente;
    private JFrame app;
    private int count;

    public MenuCarro(int count, Cliente cliente) {
        super("Cadastro Carro");
        this.cliente = cliente;
        this.count = count;
        this.setSize(400, 400);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        SpringLayout layout = new SpringLayout();
        this.setLayout(layout);

        add(msgCor);
        add(msgMarca);
        add(msgModelo);
        add(corField);
        add(marcaField);
        add(modeloField);
        add(okButton);
        okButton.addActionListener(this);

        layout.putConstraint(SpringLayout.WEST, msgCor, 5, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, msgCor, 20, SpringLayout.NORTH, getContentPane());

        layout.putConstraint(SpringLayout.WEST, corField, 5, SpringLayout.EAST, msgCor);
        layout.putConstraint(SpringLayout.NORTH, corField, 20, SpringLayout.NORTH, getContentPane());

        layout.putConstraint(SpringLayout.WEST, msgMarca, 5, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, msgMarca, 20, SpringLayout.SOUTH, corField);

        layout.putConstraint(SpringLayout.WEST, marcaField, 5, SpringLayout.EAST, msgMarca);
        layout.putConstraint(SpringLayout.NORTH, marcaField, 20, SpringLayout.SOUTH, corField);

        layout.putConstraint(SpringLayout.WEST, msgModelo, 5, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, msgModelo, 20, SpringLayout.SOUTH, msgMarca);

        layout.putConstraint(SpringLayout.WEST, modeloField, 5, SpringLayout.EAST, msgModelo);
        layout.putConstraint(SpringLayout.NORTH, modeloField, 20, SpringLayout.SOUTH, marcaField);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, okButton, 0, SpringLayout.HORIZONTAL_CENTER, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, okButton, 20, SpringLayout.SOUTH, modeloField);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            cor = corField.getText();
            marca = marcaField.getText();
            modelo = modeloField.getText();
            veiculo = new Carro(0, 4, "livre",cor,marca,modelo);

            if (cliente != null) {
                cliente.adicionarVeiculo(veiculo);
                count--;
                if (count > 0) {
                    app = new MenuCadastrarVeiculo(count, cliente);
                    app.setVisible(true);
                } else {
                    Sistema.adicionaCliente(cliente);
                    JOptionPane.showMessageDialog(this, "Cliente cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                veiculo.setStatus("Alugado");
            }

            this.dispose();

        } catch (Exception exception) {
            JOptionPane.showMessageDialog(this, "Ocorreu um erro: " + exception.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}