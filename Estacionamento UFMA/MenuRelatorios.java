import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuRelatorios extends JFrame implements ActionListener {
    private Cliente teste;
    public MenuRelatorios() {
        super("Menu Relatórios");
        this.setSize(600, 600);
        SpringLayout layout = new SpringLayout();
        this.setLayout(layout);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        for(Cliente teste : Sistema.getClientes()){
            System.out.println(teste.getEmail() +" "+ teste.getCelular());
        }


    }
    public void actionPerformed(ActionEvent event){

    }
}
