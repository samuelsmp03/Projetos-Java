import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MenuErro extends JFrame {
    private static JLabel error = new JLabel("");
    private static JDialog janelaErro;
    private static JButton entendiButton;

    public static void show(JFrame app,String mensagem){
        error.setText(mensagem);
        janelaErro = new JDialog(app, "Erro", true);
        entendiButton = new JButton("Entendi.");
        janelaErro.setLayout(new BorderLayout());
        janelaErro.add(error,BorderLayout.NORTH);
        janelaErro.add(entendiButton,BorderLayout.CENTER);
        janelaErro.setSize(500,100);
        janelaErro.setLocationRelativeTo(app);
        janelaErro.setVisible(true);
    }
}
