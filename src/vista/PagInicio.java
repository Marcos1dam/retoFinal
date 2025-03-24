package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;

import controlador.Principal;
import modelo.Bailarin;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class PagInicio extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textUsuario;
    private JButton btnRecuperarContraseña;
    private JButton btnAcceder;
    private JButton btnCancelar;
    private JPasswordField passwordField;
    private JPanel Password;
    private JTabbedPane tabbedPane; // Declaración de tabbedPane como variable de instancia

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
    	SwingUtilities.invokeLater(() -> new PagInicio().setVisible(true));
    }

    /**
     * Create the frame.
     */
    public PagInicio() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 941, 583);
        
        // 🔹 Desactivar el fondo del TabbedPane en UIManager
        UIManager.put("TabbedPane.contentOpaque", false);

        // 🔹 Panel con imagen de fondo
        contentPane = new JPanel() {
            private Image backgroundImage = new ImageIcon(getClass().getResource("/imagenes/fondoCode.png")).getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        contentPane.setLayout(new BorderLayout());
        setContentPane(contentPane);

        tabbedPane = new JTabbedPane();
        tabbedPane.setOpaque(false);
        tabbedPane.setBackground(new Color(0, 0, 0, 0));

        JPanel singIn = new JPanel();
        singIn.setOpaque(false);
        singIn.setLayout(new FlowLayout());
        tabbedPane.addTab("CODE AND DANCE", null, singIn, "Información de la Pestaña 1");

        Password = new JPanel();
        Password.setLayout(null);
        tabbedPane.addTab("Sing In", null, Password, "Información de la Pestaña 2");
        tabbedPane.setBackgroundAt(1, UIManager.getColor("Button.light"));

        JLabel lbUsuario = new JLabel("Usuario:");
        lbUsuario.setFont(new Font("Arial Black", Font.PLAIN, 14));
        lbUsuario.setBounds(255, 191, 91, 22);
        Password.add(lbUsuario);

        JLabel lbPassword = new JLabel("Password:");
        lbPassword.setFont(new Font("Arial Black", Font.PLAIN, 14));
        lbPassword.setBounds(255, 236, 91, 22);
        Password.add(lbPassword);

        textUsuario = new JTextField();
        textUsuario.setBounds(356, 195, 232, 19);
        Password.add(textUsuario);
        textUsuario.setColumns(10);

        btnAcceder = new JButton("Acceder");
        btnAcceder.addActionListener(this);
        btnAcceder.setFont(new Font("Arial Black", Font.PLAIN, 14));
        btnAcceder.setBounds(282, 343, 102, 21);
        Password.add(btnAcceder);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(this);
        btnCancelar.setFont(new Font("Arial Black", Font.PLAIN, 14));
        btnCancelar.setBounds(472, 343, 116, 21);
        Password.add(btnCancelar);

        btnRecuperarContraseña = new JButton("Has olvidado tu contraseña?");
        btnRecuperarContraseña.setFont(new Font("Arial Black", Font.PLAIN, 8));
        btnRecuperarContraseña.setBounds(425, 279, 163, 21);
        Password.add(btnRecuperarContraseña);

        passwordField = new JPasswordField();
        passwordField.setBounds(356, 240, 232, 19);
        Password.add(passwordField);

        contentPane.add(tabbedPane, BorderLayout.CENTER);

        contentPane.revalidate();
        contentPane.repaint();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnAcceder)) {
            comprobar();
        } else if (e.getSource().equals(btnCancelar)) {
            cancelar();
        }
    }

    private void cancelar() {
        textUsuario.setText("");
        passwordField.setText("");
    }

    private void comprobar() {
        String dni = new String(passwordField.getPassword());
        Bailarin bailarin = Principal.leerDni(dni);

        if (bailarin != null && dni.equalsIgnoreCase(bailarin.getDni()) && textUsuario.getText().equalsIgnoreCase(bailarin.getCorreo())) {
            JOptionPane.showMessageDialog(this, "Bienvenido, " + bailarin.getNombre(), "Acceso concedido", JOptionPane.INFORMATION_MESSAGE);
            
            // Agregar la tercera pestaña si no existe
            if (!existePestana("Información de Bailarines")) {
                JPanel panel3 = new JPanel();
                panel3.add(new JLabel("Información de los bailarines aquí"));
                tabbedPane.addTab("Información de Bailarines", null, panel3, "Datos de los Bailarines");
            }

            tabbedPane.setSelectedIndex(2); // Cambia a la nueva pestaña
        } else {
            JOptionPane.showMessageDialog(this, "DNI no registrado", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean existePestana(String titulo) {
        for (int i = 0; i < tabbedPane.getTabCount(); i++) {
            if (tabbedPane.getTitleAt(i).equalsIgnoreCase(titulo)) {
                return true;
            }
        }
        return false;
    }
}