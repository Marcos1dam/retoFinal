package vista;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.security.auth.login.LoginException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.Principal;
import modelo.Bailarin;
import modelo.Curso;
import modelo.Nivel;
import modelo.Participa;
import modelo.Profesor;

public class PagInicio extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTabbedPane tabbedPane;
	private JPanel contentPane;
	private JTextField textUsuario;
	private JPasswordField passwordField;
	private JButton btnAcceder, btnCancelar, btnRecuperarContraseña;

	// Campos para bailarín
	private JTextField textNombre, textApellido, textFechaNaciemto, textCorreo, textTelefono;

	// Campos para profesor
	private JLabel lbId, lblNombre_1, lblApellido, lblSalario, lblEmail, lblFoto;
	private JTextField textId, textNombreProfesor, textApellidoProfesor, textSalario, textEmailProfesor;
	private JTable table;
	private JButton btnCrearCurso_1;
	private JButton btnModificar_1;
	private JButton btnEliminarCurso_1;
	private JButton btnEliminarBailarin_1;
	private JButton btnOcupacion_1;
	private Profesor p;

	// Campos para curso
	// Variable para almacenar el curso seleccionado
	private Curso cursoSeleccionado = null;
	private ArrayList<Curso> cursos = new ArrayList<>();
	private JButton btnBajaCurso;
	private JButton btnApuntarse;
	private JButton btnInscripcion;
	
//	public static void main(String[] args) {
//		SwingUtilities.invokeLater(() -> {
//			try {
//				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			new PagInicio().setVisible(true);
//		});
//	}

	public PagInicio() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PagInicio.class.getResource("/imagenes/CodeAndDance.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 941, 583);

		// Configuración del fondo
		UIManager.put("TabbedPane.contentOpaque", false);
		contentPane = new JPanel() {
			private Image backgroundImage = new ImageIcon(
					getClass().getResource("/imagenes/CodeAndDanceBienvenido.png")).getImage();

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
			}
		};
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);

		// Configuración del JTabbedPane con pestañas cerrables
		tabbedPane = new JTabbedPane() {
			@Override
			public void addTab(String title, Icon icon, Component component, String tip) {
				super.addTab(title, icon, component, tip);

				if (!title.equals("CODE AND DANCE") && !title.equals("Sing In")) {
					int index = indexOfComponent(component);
					setTabComponentAt(index, new CloseTabButton(title, icon, component));
				}
			}
		};
		tabbedPane.setOpaque(false);
		tabbedPane.setBackground(new Color(0, 0, 0, 0));

		// Pestaña inicial
		JPanel singIn = new JPanel();
		singIn.setOpaque(false);
		tabbedPane.addTab("CODE AND DANCE", null, singIn, "Información de la Pestaña 1");
		singIn.setLayout(null);
		
		btnInscripcion = new JButton("INSCRIBETE");
		btnInscripcion.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnInscripcion.setBounds(370, 171, 162, 43);
		btnInscripcion.addActionListener(this);
		singIn.add(btnInscripcion);

		// Pestaña de login
		JPanel passwordPanel = new JPanel() {
			private Image backgroundImage = new ImageIcon(
					getClass().getResource("/imagenes/CodeAndDance.png")).getImage();

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
			}
		};
		passwordPanel.setBackground(new Color(255, 255, 255));
		passwordPanel.setLayout(null);
		tabbedPane.addTab("Sing In", null, passwordPanel, "Información de la Pestaña 2");

		// Componentes del login
		JLabel lbUsuario = new JLabel("Usuario:");
		lbUsuario.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lbUsuario.setBounds(255, 191, 91, 22);
		passwordPanel.add(lbUsuario);

		JLabel lbPassword = new JLabel("Password:");
		lbPassword.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lbPassword.setBounds(255, 236, 91, 22);
		passwordPanel.add(lbPassword);

		textUsuario = new JTextField();
		textUsuario.setBounds(356, 195, 253, 19);
		passwordPanel.add(textUsuario);
		textUsuario.setColumns(10);

		btnAcceder = new JButton("Acceder");
		btnAcceder.setFont(new Font("Arial Black", Font.PLAIN, 14));
		btnAcceder.setBounds(282, 343, 102, 21);
		btnAcceder.addActionListener(this);
		passwordPanel.add(btnAcceder);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Arial Black", Font.PLAIN, 14));
		btnCancelar.setBounds(472, 343, 116, 21);
		btnCancelar.addActionListener(this);
		passwordPanel.add(btnCancelar);

		btnRecuperarContraseña = new JButton("¿Has olvidado tu contraseña?");
		btnRecuperarContraseña.setFont(new Font("Arial Black", Font.PLAIN, 8));
		btnRecuperarContraseña.setBounds(425, 279, 184, 21);
		btnRecuperarContraseña.addActionListener(this);
		passwordPanel.add(btnRecuperarContraseña);

		passwordField = new JPasswordField();
		passwordField.setBounds(356, 240, 253, 19);
		passwordPanel.add(passwordField);
		//////////////////////////////////////////////
		/*JPanel panel3 = new JPanel();
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

		agregarBotonCerrarSesion(panel3);
		tabbedPane.addTab("Información de Bailarines", null, panel3, "Datos de los Bailarines");

		JLabel lblMisCursos = new JLabel("Mis cursos");
		lblMisCursos.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblMisCursos.setBounds(639, 75, 123, 26);
		panel3.add(lblMisCursos);

		JTable table_1 = new JTable();
		table_1.setBounds(748, 176, 1, 1);
		panel3.add(table_1);

		JTable table_2 = new JTable();
		table_2.setBounds(451, 114, 454, 97);
		panel3.add(table_2);

		JButton btnBajaCurso = new JButton("Darse de baja");
		btnBajaCurso.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnBajaCurso.setBounds(598, 229, 190, 21);
		panel3.add(btnBajaCurso);

		JLabel lblInfoCursos = new JLabel("mas cursos");
		lblInfoCursos.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblInfoCursos.setBounds(423, 289, 136, 13);
		panel3.add(lblInfoCursos);

		JTable table_3 = new JTable();
		table_3.setBounds(86, 318, 819, 137);
		panel3.add(table_3);

		JButton btnApuntarse = new JButton("Apuntarse");
		btnApuntarse.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnApuntarse.setBounds(408, 465, 136, 21);
		panel3.add(btnApuntarse);

		agregarBotonCerrarSesion(panel3);
		tabbedPane.addTab("Información de Bailarines", null, panel3, "Datos de los Bailarines");

		tabbedPane.setSelectedIndex(2);
	}*/
		//////////////////////////////////////////////
		contentPane.add(tabbedPane, BorderLayout.CENTER);
	}

