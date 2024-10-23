import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class TelaCarrinho extends JFrame {
    private ArrayList<String> carrinho;
    private ArrayList<Double> precosCarrinho;
    private JTextArea areaCarrinho;

    public TelaCarrinho(ArrayList<String> carrinho, ArrayList<Double> precosCarrinho) {
        this.carrinho = carrinho;
        this.precosCarrinho = precosCarrinho;

        setTitle("Carrinho de Compras");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Centralizar a interface
        setLocationRelativeTo(null);

        JLabel label = new JLabel("Itens no seu carrinho:");
        label.setBounds(10, 10, 200, 20);
        add(label);

        // Área de texto para exibir o conteúdo do carrinho
        areaCarrinho = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(areaCarrinho);
        scrollPane.setBounds(10, 40, 360, 150);
        areaCarrinho.setEditable(false);
        add(scrollPane);

        // Exibir itens do carrinho
        atualizarCarrinho();

        // Botão para limpar o carrinho
        JButton btnLimpar = new JButton("Limpar Carrinho");
        btnLimpar.setBounds(10, 210, 150, 20);
        add(btnLimpar);

        btnLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limparCarrinho();
            }
        });

        // Botão para finalizar a compra
        JButton btnFinalizar = new JButton("Finalizar Compra");
        btnFinalizar.setBounds(220, 210, 150, 50);
        add(btnFinalizar);

        btnFinalizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                finalizarCompra();
            }
        });

        // Botão para voltar para a tela de produtos
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(10, 250, 150, 20);
        add(btnVoltar);


        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaBemVindo telaBemVindo = new TelaBemVindo();
                telaBemVindo.setVisible(true);
                dispose();  // Fecha a tela de carrinho
            }
        });
    }

    // Método para atualizar os itens exibidos no carrinho
    private void atualizarCarrinho() {
        areaCarrinho.setText("");  // Limpa a área antes de exibir
        if (carrinho.isEmpty()) {
            areaCarrinho.append("O carrinho está vazio.\n");
        } else {
            double total = 0;
            for (int i = 0; i < carrinho.size(); i++) {
                areaCarrinho.append(carrinho.get(i) + " - R$ " + precosCarrinho.get(i) + "\n");
                total += precosCarrinho.get(i);
            }
            areaCarrinho.append("\nTotal: R$ " + total);
        }
    }

    // Método para limpar o carrinho
    private void limparCarrinho() {
        carrinho.clear();
        precosCarrinho.clear();
        atualizarCarrinho();
        JOptionPane.showMessageDialog(this, "Carrinho limpo.");
    }

    // Método para finalizar a compra
    private void finalizarCompra() {
        if (carrinho.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Seu carrinho está vazio. Não é possível finalizar a compra.");
        } else {
            double total = 0;
            for (double preco : precosCarrinho) {
                total += preco;
            }
            // Exibe apenas a mensagem de compra finalizada
            JOptionPane.showMessageDialog(this, "Compra finalizada! Total: R$ " + total);
            
            // Limpa o carrinho sem exibir a mensagem "Carrinho limpo"
            carrinho.clear();
            precosCarrinho.clear();
            atualizarCarrinho();  // Atualiza a interface sem mostrar mensagem
        }
    }


    public static void main(String[] args) {
        ArrayList<String> carrinho = new ArrayList<>();
        ArrayList<Double> precosCarrinho = new ArrayList<>();
        TelaCarrinho telaCarrinho = new TelaCarrinho(carrinho, precosCarrinho);
        telaCarrinho.setVisible(true);
    }
}
