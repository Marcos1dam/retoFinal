package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PagInicio extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textPassword;
    private JTextField textUsuario;
    private JButton btnRecuperarContraseña;
    private JButton btnAcceder;
    private JButton btnCancelar;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PagInicio frame = new PagInicio();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public PagInicio() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 941, 583);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout());

     // Crear un JTabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();
        contentPane.add(tabbedPane, BorderLayout.CENTER); // Añadir al centro

        // Crear el contenido de cada pestaña
        JPanel singIn = new JPanel();
        singIn.setLayout(null);
        tabbedPane.addTab("CODE AND DANCE", null, singIn, "Información de la Pestaña 1");
        
                JPanel SingIn = new JPanel();
                SingIn.setLayout(null);
                tabbedPane.addTab("Sing In", null, SingIn, "Información de la Pestaña 2");
                
                JLabel lbUsuario = new JLabel("Usuario:");
                lbUsuario.setFont(new Font("Arial Black", Font.PLAIN, 14));
                lbUsuario.setBounds(255, 191, 91, 22);
                SingIn.add(lbUsuario);
                
                JLabel lbPassword = new JLabel("Password:");
                lbPassword.setFont(new Font("Arial Black", Font.PLAIN, 14));
                lbPassword.setBounds(255, 236, 91, 22);
                SingIn.add(lbPassword);
                
                textUsuario = new JTextField();
                textUsuario.setBounds(356, 195, 232, 19);
                SingIn.add(textUsuario);
                textUsuario.setColumns(10);
                
                textPassword = new JTextField();
                textPassword.setColumns(10);
                textPassword.setBounds(356, 240, 232, 19);
                SingIn.add(textPassword);
                
                btnAcceder = new JButton("Acceder");
                btnAcceder.setFont(new Font("Arial Black", Font.PLAIN, 14));
                btnAcceder.setBounds(282, 343, 102, 21);
                SingIn.add(btnAcceder);
                
                btnCancelar = new JButton("Cancelar");
                btnCancelar.setFont(new Font("Arial Black", Font.PLAIN, 14));
                btnCancelar.setBounds(472, 343, 102, 21);
                SingIn.add(btnCancelar);
                
                btnRecuperarContraseña = new JButton("Has olvidado tu contraseña?");
                btnRecuperarContraseña.setFont(new Font("Arial Black", Font.PLAIN, 8));
                btnRecuperarContraseña.setBounds(425, 279, 163, 21);
                SingIn.add(btnRecuperarContraseña);

        JPanel panel3 = new JPanel();
        panel3.add(new JLabel("Contenido de la Pestaña 3"));
        tabbedPane.addTab("Pestaña 3", null, panel3, "Información de la Pestaña 3");
    }
}