import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuGerente extends JFrame implements ActionListener {
    private JButton cadastrar = new JButton("Cadastrar Cliente");
    private JButton remover = new JButton("Remover Cliente");
    private JButton relatorio = new JButton("Gerar Relatórios");

    private JFrame app;
    public MenuGerente(){
        super("Menu Gerente");
        this.setSize(600,600);
        SpringLayout layout = new SpringLayout();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(layout);

        cadastrar.addActionListener(this);
        remover.addActionListener(this);
        relatorio.addActionListener(this);
        add(cadastrar);
        add(remover);
        add(relatorio);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER,cadastrar,0,SpringLayout.HORIZONTAL_CENTER,getContentPane());
        layout.putConstraint(SpringLayout.NORTH,cadastrar,100,SpringLayout.NORTH,getContentPane());

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER,remover,0,SpringLayout.HORIZONTAL_CENTER,getContentPane());
        layout.putConstraint(SpringLayout.NORTH,remover,20,SpringLayout.SOUTH,cadastrar);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER,relatorio,0,SpringLayout.HORIZONTAL_CENTER,getContentPane());
        layout.putConstraint(SpringLayout.NORTH,relatorio,20,SpringLayout.SOUTH,remover);

        setLocationRelativeTo(null);
    }
    @Override
    public void actionPerformed(ActionEvent event){
        if(event.getSource() == cadastrar){
            MenuCadastrarCliente app = new MenuCadastrarCliente();
            app.setVisible(true);
        }
        else if(event.getSource() == remover){
            MenuRemoverCliente app = new MenuRemoverCliente();
            app.setVisible(true);
        }
        else if(event.getSource() == relatorio){
            MenuRelatorios app = new MenuRelatorios();
            app.setVisible(true);
        }

    }
}
