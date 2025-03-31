package vista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controlador.Principal;
import modelo.Curso;
import modelo.Nivel;
import modelo.Profesor;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class CrearCurso extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblPrecio;
	private JTextField textFieldPrecio;
	private JLabel lblPlazas;
	private JTextField textFieldPlazas;
	private JLabel lblIdProfesor;
	private JTextField textFieldIDProfesor;
	private JTextField textFieldIDCurso;
	private JLabel lblTipo;
	private JTextField textFieldTipo;
	private JLabel lblHorario;
	private JTextField textFieldHorario;
	private JLabel lblNivel;
	private JButton btnCrear;
	private JComboBox comboBoxNivel;

	/**
	 * Create the dialog.
	 */
	public CrearCurso(Curso c, boolean b, Profesor p) {
		setModal(b);
		JPanel crearCurso = new JPanel() {
			Image backgroundImage = new ImageIcon(
					getClass().getResource("/imagenes/CodeAndDance.png")).getImage();
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
			};
		};
		getContentPane().add(crearCurso, BorderLayout.NORTH);
		setBounds(100, 100, 584, 541);
		getContentPane().setLayout(new BorderLayout());
		crearCurso.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(crearCurso, BorderLayout.CENTER);
		crearCurso.setLayout(null);


		JLabel lblIDCurso = new JLabel("ID Curso:");
		lblIDCurso.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblIDCurso.setBounds(68, 44, 86, 13);
		crearCurso.add(lblIDCurso);

		textFieldIDCurso = new JTextField();
		textFieldIDCurso.setEditable(false);
		textFieldIDCurso.setBounds(181, 30, 148, 27);
		crearCurso.add(textFieldIDCurso);
		textFieldIDCurso.setColumns(10);

		lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblTipo.setBounds(100, 74, 48, 19);
		crearCurso.add(lblTipo);

		textFieldTipo = new JTextField();
		textFieldTipo.setColumns(10);
		textFieldTipo.setBounds(181, 73, 148, 27);
		crearCurso.add(textFieldTipo);

		lblHorario = new JLabel("Horario:");
		lblHorario.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblHorario.setBounds(79, 116, 75, 19);
		crearCurso.add(lblHorario);

		textFieldHorario = new JTextField();
		textFieldHorario.setColumns(10);
		textFieldHorario.setBounds(181, 115, 148, 27);
		crearCurso.add(textFieldHorario);

		lblNivel = new JLabel("Nivel:");
		lblNivel.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblNivel.setBounds(96, 164, 58, 19);
		crearCurso.add(lblNivel);

		lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblPrecio.setBounds(79, 213, 75, 19);
		crearCurso.add(lblPrecio);

		textFieldPrecio = new JTextField();
		textFieldPrecio.setColumns(10);
		textFieldPrecio.setBounds(181, 212, 148, 27);
		crearCurso.add(textFieldPrecio);

		lblPlazas = new JLabel("Plazas:");
		lblPlazas.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblPlazas.setBounds(79, 264, 75, 19);
		crearCurso.add(lblPlazas);

		textFieldPlazas = new JTextField();
		textFieldPlazas.setColumns(10);
		textFieldPlazas.setBounds(181, 263, 148, 27);
		crearCurso.add(textFieldPlazas);

		lblIdProfesor = new JLabel("ID Profesor:");
		lblIdProfesor.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblIdProfesor.setBounds(44, 313, 110, 19);
		crearCurso.add(lblIdProfesor);

		textFieldIDProfesor = new JTextField();
		textFieldIDProfesor.setEditable(false);
		textFieldIDProfesor.setColumns(10);
		textFieldIDProfesor.setBounds(181, 312, 148, 27);
		crearCurso.add(textFieldIDProfesor);

		btnCrear = new JButton("Crear Curso");
		btnCrear.addActionListener(this);
		btnCrear.setFont(new Font("Arial Black", Font.PLAIN, 18));
		btnCrear.setBounds(134, 388, 221, 45);
		crearCurso.add(btnCrear);
		
		comboBoxNivel = new JComboBox();
		comboBoxNivel.setModel(new DefaultComboBoxModel(new String[] {"PRINCIPIANTE", "MEDIO", "AVANZADO"}));
		comboBoxNivel.setFont(new Font("Arial Black", Font.PLAIN, 10));
		comboBoxNivel.setBounds(181, 166, 148, 21);
		crearCurso.add(comboBoxNivel);

		// Cargar ID's
		cargarDatos(p.getId());
	}

	private void cargarDatos(int idP) {
		int idC = obtenerIdCurso();
		textFieldIDCurso.setText(String.valueOf(idC));
		textFieldIDProfesor.setText(String.valueOf(idP));
	}

	private int obtenerIdCurso() {
		ArrayList<Curso> cursos = Principal.obtenerTodosLosCursos();
		
		int id = 0;
		
		for (Curso cu : cursos) {
		if (cu.getIdCurso() > id) {
			id = cu.getIdCurso();
		}
	}
		
		return id + 1;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnCrear)) {
			crearCurso();
			this.dispose();
		}

	}

	private void crearCurso() {
		
		
		
			Curso c = new Curso();
			
			try {
				c.setIdCurso(Integer.valueOf(textFieldIDCurso.getText()));
				c.setHorario(Time.valueOf(textFieldHorario.getText()));
				c.setTipo(textFieldTipo.getText());
				c.setPrecio(Float.valueOf(textFieldPrecio.getText()));
				c.setPlazas(Integer.valueOf(textFieldPlazas.getText()));
				c.setNivel(Nivel.obtenerPorNombre(String.valueOf(comboBoxNivel.getSelectedItem())));
				c.setIdProfesor(Integer.valueOf(textFieldIDProfesor.getText()));
				Principal.crearCurso(c);
				
				
			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(this, "EL NIVEL solo puede ser: PRINCIPIANTE, MEDIO O AVANZADO.", "Error", JOptionPane.INFORMATION_MESSAGE);
				
			}
		
	

	}
}
