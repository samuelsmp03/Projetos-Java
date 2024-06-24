import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuCliente extends JFrame implements ActionListener {
    public MenuCliente() {
        super("Menu Cliente");
        this.setSize(600, 600);
        SpringLayout layout = new SpringLayout();
        this.setLayout(layout);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent event){

    }
}
