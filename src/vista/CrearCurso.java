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
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		crearCurso.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(crearCurso, BorderLayout.CENTER);
		crearCurso.setLayout(null);

		JLabel lblIDCurso = new JLabel("ID Curso");
		lblIDCurso.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblIDCurso.setBounds(33, 38, 75, 13);
		crearCurso.add(lblIDCurso);

		textFieldID = new JTextField();
		textFieldID.setEditable(false);
		textFieldID.setBounds(118, 38, 129, 19);
		crearCurso.add(textFieldID);
		textFieldID.setColumns(10);

		lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblTipo.setBounds(53, 67, 45, 19);
		crearCurso.add(lblTipo);

		textFieldTipo = new JTextField();
		textFieldTipo.setColumns(10);
		textFieldTipo.setBounds(118, 70, 129, 19);
		crearCurso.add(textFieldTipo);

		lblHorario = new JLabel("Horario");
		lblHorario.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblHorario.setBounds(33, 99, 75, 19);
		crearCurso.add(lblHorario);

		textFieldHorario = new JTextField();
		textFieldHorario.setColumns(10);
		textFieldHorario.setBounds(118, 102, 129, 19);
		crearCurso.add(textFieldHorario);

		lblNivel = new JLabel("Nivel");
		lblNivel.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblNivel.setBounds(45, 131, 75, 19);
		crearCurso.add(lblNivel);

		textFieldNivel = new JTextField();
		textFieldNivel.setColumns(10);
		textFieldNivel.setBounds(118, 134, 129, 19);
		crearCurso.add(textFieldNivel);

		lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblPrecio.setBounds(45, 163, 75, 19);
		crearCurso.add(lblPrecio);

		textFieldPrecio = new JTextField();
		textFieldPrecio.setColumns(10);
		textFieldPrecio.setBounds(118, 166, 129, 19);
		crearCurso.add(textFieldPrecio);

		lblPlazas = new JLabel("Plazas");
		lblPlazas.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblPlazas.setBounds(45, 195, 75, 19);
		crearCurso.add(lblPlazas);

		textFieldPlazas = new JTextField();
		textFieldPlazas.setColumns(10);
		textFieldPlazas.setBounds(118, 198, 129, 19);
		crearCurso.add(textFieldPlazas);

		lblIdProfesor = new JLabel("ID Profesor");
		lblIdProfesor.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblIdProfesor.setBounds(10, 234, 110, 19);
		crearCurso.add(lblIdProfesor);

		textFieldIDProfesor = new JTextField();
		textFieldIDProfesor.setEditable(false);
		textFieldIDProfesor.setColumns(10);
		textFieldIDProfesor.setBounds(118, 234, 129, 19);
		crearCurso.add(textFieldIDProfesor);

		JButton btnCrear = new JButton("Crear Curso");
		btnCrear.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnCrear.setBounds(262, 115, 164, 35);
		crearCurso.add(btnCrear);
	}

}
