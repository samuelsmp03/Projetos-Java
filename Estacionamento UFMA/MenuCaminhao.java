import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuCaminhao extends JFrame implements ActionListener {
    private JLabel msgComprimento = new JLabel("Comprimento (M):");
    private JLabel msgCarga = new JLabel("Carga máxima (KG):");
    private JTextField comprimentoField = new JTextField(10);
    private JTextField cargaField = new JTextField(10);
    private JButton okButton = new JButton("OK!");
    private int count;
    private float comprimento;
    private int carga;
    private Caminhao veiculo;
    private Cliente cliente = null;
    private JFrame app;
    public MenuCaminhao(int count, Cliente cliente) {
        super("Cadastro Caminhão");
        this.cliente = cliente;
        this.count = count;
        this.setSize(400, 400);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        SpringLayout layout = new SpringLayout();
        this.setLayout(layout);

        add(msgComprimento);
        add(msgCarga);
        add(comprimentoField);
        add(cargaField);
        add(okButton);
        okButton.addActionListener(this);

        layout.putConstraint(SpringLayout.WEST, msgComprimento, 5, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, msgComprimento, 20, SpringLayout.NORTH, getContentPane());

        layout.putConstraint(SpringLayout.WEST, comprimentoField, 5, SpringLayout.EAST, msgComprimento);
        layout.putConstraint(SpringLayout.NORTH, comprimentoField, 20, SpringLayout.NORTH, getContentPane());

        layout.putConstraint(SpringLayout.WEST, msgCarga, 5, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, msgCarga, 20, SpringLayout.SOUTH, msgComprimento);

        layout.putConstraint(SpringLayout.WEST, cargaField, 5, SpringLayout.EAST, msgCarga);
        layout.putConstraint(SpringLayout.NORTH, cargaField, 20, SpringLayout.SOUTH, comprimentoField);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, okButton, 0, SpringLayout.HORIZONTAL_CENTER, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, okButton, 20, SpringLayout.SOUTH, cargaField);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            carga = Integer.parseInt(cargaField.getText());
            comprimento = Float.parseFloat(comprimentoField.getText());
            veiculo = new Caminhao(0, 3, "livre", carga, comprimento);

            if(cliente != null) {
                count--;
                cliente.adicionarVeiculo(veiculo);
                if (count > 0) {
                    app = new MenuCadastrarVeiculo(count, cliente);
                    app.setVisible(true);
                } else {
                    Sistema.adicionaCliente(cliente);
                    JOptionPane.showMessageDialog(this, "Cliente cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                }
            }else{
                veiculo.setStatus("Alugado");
            }
            this.dispose();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Tipo de dado incorreto! Por favor, insira números válidos.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(this, "Ocorreu um erro: " + exception.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }
}
