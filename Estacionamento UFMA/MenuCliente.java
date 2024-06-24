import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MenuCliente extends JFrame implements ActionListener{
    private JLabel msgEmail = new JLabel("Insira seu email:");
    private JLabel msgNumero = new JLabel("Insira seu número:");
    private JTextField emailField = new JTextField(20);
    private JTextField numeroField = new JTextField(20);
    private JButton okButton = new JButton("OK!");
    public MenuCliente() {
        super("Menu Cliente");
        SpringLayout layout = new SpringLayout();
        this.setLayout(layout);
        add(msgEmail);
        add(emailField);
        add(msgNumero);
        add(numeroField);
        add(okButton);
        okButton.addActionListener(this);
        /*
        layout.putConstraint(SpringLayout.WEST,msgEmail,5,SpringLayout.WEST,this);
        layout.putConstraint(SpringLayout.EAST,email,5,SpringLayout.EAST,this);
        */

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

    }
}
