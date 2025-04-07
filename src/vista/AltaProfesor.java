package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Principal;
import modelo.Curso;
import modelo.Nivel;
import modelo.Profesor;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.security.auth.login.LoginException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.Color;

public class AltaProfesor extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldIdProfesor;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldSalario;
	private JTextField textFieldEmail;
	private JButton btnCancelar;
	private JButton btnGuardar;
	private JTextField textField_IdCurso;
	private JTextField textFieldTipoCurso;
	private JTextField textFieldHorarioCurso;
	private JTextField textFieldPrecioCurso;
	private JTextField textFieldPlazasCurso;
	private JTextField textFieldFechaInicioCurso;
	private JTextField textFieldFechaFinCurso;
	private JComboBox comboBoxNivelCurso;
	private int idCurso;
	private int idProfesor;
	private JComboBox comboBoxEsAdmin;
	private JTextField textFieldRutaImagen;
	/**
	 * Launch the application.
	 * @param b 
	 */
	/*public static void main(String[] args) {
		try {
			AltaProfesor dialog = new AltaProfesor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AltaProfesor(boolean b) {
		setModal(b);
		getContentPane().setBackground(new Color(255, 255, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage(AltaProfesor.class.getResource("/imagenes/CodeAndDance.png")));
		setBounds(100, 100, 499, 542);
		getContentPane().setLayout(null);
		contentPanel.setBounds(484, 0, 1, 505);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel lblDatosProfesor = new JLabel("DATOS PERSONALES");
		lblDatosProfesor.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblDatosProfesor.setBounds(153, 27, 190, 23);
		getContentPane().add(lblDatosProfesor);
		
		JLabel lblIDProfesor = new JLabel("ID:");
		lblIDProfesor.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblIDProfesor.setBounds(55, 77, 65, 23);
		getContentPane().add(lblIDProfesor);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNombre.setBounds(55, 110, 79, 24);
		getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblApellido.setBounds(55, 144, 79, 24);
		getContentPane().add(lblApellido);
		
		JLabel lblSalario = new JLabel("Salario:");
		lblSalario.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblSalario.setBounds(55, 178, 79, 24);
		getContentPane().add(lblSalario);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblEmail.setBounds(55, 212, 79, 24);
		getContentPane().add(lblEmail);
		
		JLabel lblAdmin = new JLabel("Administrador:");
		lblAdmin.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblAdmin.setBounds(55, 246, 116, 24);
		getContentPane().add(lblAdmin);
		
		
		
		textFieldIdProfesor = new JTextField();
		textFieldIdProfesor.setEditable(false);
		textFieldIdProfesor.setFont(new Font("Arial Black", Font.PLAIN, 14));
		textFieldIdProfesor.setBounds(135, 81, 109, 19);
		getContentPane().add(textFieldIdProfesor);
		textFieldIdProfesor.setColumns(10);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setFont(new Font("Arial Black", Font.PLAIN, 14));
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(135, 115, 109, 19);
		getContentPane().add(textFieldNombre);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setFont(new Font("Arial Black", Font.PLAIN, 14));
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(135, 149, 109, 19);
		getContentPane().add(textFieldApellido);
		
		textFieldSalario = new JTextField();
		textFieldSalario.setFont(new Font("Arial Black", Font.PLAIN, 14));
		textFieldSalario.setColumns(10);
		textFieldSalario.setBounds(135, 183, 109, 19);
		getContentPane().add(textFieldSalario);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Arial Black", Font.PLAIN, 14));
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(135, 217, 109, 19);
		getContentPane().add(textFieldEmail);
		
		comboBoxEsAdmin = new JComboBox();
		comboBoxEsAdmin.setModel(new DefaultComboBoxModel(new String[] {"SI", "NO"}));
		comboBoxEsAdmin.setFont(new Font("Arial Black", Font.PLAIN, 14));
		comboBoxEsAdmin.setBounds(196, 250, 48, 21);
		getContentPane().add(comboBoxEsAdmin);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 281, 485, 19);
		getContentPane().add(separator);
		
		JLabel lblNewId = new JLabel("ID:");
		lblNewId.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNewId.setBounds(25, 306, 45, 23);
		getContentPane().add(lblNewId);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblTipo.setBounds(25, 339, 79, 24);
		getContentPane().add(lblTipo);
		
		JLabel lblHorario = new JLabel("Horario:");
		lblHorario.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblHorario.setBounds(25, 373, 79, 24);
		getContentPane().add(lblHorario);
		
		JLabel lblNivel = new JLabel("NIvel:");
		lblNivel.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNivel.setBounds(25, 424, 79, 24);
		getContentPane().add(lblNivel);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblPrecio.setBounds(25, 458, 79, 24);
		getContentPane().add(lblPrecio);
		
		JLabel lblPlazas = new JLabel("Plazas:");
		lblPlazas.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblPlazas.setBounds(234, 310, 79, 24);
		getContentPane().add(lblPlazas);
		
		JLabel lblFechaInicio = new JLabel("Fecha Inicio:");
		lblFechaInicio.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblFechaInicio.setBounds(234, 344, 109, 24);
		getContentPane().add(lblFechaInicio);
		
		JLabel lblFechaFin = new JLabel("Fecha Fin:");
		lblFechaFin.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblFechaFin.setBounds(234, 393, 109, 24);
		getContentPane().add(lblFechaFin);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Arial Black", Font.PLAIN, 14));
		btnGuardar.setBounds(234, 460, 99, 21);
		btnGuardar.addActionListener(this);
		getContentPane().add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Arial Black", Font.PLAIN, 14));
		btnCancelar.setBounds(350, 460, 109, 21);
		btnCancelar.addActionListener(this);
		getContentPane().add(btnCancelar);
		
		textField_IdCurso = new JTextField();
		textField_IdCurso.setFont(new Font("Arial Black", Font.PLAIN, 14));
		textField_IdCurso.setEditable(false);
		textField_IdCurso.setBounds(103, 310, 96, 19);
		getContentPane().add(textField_IdCurso);
		textField_IdCurso.setColumns(10);
		
		textFieldTipoCurso = new JTextField();
		textFieldTipoCurso.setFont(new Font("Arial Black", Font.PLAIN, 14));
		textFieldTipoCurso.setBounds(103, 344, 96, 19);
		getContentPane().add(textFieldTipoCurso);
		textFieldTipoCurso.setColumns(10);
		
		textFieldHorarioCurso = new JTextField();
		textFieldHorarioCurso.setFont(new Font("Arial Black", Font.PLAIN, 14));
		textFieldHorarioCurso.setColumns(10);
		textFieldHorarioCurso.setBounds(103, 378, 96, 19);
		getContentPane().add(textFieldHorarioCurso);
		
		textFieldPrecioCurso = new JTextField();
		textFieldPrecioCurso.setFont(new Font("Arial Black", Font.PLAIN, 14));
		textFieldPrecioCurso.setColumns(10);
		textFieldPrecioCurso.setBounds(103, 461, 96, 19);
		getContentPane().add(textFieldPrecioCurso);
		
		textFieldPlazasCurso = new JTextField();
		textFieldPlazasCurso.setFont(new Font("Arial Black", Font.PLAIN, 14));
		textFieldPlazasCurso.setColumns(10);
		textFieldPlazasCurso.setBounds(352, 310, 96, 19);
		getContentPane().add(textFieldPlazasCurso);
		
		textFieldFechaInicioCurso = new JTextField();
		textFieldFechaInicioCurso.setFont(new Font("Arial Black", Font.PLAIN, 14));
		textFieldFechaInicioCurso.setColumns(10);
		textFieldFechaInicioCurso.setBounds(352, 342, 96, 19);
		getContentPane().add(textFieldFechaInicioCurso);
		
		textFieldFechaFinCurso = new JTextField();
		textFieldFechaFinCurso.setFont(new Font("Arial Black", Font.PLAIN, 14));
		textFieldFechaFinCurso.setColumns(10);
		textFieldFechaFinCurso.setBounds(352, 396, 96, 19);
		getContentPane().add(textFieldFechaFinCurso);
		
		comboBoxNivelCurso = new JComboBox();
		comboBoxNivelCurso.setModel(new DefaultComboBoxModel(new String[] {"Principiante", "Medio", "Avanzado"}));
		comboBoxNivelCurso.setFont(new Font("Arial Black", Font.PLAIN, 14));
		comboBoxNivelCurso.setBounds(103, 427, 122, 21);
		getContentPane().add(comboBoxNivelCurso);
		
		JLabel lblFormatoHora = new JLabel("(HH:mm:ss)");
		lblFormatoHora.setFont(new Font("Arial Black", Font.PLAIN, 10));
		lblFormatoHora.setBounds(120, 404, 79, 13);
		getContentPane().add(lblFormatoHora);
		
		JLabel lblFormatoFecha = new JLabel("(AAAA-mm-dd)");
		lblFormatoFecha.setFont(new Font("Arial Black", Font.PLAIN, 10));
		lblFormatoFecha.setBounds(350, 373, 99, 13);
		getContentPane().add(lblFormatoFecha);
		
		JLabel lblFormatoFecha_1 = new JLabel("(AAAA-mm-dd)");
		lblFormatoFecha_1.setFont(new Font("Arial Black", Font.PLAIN, 10));
		lblFormatoFecha_1.setBounds(350, 424, 99, 13);
		getContentPane().add(lblFormatoFecha_1);
		
		JLabel lblNewLabel = new JLabel("Ruta de la imagen:");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNewLabel.setBounds(300, 223, 159, 13);
		getContentPane().add(lblNewLabel);
		
		textFieldRutaImagen = new JTextField();
		textFieldRutaImagen.setBounds(300, 251, 159, 19);
		getContentPane().add(textFieldRutaImagen);
		textFieldRutaImagen.setColumns(10);
		
		JLabel lblCurso = new JLabel("Curso");
		lblCurso.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblCurso.setBounds(10, 280, 60, 13);
		getContentPane().add(lblCurso);
		
		cargarDatos();
	}

	private void cargarDatos() {
		idCurso= obtenerIdCurso();
		idProfesor= obtenerIdProfesor();
		textField_IdCurso.setText(String.valueOf(idCurso));
		textFieldIdProfesor.setText(String.valueOf(idProfesor));
	}

	private int obtenerIdProfesor() {
		
		
		try {
			ArrayList<Profesor> profesores= new ArrayList<>();
			profesores = Principal.obtenerTodosLosProfesores(profesores);
			int id= 0;
			
			for(Profesor p: profesores) {
				
				if(p.getId() > id) {
					id = p.getId();
					
				}
			}
			return id + 1;
		} catch (LoginException e) {
			
			e.printStackTrace();
		}
		return (Integer) null;
	}

	private int obtenerIdCurso() {
		try {
			ArrayList<Curso> cursos= new ArrayList<>();
			cursos = Principal.obtenerTodosLosCursos(cursos);
			int id = 0;

			for (Curso cu : cursos) {
				if (cu.getIdCurso() > id) {
					id = cu.getIdCurso();
				}
			}

			return id + 1;
		} catch (LoginException e) {
			
			e.printStackTrace();
		}

		return (Integer) null;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnGuardar)) {
			guardarProfesor();
			
			JOptionPane.showMessageDialog(this, 
		            "Profesor y curso guardados correctamente", 
		            "Éxito", 
		            JOptionPane.INFORMATION_MESSAGE);
		}else if(e.getSource().equals(btnCancelar)) {
			this.dispose();
		}
		
	}

	private void guardarProfesor() {
	    // Validar campos antes de continuar
	    if (!validarCampos()) {
	        return; // Salir si hay campos vacíos
	    }
	    
	    try {
	        Profesor p = new Profesor();
	        p.setId(idProfesor);
	        p.setNombre(textFieldNombre.getText());
	        p.setApellido(textFieldApellido.getText());
	        p.setSalario(Float.valueOf(textFieldSalario.getText()));
	        p.setCorreo(textFieldEmail.getText());
	        p.setAdmin(comboBoxEsAdmin.getSelectedItem().equals("SI"));
	        p.setImagen(textFieldRutaImagen.getText());
	        
	        Principal.altaProfesor(p);
	        
	        // Mostrar imagen (esto debería estar en otro lugar, no aquí)
	        JLabel lblFoto = new JLabel("");
	        ImageIcon originalIcon = new ImageIcon(textFieldRutaImagen.getText());
	        Image originalImage = originalIcon.getImage();
	        Image resizedImage = originalImage.getScaledInstance(135, 152, Image.SCALE_SMOOTH);
	        ImageIcon resizedIcon = new ImageIcon(resizedImage);
	        lblFoto.setIcon(resizedIcon);
	        lblFoto.setBounds(300, 84, 99, 133);
	        getContentPane().add(lblFoto);
	            
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(this, 
	            "Error al guardar los datos: " + e.getMessage(), 
	            "Error", 
	            JOptionPane.ERROR_MESSAGE);
	        e.printStackTrace();
	    }
	    asignarCurso();
	}

	private void asignarCurso() {
		Curso c = new Curso();
	    try {
	        System.out.println(idCurso);
	        c.setIdCurso(idCurso);
	        c.setTipo(textFieldTipoCurso.getText());
	        c.setHorario(Time.valueOf(textFieldHorarioCurso.getText()));
	        c.setNivel(Nivel.obtenerPorNombre(String.valueOf(comboBoxNivelCurso.getSelectedItem())));
	        c.setPrecio(Float.valueOf(textFieldPrecioCurso.getText()));
	        c.setPlazas(Integer.valueOf(textFieldPlazasCurso.getText()));
	        
	        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
	        java.util.Date parsedDate = sdf1.parse(textFieldFechaInicioCurso.getText());
	        c.setFechaInicio(new Date(parsedDate.getTime()));
	        
	        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	        parsedDate = sdf2.parse(textFieldFechaFinCurso.getText());
	        c.setFechaFin(new Date(parsedDate.getTime()));
	        
	        c.setIdProfesor(idProfesor);
	        
	        Principal.crearCurso(c);
	        
	    } catch (ParseException e) {
	        JOptionPane.showMessageDialog(this, 
	            "Formato de fecha incorrecto. Use AAAA-MM-DD", 
	            "Error de formato", 
	            JOptionPane.ERROR_MESSAGE);
	    } catch (IllegalArgumentException e) {
	        JOptionPane.showMessageDialog(this, 
	            "Formato de hora incorrecto. Use HH:mm:ss", 
	            "Error de formato", 
	            JOptionPane.ERROR_MESSAGE);
	    } catch (LoginException e) {
	        JOptionPane.showMessageDialog(this, 
	            "Error al crear el curso: " + e.getMessage(), 
	            "Error", 
	            JOptionPane.ERROR_MESSAGE);
	    }
	}
	
	private boolean validarCampos() {
	    // Verificar campos de profesor
	    if (textFieldNombre.getText().trim().isEmpty() ||
	        textFieldApellido.getText().trim().isEmpty() ||
	        textFieldSalario.getText().trim().isEmpty() ||
	        textFieldEmail.getText().trim().isEmpty() ||
	        textFieldRutaImagen.getText().trim().isEmpty()) {
	        
	        JOptionPane.showMessageDialog(this, 
	            "Por favor complete todos los campos obligatorios del profesor", 
	            "Campos vacíos", 
	            JOptionPane.WARNING_MESSAGE);
	        return false;
	    }
	    
	    // Verificar campos de curso (si son obligatorios)
	    if (textFieldTipoCurso.getText().trim().isEmpty() ||
	        textFieldHorarioCurso.getText().trim().isEmpty() ||
	        textFieldPrecioCurso.getText().trim().isEmpty() ||
	        textFieldPlazasCurso.getText().trim().isEmpty() ||
	        textFieldFechaInicioCurso.getText().trim().isEmpty() ||
	        textFieldFechaFinCurso.getText().trim().isEmpty()) {
	        
	        JOptionPane.showMessageDialog(this, 
	            "Por favor complete todos los campos obligatorios del curso", 
	            "Campos vacíos", 
	            JOptionPane.WARNING_MESSAGE);
	        return false;
	    }
	    
	    return true;
	}
	
	
}
