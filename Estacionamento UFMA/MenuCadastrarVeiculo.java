import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuCadastrarVeiculo extends JFrame implements ActionListener {
    private JButton moto = new JButton("Moto");
    private JButton carro = new JButton("Carro");
    private JButton caminhao = new JButton("Caminhão");
    private JLabel mensagem = new JLabel("Qual o seu veículo?");
    private int count;
    private JFrame app;
    private Cliente cliente;

    public MenuCadastrarVeiculo(int count,Cliente cliente) {
        super("Cadastro Veículo");
        this.cliente = cliente;
        this.count = count;
        this.setSize(400, 300);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        SpringLayout layout = new SpringLayout();
        this.setLayout(layout);

        add(mensagem);
        add(moto);
        add(carro);
        add(caminhao);

        moto.addActionListener(this);
        carro.addActionListener(this);
        caminhao.addActionListener(this);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, mensagem, 0, SpringLayout.HORIZONTAL_CENTER, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, mensagem, 20, SpringLayout.NORTH, getContentPane());

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, moto, 0, SpringLayout.HORIZONTAL_CENTER, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, moto, 20, SpringLayout.SOUTH, mensagem);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, carro, 0, SpringLayout.HORIZONTAL_CENTER, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, carro, 20, SpringLayout.SOUTH, moto);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, caminhao, 0, SpringLayout.HORIZONTAL_CENTER, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, caminhao, 20, SpringLayout.SOUTH, carro);
    }
    @Override
    public void actionPerformed(ActionEvent event){
        if(event.getSource() == carro){
            this.dispose();
            MenuCarro app = new MenuCarro(count,cliente);
            app.setVisible(true);
        }
        else if(event.getSource() == moto){
            this.dispose();
            MenuMoto app = new MenuMoto(count,cliente);
            app.setVisible(true);
        }
        else if(event.getSource() == caminhao){
            this.dispose();
            MenuCaminhao app = new MenuCaminhao(count,cliente);
            app.setVisible(true);
        }
    }
}
