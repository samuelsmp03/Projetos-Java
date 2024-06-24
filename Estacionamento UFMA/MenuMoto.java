import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuMoto extends JFrame implements ActionListener {
    private JLabel msgCilindradas = new JLabel("Cilindradas:");
    private JLabel msgMarca = new JLabel("Marca:");
    private JTextField cilindradasField = new JTextField(10);
    private JTextField marcaField = new JTextField(10);
    private JButton okButton = new JButton("OK!");
    private String marca;
    private int cilindradas;
    private Moto veiculo;
    private Cliente cliente;
    private JFrame app;
    private int count;

    public MenuMoto(int count, Cliente cliente) {
        super("Cadastro Moto");
        this.cliente = cliente;
        this.count = count;
        this.setSize(400, 400);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        SpringLayout layout = new SpringLayout();
        this.setLayout(layout);

        add(msgCilindradas);
        add(msgMarca);
        add(cilindradasField);
        add(marcaField);
        add(okButton);
        okButton.addActionListener(this);

        layout.putConstraint(SpringLayout.WEST, msgCilindradas, 5, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, msgCilindradas, 20, SpringLayout.NORTH, getContentPane());

        layout.putConstraint(SpringLayout.WEST, cilindradasField, 5, SpringLayout.EAST, msgCilindradas);
        layout.putConstraint(SpringLayout.NORTH, cilindradasField, 20, SpringLayout.NORTH, getContentPane());

        layout.putConstraint(SpringLayout.WEST, msgMarca, 5, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, msgMarca, 20, SpringLayout.SOUTH, msgCilindradas);

        layout.putConstraint(SpringLayout.WEST, marcaField, 5, SpringLayout.EAST, msgMarca);
        layout.putConstraint(SpringLayout.NORTH, marcaField, 20, SpringLayout.SOUTH, cilindradasField);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, okButton, 0, SpringLayout.HORIZONTAL_CENTER, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, okButton, 20, SpringLayout.SOUTH, marcaField);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            cilindradas = Integer.parseInt(cilindradasField.getText());
            marca = marcaField.getText();
            veiculo = new Moto(0, 2, "livre", marca, cilindradas);

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
                JOptionPane.showMessageDialog(this, "Veículo alugado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }

            this.dispose();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Tipo de dado incorreto! Por favor, insira números válidos.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(this, "Ocorreu um erro: " + exception.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}