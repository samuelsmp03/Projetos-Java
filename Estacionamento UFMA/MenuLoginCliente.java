import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MenuLoginCliente extends JFrame implements ActionListener{
    private JLabel msgEmail = new JLabel("Insira seu email:");
    private JLabel msgNumero = new JLabel("Insira seu número:");
    private JTextField emailField = new JTextField(20);
    private JTextField numeroField = new JTextField(20);
    private JButton okButton = new JButton("OK!");
    private JLabel error;
    public MenuLoginCliente() {
        super("Menu Cliente");
        SpringLayout layout = new SpringLayout();
        this.setLayout(layout);
        add(msgEmail);
        add(emailField);
        add(msgNumero);
        add(numeroField);
        add(okButton);
        okButton.addActionListener(this);
        error = new JLabel("");
        error.setText("Verifique seu email e número! Conta não encontrada");


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
    public void erroMenu(){
        JDialog janelaErro = new JDialog(this, "Erro", true);
        janelaErro.setLayout(new FlowLayout());
        janelaErro.add(error);
        janelaErro.setSize(500,100);
        janelaErro.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event){
        try {
            String email = emailField.getText();
            long numero = Integer.parseInt(numeroField.getText());
            Cliente cliente = Sistema.procuraCliente(email,numero);
            if(cliente != null){
                MenuCliente app = new MenuCliente();
                app.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                app.setSize(600, 600);
                app.setVisible(true);
                this.setVisible(false);
            }else{
                erroMenu();
            }
        }catch(Exception exception){
            erroMenu();
        }
    }
}
