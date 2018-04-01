/*public class CrudDemo {
	public static void main(String[] args) {
		
		ModelStudent student = new ModelStudent("1023254381", "201520094001", "Jesus Liberio", 16, "Finanzas");
		
		//Controller
		ControllerStudent controller = new ControllerStudent();
		//Save student throught the controller
		controller.register(student);
		//See students
		controller.showStudents();
		//Student update by Age
		student.setId("1018257927");
		student.setName("Jarlan Moreco");
		controller.update(student);
		//See updates
		controller.showStudents();
		//Delete Student by Age
		student.setId("1018257927");
		controller.delete(student);
	}	
}*/

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;


public class CrudDemo {

	private JFrame frame;
	private JTextField txtNombre;
	private JTextField txtCdula;
	private JTextField txtEdad;
	private JTextField txtCdigo;
	private JTextField txtCarrera;
	private JButton btnCrear;
	private JLabel lblId;
	private JLabel lblEdad;
	private JLabel lblCdula;
	private JLabel lblCarrera;
	private JTextPane txtpnStudent;
	private JTable table;
	private JButton btnEliminar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrudDemo window = new CrudDemo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public CrudDemo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		frame.setBounds(100, 100, 650, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(12, 33, 70, 15);
		frame.getContentPane().add(lblNombre);
		
		txtNombre = new JTextField();
		lblNombre.setLabelFor(txtNombre);
		txtNombre.setBounds(72, 33, 114, 19);
		frame.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		lblEdad = new JLabel("Edad");
		lblEdad.setBounds(12, 177, 70, 15);
		frame.getContentPane().add(lblEdad);
		
		txtEdad = new JTextField();
		lblEdad.setLabelFor(txtEdad);
		txtEdad.setBounds(72, 177, 114, 19);
		frame.getContentPane().add(txtEdad);
		txtEdad.setColumns(10);
		
		lblCdula = new JLabel("Cédula");
		lblCdula.setBounds(12, 132, 70, 15);
		frame.getContentPane().add(lblCdula);
		
		txtCdula = new JTextField();
		lblCdula.setLabelFor(txtCdula);
		txtCdula.setBounds(72, 132, 114, 19);
		frame.getContentPane().add(txtCdula);
		txtCdula.setColumns(10);
		
		lblId = new JLabel("Código");
		lblId.setBounds(12, 84, 70, 15);
		frame.getContentPane().add(lblId);
		
		txtCdigo = new JTextField();
		lblId.setLabelFor(txtCdigo);
		txtCdigo.setBounds(72, 84, 114, 19);
		frame.getContentPane().add(txtCdigo);
		txtCdigo.setColumns(10);
		
		lblCarrera = new JLabel("Carrera");
		lblCarrera.setBounds(12, 225, 70, 15);
		frame.getContentPane().add(lblCarrera);
		
		txtCarrera = new JTextField();
		lblCarrera.setLabelFor(txtCarrera);
		txtCarrera.setHorizontalAlignment(SwingConstants.LEFT);
		txtCarrera.setBounds(72, 225, 114, 19);
		frame.getContentPane().add(txtCarrera);
		txtCarrera.setColumns(10);
		
		btnCrear = new JButton("Crear");
		btnCrear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtpnStudent.setText("Hi Jose");
				
				if(txtNombre.getText() != "" && txtCdula.getText() != "" && txtEdad.getText() != "" && 
						txtCdigo.getText() != "" && txtCarrera.getText() != ""){
					String codigo = txtCdigo.getText();
					String nombre = txtNombre.getText();
					String id = txtCdula.getText();
					int edad = Integer.parseInt(txtEdad.getText());
					String carrera = txtCarrera.getText();
					
					txtpnStudent.setText("Hi " + nombre + ",\n" + "Codigo: " + codigo + "\n" 
					+ "ID: " + id + "\n" + "Edad: " + edad + "\n" + "Carrera: " + carrera);
					
					ModelStudent student = new ModelStudent(id, codigo, nombre, edad, carrera);
					ControllerStudent controller = new ControllerStudent();
					controller.register(student);
					
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.addRow(new Object[]{codigo, nombre, id, edad, carrera});
				}
			}
		});
		btnCrear.setBounds(259, 223, 135, 22);
		frame.getContentPane().add(btnCrear);
		
		txtpnStudent = new JTextPane();
		txtpnStudent.setEditable(false);
		txtpnStudent.setText("Student");
		txtpnStudent.setBounds(215, 35, 248, 178);
		frame.getContentPane().add(txtpnStudent);
		
		ControllerStudent controller = new ControllerStudent();
		List<ModelStudent> students = new ArrayList<ModelStudent>();
		IStudentDao dao = new ImplStudentDao();
		students = dao.getStudent();
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nombre", "Cedula", "Edad", "Carrera"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		if (students.size() > 0){
		
			DefaultTableModel model = (DefaultTableModel) table.getModel();
		
			for (final ModelStudent student : students) {
				model.addRow(new Object[]{student.getId(), student.getName(), student.getCode(), student.getAge(), student.getCareer()});
			}
		}
		
		
		table.setBounds(41, 305, 539, 108);
		frame.getContentPane().add(table);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				String cedula = (String) table.getValueAt(table.getSelectedRow(), 0);
				String name = JOptionPane.showInputDialog(table.getValueAt(table.getSelectedRow(), 1));
				String cod = JOptionPane.showInputDialog(table.getValueAt(table.getSelectedRow(), 2));
				String edad = JOptionPane.showInputDialog(table.getValueAt(table.getSelectedRow(), 3));
				String carrera = JOptionPane.showInputDialog(table.getValueAt(table.getSelectedRow(), 4));
				
				table.getModel().setValueAt(name, table.getSelectedRow(), 1);
				table.getModel().setValueAt(cedula, table.getSelectedRow(), 2);
				table.getModel().setValueAt(edad, table.getSelectedRow(), 3);
				table.getModel().setValueAt(carrera, table.getSelectedRow(), 4);
				
				int newAge = Integer.parseInt(edad);
				
				ModelStudent student = new ModelStudent(cedula, cod, name, newAge, carrera);
				
				ControllerStudent controller = new ControllerStudent();
				
				controller.update(student);
			}
		});
		btnActualizar.setBounds(41, 481, 117, 25);
		frame.getContentPane().add(btnActualizar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				String cedula = (String) table.getValueAt(table.getSelectedRow(), 0);
				String name = (String) table.getValueAt(table.getSelectedRow(), 1);
				String cod = (String) table.getValueAt(table.getSelectedRow(), 2);
				int edad = (Integer) table.getValueAt(table.getSelectedRow(), 3);
				String carrera = (String) table.getValueAt(table.getSelectedRow(), 4);
				
				ModelStudent student = new ModelStudent(cedula, cod, name, edad, carrera);
				
				ControllerStudent controller = new ControllerStudent();
				controller.delete(student);
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.removeRow(table.getSelectedRow());
				
			}
		});
		btnEliminar.setBounds(194, 481, 117, 25);
		frame.getContentPane().add(btnEliminar);
	}
}
