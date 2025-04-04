package vista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import controlador.Principal;
import modelo.Bailarin;
import modelo.Curso;

public class ConsultarBailarinesCurso extends JDialog implements ActionListener {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private Bailarin bailarinSeleccionado = null;
    private JButton btnEliminar, btnCancelar;
    private ArrayList<Bailarin> bailarines;
    private JTable tableBailarines;
    private DefaultTableModel tableModel;
    private Curso curso;

    public ConsultarBailarinesCurso(PagInicio pagInicio, boolean modal, Curso cursoSeleccionado) {
        super(pagInicio);
        this.setModal(modal);
        this.curso = cursoSeleccionado;

        setBounds(100, 100, 500, 350);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JLabel lblTitulo = new JLabel("BAILARINES");
        lblTitulo.setFont(new Font("Arial Black", Font.PLAIN, 16));
        lblTitulo.setBounds(180, 10, 140, 25);
        contentPanel.add(lblTitulo);

        tableBailarines = new JTable();
        JScrollPane scrollPane = new JScrollPane(tableBailarines);
        scrollPane.setBounds(20, 50, 450, 200);
        contentPanel.add(scrollPane);

        String[] columnNames = {"DNI", "Nombre", "Apellido", "Fecha Nac.", "Teléfono", "Correo"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableBailarines.setModel(tableModel);
        
        btnEliminar = new JButton("ELIMINAR");
        btnEliminar.setBounds(80, 270, 100, 25);
        btnEliminar.addActionListener(this);
        btnEliminar.setVisible(false);
        contentPanel.add(btnEliminar);

        btnCancelar = new JButton("CANCELAR");
        btnCancelar.setBounds(280, 270, 100, 25);
        btnCancelar.addActionListener(this);
        contentPanel.add(btnCancelar);

        cargarTablaBailarines();

        tableBailarines.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tableBailarines.getSelectedRow() >= 0) {
                seleccionarBailarin(tableBailarines.getSelectedRow());
            }
        });
    }

    private void cargarTablaBailarines() {
        tableModel.setRowCount(0);
        bailarines = Principal.obtenerBailarinsDelCurso(curso.getIdCurso());
        for (Bailarin bai : bailarines) {
            tableModel.addRow(new Object[]{bai.getDni(), bai.getNombre(), bai.getApellido(),
                    bai.getFechaNacimiento(), bai.getTelefono(), bai.getCorreo()});
        }
    }

    private void seleccionarBailarin(int selectedRow) {
        bailarinSeleccionado = new Bailarin();
        bailarinSeleccionado.setDni(tableBailarines.getValueAt(selectedRow, 0).toString());
        bailarinSeleccionado.setNombre(tableBailarines.getValueAt(selectedRow, 1).toString());
        bailarinSeleccionado.setApellido(tableBailarines.getValueAt(selectedRow, 2).toString());
        
        String fechaStr = tableBailarines.getValueAt(selectedRow, 3).toString();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            bailarinSeleccionado.setFechaNacimiento(new java.sql.Date(sdf.parse(fechaStr).getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        bailarinSeleccionado.setTelefono(Integer.parseInt(tableBailarines.getValueAt(selectedRow, 4).toString()));
        bailarinSeleccionado.setCorreo(tableBailarines.getValueAt(selectedRow, 5).toString());
        btnEliminar.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnEliminar)) {
            eliminarBailarin();
        } else if (e.getSource().equals(btnCancelar)) {
            dispose();
        }
    }

    private void eliminarBailarin() {
        if (bailarinSeleccionado != null) {
            Principal.eliminarBailarin(bailarinSeleccionado, curso.getIdCurso());
            JOptionPane.showMessageDialog(this, "Alumno eliminado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona un alumno primero.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
}
