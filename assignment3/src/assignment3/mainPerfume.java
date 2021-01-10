package assignment3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class mainPerfume {

	private JFrame frame;
	private JTextField name;
	private JTextField type;
	private JTextField brand;
	private JTable table;
	
	int row;
	ArrayList<customer> customerList;
	DefaultTableModel dtm;
	String header[]= new String[]{"Customer Name","Phone","Type Of Perfume","Perfume Brand"};
	private JTextField phn;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainPerfume window = new mainPerfume();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void displayStudentDetails(){
		dtm.setRowCount(0);
		for(int i=0; i<customerList.size();i++){
			Object[] obj={customerList.get(i).name,customerList.get(i).phn,customerList.get(i).type,customerList.get(i).brand};
			dtm.addRow(obj);
		}
	}

	/**
	 * Create the application.
	 */
	public mainPerfume() {
		initialize();
		customerList=new ArrayList<>();
		dtm=new DefaultTableModel(header,0);
		table.setModel(dtm);
		
		phn = new JTextField();
		phn.setColumns(10);
		phn.setBounds(190, 220, 111, 20);
		frame.getContentPane().add(phn);
		
		JLabel lblNewLabel_4 = new JLabel("Perfume Order System");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Constantia", Font.BOLD, 27));
		lblNewLabel_4.setBackground(Color.PINK);
		lblNewLabel_4.setBounds(0, 43, 383, 58);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Order Now!");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		lblNewLabel_4_1.setBackground(Color.PINK);
		lblNewLabel_4_1.setBounds(0, 110, 383, 58);
		frame.getContentPane().add(lblNewLabel_4_1);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(245, 222, 179));
		frame.setBounds(100, 100, 1079, 546);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCustomerName = new JLabel("Customer Name");
		lblCustomerName.setForeground(new Color(0, 0, 0));
		lblCustomerName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblCustomerName.setBounds(29, 179, 102, 26);
		frame.getContentPane().add(lblCustomerName);
		
		name = new JTextField();
		name.setBounds(190, 183, 111, 20);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setForeground(new Color(0, 0, 0));
		lblPhone.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPhone.setBounds(29, 216, 102, 26);
		frame.getContentPane().add(lblPhone);
		
		JLabel lblType = new JLabel("Type Of Perfume");
		lblType.setForeground(new Color(0, 0, 0));
		lblType.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblType.setBounds(29, 253, 151, 26);
		frame.getContentPane().add(lblType);
		
		type = new JTextField();
		type.setColumns(10);
		type.setBounds(190, 257, 111, 20);
		frame.getContentPane().add(type);
		
		JLabel lblBrand = new JLabel("Perfume Brand");
		lblBrand.setForeground(new Color(0, 0, 0));
		lblBrand.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblBrand.setBounds(29, 296, 102, 26);
		frame.getContentPane().add(lblBrand);
		
		brand = new JTextField();
		brand.setColumns(10);
		brand.setBounds(190, 300, 111, 20);
		frame.getContentPane().add(brand);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				customer data=new customer(name.getText(),phn.getText(),type.getText(),brand.getText());
				customerList.add(data);
				displayStudentDetails();
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAdd.setBounds(10, 400, 164, 46);
		frame.getContentPane().add(btnAdd);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice=JOptionPane.showConfirmDialog(null, "Delete this data ?", "Delete",JOptionPane.YES_NO_OPTION);
				if(choice==0){
					dtm.removeRow(row);
					customerList.remove(row);
					displayStudentDetails();
				}
				
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDelete.setBounds(612, 400, 196, 46);
		frame.getContentPane().add(btnDelete);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customerList.get(row).name=name.getText();
				customerList.get(row).phn=phn.getText();
				customerList.get(row).type=type.getText();
				customerList.get(row).brand=brand.getText();
				displayStudentDetails();
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnUpdate.setBounds(219, 400, 164, 46);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnRefresh = new JButton("REFRESH");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				name.setText("");
				phn.setText("");
				type.setText("");
				brand.setText("");
			}
		});
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRefresh.setBounds(820, 400, 196, 46);
		frame.getContentPane().add(btnRefresh);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(370, 36, 646, 339);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				row=table.getSelectedRow();
				
				name.setText(dtm.getValueAt(row, 0).toString());
				phn.setText(dtm.getValueAt(row, 1).toString());
				type.setText(dtm.getValueAt(row, 2).toString());
				brand.setText(dtm.getValueAt(row, 3).toString());
				
			}
		});
		scrollPane.setViewportView(table);
	}
}