// Clase interna para botones de cierre de pestaña
	private class CloseTabButton extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public CloseTabButton(String title, Icon icon, final Component component) {
			setOpaque(false);
			setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

			JLabel label = new JLabel(title);
			label.setIcon(icon);
			add(label);

			JButton closeButton = new JButton("x");
			closeButton.setMargin(new Insets(0, 5, 0, 0));
			closeButton.addActionListener(e -> {
				int index = tabbedPane.indexOfComponent(component);
				if (index != -1) {
					tabbedPane.remove(index);

					if (!existePestana("Información de Bailarines") && !existePestana("Información de Profesores")) {
						tabbedPane.setSelectedIndex(0);
						tabbedPane.setEnabledAt(1, true);
					}
				}
			});
			add(closeButton);
		}

	}

	private void agregarBotonCerrarSesion(JPanel panel) {
		JButton btnCerrarSesion = new JButton("Cerrar sesión");
		btnCerrarSesion.setFont(new Font("Arial Black", Font.PLAIN, 14));
		btnCerrarSesion.setBounds(689, 460, 195, 21);
		btnCerrarSesion.addActionListener(e -> {
			while (tabbedPane.getTabCount() > 2) {
				tabbedPane.remove(2);
			}
			tabbedPane.setEnabledAt(1, true);
			tabbedPane.setSelectedIndex(0);
			textUsuario.setText("");
			passwordField.setText("");
		});
		panel.add(btnCerrarSesion);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnAcceder)) {
			comprobar();
		} else if (e.getSource().equals(btnCancelar)) {
			cancelar();
		} else if (e.getSource().equals(btnRecuperarContraseña)) {
			mostrar();
		}else if(e.getSource().equals(btnApuntarse)) {
			try {
				apuntarse(cursoSeleccionado);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}else if(e.getSource().equals(btnBajaCurso)) {
			try {
				bajaCurso(cursoSeleccionado);
			} catch (SQLException ex) {
			      JOptionPane.showMessageDialog(this, "Error al darse de baja: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		            ex.printStackTrace();
			}
		} else if (e.getSource().equals(btnCrearCurso_1)) {
			crear();

		} else if (e.getSource().equals(btnModificar_1)) {
			if(cursoSeleccionado==null) {
				JOptionPane.showMessageDialog(this, "No ha seleccionado ningun curso", "Error", JOptionPane.ERROR_MESSAGE);
			}else {
				modificar();
			}
			
			
		} else if(e.getSource().equals(btnEliminarCurso_1)) {
			if(cursoSeleccionado==null) {
				JOptionPane.showMessageDialog(this, "No ha seleccionado ningun curso", "Error", JOptionPane.ERROR_MESSAGE);
			}else {
				eliminarCurso(cursoSeleccionado);
			}
			
		}else if(e.getSource().equals(btnInscripcion)) {
			inscripcion();
		}
	}

	private void inscripcion() {
		Inscripcion mod= new Inscripcion(true);
		mod.setVisible(true);
	}

	private void eliminarCurso(Curso cursoSeleccionado2) {
		if(cursoSeleccionado2 != null) {
			try {
				Principal.elimiinarCurso(cursoSeleccionado2.getIdCurso());
			} catch (LoginException e) {
				
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(this, "Curso eliminado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
			actualizarTablaCursosPorProfesor(cursoSeleccionado2.getIdProfesor());
		} else {
			 JOptionPane.showMessageDialog(this, "Selecciona un curso primero.", "Advertencia", JOptionPane.WARNING_MESSAGE);
		}
		
	}

	private void actualizarTablaCursosPorProfesor(int idProfesor) {
		// Obtener el panel de la pestaña actual
	    Component selectedTab = tabbedPane.getSelectedComponent();
	    
	    if(selectedTab instanceof JPanel) {
	    	JPanel panel = (JPanel) selectedTab;
	    	
	    	 for (Component comp : panel.getComponents()) {
		            if (comp instanceof JScrollPane) {
		                JScrollPane scrollPane = (JScrollPane) comp;
		                Component view = scrollPane.getViewport().getView();
		                
		                if (view instanceof JTable) {
		                    JTable tableMisCursos = (JTable) view;
		                    DefaultTableModel model = (DefaultTableModel) tableMisCursos.getModel();
		                    model.setRowCount(0); // Limpiar la tabla
		                    
		                    // Obtener los cursos actualizados del Profesor
		                    ArrayList<Curso> cursosProfesor = null;
							try {
								cursosProfesor = Principal.obtenerCursosPorProfesor(idProfesor, cursosProfesor);
								// Llenar la tabla con los nuevos datos
			                    for (Curso curso : cursosProfesor) {
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
							} catch (LoginException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
		                    
		                    
		                    return; // Terminar después de actualizar
		                }
		            }
		        }
		                
	    }
	    JOptionPane.showMessageDialog(this, "No se pudo actualizar la tabla de cursos", "Error", JOptionPane.ERROR_MESSAGE);
	}

	private void bajaCurso(Curso cursoSeleccionado2) throws SQLException {
	    if (cursoSeleccionado2 != null) {
	        String dniBailarin = new String(passwordField.getPassword()); // Obtiene el DNI del bailarín
	        
	        try {
				Principal.darDeBajaCurso(cursoSeleccionado.getIdCurso(), dniBailarin);
			} catch (LoginException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(this, "Baja realizada con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
			
			// Actualiza las tablas
			actualizarTablaMisCursos(dniBailarin);
	    } else {
	        JOptionPane.showMessageDialog(this, "Selecciona un curso primero.", "Advertencia", JOptionPane.WARNING_MESSAGE);
	    }
	}
	

	private void apuntarse(Curso cursoSeleccionado) throws SQLException {
	    try {
	        // Obtener el DNI del bailarín (que es la contraseña)
	        String dniBailarin = new String(passwordField.getPassword());
	        
	        // Obtener las fechas de participación (puedes usar las predeterminadas o pedirlas)
	        Participa par = Principal.leerParticipa(cursoSeleccionado.getIdCurso());
	        
	        // Realizar la inscripción
	        Principal.inscripcion(cursoSeleccionado.getIdCurso(), dniBailarin);
	        
	        // Actualizar la tabla de "Mis cursos"
	        actualizarTablaMisCursos(dniBailarin);
	        
	        JOptionPane.showMessageDialog(this, "Inscripción realizada con éxito");
	    } catch (Exception e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Error inesperado: " + e.getMessage(), 
	                                    "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}

	// Método para actualizar la tabla de "Mis cursos"
	private void actualizarTablaMisCursos(String dniBailarin) {
	    // Obtener el panel de la pestaña actual
	    Component selectedTab = tabbedPane.getSelectedComponent();
	    
	    if (selectedTab instanceof JPanel) {
	        JPanel panel = (JPanel) selectedTab;
	        
	        // Buscar table_1 dentro del panel
	        for (Component comp : panel.getComponents()) {
	            if (comp instanceof JScrollPane) {
	                JScrollPane scrollPane = (JScrollPane) comp;
	                Component view = scrollPane.getViewport().getView();
	                
	                if (view instanceof JTable) {
	                    JTable tableMisCursos = (JTable) view;
	                    DefaultTableModel model = (DefaultTableModel) tableMisCursos.getModel();
	                    model.setRowCount(0); // Limpiar la tabla
	                    
	                    // Obtener los cursos actualizados del bailarín
	                    ArrayList<Curso> cursosBailarin;
						try {
							cursosBailarin = Principal.obtenerCursosPorBailarin(dniBailarin);
							 // Llenar la tabla con los nuevos datos
		                    for (Curso curso : cursosBailarin) {
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
						} catch (LoginException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	                    
	                   
	                    return; // Terminar después de actualizar
	                }
	            }
	        }
	    }
	    JOptionPane.showMessageDialog(this, "No se pudo actualizar la tabla de cursos", "Error", JOptionPane.ERROR_MESSAGE);
	}

	private void mostrar() {
		JOptionPane.showMessageDialog(this, "Tu usuario es tu correo electrónico y la contraseña es tu DNI",
				"Informacion de SingIN", JOptionPane.INFORMATION_MESSAGE);
	}

	private void cancelar() {
		textUsuario.setText("");
		passwordField.setText("");
	}

	private void comprobar() {

        char[] passwordChars = passwordField.getPassword();

		if (passwordChars.length == 9) {
			Bailarin bailarin;
			try {
				bailarin = Principal.leerDni(String.valueOf(passwordChars));
				if (bailarin != null && String.valueOf(passwordChars).equalsIgnoreCase(bailarin.getDni())
						&& textUsuario.getText().equalsIgnoreCase(bailarin.getCorreo())) {


					JOptionPane.showMessageDialog(this, "Bienvenido, " + bailarin.getNombre(), "Acceso concedido",
							JOptionPane.INFORMATION_MESSAGE);

					tabbedPane.setEnabledAt(1, false);

					if (!existePestana("Información de Bailarines")) {
						JPanel panel3 = new JPanel() {
							private Image backgroundImage = new ImageIcon(
									getClass().getResource("/imagenes/CodeAndDance.png")).getImage();

							@Override
							protected void paintComponent(Graphics g) {
								super.paintComponent(g);
								g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
							}
						};
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

						agregarBotonCerrarSesion(panel3);
						tabbedPane.addTab("Información de Bailarines", null, panel3, "Datos de los Bailarines");

						JLabel lblMisCursos = new JLabel("Mis cursos");
						lblMisCursos.setFont(new Font("Arial Black", Font.PLAIN, 16));
						lblMisCursos.setBounds(639, 75, 123, 26);
						panel3.add(lblMisCursos);

						// Declarar la tabla correctamente (usando table_1 consistentemente)
						JTable table_1 = new JTable();
						JScrollPane scrollPaneTable1 = new JScrollPane(table_1); // ScrollPane para table_1
						scrollPaneTable1.setBounds(451, 114, 454, 97); // Ajusta estos valores según necesites
						panel3.add(scrollPaneTable1);

						// Configurar el modelo de tabla para table_1 (no para table)
						String[] columnNames = {"ID ", "Tipo", "Horario", "Nivel", "Precio", "Plazas","Fecha Inicio","Fecha Fin", "Id Profesor"};
						DefaultTableModel model_1 = new DefaultTableModel(columnNames, 0) {
						    @Override
						    public boolean isCellEditable(int row, int column) {
						        return false;
						    }
						};
						table_1.setModel(model_1);

						// Llenar la tabla
						model_1.setRowCount(0);
						ArrayList<Curso>cursosBailarin= new ArrayList<>();
						try {
							cursosBailarin = Principal.obtenerCursosPorBailarin(bailarin.getDni());
						} catch (LoginException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						for (Curso curso : cursosBailarin) {
							System.out.println();
						    model_1.addRow(new Object[]{
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

						// Listener para selección de filas
						table_1.getSelectionModel().addListSelectionListener(e -> {
						    if (!e.getValueIsAdjusting()) {
						        int selectedRow = table_1.getSelectedRow();
						        if (selectedRow >= 0) {
						            try {
						                cursoSeleccionado = new Curso();
						                
						                // Configuración básica del curso
						                cursoSeleccionado.setIdCurso(Integer.parseInt(table_1.getValueAt(selectedRow, 0).toString()));
						                cursoSeleccionado.setTipo(table_1.getValueAt(selectedRow, 1).toString());
						                
						                // Horario
						                cursoSeleccionado.setHorario(Time.valueOf(table_1.getValueAt(selectedRow, 2).toString()));
						                
						                // Nivel
						                cursoSeleccionado.setNivel(Nivel.obtenerPorNombre(table_1.getValueAt(selectedRow, 3).toString()));
						                
						                // Precio y plazas
						                cursoSeleccionado.setPrecio(Float.parseFloat(table_1.getValueAt(selectedRow, 4).toString()));
						                cursoSeleccionado.setPlazas(Integer.parseInt(table_1.getValueAt(selectedRow, 5).toString()));
						                
						                // Conversión segura de fechas a java.sql.Date
						                Object fechaInicioValue = table_1.getValueAt(selectedRow, 6);
						                Object fechaFinValue = table_1.getValueAt(selectedRow, 7);
						                
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
						                cursoSeleccionado.setIdProfesor(Integer.parseInt(table_1.getValueAt(selectedRow, 8).toString()));
						                
						                // Habilitar botones
						                btnBajaCurso.setVisible(true);
						                
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


						btnBajaCurso = new JButton("Darse de baja");
						btnBajaCurso.setFont(new Font("Arial Black", Font.PLAIN, 16));
						btnBajaCurso.setBounds(598, 229, 190, 21);
						btnBajaCurso.addActionListener(this);
						panel3.add(btnBajaCurso);

						JLabel lblInfoCursos = new JLabel("mas cursos");
						lblInfoCursos.setFont(new Font("Arial Black", Font.PLAIN, 16));
						lblInfoCursos.setBounds(423, 289, 136, 13);
						panel3.add(lblInfoCursos);

						// Declarar la tabla correctamente 
						JTable table_3 = new JTable();
						JScrollPane scrollPaneTable3 = new JScrollPane(table_3); // ScrollPane para table_3
						scrollPaneTable3.setBounds(86, 318, 819, 137); // Ajusta estos valores según necesites
						panel3.add(scrollPaneTable3);

						// Configurar el modelo de tabla para table_3
						String[] columnNames3 = {"ID ", "Tipo", "Horario", "Nivel", "Precio", "Plazas","Fecha Inicio","Fecha Fin", "Id Profesor"};
						DefaultTableModel model_3 = new DefaultTableModel(columnNames3, 0) {
						    @Override
						    public boolean isCellEditable(int row, int column) {
						        return false;
						    }
						};
						table_3.setModel(model_3);

						// Llenar la tabla
						model_3.setRowCount(0);
						ArrayList<Curso>todosLosCursos= new ArrayList<>();
						try {
							Principal.obtenerTodosLosCursos();
						} catch (LoginException e1) {
							
							e1.printStackTrace();
						}
						
						for (Curso curso : todosLosCursos) {
							System.out.println();
						    model_3.addRow(new Object[]{
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

						
						// Listener para selección de filas
						table_3.getSelectionModel().addListSelectionListener(e -> {
						    if (!e.getValueIsAdjusting()) {
						        int selectedRow = table_3.getSelectedRow();
						        if (selectedRow >= 0) {
						            try {
						                cursoSeleccionado = new Curso();
						                
						                // Configuración básica del curso
						                cursoSeleccionado.setIdCurso(Integer.parseInt(table_3.getValueAt(selectedRow, 0).toString()));
						                cursoSeleccionado.setTipo(table_3.getValueAt(selectedRow, 1).toString());
						                
						                // Horario
						                cursoSeleccionado.setHorario(Time.valueOf(table_3.getValueAt(selectedRow, 2).toString()));
						                
						                // Nivel
						                cursoSeleccionado.setNivel(Nivel.obtenerPorNombre(table_3.getValueAt(selectedRow, 3).toString()));
						                
						                // Precio y plazas
						                cursoSeleccionado.setPrecio(Float.parseFloat(table_3.getValueAt(selectedRow, 4).toString()));
						                cursoSeleccionado.setPlazas(Integer.parseInt(table_3.getValueAt(selectedRow, 5).toString()));
						                
						                // Conversión segura de fechas a java.sql.Date
						                Object fechaInicioValue = table_3.getValueAt(selectedRow, 6);
						                Object fechaFinValue = table_3.getValueAt(selectedRow, 7);
						                
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
						                cursoSeleccionado.setIdProfesor(Integer.parseInt(table_3.getValueAt(selectedRow, 8).toString()));
						                
						                // Habilitar botones
						                btnApuntarse.setVisible(true);
						                
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

						btnApuntarse = new JButton("Apuntarse");
						btnApuntarse.setFont(new Font("Arial Black", Font.PLAIN, 16));
						btnApuntarse.setBounds(408, 465, 136, 21);
						btnApuntarse.addActionListener(this);
						panel3.add(btnApuntarse);

						agregarBotonCerrarSesion(panel3);
						tabbedPane.addTab("Información de Bailarines", null, panel3, "Datos de los Bailarines");

						tabbedPane.setSelectedIndex(2);
					}
				} else {
					  // Credenciales incorrectas para bailarín
		            JOptionPane.showMessageDialog(this, "DNI o correo incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
				}
			} catch (LoginException e) {
				
				e.printStackTrace();
			}
			

		} else if (passwordChars.length == 1) {

			 try {
				p = Principal.leerId(String.valueOf(passwordChars));
			} catch (LoginException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (p != null && String.valueOf(passwordChars).equals(String.valueOf(p.getId()))
					&& textUsuario.getText().equalsIgnoreCase(p.getCorreo())) {

				JOptionPane.showMessageDialog(this, "Bienvenido, " + p.getNombre(), "Acceso concedido",
						JOptionPane.INFORMATION_MESSAGE);

				tabbedPane.setEnabledAt(1, false);

				if (!existePestana("Información de Profesores")) {
					JPanel panel4 = new JPanel() {
						private Image backgroundImage = new ImageIcon(
								getClass().getResource("/imagenes/CodeAndDance.png")).getImage();

						@Override
						protected void paintComponent(Graphics g) {
							super.paintComponent(g);
							g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
						}
					};
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

					lblEmail = new JLabel("Correo:");
					lblEmail.setFont(new Font("Arial Black", Font.PLAIN, 14));
					lblEmail.setBounds(103, 228, 87, 18);
					panel4.add(lblEmail);

					lblFoto = new JLabel("");
					lblFoto.setBounds(683, 69, 201, 177);
					ImageIcon icon = new ImageIcon(getClass().getResource(p.getImagen()));
					Image imagen = icon.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(),
							Image.SCALE_SMOOTH);
					lblFoto.setIcon(new ImageIcon(imagen));
					panel4.add(lblFoto);

					textId = new JTextField();
					textId.setEditable(false);
					textId.setBounds(177, 71, 87, 19);
					panel4.add(textId);
					textId.setText(String.valueOf(p.getId()));
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

					// En la creación de la pestaña de profesores
					table = new JTable();
					JScrollPane scrollPane = new JScrollPane(table);
					scrollPane.setBounds(103, 305, 576, 161);
					panel4.add(scrollPane);

					// Configurar el modelo de tabla para cursos
					String[] columnNames = { "ID ", "Tipo", "Horario", "Nivel", "Precio", "Plazas","Fecha Inicio","Fecha Fin", "Id Profesor" };
					DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
						@Override
						public boolean isCellEditable(int row, int column) {
							return false; // Hacer que la tabla no sea editable directamente
						}
					};
					table.setModel(model);
					model.setRowCount(0);
					// ArrayList<Curso>cursos = Principal.obtenerCursosPorProfesor(p.getId());
				
					try {
						cursos = Principal.obtenerCursosPorProfesor(p.getId(), cursos);
					} catch (LoginException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					for (Curso curso : cursos) {
						model.addRow(new Object[] { curso.getIdCurso(), curso.getTipo(), curso.getHorario(),
								curso.getNivel(), curso.getPrecio(), curso.getPlazas(),curso.getFechaInicio(),curso.getFechaFin(), curso.getIdProfesor() });
					}

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
					                
					                // Habilitar botones
					                btnModificar_1.setEnabled(true);
					                btnEliminarCurso_1.setEnabled(true);
					                btnEliminarBailarin_1.setEnabled(true);
					                
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

					JSeparator separator = new JSeparator();
					separator.setBounds(10, 268, 902, 27);
					panel4.add(separator);

					JLabel lblTablaCursos = new JLabel("Cursos");
					lblTablaCursos.setFont(new Font("Arial Black", Font.PLAIN, 14));
					lblTablaCursos.setBounds(314, 277, 87, 18);
					panel4.add(lblTablaCursos);

					btnCrearCurso_1 = new JButton("Crear");
					btnCrearCurso_1.setFont(new Font("Arial Black", Font.PLAIN, 14));
					btnCrearCurso_1.addActionListener(this);
					btnCrearCurso_1.setBounds(689, 302, 195, 21);
					panel4.add(btnCrearCurso_1);

					btnModificar_1 = new JButton("Modificar");
					btnModificar_1.setFont(new Font("Arial Black", Font.PLAIN, 14));
					btnModificar_1.addActionListener(this);
					btnModificar_1.setBounds(689, 336, 195, 21);
					panel4.add(btnModificar_1);

					btnEliminarCurso_1 = new JButton("Eliminar");
					btnEliminarCurso_1.setFont(new Font("Arial Black", Font.PLAIN, 14));
					btnEliminarCurso_1.setBounds(689, 367, 195, 21);
					btnEliminarCurso_1.addActionListener(this);
					panel4.add(btnEliminarCurso_1);

					btnEliminarBailarin_1 = new JButton("Eliminar bailarín");
					btnEliminarBailarin_1.setFont(new Font("Arial Black", Font.PLAIN, 14));
					btnEliminarBailarin_1.setBounds(689, 398, 195, 21);
					panel4.add(btnEliminarBailarin_1);

					btnOcupacion_1 = new JButton("Consultar ocupación");
					btnOcupacion_1.setFont(new Font("Arial Black", Font.PLAIN, 14));
					btnOcupacion_1.setBounds(689, 429, 195, 21);
					panel4.add(btnOcupacion_1);

					agregarBotonCerrarSesion(panel4);
					tabbedPane.addTab("Información de Profesores", null, panel4, "Datos de los Profesores");
				}
				tabbedPane.setSelectedIndex(2);

			} else {
				// Credenciales incorrectas para profesor
	            JOptionPane.showMessageDialog(this, "ID o correo incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
			}

		}else {
			// Longitud de contraseña inválida (ni 1 ni 9 caracteres)
	        JOptionPane.showMessageDialog(this, "Credenciales inválidas", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void modificar() {
		ModificarCurso mod = new ModificarCurso(cursoSeleccionado, true);
		mod.setVisible(true);
		actualizarTablaCursosPorProfesor(p.getId());
		
		
	}

	private void crear() {
		CrearCurso crear = new CrearCurso(cursoSeleccionado, true, p);
		crear.setVisible(true);
		actualizarTablaCursosPorProfesor(p.getId());
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
