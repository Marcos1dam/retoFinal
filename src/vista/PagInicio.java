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
    private JTextField textNombre;
    private JTextField textApellido;
    private JTextField textEdad;
    private JTextField textCorreo;
    private JTextField textField;

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
        btnAcceder.setFont(new Font("Arial Black", Font.PLAIN, 14));
        btnAcceder.setBounds(282, 343, 102, 21);
        Password.add(btnAcceder);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setFont(new Font("Arial Black", Font.PLAIN, 14));
        btnCancelar.setBounds(472, 343, 116, 21);
        Password.add(btnCancelar);

        btnRecuperarContraseña = new JButton("Has olvidado tu contraseña?");
        btnRecuperarContraseña.setFont(new Font("Arial Black", Font.PLAIN, 8));
        btnRecuperarContraseña.setBounds(425, 279, 163, 21);
        btnRecuperarContraseña.addActionListener(this);
        Password.add(btnRecuperarContraseña);

        passwordField = new JPasswordField();
        passwordField.setBounds(356, 240, 232, 19);
        Password.add(passwordField);

        /*
        JPanel panel3 = new JPanel();
        tabbedPane.addTab("Información de Bailarines", null, panel3, "Datos de los Bailarines");
        panel3.setLayout(null);
        
        textNombre = new JTextField();
        textNombre.setEditable(false);
        textNombre.setBounds(130, 33, 123, 19);
        panel3.add(textNombre);
        textNombre.setColumns(10);
        
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new Font("Arial Black", Font.PLAIN, 14));
        lblNombre.setBounds(42, 36, 78, 16);
        panel3.add(lblNombre);
        
        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setFont(new Font("Arial Black", Font.PLAIN, 14));
        lblApellido.setBounds(42, 73, 78, 16);
        panel3.add(lblApellido);
        
        JLabel lblEdad = new JLabel("Edad:");
        lblEdad.setFont(new Font("Arial Black", Font.PLAIN, 14));
        lblEdad.setBounds(42, 111, 78, 16);
        panel3.add(lblEdad);
        
        JLabel lblCorreo = new JLabel("Correo:");
        lblCorreo.setFont(new Font("Arial Black", Font.PLAIN, 14));
        lblCorreo.setBounds(42, 153, 78, 16);
        panel3.add(lblCorreo);
        
        textApellido = new JTextField();
        textApellido.setEditable(false);
        textApellido.setColumns(10);
        textApellido.setBounds(130, 74, 123, 19);
        panel3.add(textApellido);
        
        textEdad = new JTextField();
        textEdad.setEditable(false);
        textEdad.setColumns(10);
        textEdad.setBounds(130, 112, 123, 19);
        panel3.add(textEdad);
        
        textCorreo = new JTextField();
        textCorreo.setEditable(false);
        textCorreo.setColumns(10);
        textCorreo.setBounds(130, 154, 267, 19);
        panel3.add(textCorreo);
        
        JLabel lblTelefono = new JLabel("Telefono:");
        lblTelefono.setFont(new Font("Arial Black", Font.PLAIN, 14));
        lblTelefono.setBounds(42, 192, 78, 16);
        panel3.add(lblTelefono);
        
        textField = new JTextField();
        textField.setEditable(false);
        textField.setColumns(10);
        textField.setBounds(130, 193, 123, 19);
        panel3.add(textField);*/

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
        }else if(e.getSource().equals(btnRecuperarContraseña)) {
        	mostrar();
        }
    }

    private void mostrar() {
    	JOptionPane.showMessageDialog(this, "Tu usuario es tu correo electronico y la contraseña es tu DNI ", "Informacion de SingIN", JOptionPane.INFORMATION_MESSAGE);
		
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
                  tabbedPane.addTab("Información de Bailarines", null, panel3, "Datos de los Bailarines");
                  panel3.setLayout(null);
                  
                  textNombre = new JTextField();
                  textNombre.setEditable(false);
                  textNombre.setBounds(130, 33, 123, 19);
                  panel3.add(textNombre);
                  textNombre.setColumns(10);
                  
                  JLabel lblNombre = new JLabel("Nombre:");
                  lblNombre.setFont(new Font("Arial Black", Font.PLAIN, 14));
                  lblNombre.setBounds(42, 36, 78, 16);
                  panel3.add(lblNombre);
                  
                  JLabel lblApellido = new JLabel("Apellido:");
                  lblApellido.setFont(new Font("Arial Black", Font.PLAIN, 14));
                  lblApellido.setBounds(42, 73, 78, 16);
                  panel3.add(lblApellido);
                  
                  JLabel lblEdad = new JLabel("Edad:");
                  lblEdad.setFont(new Font("Arial Black", Font.PLAIN, 14));
                  lblEdad.setBounds(42, 111, 78, 16);
                  panel3.add(lblEdad);
                  
                  JLabel lblCorreo = new JLabel("Correo:");
                  lblCorreo.setFont(new Font("Arial Black", Font.PLAIN, 14));
                  lblCorreo.setBounds(42, 153, 78, 16);
                  panel3.add(lblCorreo);
                  
                  textApellido = new JTextField();
                  textApellido.setEditable(false);
                  textApellido.setColumns(10);
                  textApellido.setBounds(130, 74, 123, 19);
                  panel3.add(textApellido);
                  
                  textEdad = new JTextField();
                  textEdad.setEditable(false);
                  textEdad.setColumns(10);
                  textEdad.setBounds(130, 112, 123, 19);
                  panel3.add(textEdad);
                  
                  textCorreo = new JTextField();
                  textCorreo.setEditable(false);
                  textCorreo.setColumns(10);
                  textCorreo.setBounds(130, 154, 267, 19);
                  panel3.add(textCorreo);
                  
                  JLabel lblTelefono = new JLabel("Telefono:");
                  lblTelefono.setFont(new Font("Arial Black", Font.PLAIN, 14));
                  lblTelefono.setBounds(42, 192, 78, 16);
                  panel3.add(lblTelefono);
                  
                  textField = new JTextField();
                  textField.setEditable(false);
                  textField.setColumns(10);
                  textField.setBounds(130, 193, 123, 19);
                  panel3.add(textField);
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