//***********************************************************
//* HelpMenuActionListener.java Created By Kian Gorgichuk   *
//* Copyright (c) 2014 Kian Gorgichuk. All rights reserved. *
//***********************************************************
package menu;

//Imports
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Kian
 */

//Action Listener Class that is called when the Help JMenu is invoked.
public class HelpMenuActionListener implements ActionListener {
    @Override    
    public void actionPerformed(ActionEvent a)
    {	
        //Create Text Information for Dialog
        String info = "<html>" + 
                "<b>Directions:</b><br>" +
                "1. Select Whether the Objects Fuse or Link Together.<br>" +
                "2. Enter the Mass in Kilograms for Mass A and Mass B:<br>" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- Must be positive.<br>" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- Cannot be Zero.<br>" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- Scientific Notation is Supported. (ex: 12e5 or -12e-5)<br>" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- Other Characters are Not Supported. (ex: abc#@!) <br>" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- Note: If the Objects Fuse Together After Collison, <br>" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; the Masses of the Objects Can Be Determined <br>" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Using the Formula: Final Mass = Mass A + Mass B <br>" +
                "3. Select Which Vector to Solve Using the Button Next to the Object Name:<br>" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- This Will Cause the Textboxes to Become Grayed<br>" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Out Under the Selected Object.<br>" +
                "4. Enter the Velocity for All of the Other Objects in m/s:<br>" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- Must be positive or Zero.<br>" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- Scientific Notation is Supported. (ex: 12e5 or -12e-5)<br>" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- Other Characters are Not Supported. (ex: abc#@!) <br>" +
                "5. Enter the Direction for All of the Other Objects:<br>" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- Direction must be in Degrees.<br>" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- Scientific Notation is Supported. (ex: 12e5 or -12e-5)<br>" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- Other Characters are Not Supported. (ex: abc#@!) <br>" +
                "6. Press \"Calculate Answer.\"<br><br>" +
                "</html>";
        JLabel infoLabel = new JLabel(info);
        infoLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        //Create Panel for Dialog
        JPanel infoPanel = new JPanel();
        infoPanel.add(infoLabel);
        //Create Buttons for Message Dialog
        String[] infoBtn = {"OK"};
        //Display Message
        JOptionPane.showOptionDialog(null, infoPanel, "Help", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, infoBtn, infoBtn[0]);
    }
}
