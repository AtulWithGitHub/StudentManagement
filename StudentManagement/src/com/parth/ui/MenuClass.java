package com.parth.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.parth.ui.MainFrame.MenuActionListener;

public class MenuClass extends JMenuBar{


	private static final long serialVersionUID = 1L;
	JMenu loginMenu;
	JMenuItem loginMenuItem;
	JMenuItem regMenuItem;
	
	public MenuClass() {
		
		loginMenu = new JMenu("Login");
		loginMenuItem = new JMenuItem("Login");
		regMenuItem = new JMenuItem("Registration");
		
		loginMenu.add(loginMenuItem);
		loginMenu.add(regMenuItem);
		
		MenuActionListener listenerObj = new MenuActionListener();
		regMenuItem.addActionListener(listenerObj);
		
		add(loginMenu);
	}
	public class MenuActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			System.out.println(e.getSource());
			
			JMenu obj = (JMenu)e.getSource();
			
		}
		
	}

}
