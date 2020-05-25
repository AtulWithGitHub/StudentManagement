package com.parth.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.parth.db.DatabaseConnector;


public class Registration extends JPanel {
	
	ArrayList<String> errorMsgs;
	
	JTextField txtFirstName;
	JTextField txtLastName;
	JTextField txtAddress1;
	JTextField txtAddress2;
	JTextField txtCity;
	JTextField txtState;
	//JTextField txtCountry;
	JComboBox txtCountry;
	JTextField txtZipCode;
	JTextField txteMail;
	JTextField txtPhone;

	JTextField txtUserName;
	//JTextField txtPassword;
	JPasswordField txtPassword;
	JTextField txtSecurityQue1;
	JTextField txtSecurityAns1;
	JTextField txtSecurityQue2;
	JTextField txtSecurityAns2;
	
	JButton btnSubmit;
	JButton btnClear;
	
	public Registration() {
		super();
		
		errorMsgs = new ArrayList<String>();
		txtFirstName = new JTextField(25);
		txtLastName = new JTextField(25);
		txtAddress1 = new JTextField(25);
		txtAddress2 = new JTextField(25);
		txtCity = new JTextField(25);
		txtState = new JTextField(25);
		//txtCountry = new JTextField(25);
		txtCountry = new JComboBox();
		txtCountry.addItem("NONE");
		txtCountry.addItem("India");
		txtZipCode = new JTextField(25);
		txteMail = new JTextField(25);
		txtPhone = new JTextField(25);

		txtUserName = new JTextField(25);
		txtPassword = new JPasswordField(25);
		txtSecurityQue1 = new JTextField(25);
		txtSecurityAns1 = new JTextField(25);
		txtSecurityQue2 = new JTextField(25);
		txtSecurityAns2 = new JTextField(25);
		
		btnSubmit = new JButton("Submit");
		btnClear = new JButton("Clear");
	}
	
	public void createPanel() {
		
		//GridBagLayout gridBag = new GridBagLayout();
        //GridBagConstraints gridBagC = new GridBagConstraints();
        
        //setLayout(gridBag);
		
		GridLayout gridLayout = new GridLayout(17,2);
		setLayout(gridLayout);
        
		add(new JLabel("First Name: "));
		add(txtFirstName);
		add(new JLabel("Last Name: "));
		add(txtLastName);
		add(new JLabel("Address1: "));
		add(txtAddress1);
		add(new JLabel("Address2: "));
		add(txtAddress2);
		add(new JLabel("City: "));
		add(txtCity);
		add(new JLabel("State: "));
		add(txtState);
		add(new JLabel("Country: "));
		add(txtCountry);
		add(new JLabel("ZipCode: "));
		add(txtZipCode);
		add(new JLabel("eMail: "));
		add(txteMail);
		add(new JLabel("Phone No: "));
		add(txtPhone);
		add(new JLabel("UserName: "));
		add(txtUserName);
		add(new JLabel("Password: "));
		add(txtPassword);
		add(new JLabel("Security Question 1:"));
		add(txtSecurityQue1);
		add(new JLabel("Security Answer 1: "));
		add(txtSecurityAns1);
		add(new JLabel("Security Question 2: "));
		add(txtSecurityQue2);
		add(new JLabel("Security Answer 2: "));
		add(txtSecurityAns2);
		
		add(btnClear);
		add(btnSubmit);
		
		ButtonActionListener btnActionListener = new ButtonActionListener();
		btnClear.addActionListener(btnActionListener);
		btnSubmit.addActionListener(btnActionListener);
	}

