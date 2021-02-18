
package Evaluacion;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author olimpoç
 */
public class Resultados extends JFrame{
    DefaultTableModel contenedor;
    private int st=0;
    private JTable tableCli;
    private String datoColumna[][];
    private String titColumna[]={"Equipo","PJ","PG","PE","PP","GF","GC","Puntos"};
    
    public Resultados(ArrayList<Equipo> e){
        setSize(480,440);
        inicio(e);
        setVisible(true);
        eventos();
    }

    public void inicio(ArrayList<Equipo> e){
        for(int i=0;i<e.size();i++){
            e.get(i).limpiarPartidos();
        }
        JPanel panel = new JPanel(new GridLayout(5,2));
        JPanel panel2 = new JPanel(new GridLayout(1,1));
        JPanel panel3 = new JPanel(new GridLayout(2,1));
        int aux=0;
        int aux1=0;
        for(int i=0;i<e.size()-1;i++){
            for(int j=i;j<e.size()-1;j++){
               aux=(int) (Math.random() * 10) + 1;
               aux1=(int) (Math.random() * 10) + 1;
               if(aux>aux1){
                   e.get(i).addP(new Victoria(new String(aux+"-"+aux1),e.get(i).getNombre(),e.get(j+1).getNombre(),aux-aux1));
                   e.get(j+1).addP(new Derrota(new String(aux+"-"+aux1),e.get(i).getNombre(),e.get(j+1).getNombre(),aux-aux1));
               }else if(aux<aux1){
                   e.get(i).addP(new Derrota(new String(aux+"-"+aux1),e.get(i).getNombre(),e.get(j+1).getNombre(),aux1-aux));
                   e.get(j+1).addP(new Victoria(new String(aux+"-"+aux1),e.get(i).getNombre(),e.get(j+1).getNombre(),aux1-aux));                  
               }else{
                   e.get(i).addP(new Empate(new String(aux+"-"+aux1),e.get(i).getNombre(),e.get(j+1).getNombre()));
                   e.get(j+1).addP(new Empate(new String(aux+"-"+aux1),e.get(i).getNombre(),e.get(j+1).getNombre()));                    
               }                 
            }
        }
               
        datoColumna = new String[e.size()][8];
    
        for( int iY=0; iY < e.size(); iY++ ) {
            for( int iX=0; iX < 8; iX++ ) {
                switch(iX+1){
                case 1:
                    datoColumna[iY][iX] =e.get(iY).getNombre();
                break;
                case 2:
                    datoColumna[iY][iX] = String.valueOf(e.get(iY).partidoJ());
                break;
                case 3:
                    datoColumna[iY][iX] = String.valueOf(e.get(iY).partidoGa());
                break;
                case 4:
                    datoColumna[iY][iX] = String.valueOf(e.get(iY).partidoE());
                break;
                case 5:
                    datoColumna[iY][iX] = String.valueOf(e.get(iY).partidoP());
                break;
                case 6:
                    datoColumna[iY][iX] = String.valueOf(e.get(iY).golesAf());
                break;
                case 7:
                datoColumna[iY][iX] = String.valueOf(e.get(iY).golesEn());
                break;
                case 8:
                    datoColumna[iY][iX] = String.valueOf(e.get(iY).puntos());
                break;
                }
            }
        }
        DefaultTableModel modelo2=new DefaultTableModel(datoColumna,titColumna){
        public boolean isCellEditable(int rowIndex,int columnIndex){
                return false;
            }
        }; 
        tableCli = new JTable(modelo2);
        tableCli.getTableHeader().setReorderingAllowed(false);
        panel2.add(new JScrollPane(tableCli));
        add(panel,BorderLayout.NORTH);
        add(panel2,BorderLayout.CENTER);
        add(panel3,BorderLayout.SOUTH);
        int vSup=-1;
        int iSup=0;
        int inf=999;
        
        int vEm=0;
        int emp=0;
        for(int i=0;i<e.size();i++){
            if(e.get(i).puntos()>vSup){
                vSup=e.get(i).puntos(); iSup=i;
            } 
            if(e.get(i).puntos()<inf){
                inf=e.get(i).puntos();
            }
        }
        vEm=vSup;
        
        for(int i=0;i<e.size();i++){
            if(e.get(i).puntos()==vEm&&iSup!=i){
                emp++;
            } 
        }
        System.out.println(emp);
        if(emp==0){
         for(int i=0;i<e.size();i++){
            if(e.get(i).puntos()==vSup){
                JOptionPane.showMessageDialog(null, "Ganador:"+e.get(i).getNombre().toUpperCase());
            } 
          }           
        }else if(emp>0){
          int gF=-1,posG=0;  
          for(int i=0;i<e.size();i++){
            if(e.get(i).puntos()==vEm){
                if(e.get(i).golesAf()>gF){
                    gF=e.get(i).golesAf();posG=i;
                }
            } 
          }
          emp=gF;
           int gCon=0;
           ArrayList<Equipo> listaEquipoEmp = new ArrayList<Equipo>();
            for(int i=0;i<e.size();i++){
                if(e.get(i).golesAf()==emp){
                    gCon++;listaEquipoEmp.add(e.get(i));
                } 
            }
            if(gCon==1){
                JOptionPane.showMessageDialog(null, "Ganador:"+e.get(posG).getNombre().toUpperCase());
            }else{
                String ganadores="";
                for(int i=0;i<listaEquipoEmp.size();i++){
                    ganadores+="-"+listaEquipoEmp.get(i).getNombre().toUpperCase();
                }
                JOptionPane.showMessageDialog(null, "Ganadores:"+ganadores);
            }
        }
    }
    
    public void desbloquearEliminar(){

    }
    
    
   
    public void eventos(){
      addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){           
             
            }
        });
        
    }
    
}
