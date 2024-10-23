import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class TelaBemVindo extends JFrame {
    ArrayList<String> carrinho;
    ArrayList<Double> precosCarrinho;

    public TelaBemVindo() {
        carrinho = new ArrayList<>();
        precosCarrinho = new ArrayList<>();

        setTitle("Lojinha");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Centralizar a interface
        setLocationRelativeTo(null);

        JLabel label = new JLabel("Produtos disponíveis:");
        label.setBounds(50, 20, 300, 30);
        add(label);

        // Botões para os produtos
        JButton produto1 = new JButton("Produto 1 - R$ 10.50");
        produto1.setBounds(50, 60, 300, 30);
        add(produto1);

        JButton produto2 = new JButton("Produto 2 - R$ 20.00");
        produto2.setBounds(50, 100, 300, 30);
        add(produto2);

        JButton produto3 = new JButton("Produto 3 - R$ 30.00");
        produto3.setBounds(50, 140, 300, 30);
        add(produto3);

        // Ações para cada produto
        produto1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adicionarProdutoAoCarrinho("Produto 1", 10.50, "Descrição breve do Produto 1: Este é um produto excelente.");
            }
        });

        produto2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adicionarProdutoAoCarrinho("Produto 2", 20.00, "Descrição breve do Produto 2: Produto de alta qualidade.");
            }
        });

        produto3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adicionarProdutoAoCarrinho("Produto 3", 30.00, "Descrição breve do Produto 3: Melhor custo-benefício.");
            }
        });

        // Botão para visualizar o carrinho
        JButton btnCarrinho = new JButton("Visualizar Carrinho");
        btnCarrinho.setBounds(50, 220, 300, 25);
        add(btnCarrinho);

        btnCarrinho.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                visualizarCarrinho();
            }
        });
    }

    // Método para adicionar produtos ao carrinho
    private void adicionarProdutoAoCarrinho(String nomeProduto, double preco, String descricao) {
        // Mostra uma mensagem com a descrição e pergunta a quantidade
        String quantidadeStr = JOptionPane.showInputDialog(null, 
                descricao + "\n\nQuantos itens deseja adicionar ao carrinho?");
        
        if (quantidadeStr != null) {
            int quantidade = Integer.parseInt(quantidadeStr);

            if (quantidade > 0) {
                for (int i = 0; i < quantidade; i++) {
                    carrinho.add(nomeProduto);
                    precosCarrinho.add(preco);
                }
                JOptionPane.showMessageDialog(null, "Adicionado " + quantidade + " de " + nomeProduto + " ao carrinho.");
            } else {
                JOptionPane.showMessageDialog(null, "Produto não adicionado ao carrinho.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum produto foi selecionado.");
        }
    }

    // Método para visualizar o carrinho
    private void visualizarCarrinho() {
        TelaCarrinho telaCarrinho = new TelaCarrinho(carrinho, precosCarrinho);
        telaCarrinho.setVisible(true);
        this.dispose();  // Fecha a tela de bem-vindo
    }

    public static void main(String[] args) {
        TelaBemVindo telaBemVindo = new TelaBemVindo();
        telaBemVindo.setVisible(true);
    }
}
