import javax.swing.*;
import java.awt.event.*;

public class TelaLogin extends JFrame {
    private JTextField campoUsuario;
    private JPasswordField campoSenha;

    public TelaLogin() {
        setTitle("Login");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Centralizar a interface
        setLocationRelativeTo(null);

        JLabel labelUsuario = new JLabel("Usuário:");
        labelUsuario.setBounds(10, 10, 80, 25);
        add(labelUsuario);

        campoUsuario = new JTextField(20);
        campoUsuario.setBounds(100, 10, 160, 25);
        add(campoUsuario);

        JLabel labelSenha = new JLabel("Senha:");
        labelSenha.setBounds(10, 40, 80, 25);
        add(labelSenha);

        campoSenha = new JPasswordField(20);
        campoSenha.setBounds(100, 40, 160, 25);
        add(campoSenha);

        JButton btnLogin = new JButton("Entrar");
        btnLogin.setBounds(100, 80, 80, 25);
        add(btnLogin);

        // Definir o botão 'Entrar' como padrão quando pressionar Enter
        getRootPane().setDefaultButton(btnLogin);

        // Ação do botão de login
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = campoUsuario.getText();
                String senha = new String(campoSenha.getPassword());

                // Verificar login (por exemplo, usuário: admin, senha: 1234)
                if (usuario.equals("admin") && senha.equals("1234")) {
                    JOptionPane.showMessageDialog(null, "Login realizado com sucesso.");
                    abrirTelaBemVindo();  // Chama a tela de bem-vindo
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos.");
                }
            }
        });

        // Listener para o campo de senha para detectar Enter pressionado
        campoSenha.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnLogin.doClick();  // Simula o clique no botão Entrar
                }
            }
        });
    }

    // Método para abrir a tela de Bem-Vindo
    private void abrirTelaBemVindo() {
        TelaBemVindo telaBemVindo = new TelaBemVindo();
        telaBemVindo.setVisible(true);
        this.dispose();  // Fecha a tela de login
    }

    public static void main(String[] args) {
        TelaLogin telaLogin = new TelaLogin();
        telaLogin.setVisible(true);
    }
}
