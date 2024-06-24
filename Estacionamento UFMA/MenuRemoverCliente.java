import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuRemoverCliente extends JFrame implements ActionListener {
    public MenuRemoverCliente() {
        super("Remover Cliente");
        this.setSize(600, 600);
        SpringLayout layout = new SpringLayout();
        this.setLayout(layout);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent event){

    }
}
