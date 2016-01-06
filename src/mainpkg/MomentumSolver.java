//***********************************************************
//* MomentumSolver.java Created By Kian Gorgichuk           *
//* Copyright (c) 2014 Kian Gorgichuk. All rights reserved. *
//***********************************************************

package mainpkg;

//Imports
import menu.AboutListenerMac;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
/**
 *
 * @author Kian
 */
public class MomentumSolver {
    
    //Custom Variables
    boolean _isMacOS;
    
    //MenuBar Variables for Dialog
    JMenuBar _menuBar = null;
    JMenu _infoMenu = null;
    JMenuItem _aboutItem = null;
    JMenuItem _helpItem = null;
    
    //Main code for controlling subJFrames of GUI 
    public MomentumSolver() {
        //Check if the system is Mac OS X
        String osName = System.getProperty("os.name").toLowerCase();
	_isMacOS = osName.contains("os x");
        
        //Initalize MenuBar
        initMenuBar();
        
        //Loop forever until System.exit(0); is called
        while(true) {
            
            //Create Main Menu JFrame
            JFrame optionsFrame = new JFrame("2D Momentum Solver - Main Menu");
            //Set Static MenuBar to JFrame
            optionsFrame.setJMenuBar(_menuBar);
            
            //Option Panel - Is Objects Fused?
            Object[] buttons = {"Yes", "No", "Exit" };
            JOptionPane optionPane = new JOptionPane("After Collision Do the Two Objects Fuse or Link Together?", JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION, null, buttons, buttons[1]);
            
            //Setup Image Icon - Windows Only
            ImageIcon img = new ImageIcon(getClass().getResource("icon.png"));
            optionsFrame.setIconImage(img.getImage());
            
            //Set Arritubes of Frame
            optionsFrame.setContentPane(optionPane); //Add optionPane to Frame
            optionsFrame.pack();
            optionsFrame.setResizable(false);
            optionsFrame.setLocationRelativeTo(null);
            optionsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            optionsFrame.setVisible(true);
            
            //Pull String Value from OptionPane
            String userValue;
            do
            {
                //Pull in User Value
                userValue = (String)optionPane.getValue();
                 //Wait in order to reduce proccessing 
                 try { Thread.sleep(50); }
                 catch (InterruptedException ex) 
                 { 
                     JOptionPane.showMessageDialog(null, ex.toString(), "Error!",  JOptionPane.ERROR_MESSAGE);
		     System.err.println(ex.toString()); 
		} //Show Pop-up Alert and Print Out Error to Console
            } while (userValue.equals("uninitializedValue")); //Check if user clicked button
            
            //Remove JFrame from application memory
            optionsFrame.dispose();
        
            //Display different GUI Based on dialog answer
            switch(userValue){
                case "Yes": { 
                    //Create New Instance of GUI - Fused
                     MomentumSolverFuseGUI MFuseSolve = new MomentumSolverFuseGUI();
                     MFuseSolve.setVisible(true);

                     //Check to See When GUI is Disabled
                     while(MFuseSolve.isVisible()) {
                         //Wait in order to reduce proccessing 
                         try { Thread.sleep(200); }
                          catch (InterruptedException ex) 
                          { 
                              JOptionPane.showMessageDialog(null, ex.toString(), "Error!",  JOptionPane.ERROR_MESSAGE);
                              System.err.println(ex.toString()); 
                          } //Show Pop-up Alert and Print Out Error to Console
                     }

                     //Remove GUI from application memory
                     MFuseSolve.dispose();
                     break;
                }
                case "No": {
                    //Create New Instance of GUI - Not Fused
                    MomentumSolverGUI MSolve = new MomentumSolverGUI();
                    MSolve.setVisible(true);

                    //Check to See When GUI is Disabled
                    while(MSolve.isVisible()) {
                        //Wait in order to reduce proccessing 
                        try { Thread.sleep(200); }
                        catch (InterruptedException ex) 
                        {
                            JOptionPane.showMessageDialog(null, ex.toString(), "Error!",  JOptionPane.ERROR_MESSAGE);
                            System.err.println(ex.toString()); 
                        } //Show Pop-up Alert and Print Out Error to Consol
                     }

                    //Remove GUI from application memory
                    MSolve.dispose();
                    break;
                }
                case "Exit": {
                    //Exit is called - terminate the application
                    System.exit(0);
                }
                default: System.exit(0); //Terminate the Application as Dialog answer is Invalid
            }
        }
    }
    //Initalize the Menu
    private void initMenuBar() {
        _menuBar = new JMenuBar();
        if(_isMacOS) //Mac Specific Setup
        {
           //Setup Menus
           _infoMenu = new JMenu("Information");
           _helpItem = new JMenuItem("Help");
           _infoMenu.add(_helpItem);
           _menuBar.add(_infoMenu);
           
           //Change Look & Feel for Popups
           try{ UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); }
           catch(ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) 
           { 
               JOptionPane.showMessageDialog(null, ex.toString(), "Error!",  JOptionPane.ERROR_MESSAGE);
               System.err.println(ex.toString()); 
           } //Show Pop-up Alert and Print Out Error to Console
           
           //Wire Up About Item
            try 
            {
                //Must be done using reflection otherwise will crash and not compile on other systems
                // See http://stackoverflow.com/questions/7256230/in-order-to-macify-a-java-app-to-catch-the-about-event-do-i-have-to-implement for more details
                //Pull Application Class
                Object thisApp = Class.forName("com.apple.eawt.Application").getMethod("getApplication",(Class[]) null).invoke(null, (Object[]) null);

                //Create a Instance of About Listener (Using Proxies)
                Object handleInstance = Proxy.newProxyInstance(Class.forName("com.apple.eawt.AboutHandler").getClassLoader(), new Class[] { Class.forName("com.apple.eawt.AboutHandler") }, new menu.AboutListenerMac());

                //Set Instance to Application Class
                thisApp.getClass().getMethod("setAboutHandler", new Class[] { Class.forName("com.apple.eawt.AboutHandler") }).invoke(thisApp, new Object[] { handleInstance });
            }
            catch(ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException ex) 
            { 
                JOptionPane.showMessageDialog(null, ex.toString(), "Error!",  JOptionPane.ERROR_MESSAGE);
		System.err.println(ex.toString()); 
            } //Show Pop-up Alert and Print Out Error to Console
     }
     else //Setup for All Other Operating Systems
            {
                //Change Look & Feel
                try{ UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); }
                catch(ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) 
                { 
                    JOptionPane.showMessageDialog(null, ex.toString(), "Error!",  JOptionPane.ERROR_MESSAGE);
                    System.err.println(ex.toString()); 
		} //Show Pop-up Alert and Print Out Error to Console
                
                //Setup Menus
                _infoMenu = new JMenu("Information");
                _aboutItem = new JMenuItem("About");
                _helpItem = new JMenuItem("Help");
                _infoMenu.add(_aboutItem);
                _infoMenu.add(_helpItem);
                _menuBar.add(_infoMenu);
                
                //Wire Up About Item
                _aboutItem.addActionListener( new menu.AboutMenuActionListener());
            }
        
            //Wire Up Help Item - System Independent
            _helpItem.addActionListener( new menu.HelpMenuActionListener());
        }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         //Check if the system is Mac OS X
        String osName = System.getProperty("os.name").toLowerCase();
        boolean isMacOS = osName.contains("os x");
        //Check to See if Menu Bar Must be Moved
        if(isMacOS)
        {
            System.setProperty("apple.laf.useScreenMenuBar", "true");
        }
     
        //Launch Main Code
        MomentumSolver mainProgram = new MomentumSolver();
    }
}