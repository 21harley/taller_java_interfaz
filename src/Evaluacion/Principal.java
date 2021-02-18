/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Evaluacion;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author olimpoç
 */
public class Principal extends JFrame{
    private JMenuBar menu;
    private JMenu file;
    private JMenuItem equipos  ,exit;
    private JDesktopPane desktop;
    
    public Principal (){
        super("Principal");
        setSize(500,500);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inicio();
        menu = new JMenuBar();
        file = new JMenu("Equipos");
        
        equipos = new JMenuItem("lista de equipos");
        exit = new JMenuItem("salir");
        
        desktop = new JDesktopPane();
        
        setJMenuBar(menu);//mostrar menu
        menu.add(file);

        file.add(equipos);
        file.add(exit);
        
        add(desktop);
        
        eventos();
        setVisible(true);
    }
    private void inicio(){
       
    }
    private void eventos(){
        ////cerrar ventana
       addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                System.exit(0);//finalizar aplicacion grafica
            }
        });
       exit.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               System.exit(0);//finalizar aplicacion grafica

        }
       });
       
       equipos.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               desktop.add(new Equipos());
        }
       });
       

    }

    
    
}
