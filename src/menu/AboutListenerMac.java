//***********************************************************
//* AboutListenerMac.java Created By Kian Gorgichuk         *
//* Copyright (c) 2014 Kian Gorgichuk. All rights reserved. *
//***********************************************************

package menu;

//Imports
import java.awt.Font;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

//Action Listener Class that is called when the Help JMenu is invoked on a Mac.
public class AboutListenerMac implements InvocationHandler {

    public Object invoke(Object proxy, Method method, Object[] args) {
    	
		//Create Text Information for Dialog
		String info = "<html><div style=\"text-align: center;\">" + 
                                "<font size=\"5\"><b>2D Momentum Solver</b></font><br><br>" +
                                "Version: 1.0.0<br><br>" +
                                "<b>Design, Programming, and Testing</b><br>" +
                                "<b>Done By Kian Gorgichuk</b><br><br>" +
                                "<b>Special Thanks to Ms. Bater!</b><br><br>" +
                                "Copyright (c) 2014 Kian Gorgichuk.<br>" + 
                                "All rights reserved.<br><br>" +
                                "Application Icon: \"Balance\" by Evonne (Flickr)<br>" +
                                "is licensed under CC Attribution 2.0" +
                                "</html>";
		JLabel aboutLabel = new JLabel(info);
		aboutLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		//Create Panel for Dialog
		JPanel aboutPanel = new JPanel();
		aboutPanel.add(aboutLabel);
		//Create Buttons for Message Dialog
		String[] aboutBtn = {"OK"};
		//Display Message
		JOptionPane.showOptionDialog(null, aboutPanel, "About", JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE, null, aboutBtn, aboutBtn[0]);
    	
        return null;
    }
}