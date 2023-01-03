import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.sql.*;
import java.text.SimpleDateFormat;

import javax.swing.*;

public class DataEntryForms {

	private JFrame frame;
	private JTable table;
	private JTextField jtextRefNo;
	private JTextField jtextFirstname;
	private JTextField jtextSurname;
	private JTextField jtextAddress;
	private JTextField jtextTelephone;
	private JTextField jtextPostCode;

	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	DefaultTableModel model = new DefaultTableModel();

	/**
	 * Launch the application.
	 */

	public void updateTable() {
		conn = DataEntryClass.ConnectDB();
		if (conn != null) {
			String sql = "Select  RefNo,Firstname,Surname, Address,Telephone,Registration Date,"
					+ " ProveofID,Date,MemberType,MemberFee,PostCode from dataform";
			try {
				pst = conn.prepareStatement(sql);
				rs = pst.executeQuery();
				Object[] coulmnData = new Object[11];
				while (rs.next()) {
					coulmnData[0] = rs.getString("RefNo");
					coulmnData[1] = rs.getString("Firstname");
					coulmnData[2] = rs.getString("Surname");
					coulmnData[3] = rs.getString("Address");
					coulmnData[4] = rs.getString("Telephone");
					coulmnData[5] = rs.getString("ResistrationDtae");
					coulmnData[6] = rs.getString("ProveofID");
					coulmnData[7] = rs.getString("Date");
					coulmnData[8] = rs.getString("MemberType");
					coulmnData[9] = rs.getString("MemberFee");
					coulmnData[10] = rs.getString("PostCode");
					model.addRow(coulmnData);

				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DataEntryForms window = new DataEntryForms();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DataEntryForms() {
		initialize();

		Object coll[] = { " RefNo", "Firstname", "Surname", "Address", " Telephone", "RegistrationDate ", " ProveofID",
				" Date", "MemberType", "MemberFee", " PostCode" };
		model.setColumnIdentifiers(coll);
		table.setModel(model);
		conn = DataEntryClass.ConnectDB();

		updateTable();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1460, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 11, 1350, 212);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Reference No");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 11, 136, 37);
		panel.add(lblNewLabel);

		jtextRefNo = new JTextField();
		jtextRefNo.setFont(new Font("Tahoma", Font.BOLD, 18));
		jtextRefNo.setBounds(172, 11, 274, 37);
		panel.add(jtextRefNo);
		jtextRefNo.setColumns(10);

		jtextFirstname = new JTextField();
		jtextFirstname.setFont(new Font("Tahoma", Font.BOLD, 18));
		jtextFirstname.setColumns(10);
		jtextFirstname.setBounds(172, 59, 274, 37);
		panel.add(jtextFirstname);

		JLabel lblFirstname = new JLabel("Firstname");
		lblFirstname.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblFirstname.setBounds(10, 63, 136, 37);
		panel.add(lblFirstname);

		jtextSurname = new JTextField();
		jtextSurname.setFont(new Font("Tahoma", Font.BOLD, 18));
		jtextSurname.setColumns(10);
		jtextSurname.setBounds(172, 114, 274, 37);
		panel.add(jtextSurname);

		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSurname.setBounds(10, 114, 136, 37);
		panel.add(lblSurname);

		jtextAddress = new JTextField();
		jtextAddress.setFont(new Font("Tahoma", Font.BOLD, 18));
		jtextAddress.setColumns(10);
		jtextAddress.setBounds(172, 162, 776, 37);
		panel.add(jtextAddress);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAddress.setBounds(10, 162, 136, 37);
		panel.add(lblAddress);

		JLabel lblTelephone = new JLabel("Telephone");
		lblTelephone.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTelephone.setBounds(495, 11, 136, 37);
		panel.add(lblTelephone);

		jtextTelephone = new JTextField();
		jtextTelephone.setFont(new Font("Tahoma", Font.BOLD, 18));
		jtextTelephone.setColumns(10);
		jtextTelephone.setBounds(674, 11, 274, 37);
		panel.add(jtextTelephone);

		JLabel lblRegistrationDate = new JLabel("Registration Date");
		lblRegistrationDate.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblRegistrationDate.setBounds(495, 59, 169, 37);
		panel.add(lblRegistrationDate);

		JLabel lblProveOfId = new JLabel("Prove of ID");
		lblProveOfId.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblProveOfId.setBounds(495, 114, 136, 37);
		panel.add(lblProveOfId);

		JDateChooser jDateChooser1 = new JDateChooser();
		jDateChooser1.setBounds(674, 59, 274, 37);
		panel.add(jDateChooser1);

		JComboBox jtextProve = new JComboBox();
		jtextProve.setFont(new Font("Tahoma", Font.BOLD, 18));
		jtextProve.setModel(new DefaultComboBoxModel(
				new String[] { "Select Prove of ID", "Pilot Licence", "Driving Licence", "Student ID", "Pasorrt" }));
		jtextProve.setBounds(675, 119, 274, 32);
		panel.add(jtextProve);

		JLabel lblDate = new JLabel(" Date");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDate.setBounds(988, 11, 128, 37);
		panel.add(lblDate);

		JDateChooser jDateChooser2 = new JDateChooser();
		jDateChooser2.setBounds(1126, 11, 204, 37);
		panel.add(jDateChooser2);

		JComboBox jtextMemberType = new JComboBox();
		jtextMemberType.setFont(new Font("Tahoma", Font.BOLD, 18));
		jtextMemberType.setModel(new DefaultComboBoxModel(
				new String[] { "Select Membership Type", "Annual", "Quarterly", "Monthly", "Weekly" }));
		jtextMemberType.setBounds(1126, 64, 204, 32);
		panel.add(jtextMemberType);

		JLabel lblMemberType = new JLabel("Member Type");
		lblMemberType.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMemberType.setBounds(988, 59, 128, 37);
		panel.add(lblMemberType);

		JComboBox jtextMemberFee = new JComboBox();
		jtextMemberFee.setFont(new Font("Tahoma", Font.BOLD, 18));
		jtextMemberFee.setModel(
				new DefaultComboBoxModel(new String[] { "Select Member Fee", "200$", "150$", "100$", "50$" }));
		jtextMemberFee.setBounds(1126, 119, 204, 32);
		panel.add(jtextMemberFee);

		JLabel lblMemberFee = new JLabel("Member Fee");
		lblMemberFee.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMemberFee.setBounds(988, 114, 128, 37);
		panel.add(lblMemberFee);

		JLabel lblPostcode = new JLabel("PostCode");
		lblPostcode.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPostcode.setBounds(988, 162, 128, 37);
		panel.add(lblPostcode);

		jtextPostCode = new JTextField();
		jtextPostCode.setFont(new Font("Tahoma", Font.BOLD, 18));
		jtextPostCode.setColumns(10);
		jtextPostCode.setBounds(1126, 162, 204, 37);
		panel.add(jtextPostCode);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(10, 233, 1350, 68);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JButton btnAddNew = new JButton("Add  New");
		btnAddNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				SimpleDateFormat Dformat = new SimpleDateFormat("dd-MM-yyyy");
				String sql = "INSERT INTO dataform(RefNo,Firstname,Surname, Address,Telephone,RegistrationDate,"
						+ " ProveofID,Date,MemberType,MemberFee,PostCode)VALUES(?,?,?,?,?,?,?,?,?,?,?)";

				try {
					pst = conn.prepareStatement(sql);
					pst.setString(1, jtextRefNo.getText());
					pst.setString(2, jtextFirstname.getText());
					pst.setString(3, jtextSurname.getText());
					pst.setString(4, jtextAddress.getText());
					pst.setString(5, jtextTelephone.getText());
					pst.setString(6, Dformat.format(jDateChooser1.getDate()));
					pst.setString(7, (String) jtextProve.getSelectedItem());
					pst.setString(6, Dformat.format(jDateChooser2.getDate()));
					pst.setString(7, (String) jtextMemberType.getSelectedItem());
					pst.setString(7, (String) jtextMemberFee.getSelectedItem());
					pst.setString(11, jtextPostCode.getText());

					pst.execute();
					rs.close();
					pst.close();
				}

				catch (Exception ev) {
					JOptionPane.showMessageDialog(null, "System Update Imcomplate");

				}

				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] { jtextRefNo.getText(), jtextFirstname.getText(), jtextSurname.getText(),
						jtextAddress.getText(), jtextTelephone.getText(), jDateChooser1.getDate(),
						jtextProve.getSelectedItem(), jDateChooser2.getDate(), jtextMemberType.getSelectedItem(),
						jtextMemberFee.getSelectedItem(), jtextPostCode.getText(),

				});
				if (table.getSelectedRow() == -1) {
					if (table.getRowCount() == 0) {
						JOptionPane.showMessageDialog(null, "Data Entry Form update", "Data Entry Form",
								JOptionPane.OK_OPTION);
					}

				}

			}
		});
		btnAddNew.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAddNew.setBounds(10, 11, 210, 40);
		panel_1.add(btnAddNew);

		JButton btnUpdate = new JButton("Udate");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				updateTable();

				DefaultTableModel iModel = (DefaultTableModel) table.getModel();
				if (table.getSelectedRow() == -1) {
					if (table.getRowCount() == 0) {
						JOptionPane.showMessageDialog(null, "Data Entry Form update confirmed", "Data Entry System",
								JOptionPane.OK_OPTION);
					}

				}

			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnUpdate.setBounds(230, 11, 210, 40);
		panel_1.add(btnUpdate);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel mod = (DefaultTableModel) table.getModel();
				if (table.getSelectedRow() == -1) {
					if (table.getRowCount() == 0) {
						JOptionPane.showMessageDialog(null, "No Data to delete", "Data Entry Form",
								JOptionPane.OK_OPTION);
					} else {
						JOptionPane.showMessageDialog(null, "Select a row to delete", "Data Entry From",
								JOptionPane.OK_OPTION);

					}
				} else {
					mod.removeRow(table.getSelectedRowCount());
				}

			}

		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDelete.setBounds(450, 11, 210, 40);
		panel_1.add(btnDelete);

		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					table.print();
				} catch (java.awt.print.PrinterException ev) {
					System.err.format("No Printer found".concat(ev.getMessage()));
				}
			}

		});
		btnPrint.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnPrint.setBounds(670, 11, 210, 40);
		panel_1.add(btnPrint);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					jtextRefNo.setText(null);
					jtextFirstname.setText(null);
					jtextSurname.setText(null);
					jtextAddress.setText(null);
					jtextTelephone.setText(null);
					jDateChooser1.setDate(null);
					jtextProve.setSelectedIndex(0);
					jDateChooser2.setDate(null);
					jtextMemberType.setSelectedIndex(0);
					jtextMemberFee.setSelectedIndex(0);
					jtextPostCode.setText(null);
				} catch (Exception ev) {
					JOptionPane.showMessageDialog(null, ev);
				}

			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnReset.setBounds(890, 11, 210, 40);
		panel_1.add(btnReset);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frame, "Cnfirm if you want to exit", "Data Entry From",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}

			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnExit.setBounds(1110, 11, 210, 40);
		panel_1.add(btnExit);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBounds(10, 312, 1350, 354);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 7, 1340, 322);
		panel_2.add(scrollPane);

		table = new JTable();
		table.setToolTipText("");
		table.setFont(new Font("Tahoma", Font.PLAIN, 11));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "   RefNo", "   Firstname", "   Surname", "   Address", "  Telephone",
						"   Registration Date ", "     Prove of ID", "  Date", "  Member Type",
						"       Member Fee", "   Post Code" }));
		scrollPane.setViewportView(table);
	}
}
