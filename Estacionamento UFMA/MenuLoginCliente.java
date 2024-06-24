import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Long.parseLong;


public class MenuLoginCliente extends JFrame implements ActionListener{
    private JLabel msgEmail = new JLabel("Insira seu email:");
    private JLabel msgNumero = new JLabel("Insira seu número:");
    private JTextField emailField = new JTextField(20);
    private JTextField numeroField = new JTextField(20);
    private JButton okButton = new JButton("OK!");
    private long numero;
    private String email;
    private Cliente cliente;
    private JFrame app;
    public MenuLoginCliente() {
        super("Login Cliente");
        this.setSize(400, 170);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        SpringLayout layout = new SpringLayout();
        this.setLayout(layout);
        add(msgEmail);
        add(emailField);
        add(msgNumero);
        add(numeroField);
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

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, okButton, 0, SpringLayout.HORIZONTAL_CENTER, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, okButton, 20, SpringLayout.SOUTH, numeroField);
    }

    @Override
    public void actionPerformed(ActionEvent event){
        try {
            email = emailField.getText();
            numero = parseLong(numeroField.getText());
            cliente = Sistema.procuraCliente(email,numero);
            if(cliente != null){
                MenuCliente app = new MenuCliente();
            }else{
                JOptionPane.showMessageDialog(this,"Conta não encontrada" , "Erro", JOptionPane.ERROR_MESSAGE);            }
        }catch(Exception exception){
            JOptionPane.showMessageDialog(this, "Tipo de dado incorreto!!!", "Erro", JOptionPane.ERROR_MESSAGE);        }
    }
}
