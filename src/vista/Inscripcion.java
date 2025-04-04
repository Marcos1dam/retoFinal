package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.Principal;
import modelo.Bailarin;
import modelo.Curso;
import modelo.Nivel;

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
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JTable;
import java.awt.Color;

import javax.security.auth.login.LoginException;
import javax.swing.ImageIcon;

public class Inscripcion extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNombre;
	private JTextField textFieldDni;
	private JTextField textFieldApellido;
	private JTextField textFieldTelefono;
	private JTextField textFieldFechaNacimiento;
	private JTable table;
	private JButton btnInscribirse;
	private Curso cursoSeleccionado;
	private JTextField textFieldEmail;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			Inscripcion dialog = new Inscripcion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @param b 
	 */
	public Inscripcion(boolean b) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Inscripcion.class.getResource("/imagenes/CodeAndDance.png")));
		setModal(b);
		setBounds(100, 100, 657, 548);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblDatosPersonales = new JLabel("DATOS PERSONALES");
		lblDatosPersonales.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblDatosPersonales.setBounds(211, 10, 199, 21);
		contentPanel.add(lblDatosPersonales);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblNombre.setBounds(57, 55, 86, 21);
		contentPanel.add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setFont(new Font("Arial Black", Font.PLAIN, 14));
		textFieldNombre.setBounds(163, 59, 129, 19);
		contentPanel.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblDni.setBounds(57, 86, 86, 21);
		contentPanel.add(lblDni);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblApellido.setBounds(57, 117, 86, 21);
		contentPanel.add(lblApellido);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha nac:");
		lblFechaNacimiento.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblFechaNacimiento.setBounds(57, 148, 105, 21);
		contentPanel.add(lblFechaNacimiento);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblTelefono.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblTelefono.setBounds(57, 179, 86, 21);
		contentPanel.add(lblTelefono);
		
		textFieldDni = new JTextField();
		textFieldDni.setFont(new Font("Arial Black", Font.PLAIN, 14));
		textFieldDni.setColumns(10);
		textFieldDni.setBounds(163, 90, 129, 19);
		contentPanel.add(textFieldDni);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setFont(new Font("Arial Black", Font.PLAIN, 14));
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(163, 121, 129, 19);
		contentPanel.add(textFieldApellido);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setFont(new Font("Arial Black", Font.PLAIN, 14));
		textFieldTelefono.setColumns(10);
		textFieldTelefono.setBounds(163, 179, 129, 19);
		contentPanel.add(textFieldTelefono);
		
		textFieldFechaNacimiento = new JTextField();
		textFieldFechaNacimiento.setFont(new Font("Arial Black", Font.PLAIN, 14));
		textFieldFechaNacimiento.setColumns(10);
		textFieldFechaNacimiento.setBounds(163, 150, 129, 19);
		contentPanel.add(textFieldFechaNacimiento);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 237, 643, 10);
		contentPanel.add(separator);
		
		JLabel lblCursos = new JLabel("CURSOS DISPONIBLES");
		lblCursos.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblCursos.setBounds(200, 257, 210, 21);
		contentPanel.add(lblCursos);
		
		table = new JTable();
		JScrollPane scrollPaneTable3 = new JScrollPane(table); // ScrollPane para table_3
		scrollPaneTable3.setBounds(46, 288, 534, 125); // Ajusta estos valores según necesites
		contentPanel.add(scrollPaneTable3);

		// Configurar el modelo de tabla para table_3
		String[] columnNames3 = {"ID ", "Tipo", "Horario", "Nivel", "Precio", "Plazas","Fecha Inicio","Fecha Fin", "Id Profesor"};
		DefaultTableModel model = new DefaultTableModel(columnNames3, 0) {
		    @Override
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		};
		table.setModel(model);

		// Llenar la tabla
		model.setRowCount(0);
		
		try {
			ArrayList<Curso>todosLosCursos= new ArrayList<>();
			todosLosCursos = Principal.obtenerTodosLosCursos(todosLosCursos);
			
			for (Curso curso : todosLosCursos) {
				System.out.println();
			    model.addRow(new Object[]{
			        curso.getIdCurso(),
			        curso.getTipo(),
			        curso.getHorario(),
			        curso.getNivel(),
			        curso.getPrecio(),
			        curso.getPlazas(),
			        curso.getFechaInicio(),
			        curso.getFechaFin(),
			        curso.getIdProfesor()
			    });
			}
		} catch (LoginException e1) {
			
			e1.printStackTrace();
		}
		
		

		
		// Listener para selección de filas
		table.getSelectionModel().addListSelectionListener(e -> {
		    if (!e.getValueIsAdjusting()) {
		        int selectedRow = table.getSelectedRow();
		        if (selectedRow >= 0) {
		            try {
		                cursoSeleccionado = new Curso();
		                
		                // Configuración básica del curso
		                cursoSeleccionado.setIdCurso(Integer.parseInt(table.getValueAt(selectedRow, 0).toString()));
		                cursoSeleccionado.setTipo(table.getValueAt(selectedRow, 1).toString());
		                
		                // Horario
		                cursoSeleccionado.setHorario(Time.valueOf(table.getValueAt(selectedRow, 2).toString()));
		                
		                // Nivel
		                cursoSeleccionado.setNivel(Nivel.obtenerPorNombre(table.getValueAt(selectedRow, 3).toString()));
		                
		                // Precio y plazas
		                cursoSeleccionado.setPrecio(Float.parseFloat(table.getValueAt(selectedRow, 4).toString()));
		                cursoSeleccionado.setPlazas(Integer.parseInt(table.getValueAt(selectedRow, 5).toString()));
		                
		                // Conversión segura de fechas a java.sql.Date
		                Object fechaInicioValue = table.getValueAt(selectedRow, 6);
		                Object fechaFinValue = table.getValueAt(selectedRow, 7);
		                
		                // Manejo para FechaInicio
		                if (fechaInicioValue instanceof java.util.Date) {
		                    java.util.Date utilDate = (java.util.Date) fechaInicioValue;
		                    cursoSeleccionado.setFechaInicio(new java.sql.Date(utilDate.getTime()));
		                } else if (fechaInicioValue instanceof String) {
		                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		                    java.util.Date parsedDate = sdf.parse((String) fechaInicioValue);
		                    cursoSeleccionado.setFechaInicio(new java.sql.Date(parsedDate.getTime()));
		                }
		                
		                // Manejo para FechaFin
		                if (fechaFinValue instanceof java.util.Date) {
		                    java.util.Date utilDate = (java.util.Date) fechaFinValue;
		                    cursoSeleccionado.setFechaFin(new java.sql.Date(utilDate.getTime()));
		                } else if (fechaFinValue instanceof String) {
		                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		                    java.util.Date parsedDate = sdf.parse((String) fechaFinValue);
		                    cursoSeleccionado.setFechaFin(new java.sql.Date(parsedDate.getTime()));
		                }
		                
		                // ID Profesor
		                cursoSeleccionado.setIdProfesor(Integer.parseInt(table.getValueAt(selectedRow, 8).toString()));
		               
		                
		            } catch (ParseException ex) {
		                JOptionPane.showMessageDialog(null, 
		                    "Formato de fecha inválido. Use yyyy-MM-dd", 
		                    "Error", 
		                    JOptionPane.ERROR_MESSAGE);
		            } catch (IllegalArgumentException ex) {
		                JOptionPane.showMessageDialog(null, 
		                    "Formato de horario inválido. Use HH:mm:ss", 
		                    "Error", 
		                    JOptionPane.ERROR_MESSAGE);
		            } catch (Exception ex) {
		                JOptionPane.showMessageDialog(null, 
		                    "Error al cargar los datos: " + ex.getMessage(), 
		                    "Error", 
		                    JOptionPane.ERROR_MESSAGE);
		                ex.printStackTrace();
		            }
		        }
		    }
		});

		
		
		btnInscribirse = new JButton("Inscribirse");
		btnInscribirse.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnInscribirse.setBounds(247, 439, 129, 28);
		btnInscribirse.addActionListener(this);
		contentPanel.add(btnInscribirse);
		
		JLabel lblImagen = new JLabel("");
		// Código modificado para redimensionar la imagen
		ImageIcon originalIcon = new ImageIcon(Inscripcion.class.getResource("/imagenes/Logo.png"));
		Image originalImage = originalIcon.getImage();
		Image resizedImage = originalImage.getScaledInstance(135, 152, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon = new ImageIcon(resizedImage);
		lblImagen.setIcon(resizedIcon);
		lblImagen.setBounds(445, 48, 135, 152);
		contentPanel.add(lblImagen);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblEmail.setBounds(57, 210, 86, 21);
		contentPanel.add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Arial Black", Font.PLAIN, 14));
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(163, 208, 129, 19);
		contentPanel.add(textFieldEmail);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(btnInscribirse)) {
			
			solicitudInscripcion(cursoSeleccionado);
			this.dispose();
		}
		
	}

	private void solicitudInscripcion(Curso cursoSeleccionado2) {
	    // Validar que el curso seleccionado no sea nulo
	    if (cursoSeleccionado2 == null) {
	        JOptionPane.showMessageDialog(this, "No se ha seleccionado ningún curso", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    // Crear el objeto Bailarín con los datos del formulario
	    Bailarin b = new Bailarin();
	    b.setDni(textFieldDni.getText());
	    b.setNombre(textFieldNombre.getText());
	    b.setApellido(textFieldApellido.getText());
	    b.setFechaNacimiento(Date.valueOf(textFieldFechaNacimiento.getText()));
	    b.setTelefono(Integer.valueOf(textFieldTelefono.getText()));
	    b.setCorreo(textFieldEmail.getText());

	    try {
	        // Primero intentamos inscribir al bailarín
	        Principal.inscribirse(b);
	        
	        //  la inscripción fue exitosa, entonces lo inscribimos al curso
	        try {
	            Principal.inscripcion(cursoSeleccionado2.getIdCurso(), b.getDni());
	            JOptionPane.showMessageDialog(this, "Inscripción realizada con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
	        } catch (LoginException e) {
	            JOptionPane.showMessageDialog(this, "El bailarín se registró pero hubo un error al inscribirlo en el curso: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	            e.printStackTrace();
	        }
	        
	    } catch (LoginException e) {
	        // Verificamos si el error es por DNI duplicado
	        if (e.getMessage().contains("Duplicate entry") || e.getMessage().contains("clave duplicada") || 
	            e.getMessage().contains("viola la restricción única") || e.getMessage().contains("PRIMARY KEY")) {
	            JOptionPane.showMessageDialog(this, "El DNI ya está registrado en el sistema", "Error", JOptionPane.ERROR_MESSAGE);
	        } else {
	            JOptionPane.showMessageDialog(this, "Error al registrar el bailarín: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        }
	        e.printStackTrace();
	    }
	}
}