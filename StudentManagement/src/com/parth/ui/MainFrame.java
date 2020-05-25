package com.parth.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	JMenuBar menuBar;
	JMenu loginMenu;
	JMenuItem loginMenuItem;
	JMenuItem regMenuItem;
	
	public MainFrame() {
		super("Student Management");
		
		menuBar = new JMenuBar();
		loginMenu = new JMenu("Login");
		loginMenuItem = new JMenuItem("Login");
		regMenuItem = new JMenuItem("Registration");
		
		loginMenu.add(loginMenuItem);
		loginMenu.add(regMenuItem);
		menuBar.add(loginMenu);
		
		MenuActionListener listenerObj = new MenuActionListener();
		regMenuItem.addActionListener(listenerObj);
		
		setLayout(new BorderLayout());
	    add(menuBar, BorderLayout.NORTH);
		
		Registration reg = new Registration();
		
		reg.createPanel();
		
		add(reg);
		
		
		setSize(500, 500);
		setLocation(800, 300);
		setVisible(true);
	}
	
	public class MenuActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			System.out.println(e.getSource());
			if(e.getSource() == regMenuItem) {
				
			}
			
			
		}
		
	}

}
