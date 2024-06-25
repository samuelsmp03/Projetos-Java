import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MenuCliente extends JFrame implements ActionListener {
    private JLabel msg;
    private JButton reservar = new JButton("Reservar Vaga");
    private JButton novoVeiculo = new JButton("Adicionar Veículo");
    private JButton listarVeiculos = new JButton("Listar Veículos");
    private JPanel panel;
    private JFrame app;
    private Cliente cliente;
    public MenuCliente(Cliente cliente) {
        super("Menu Cliente");
        this.cliente = cliente;
        msg = new JLabel("Bem-vindo, "+cliente.getEmail(), SwingConstants.CENTER);
        this.setSize(600, 600);
        GridLayout layout = new GridLayout(0,1);
        panel = new JPanel(layout);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panel.add(msg,BorderLayout.NORTH);
        panel.add(reservar);
        panel.add(novoVeiculo);
        panel.add(listarVeiculos);
        reservar.addActionListener(this);
        novoVeiculo.addActionListener(this);
        listarVeiculos.addActionListener(this);
        add(panel);
        System.out.println(cliente.getVeiculos().size());
    }
    @Override
    public void actionPerformed(ActionEvent event){
        if(event.getSource() == reservar){
            app = new MenuReservar(cliente);
            app.setVisible(true);
        }else if(event.getSource() == novoVeiculo){

        }else if(event.getSource() == listarVeiculos){

        }
    }
}
