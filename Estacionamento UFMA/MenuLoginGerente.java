import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuLoginGerente extends JFrame implements ActionListener {

    private JLabel msgSenha = new JLabel("Senha:");
    private JTextField senhaField = new JTextField(20);
    private JButton okButton = new JButton("OK!");
    private JFrame app;

    public MenuLoginGerente() {
        super("Login Gerente");
        this.setSize(300, 150);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        SpringLayout layout = new SpringLayout();
        setLayout(layout);

        add(msgSenha);
        add(senhaField);
        add(okButton);

        okButton.addActionListener(this);

        layout.putConstraint(SpringLayout.WEST, msgSenha, 5, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, msgSenha, 5, SpringLayout.NORTH, getContentPane());

        layout.putConstraint(SpringLayout.WEST, senhaField, 5, SpringLayout.EAST, msgSenha);
        layout.putConstraint(SpringLayout.NORTH, senhaField, 5, SpringLayout.NORTH, getContentPane());

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, okButton, 0, SpringLayout.HORIZONTAL_CENTER, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, okButton, 20, SpringLayout.SOUTH, senhaField);
    }

    @Override
    public void actionPerformed(ActionEvent event){
        try {
            int teste = Integer.parseInt(senhaField.getText());
            if(Sistema.verificaSenha(teste) == true){
                this.dispose();
                MenuGerente app = new MenuGerente();
                app.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(this,"Senha incorreta" , "Erro", JOptionPane.ERROR_MESSAGE);            }
        }catch(Exception exception){
            JOptionPane.showMessageDialog(this,"Insira um inteiro" , "Erro", JOptionPane.ERROR_MESSAGE);        }
    }
}
