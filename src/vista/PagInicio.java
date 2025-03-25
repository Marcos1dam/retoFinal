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
import modelo.Profesor;

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
import java.awt.Toolkit;

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
    private JTextField textFechaNaciemto;
    private JTextField textCorreo;
    private JTextField textTelefono;
    private JLabel lbId;
    private JLabel lblNombre_1;
    private JLabel lblApellido;
    private JLabel lblSalario;
    private JLabel lblEmail;
    private JLabel lblFoto;
    private JTextField textId;
    private JTextField textNombreProfesor;
    private JTextField textApellidoProfesor;
    private JTextField textSalario;
    private JTextField textEmailProfesor;

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
    	setIconImage(Toolkit.getDefaultToolkit().getImage(PagInicio.class.getResource("/imagenes/CodeAndDance.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 941, 583);
        
        // 🔹 Desactivar el fondo del TabbedPane en UIManager
        UIManager.put("TabbedPane.contentOpaque", false);

        // 🔹 Panel con imagen de fondo
        contentPane = new JPanel() {

           
            private Image backgroundImage = new ImageIcon(getClass().getResource("/imagenes/CodeAndDanceBienvenido.png")).getImage();


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
        Password.setBackground(new Color(255, 255, 255));
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
        btnAcceder.addActionListener(this);
        Password.add(btnAcceder);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setFont(new Font("Arial Black", Font.PLAIN, 14));
        btnCancelar.setBounds(472, 343, 116, 21);
        btnCancelar.addActionListener(this);
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
        JPanel panel4 = new JPanel();
        tabbedPane.addTab("Información de Profesores", null, panel4, "Datos de los Bailarines");
        panel4.setLayout(null);
        
        lbId = new JLabel("ID:");
        lbId.setFont(new Font("Arial Black", Font.PLAIN, 14));
        lbId.setBounds(103, 69, 87, 18);
        panel4.add(lbId);
        
        lblNombre_1 = new JLabel("Nombre:");
        lblNombre_1.setFont(new Font("Arial Black", Font.PLAIN, 14));
        lblNombre_1.setBounds(103, 110, 87, 18);
        panel4.add(lblNombre_1);
        
        lblApellido = new JLabel("Apellido:");
        lblApellido.setFont(new Font("Arial Black", Font.PLAIN, 14));
        lblApellido.setBounds(103, 148, 87, 18);
        panel4.add(lblApellido);
        
        lblSalario = new JLabel("Salario:");
        lblSalario.setFont(new Font("Arial Black", Font.PLAIN, 14));
        lblSalario.setBounds(103, 188, 87, 18);
        panel4.add(lblSalario);
        
        lblEmail = new JLabel("Email:");
        lblEmail.setFont(new Font("Arial Black", Font.PLAIN, 14));
        lblEmail.setBounds(103, 228, 87, 18);
        panel4.add(lblEmail);
        
        
        lblFoto = new JLabel("");
        lblFoto.setBounds(604, 69, 151, 167);
        panel4.add(lblFoto);
        
        textId = new JTextField();
        textId.setEditable(false);
        textId.setBounds(177, 71, 87, 19);
        panel4.add(textId);
        textId.setText(getWarningString().valueOf(p.getId()));
        textId.setColumns(10);
        
        textNombreProfesor = new JTextField();
        textNombreProfesor.setEditable(false);
        textNombreProfesor.setColumns(10);
        textNombreProfesor.setBounds(177, 109, 87, 19);
        textNombreProfesor.setText(p.getNombre());
        panel4.add(textNombreProfesor);
        
        textApellidoProfesor = new JTextField();
        textApellidoProfesor.setEditable(false);
        textApellidoProfesor.setColumns(10);
        textApellidoProfesor.setBounds(177, 150, 87, 19);
        textApellidoProfesor.setText(p.getApellido());	            
        panel4.add(textApellidoProfesor);
        
        textSalario = new JTextField();
        textSalario.setEditable(false);
        textSalario.setColumns(10);
        textSalario.setBounds(177, 190, 87, 19);
        textSalario.setText(String.valueOf(p.getSalario()));
        panel4.add(textSalario);
        
        textEmailProfesor = new JTextField();
        textEmailProfesor.setEditable(false);
        textEmailProfesor.setColumns(10);
        textEmailProfesor.setBounds(177, 230, 224, 19);
        textEmailProfesor.setText(p.getCorreo());
        panel4.add(textEmailProfesor);*/
        
       

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
		char[] passwordChars = passwordField.getPassword();
		System.out.println(passwordChars.length);
		char admin= '1';
    	if(passwordChars.length== 9) {
    		Bailarin bailarin = Principal.leerDni(String.valueOf(passwordChars));
    		
    		if (bailarin != null && String.valueOf(passwordChars).equalsIgnoreCase(bailarin.getDni()) && textUsuario.getText().equalsIgnoreCase(bailarin.getCorreo())) {
    	        JOptionPane.showMessageDialog(this, "Bienvenido, " + bailarin.getNombre(), "Acceso concedido", JOptionPane.INFORMATION_MESSAGE);
    	        
    	        // Agregar la tercera pestaña si no existe
    	        if (!existePestana("Información de Bailarines")) {
    	        	JPanel panel3 = new JPanel();
    	            tabbedPane.addTab("Información de Bailarines", null, panel3, "Datos de los Bailarines");
    	            panel3.setLayout(null);
    	            
    	            textNombre = new JTextField();
    	            textNombre.setEditable(false);
    	            textNombre.setBounds(130, 33, 123, 19);
    	            textNombre.setText(bailarin.getNombre());
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
    	            
    	            JLabel lblFechaNacimiento = new JLabel("Edad:");
    	            lblFechaNacimiento.setFont(new Font("Arial Black", Font.PLAIN, 14));
    	            lblFechaNacimiento.setBounds(42, 111, 78, 16);
    	            panel3.add(lblFechaNacimiento);
    	            
    	            JLabel lblCorreo = new JLabel("Correo:");
    	            lblCorreo.setFont(new Font("Arial Black", Font.PLAIN, 14));
    	            lblCorreo.setBounds(42, 153, 78, 16);
    	            panel3.add(lblCorreo);
    	            
    	            textApellido = new JTextField();
    	            textApellido.setEditable(false);
    	            textApellido.setColumns(10);
    	            textApellido.setBounds(130, 74, 123, 19);
    	            textApellido.setText(bailarin.getApellido());
    	            panel3.add(textApellido);
    	            
    	            textFechaNaciemto = new JTextField();
    	            textFechaNaciemto.setEditable(false);
    	            textFechaNaciemto.setColumns(10);
    	            textFechaNaciemto.setBounds(130, 112, 123, 19);
    	            textFechaNaciemto.setText(String.valueOf(bailarin.getFechaNacimiento()));
    	            panel3.add(textFechaNaciemto);
    	            
    	            textCorreo = new JTextField();
    	            textCorreo.setEditable(false);
    	            textCorreo.setColumns(10);
    	            textCorreo.setBounds(130, 154, 267, 19);
    	            textCorreo.setText(bailarin.getCorreo());
    	            panel3.add(textCorreo);
    	            
    	            JLabel lblTelefono = new JLabel("Telefono:");
    	            lblTelefono.setFont(new Font("Arial Black", Font.PLAIN, 14));
    	            lblTelefono.setBounds(42, 192, 78, 16);
    	            panel3.add(lblTelefono);
    	            
    	            textTelefono = new JTextField();
    	            textTelefono.setEditable(false);
    	            textTelefono.setColumns(10);
    	            textTelefono.setBounds(130, 193, 123, 19);
    	            textTelefono.setText(String.valueOf(bailarin.getTelefono()));
    	            panel3.add(textTelefono);

    	        } else if(bailarin == null) {
    	        	JOptionPane.showMessageDialog(this, "DNI o correo incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
    	        }
    		}
    	        tabbedPane.setSelectedIndex(2); // Cambiar a la tercera pestaña
    	}else  if(passwordChars.length == 1){
    		System.out.println("entra");
    		Profesor p= Principal.leerId(String.valueOf(passwordChars));
    		
    		 if(p != null && String.valueOf(passwordChars).equals(String.valueOf(p.getId())) && textUsuario.getText().equalsIgnoreCase(p.getCorreo())){
    		    	
    		    	JOptionPane.showMessageDialog(this, "Bienvenido, " + p.getNombre(), "Acceso concedido", JOptionPane.INFORMATION_MESSAGE);
    		    	if(!existePestana("Información de Profesores")) {
    		    		JPanel panel4 = new JPanel();
    		            tabbedPane.addTab("Información de Profesores", null, panel4, "Datos de los Bailarines");
    		            panel4.setLayout(null);
    		            
    		            lbId = new JLabel("ID:");
    		            lbId.setFont(new Font("Arial Black", Font.PLAIN, 14));
    		            lbId.setBounds(103, 69, 87, 18);
    		            panel4.add(lbId);
    		            
    		            lblNombre_1 = new JLabel("Nombre:");
    		            lblNombre_1.setFont(new Font("Arial Black", Font.PLAIN, 14));
    		            lblNombre_1.setBounds(103, 110, 87, 18);
    		            panel4.add(lblNombre_1);
    		            
    		            lblApellido = new JLabel("Apellido:");
    		            lblApellido.setFont(new Font("Arial Black", Font.PLAIN, 14));
    		            lblApellido.setBounds(103, 148, 87, 18);
    		            panel4.add(lblApellido);
    		            
    		            lblSalario = new JLabel("Salario:");
    		            lblSalario.setFont(new Font("Arial Black", Font.PLAIN, 14));
    		            lblSalario.setBounds(103, 188, 87, 18);
    		            panel4.add(lblSalario);
    		            
    		            lblEmail = new JLabel("Email:");
    		            lblEmail.setFont(new Font("Arial Black", Font.PLAIN, 14));
    		            lblEmail.setBounds(103, 228, 87, 18);
    		            panel4.add(lblEmail);
    		            
    		            
    		            lblFoto = new JLabel("");
    		            lblFoto.setBounds(591, 69, 201, 177);
    		         // Cargar la imagen original
    		            ImageIcon icon = new ImageIcon(getClass().getResource(p.getImagen()));

    		            // Escalar la imagen al tamaño del JLabel
    		            Image imagen = icon.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_SMOOTH);

    		            // Asignar la imagen escalada al JLabel
    		            lblFoto.setIcon(new ImageIcon(imagen));

    		            panel4.add(lblFoto);
    		            
    		            textId = new JTextField();
    		            textId.setEditable(false);
    		            textId.setBounds(177, 71, 87, 19);
    		            panel4.add(textId);
    		            textId.setText(getWarningString().valueOf(p.getId()));
    		            textId.setColumns(10);
    		            
    		            textNombreProfesor = new JTextField();
    		            textNombreProfesor.setEditable(false);
    		            textNombreProfesor.setColumns(10);
    		            textNombreProfesor.setBounds(177, 109, 87, 19);
    		            textNombreProfesor.setText(p.getNombre());
    		            panel4.add(textNombreProfesor);
    		            
    		            textApellidoProfesor = new JTextField();
    		            textApellidoProfesor.setEditable(false);
    		            textApellidoProfesor.setColumns(10);
    		            textApellidoProfesor.setBounds(177, 150, 87, 19);
    		            textApellidoProfesor.setText(p.getApellido());	            
    		            panel4.add(textApellidoProfesor);
    		            
    		            textSalario = new JTextField();
    		            textSalario.setEditable(false);
    		            textSalario.setColumns(10);
    		            textSalario.setBounds(177, 190, 87, 19);
    		            textSalario.setText(String.valueOf(p.getSalario()));
    		            panel4.add(textSalario);
    		            
    		            textEmailProfesor = new JTextField();
    		            textEmailProfesor.setEditable(false);
    		            textEmailProfesor.setColumns(10);
    		            textEmailProfesor.setBounds(177, 230, 224, 19);
    		            textEmailProfesor.setText(p.getCorreo());
    		            panel4.add(textEmailProfesor);
    		            
    		           
    		    	}
    		    	tabbedPane.setSelectedIndex(2); // Cambiar a la tercera pestaña
    	}else if(p == null) {
    		JOptionPane.showMessageDialog(this, "DNI o correo incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
    	}
	    
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