package vista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import modelo.Curso;
import modelo.Profesor;

public class CrearCurso extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel crearCurso = new JPanel();
	private JTextField textFieldNivel;
	private JLabel lblPrecio;
	private JTextField textFieldPrecio;
	private JLabel lblPlazas;
	private JTextField textFieldPlazas;
	private JLabel lblIdProfesor;
	private JTextField textFieldIDProfesor;
	private JTextField textFieldID;
	private JLabel lblTipo;
	private JTextField textFieldTipo;
	private JLabel lblHorario;
	private JTextField textFieldHorario;
	private JLabel lblNivel;
	private JButton btnCrear;

	/**
	 * Create the dialog.
	 */
	public CrearCurso(Curso c, boolean b, Profesor p) {
		setModal(b);
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

		textFieldID = new JTextField();
		textFieldID.setEditable(false);
		textFieldID.setBounds(181, 30, 148, 27);
		crearCurso.add(textFieldID);
		textFieldID.setColumns(10);

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

		textFieldNivel = new JTextField();
		textFieldNivel.setColumns(10);
		textFieldNivel.setBounds(181, 163, 148, 27);
		crearCurso.add(textFieldNivel);

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
		
		
		//Cargar ID's
		cargarDatos(c.getIdCurso(), p.getId());
	}

	private void cargarDatos(int idP, int idC) {
		textFieldID.setText(String.valueOf(idC));
		textFieldIDProfesor.setText(String.valueOf(idP));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnCrear)) {
			crearCurso();
		}
		
	}

	private void crearCurso() {
		
		
	}

}
