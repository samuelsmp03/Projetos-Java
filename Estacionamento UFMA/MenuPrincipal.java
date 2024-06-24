import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuPrincipal extends JFrame implements ActionListener {

    private JLabel mensagem;
    private JButton convidado;
    private JButton cliente;
    private JButton gerente;
    private JPanel teste;
    private Dimension buttonSize = new Dimension(220,80);

    public MenuPrincipal(){
        super("Estacionamento UFMA");
        this.setSize(800,600);

        mensagem = new JLabel("Bem-vindo ao estacionamento UFMA! Selecione a forma de login");
        convidado = new JButton("Convidado");
        cliente = new JButton("Cliente");
        gerente = new JButton("Gerente");


        convidado.addActionListener(this);
        cliente.addActionListener(this);
        gerente.addActionListener(this);
        convidado.setPreferredSize(buttonSize);
        cliente.setPreferredSize(buttonSize);
        gerente.setPreferredSize(buttonSize);

        add(convidado,BorderLayout.WEST);
        add(cliente,BorderLayout.CENTER);
        add(gerente,BorderLayout.EAST);
        add(mensagem,BorderLayout.NORTH);
        setLocationRelativeTo(null);
    }
    @Override
    public void actionPerformed(ActionEvent event){
        if(event.getSource() == cliente) {
            MenuLoginCliente app = new MenuLoginCliente();
            app.setVisible(true);
        }
        else if(event.getSource() == convidado){
            JOptionPane.showConfirmDialog(this, "CONVIDADO", "Erro", JOptionPane.YES_OPTION);
        }
        else if(event.getSource() == gerente){
            MenuLoginGerente app = new MenuLoginGerente();
            app.setVisible(true);
        }
    }
}
