package com.parth.ui;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
public class SampleMenu extends JFrame implements WindowListener, ActionListener{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static SampleMenu mainFrameObj;
    
    JMenuBar menuBar;
    JMenu menu1;
    JMenu menu2;
    JMenu menu3;
    
    JMenuItem menuItem1;
    JMenuItem menuItem2;
    JMenuItem menuItem3;
    
    JPanel mainPanel;
    JPanel loginPanel;
    JPanel regPanel;
    public SampleMenu() {
        
        mainPanel = new JPanel();
        loginPanel = new JPanel();
        regPanel = new JPanel();
        
        menuBar = new JMenuBar();
        menu1 = new JMenu("Login");
        menu2 = new JMenu("Attendance");
        menu3 = new JMenu("Schedule");
        
        menuItem1 = new JMenuItem("Login");
        menuItem2 = new JMenuItem("Register");
        menuItem3 = new JMenuItem("Logout");
        
        menuItem1.addActionListener(this);
        menuItem2.addActionListener(this);
        menuItem3.addActionListener(this);
        
        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);
        
        menu1.add(menuItem1);
        menu1.add(menuItem2);
        menu1.add(menuItem3);
        add(menuBar,BorderLayout.NORTH);
        
        mainPanel = new JPanel();
        mainPanel.add(new JLabel("Student Management System"));
        
        loginPanel = new JPanel();
        loginPanel.add(new JLabel("Login Page"));
        
        regPanel = new JPanel();
        regPanel.add(new JLabel("Registration Page"));
        
        add(mainPanel,BorderLayout.CENTER);
        
        setSize(500,500);
        setLocation(400,100);
        setVisible(true);
        addWindowListener(this);
    }
    
    public static void main(String[] args) {
        mainFrameObj = new SampleMenu();
    }
public void windowOpened(WindowEvent e) {
        // TODO Auto-generated method stub
        
    }
    public void windowClosing(WindowEvent e) {
        System.exit(0);
        
    }
    public void windowClosed(WindowEvent e) {
        // TODO Auto-generated method stub
        
    }

    public void windowIconified(WindowEvent e) {
        // TODO Auto-generated method stub
        
    }
    public void windowDeiconified(WindowEvent e) {
        // TODO Auto-generated method stub
        
    }
    public void windowActivated(WindowEvent e) {
        // TODO Auto-generated method stub
        
    }
    public void windowDeactivated(WindowEvent e) {
        // TODO Auto-generated method stub
        
    }
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == menuItem1) {
            System.out.println("load Login Page");
            mainFrameObj.remove(mainPanel);
            mainFrameObj.add(loginPanel, BorderLayout.CENTER);
            mainFrameObj.setSize(501,500);
            
        } else if(e.getSource() == menuItem2) {
            System.out.println("load Registration Page");
            mainFrameObj.remove(mainPanel);
            mainFrameObj.add(regPanel, BorderLayout.CENTER);
            mainFrameObj.setSize(500,501);
            
        } else if(e.getSource() == menuItem3) {
            System.out.println("load Logout Page");
            System.exit(0);
        }
        
    }
}

