import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuPrincipal extends JFrame implements ActionListener {

    private JLabel mensagem = new JLabel("Bem-vindo ao estacionamento UFMA! Selecione a forma de login", SwingConstants.CENTER);
    private JButton convidado = new JButton("Convidado");
    private JButton cliente = new JButton("Cliente");
    private JButton gerente = new JButton("Gerente");
    private JPanel teste;
    private JFrame app;
    private GridLayout layout = new GridLayout(0,1);

    public MenuPrincipal(){
        super("Estacionamento UFMA");
        this.setSize(800,600);
        this.setLayout(layout);
        convidado.addActionListener(this);
        cliente.addActionListener(this);
        gerente.addActionListener(this);
        add(mensagem);
        add(convidado);
        add(cliente);
        add(gerente);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent event){
        if(event.getSource() == cliente) {
            app = new MenuLoginCliente();
            app.setVisible(true);
        }
        else if(event.getSource() == convidado){
            app = new MenuCadastrarVeiculo(1,null);
            app.setVisible(true);
        }
        else if(event.getSource() == gerente){
            app = new MenuLoginGerente();
            app.setVisible(true);
        }
    }
}
