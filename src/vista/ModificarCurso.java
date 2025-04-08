package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Principal;
import modelo.Curso;
import modelo.Nivel;
import modelo.Profesor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.security.auth.login.LoginException;
import javax.swing.DefaultComboBoxModel;

public class ModificarCurso extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField textoIDCurso;
	private JTextField textoTipo;
	private JTextField textoHorario;
	private JTextField textoPrecio;
	private JTextField textoPlaza;
	private JTextField textoIDProfesor;
	private JComboBox comboBox;
	private JButton btnModificarCurso;
	private Curso cu = null;

	/**
	 * Create the dialog.
	 * 
	 * @author Luis
	 */
	public ModificarCurso(Curso cursoSeleccionado, boolean b) {
		setFont(new Font("Arial Black", Font.PLAIN, 12));
		setModal(b);
		if (cursoSeleccionado != null) {
			cu = cursoSeleccionado;
		}

		JPanel contentPanel = new JPanel() {

			Image backgroundImage = new ImageIcon(getClass().getResource("/imagenes/CodeAndDance.png")).getImage();

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
			};
		};
		setBounds(100, 100, 710, 515);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblIDCurso = new JLabel("ID Curso:");
		lblIDCurso.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblIDCurso.setBounds(115, 61, 90, 26);
		contentPanel.add(lblIDCurso);

		textoIDCurso = new JTextField();
		textoIDCurso.setEditable(false);
		textoIDCurso.setBounds(202, 61, 112, 26);
		contentPanel.add(textoIDCurso);
		textoIDCurso.setColumns(10);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblTipo.setBounds(145, 113, 52, 26);
		contentPanel.add(lblTipo);

		JLabel lblHorario = new JLabel("Horario:");
		lblHorario.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblHorario.setBounds(122, 164, 75, 26);
		contentPanel.add(lblHorario);

		JLabel lblNivel = new JLabel("Nivel:");
		lblNivel.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblNivel.setBounds(145, 209, 52, 26);
		contentPanel.add(lblNivel);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblPrecio.setBounds(130, 255, 75, 26);
		contentPanel.add(lblPrecio);

		JLabel lblPlaza = new JLabel("Plaza:");
		lblPlaza.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblPlaza.setBounds(130, 307, 64, 26);
		contentPanel.add(lblPlaza);

		JLabel lblIDProfesor = new JLabel("ID Profesor:");
		lblIDProfesor.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblIDProfesor.setBounds(93, 343, 112, 26);
		contentPanel.add(lblIDProfesor);

		textoTipo = new JTextField();
		textoTipo.setColumns(10);
		textoTipo.setBounds(202, 113, 112, 26);
		contentPanel.add(textoTipo);

		textoHorario = new JTextField();
		textoHorario.setColumns(10);
		textoHorario.setBounds(202, 164, 112, 26);
		contentPanel.add(textoHorario);

		textoPrecio = new JTextField();
		textoPrecio.setColumns(10);
		textoPrecio.setBounds(202, 255, 112, 26);
		contentPanel.add(textoPrecio);

		textoPlaza = new JTextField();
		textoPlaza.setColumns(10);
		textoPlaza.setBounds(202, 307, 112, 26);
		contentPanel.add(textoPlaza);

		textoIDProfesor = new JTextField();
		textoIDProfesor.setEditable(false);
		textoIDProfesor.setColumns(10);
		textoIDProfesor.setBounds(202, 347, 112, 26);
		contentPanel.add(textoIDProfesor);

		btnModificarCurso = new JButton("Modificar Curso");
		btnModificarCurso.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnModificarCurso.setBounds(403, 184, 205, 51);
		// Añadimos la animación de hover directamente en el botón
		btnModificarCurso.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        new Thread(() -> {
		            for (int i = 205; i <= 250; i += 2) { // Aumentar tamaño
		                btnModificarCurso.setBounds(403 - (i - 205) / 2, 184 - (i - 205) / 4, i, 51);
		                try { Thread.sleep(10); } catch (InterruptedException ex) {}
		            }
		        }).start();
		    }
		    @Override
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        new Thread(() -> {
		            for (int i = 250; i >= 205; i -= 2) { // Volver al tamaño original
		                btnModificarCurso.setBounds(403 - (i - 205) / 2, 184 - (i - 205) / 4, i, 51);
		                try { Thread.sleep(10); } catch (InterruptedException ex) {}
		            }
		        }).start();
		    }
		});

		btnModificarCurso.addActionListener(this);
		contentPanel.add(btnModificarCurso);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "PRINCIPIANTE", "MEDIO", "AVANZADO" }));
		comboBox.setBounds(202, 209, 112, 27);
		contentPanel.add(comboBox);

		cargaDatos(cu);
	}

	private void cargaDatos(Curso cursoSeleccionado) {
		textoIDCurso.setText(String.valueOf(cursoSeleccionado.getIdCurso()));
		textoTipo.setText(cursoSeleccionado.getTipo());
		textoHorario.setText(String.valueOf(cursoSeleccionado.getHorario()));
		textoPrecio.setText(String.valueOf(cursoSeleccionado.getPrecio()));
		textoPlaza.setText(String.valueOf(cursoSeleccionado.getPlazas()));
		textoIDProfesor.setText(String.valueOf(cursoSeleccionado.getIdProfesor()));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnModificarCurso)) {
			modificar();
		}

	}

	private void modificar() {
		Curso cu2 = new Curso();

		cu2.setIdCurso(Integer.valueOf(textoIDCurso.getText()));
		cu2.setTipo(textoTipo.getText());
		cu2.setHorario(Time.valueOf(textoHorario.getText()));
		cu2.setNivel(Nivel.obtenerPorNombre(String.valueOf(comboBox.getSelectedItem())));
		cu2.setPrecio(Float.valueOf(textoPrecio.getText()));
		cu2.setPlazas(Integer.valueOf(textoPlaza.getText()));
		cu2.setIdProfesor(Integer.valueOf(textoIDProfesor.getText()));
		
		try {
			Principal.modificarCurso(cu2);
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.dispose();
	}
}
