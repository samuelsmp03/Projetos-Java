import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MenuCliente extends JFrame implements ActionListener {
    private JLabel msg;
    private JButton reservar = new JButton("Reservar Vaga");
    private JButton novoVeiculo = new JButton("Adicionar Veículo");
    private JButton listarVeiculos = new JButton("Listar Veículos");
    private JButton estacionar = new JButton("Estacionar");
    private JPanel panel;
    private JFrame app;
    private Cliente cliente;
    private ArrayList<Veiculo>veiculos;

    private JPanel veiculosPanel = new JPanel(new GridLayout(0,1));
    private JPanel estacionarPanel = new JPanel(new GridLayout(0,1));
    private JLabel aux;
    private Carro carro;
    private Caminhao caminhao;
    private Moto moto;
    private int countCar=0;
    private int countMot=0;
    private int countCam=0;
    private JButton button;
    public MenuCliente(Cliente cliente) {
        super("Menu Cliente");
        this.cliente = cliente;
        this.veiculos = cliente.getVeiculos();
        msg = new JLabel("Bem-vindo, "+cliente.getEmail(), SwingConstants.CENTER);
        this.setSize(600, 600);
        GridLayout layout = new GridLayout(0,1);
        panel = new JPanel(layout);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panel.add(msg,BorderLayout.NORTH);
        panel.add(reservar);
        panel.add(novoVeiculo);
        panel.add(listarVeiculos);
        panel.add(estacionar);
        reservar.addActionListener(this);
        novoVeiculo.addActionListener(this);
        listarVeiculos.addActionListener(this);
        estacionar.addActionListener(this);
        add(panel);
        //System.out.println(cliente.getVeiculos().size());
    }
    @Override
    public void actionPerformed(ActionEvent event){
        if(event.getSource() == reservar){
            app = new MenuReservar(cliente);
            app.setVisible(true);
        }else if(event.getSource() == novoVeiculo){
            app = new MenuCadastrarVeiculo(1,cliente);
            app.setVisible(true);
        }else if(event.getSource() == listarVeiculos){
            for(Veiculo veiculo: veiculos){
                if(veiculo instanceof Moto) {
                    moto = (Moto)veiculo;
                    veiculosPanel.add(new JLabel("Moto:  Cilindradas: "+moto.getCilindradas()+"  ;Marca: "+moto.getMarca(),SwingConstants.CENTER));
                }
                else if(veiculo instanceof Carro){
                    carro = (Carro)veiculo;
                    veiculosPanel.add(new JLabel("Carro:  Marca:"+carro.getMarca() +"; Cor:"+carro.getCor()+"; Modelo: "+carro.getModelo(),SwingConstants.CENTER));
                }
                else if(veiculo instanceof Caminhao){
                    caminhao = (Caminhao)veiculo;
                    veiculosPanel.add(new JLabel("Caminhão:  Comprimento(M): "+caminhao.getComprimento()+"  ;Carga Máxima(KG): "+caminhao.getCargaMax(),SwingConstants.CENTER));
                }
            }
            JOptionPane.showMessageDialog(null, veiculosPanel, "Veículos do cliente", JOptionPane.PLAIN_MESSAGE);
            veiculosPanel.removeAll();
        }
        else if(event.getSource() == estacionar){

            for(Veiculo veiculo: veiculos){
                if(veiculo instanceof Moto) {

                }
                else if(veiculo instanceof Carro){
                    countCar++;
                    carro = (Carro)veiculo;
                    estacionarPanel.add(new JLabel("Marca:"+carro.getMarca() +"; Cor:"+carro.getCor()+"; Modelo: "+carro.getModelo(),SwingConstants.CENTER));
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
                    estacionarPanel.add(button);
                }
                else if(veiculo instanceof Caminhao){
                    countCam++;
                    caminhao = (Caminhao)veiculo;
                    estacionarPanel.add(new JLabel("Comprimento(M):"+caminhao.getComprimento() +" ;Carga Máxima(KG):"+caminhao.getCargaMax(),SwingConstants.CENTER));
                    button = new JButton("Caminhão"+countCam);
                    button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try{
                                if(caminhao.estacionar(Sistema.getVagas()) == true){
                                    JOptionPane.showMessageDialog(button, "Caminhão reservado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                                }else{
                                    JOptionPane.showMessageDialog(button, "Não foi possível cadastrar esse veículo", "Erro", JOptionPane.ERROR_MESSAGE);
                                }
                            }catch(Exception exception){
                                JOptionPane.showMessageDialog(panel, "Ocorreu um erro: " + exception.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    });
                    estacionarPanel.add(button);
                }
            }
            add(estacionarPanel);
        }
        }
    }
