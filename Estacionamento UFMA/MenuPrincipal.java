import javax.swing.*;
import javax.swing.event.*;
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
        teste = new JPanel();
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
    }
    @Override
    public void actionPerformed(ActionEvent event){
        if(event.getSource() == cliente) {
            MenuCliente app = new MenuCliente();
            app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            app.setSize(600, 600);
            app.setVisible(true);
        }
        else if(event.getSource() == convidado){
            JOptionPane.showConfirmDialog(this, "CONVIDADO", "TESTE2", JOptionPane.YES_OPTION);
        }
        else if(event.getSource() == gerente){
            JOptionPane.showConfirmDialog(this, "GERENTE", "TESTE2", JOptionPane.YES_OPTION);

        }
    }
}