	public boolean validateFields() {
		
		boolean flag = true;
		
		errorMsgs.clear();
		
		if(txtFirstName.getText().length() <= 0) {
			flag = false;
			errorMsgs.add("Please provide First Name");
		}
		if(txtLastName.getText().length() <= 0) {
			flag = false;
			errorMsgs.add("Please provide Last Name");
		}
		//Parth will complete remaining fields
		if(txtAddress1.getText().length() <= 0) {
			flag = false;
			errorMsgs.add("Please provide Address 1");
		}
		if(txtAddress2.getText().length() <= 0) {
			flag = false;
			errorMsgs.add("Please provide Address 2");
		}
		if(txtCity.getText().length() <= 0) {
			flag = false;
			errorMsgs.add("Please provide City");
		}
		if(txtState.getText().length() <= 0) {
			flag = false;
			errorMsgs.add("Please provide State");
		}
		if(((String)txtCountry.getSelectedItem()).length() <= 0) {
			flag = false;
			errorMsgs.add("Please provide Country");
		}
		if(txtZipCode.getText().length() <= 0 && txtZipCode.getText().length() > 7) {
			flag = false;
			errorMsgs.add("Please provide valid Zipcode");
		}
		if(txteMail.getText().length() <= 0) {
			flag = false;
			errorMsgs.add("Please provide Email");
		}
		if(txtPhone.getText().length() <= 0) {
			flag = false;
			errorMsgs.add("Please provide valid Phone number");
		} else if(txtPhone.getText().length() >= 11 && txtPhone.getText().length() < 10) {
			flag = false;
			errorMsgs.add("Please provide valid Phone number");
			
		}
		if(txtUserName.getText().length() <= 0) {
			flag = false;
			errorMsgs.add("Please provide Username");
		}
		if(txtPassword.getText().length() <= 0) {
			flag = false;
			errorMsgs.add("Please provide Password");
		}
		if(txtSecurityQue1.getText().length() <= 0) {
			flag = false;
			errorMsgs.add("Please provide Security Question 1");
		}
		if(txtSecurityAns1.getText().length() <= 0) {
			flag = false;
			errorMsgs.add("Please provide Security Answer 1");
		}
		if(txtSecurityQue2.getText().length() <= 0) {
			flag = false;
			errorMsgs.add("Please provide Security Question 2");
		}
		if(txtSecurityAns2.getText().length() <= 0) {
			flag = false;
			errorMsgs.add("Please provide Security Answer 2");
		}
		
		
		
		return flag;
	}
	public class ButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if(e.getSource() == btnClear) {
				System.out.println("Clear Button clicked");
				txtFirstName.setText("");
				txtLastName.setText("");
				txtAddress1.setText("");
				txtAddress2.setText("");
				txtCity.setText("");
				txtState.setText("");
				txtCountry.setSelectedIndex(0);
				txtZipCode.setText("");
				txteMail.setText("");
				txtPhone.setText("");
				txtUserName.setText("");
				txtPassword.setText("");    
				txtSecurityQue1.setText("");
				txtSecurityAns1.setText("");
				txtSecurityQue2.setText("");
				txtSecurityAns2.setText("");
				//Parth will complete remaining clearing of text fields
				
				
			} else if (e.getSource() == btnSubmit) {
				//System.out.println("Submit Button Clicked");
				//System.out.println("FIrst Name = "+txtFirstName.getText());
				if(validateFields()) {
					
					System.out.println("Fields validated, call DB insert");
					DatabaseConnector dbConnect = new DatabaseConnector();
					Connection insertConnection = dbConnect.getConnection();
					/*try {
						Statement insertStatement = insertConnection.createStatement();
						
						String query = "insert into userdetail(`FirstName`,`LastName`,`UserName`) values('"+txtFirstName.getText()+"','"+txtLastName.getText()+"','"+txtUserName.getText()+"')";
						System.out.println("Executing Query: "+query);
						boolean status = insertStatement.execute(query);
						System.out.println("Inser happened in DB with status: "+ status);
					} catch(SQLException sqlException) {
						sqlException.printStackTrace();
					}*/
					
					try {
						String sqlQuery = "INSERT INTO `userdetail`(`UserName`, `FirstName`, `LastName`, `Address`, `Email`, `Phone`, `Password`, `SecurityQue1`, `SecurityAns1`, `SecurityQue2`, `SecurityAns2`, `LoginFlag`, `Address1`, `Address2`, `City`, `State`, `Country`, `ZipCode`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
						PreparedStatement insertStatement = insertConnection.prepareStatement(sqlQuery);
						
						insertStatement.setString(1, txtUserName.getText());
						insertStatement.setString(2, txtFirstName.getText());
						insertStatement.setString(3, txtLastName.getText());
						insertStatement.setString(4, "This is Address");
						insertStatement.setString(5, txteMail.getText());
						insertStatement.setString(6, txtPhone.getText());
						insertStatement.setString(7, txtPassword.getText());
						insertStatement.setString(8, txtSecurityQue1.getText());
						insertStatement.setString(9, txtSecurityAns1.getText());
						insertStatement.setString(10, txtSecurityQue2.getText());
						insertStatement.setString(11, txtSecurityAns2.getText());
						insertStatement.setString(12, "N");
						insertStatement.setString(13, txtAddress1.getText());
						insertStatement.setString(14, txtAddress2.getText());
						insertStatement.setString(15, txtCity.getText());
						insertStatement.setString(16, txtState.getText());
						insertStatement.setString(17, (String)txtCountry.getSelectedItem());
						insertStatement.setString(18, txtZipCode.getText());
						
						insertStatement.execute();
					} catch(Exception e1) {
						e1.printStackTrace();
					}
					//String sql = "insert into data(`email`,`username`,`password`) values('"+temail.getText()+"','"+tname.getText()+"','"+tpass.getText()+"')";
					// int i = stmt.executeUpdate(sql);		
					
					dbConnect.closeConnection();
							
							
				} else {
					System.out.println("Please provide value");
					JDialog errorDialog = new JDialog();
					errorDialog.setTitle("Error Occured");
					errorDialog.setLayout(new GridLayout(10,1));
					for(int count=0; count < errorMsgs.size(); count++) {
						
						errorDialog.add(new JLabel(errorMsgs.get(count)));
					}
					
					errorDialog.setSize(300, 150);
					errorDialog.setLocation(850, 400);
					errorDialog.setVisible(true);
					
				}
				
			}
		}
		
		
	}
}
