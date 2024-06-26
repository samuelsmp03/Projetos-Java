import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuRelatorios extends JFrame implements ActionListener {
    private JButton dia = new JButton("Relatório Dia Receita");
    private JButton historico = new JButton("Histórico");
    private JButton atual = new JButton("Relatório Atual");
    private JButton relatorioClientes = new JButton("Relatório Clientes");
    private JPanel panel = new JPanel(new GridLayout(0, 1));
    private JPanel diaPanel = new JPanel(new GridLayout(0, 1));
    private JPanel historicoPanel = new JPanel(new GridLayout(0, 1));
    private JPanel atualPanel = new JPanel(new GridLayout(0, 1));
    private JPanel clientesPanel = new JPanel(new GridLayout(0, 1));
    private JLabel msgDia;
    private JLabel msgHistorico;
    private JLabel msgAtual;
    private JLabel msgClientes;
    private Carro carro;
    private Caminhao caminhao;
    private Moto moto;

    public MenuRelatorios() {
        super("Menu Relatórios");
        this.setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        panel.add(dia);
        panel.add(historico);
        panel.add(atual);
        panel.add(relatorioClientes);
        dia.addActionListener(this);
        historico.addActionListener(this);
        atual.addActionListener(this);
        relatorioClientes.addActionListener(this);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == dia) {
            diaPanel.removeAll(); // Limpa o painel antes de adicionar novos componentes
            msgDia = new JLabel("Receita: " + Sistema.getReceita());
            diaPanel.add(msgDia);
            JOptionPane.showMessageDialog(null, diaPanel, "Receita diária", JOptionPane.PLAIN_MESSAGE);
        } else if (event.getSource() == historico) {
            historicoPanel.removeAll(); // Limpa o painel antes de adicionar novos componentes
            for (Vagas vaga : Sistema.getVagas()) {
                if (vaga.getVeiculo() instanceof Carro) {
                    carro = (Carro) vaga.getVeiculo();
                    msgHistorico = new JLabel("Carro:  " + carro.getModelo() + "  " + carro.getCor() + "  " + vaga.getStatus() + " minutos: " + carro.getMinutos());
                } else if (vaga.getVeiculo() instanceof Caminhao) {
                    caminhao = (Caminhao) vaga.getVeiculo();
                    msgHistorico = new JLabel("Caminhão:  " + caminhao.getComprimento() + "  " + caminhao.getCargaMax() + "  " + vaga.getStatus() + " minutos: " + caminhao.getMinutos());
                } else if (vaga.getVeiculo() instanceof Moto) {
                    moto = (Moto) vaga.getVeiculo();
                    msgHistorico = new JLabel("Moto:  " + moto.getCilindradas() + "  " + moto.getMarca() + "  " + vaga.getStatus() + " minutos: " + moto.getMinutos());
                }
                historicoPanel.add(msgHistorico);
            }
            JOptionPane.showMessageDialog(null, historicoPanel, "Histórico", JOptionPane.PLAIN_MESSAGE);
        } else if (event.getSource() == atual) {
            atualPanel.removeAll(); // Limpa o painel antes de adicionar novos componentes
            for (Vagas vaga : Sistema.getVagas()) {
                if (vaga.getStatus() != 0 && vaga.getStatus() != 1) {
                    if (vaga.getVeiculo() instanceof Carro) {
                        carro = (Carro) vaga.getVeiculo();
                        msgAtual = new JLabel("Carro:  " + carro.getModelo() + "  " + carro.getCor() + "  " + vaga.getStatus() + " minutos: " + carro.getMinutos());
                    } else if (vaga.getVeiculo() instanceof Caminhao) {
                        caminhao = (Caminhao) vaga.getVeiculo();
                        msgAtual = new JLabel("Caminhão:  " + caminhao.getComprimento() + "  " + caminhao.getCargaMax() + "  " + vaga.getStatus() + " minutos: " + caminhao.getMinutos());
                    } else if (vaga.getVeiculo() instanceof Moto) {
                        moto = (Moto) vaga.getVeiculo();
                        msgAtual = new JLabel("Moto:  " + moto.getCilindradas() + "  " + moto.getMarca() + "  " + vaga.getStatus() + " minutos: " + moto.getMinutos());
                    }
                    atualPanel.add(msgAtual);
                }
            }
            JOptionPane.showMessageDialog(null, atualPanel, "Relatório Atual", JOptionPane.PLAIN_MESSAGE);
        } else if (event.getSource() == relatorioClientes) {
            clientesPanel.removeAll(); // Limpa o painel antes de adicionar novos componentes
            for (Cliente cliente : Sistema.getClientes()) {
                msgClientes = new JLabel("Cliente: " + cliente.getEmail() + "  " + cliente.getCelular() + "  " + cliente.getVeiculos().size());
                clientesPanel.add(msgClientes);
            }
            JOptionPane.showMessageDialog(null, clientesPanel, "Relatório Clientes", JOptionPane.PLAIN_MESSAGE);
        }
    }
}