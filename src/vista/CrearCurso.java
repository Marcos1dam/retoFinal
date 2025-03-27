package vista;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CrearCurso extends JDialog {

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CrearCurso dialog = new CrearCurso();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CrearCurso() {
		getContentPane().add(crearCurso, BorderLayout.NORTH);
		setBounds(100, 100, 584, 541);
		getContentPane().setLayout(new BorderLayout());
		crearCurso.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(crearCurso, BorderLayout.CENTER);
		crearCurso.setLayout(null);

		JLabel lblIDCurso = new JLabel("ID Curso");
		lblIDCurso.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblIDCurso.setBounds(68, 44, 75, 13);
		crearCurso.add(lblIDCurso);

		textFieldID = new JTextField();
		textFieldID.setEditable(false);
		textFieldID.setBounds(181, 30, 148, 27);
		crearCurso.add(textFieldID);
		textFieldID.setColumns(10);

		lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblTipo.setBounds(77, 81, 45, 19);
		crearCurso.add(lblTipo);

		textFieldTipo = new JTextField();
		textFieldTipo.setColumns(10);
		textFieldTipo.setBounds(181, 73, 148, 27);
		crearCurso.add(textFieldTipo);

		lblHorario = new JLabel("Horario");
		lblHorario.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblHorario.setBounds(68, 123, 75, 19);
		crearCurso.add(lblHorario);

		textFieldHorario = new JTextField();
		textFieldHorario.setColumns(10);
		textFieldHorario.setBounds(181, 115, 148, 27);
		crearCurso.add(textFieldHorario);

		lblNivel = new JLabel("Nivel");
		lblNivel.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblNivel.setBounds(68, 171, 75, 19);
		crearCurso.add(lblNivel);

		textFieldNivel = new JTextField();
		textFieldNivel.setColumns(10);
		textFieldNivel.setBounds(181, 163, 148, 27);
		crearCurso.add(textFieldNivel);

		lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblPrecio.setBounds(68, 213, 75, 19);
		crearCurso.add(lblPrecio);

		textFieldPrecio = new JTextField();
		textFieldPrecio.setColumns(10);
		textFieldPrecio.setBounds(181, 212, 148, 27);
		crearCurso.add(textFieldPrecio);

		lblPlazas = new JLabel("Plazas");
		lblPlazas.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblPlazas.setBounds(68, 264, 75, 19);
		crearCurso.add(lblPlazas);

		textFieldPlazas = new JTextField();
		textFieldPlazas.setColumns(10);
		textFieldPlazas.setBounds(181, 263, 148, 27);
		crearCurso.add(textFieldPlazas);

		lblIdProfesor = new JLabel("ID Profesor");
		lblIdProfesor.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblIdProfesor.setBounds(33, 313, 110, 19);
		crearCurso.add(lblIdProfesor);

		textFieldIDProfesor = new JTextField();
		textFieldIDProfesor.setEditable(false);
		textFieldIDProfesor.setColumns(10);
		textFieldIDProfesor.setBounds(181, 312, 148, 27);
		crearCurso.add(textFieldIDProfesor);

		JButton btnCrear = new JButton("Crear Curso");
		btnCrear.setFont(new Font("Arial Black", Font.PLAIN, 18));
		btnCrear.setBounds(134, 388, 198, 45);
		crearCurso.add(btnCrear);
	}

}
