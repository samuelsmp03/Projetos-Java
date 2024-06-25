import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MenuReservar extends JFrame implements ActionListener {
    private Cliente cliente;
    private ArrayList<Veiculo>veiculos;
    private JLabel msg;
    private JLabel msgVeiculo;
    private JPanel panel = new JPanel(new GridLayout(0,1));
    private int countCar = 0;
    private int countCam = 0;
    private Carro carro;
    private Caminhao caminhao;
    private JButton button;

    public MenuReservar(Cliente cliente){
        super("Menu Reservar Vaga");
        this.cliente = cliente;
        this.veiculos = cliente.getVeiculos();
        this.setSize(600,600);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        for(Veiculo veiculo: veiculos){
            if(veiculo instanceof Moto) {

            }
            else if(veiculo instanceof Carro){
                countCar++;
                carro = (Carro)veiculo;
                panel.add(new JLabel("Marca:"+carro.getMarca() +"; Cor:"+carro.getCor()+"; Modelo: "+carro.getModelo(),SwingConstants.CENTER));
                button = new JButton("Carro"+countCar);
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try{
                            if(carro.reservar(Sistema.getVagas()) == true){
                                JOptionPane.showMessageDialog(button, "Carro reservado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                            }else{
                                JOptionPane.showMessageDialog(button, "Não foi possível cadastrar esse veículo", "Erro", JOptionPane.ERROR_MESSAGE);
                            }
                        }catch(Exception exception){
                            JOptionPane.showMessageDialog(panel, "Ocorreu um erro: " + exception.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });
                panel.add(button);
            }
            else if(veiculo instanceof Caminhao){
                countCam++;
                caminhao = (Caminhao)veiculo;
                panel.add(new JLabel("Comprimento(M):"+caminhao.getComprimento() +" ;Carga Máxima(KG):"+caminhao.getCargaMax(),SwingConstants.CENTER));
                button = new JButton("Caminhão"+countCam);
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try{
                            if(caminhao.reservar(Sistema.getVagas()) == true){
                                JOptionPane.showMessageDialog(button, "Caminhão reservado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                            }else{
                                JOptionPane.showMessageDialog(button, "Não foi possível cadastrar esse veículo", "Erro", JOptionPane.ERROR_MESSAGE);
                            }
                        }catch(Exception exception){
                            JOptionPane.showMessageDialog(panel, "Ocorreu um erro: " + exception.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });
                panel.add(button);
            }
        }
        add(panel);
    }
    public void actionPerformed(ActionEvent event){

    }
}
