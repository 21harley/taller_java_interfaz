
package Evaluacion;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Equipos extends JInternalFrame {
    private JTextField nombre,codigo;
    private JButton crear,buscar,guardar,eliminar,editar;
    DefaultTableModel contenedor;
    private JTable tablePro;
    private ArrayList<Equipo> listaEquipo = new ArrayList<Equipo>();
    private int equipo;
    private Resultados r;
    
    public Equipos(){
        super("lista de Equipos",true,true,true,true);
        setSize(480,440);
        
        inicio();
        eventos();
        setVisible(true);
    }
    
    public void inicio(){
        nombre = new JTextField();
        codigo= new JTextField();
        r=null;
        crear= new JButton("REGISTRAR");
        guardar= new JButton("G.PARTIDOS");
        eliminar= new JButton("ELIMINAR");
        editar= new JButton("EDITAR");
        
        contenedor = new DefaultTableModel();
        tablePro= new JTable(contenedor);
        tablePro.getTableHeader().setReorderingAllowed(false);
        
        JPanel panel = new JPanel(new GridLayout(2,2));
        JPanel panel2 = new JPanel(new GridLayout(1,1));
        JPanel panel3 = new JPanel(new GridLayout(2,2));
        
        panel.add(new JLabel("Nombre: "));
        panel.add(nombre);
        
        panel.add(new JLabel("Codigo: "));
        panel.add(codigo);
        
        
        panel2.add(new JScrollPane(tablePro));
        
        contenedor.addColumn("nombre");
        contenedor.addColumn("codigo");
        
        panel3.add(crear,BorderLayout.CENTER);
        panel3.add(eliminar,BorderLayout.CENTER);
        panel3.add(guardar,BorderLayout.CENTER);
        panel3.add(editar,BorderLayout.CENTER);
        
                
        add(panel,BorderLayout.NORTH);
        add(panel2,BorderLayout.CENTER);
        add(panel3,BorderLayout.SOUTH);
        
        panel3.add(crear,BorderLayout.CENTER);
        
        //-------------BLQUEAR LOS BOTONES-----------
        guardar.setEnabled(false);//bloquea el boton
        eliminar.setEnabled(false);
        editar.setEnabled(false);
        
    }
  
   
    public void eventos(){
        
        crear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(nombre.getText().length()>0&&codigo.getText().length()>0){
                    int res=0;
                    for(int i=0;i<listaEquipo.size();i++){
                        if(nombre.getText().equals(listaEquipo.get(i).getNombre())){
                            res=1; break;
                        }
                    }
                    if(res!=1){
                        DefaultTableModel modelo = (DefaultTableModel) tablePro.getModel();
                        
                        Object [] fila=new Object[2];
                        fila[0]=nombre.getText();
                        fila[1]=codigo.getText();
                        modelo.addRow(fila);
                        
                        tablePro.setModel(modelo);
                        tablePro.getTableHeader().setReorderingAllowed(false);
                        tablePro.setEnabled(false);
                        tablePro.getTableHeader().setReorderingAllowed(false); 
                        listaEquipo.add(new Equipo(nombre.getText(),codigo.getText(),null));
                        nombre.setText("");
                        codigo.setText("");                    
                    }else{
                        nombre.setText("");
                        codigo.setText(""); 
                    }
                }
                if(listaEquipo.size()>1){
                    guardar.setEnabled(true);
                }else{
                    guardar.setEnabled(false);
                }
                if(listaEquipo.size()>0){
                    eliminar.setEnabled(true);
                    editar.setEnabled(true);
                }
                
                
            }
        });
        guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(r==null){
                    r=new Resultados(listaEquipo);
                }else if(!r.isVisible()){
                    r=new Resultados(listaEquipo);
                }
                
            }
        });
        eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(nombre.getText().length()>0&&codigo.getText().length()>0){
                    int res=0,pos=0;
                    for(int i=0;i<listaEquipo.size();i++){
                        if(nombre.getText().equals(listaEquipo.get(i).getNombre())){
                            res=1; pos=i; break;
                        }
                    }
                    if(res==1){
                        listaEquipo.remove(pos);
                        DefaultTableModel modelo = (DefaultTableModel) tablePro.getModel();
                        modelo.removeRow(pos);
                        tablePro.setModel(modelo);
                        tablePro.getTableHeader().setReorderingAllowed(false);
                        tablePro.setEnabled(false);
                        nombre.setText("");
                        codigo.setText("");                    
                    }else{
                        nombre.setText("");
                        codigo.setText(""); 
                    }
                }
                if(listaEquipo.size()>1){
                    guardar.setEnabled(true);
                }else{
                    guardar.setEnabled(false);
                }
                if(listaEquipo.size()>0){
                    eliminar.setEnabled(true);
                    editar.setEnabled(true);
                }else{
                    eliminar.setEnabled(false);
                    editar.setEnabled(false);                    
                }
            }
        });
        editar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(nombre.getText().length()>0&&codigo.getText().length()>0){
                    int res=0,pos=0;
                    for(int i=0;i<listaEquipo.size();i++){
                        if(codigo.getText().equals(listaEquipo.get(i).getCodigo())){
                            res=1; pos=i; break;
                        }
                    }
                    if(res==1){
                        listaEquipo.set(pos,new Equipo(nombre.getText(),codigo.getText(),null));
                        tablePro.setValueAt(nombre.getText(),pos,0);
                        tablePro.getTableHeader().setReorderingAllowed(false);
                        tablePro.setEnabled(false);
                        nombre.setText("");
                        codigo.setText("");                    
                    }else{
                        nombre.setText("");
                        codigo.setText(""); 
                    }
                }
                if(listaEquipo.size()>1){
                    guardar.setEnabled(true);
                }else{
                    guardar.setEnabled(false);
                }
                if(listaEquipo.size()>0){
                    eliminar.setEnabled(true);
                    editar.setEnabled(true);
                }else{
                    eliminar.setEnabled(false);
                    editar.setEnabled(false);                    
                }
            }
        });        
        /*
        mostrar resultados
        clientes.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               desktop.add(new Resultados());
               
           }
       });
        */
    }
    
    
}
