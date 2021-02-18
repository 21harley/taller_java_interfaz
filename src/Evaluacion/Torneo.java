
package Evaluacion;

import java.util.ArrayList;

public class Torneo {
    private ArrayList<Equipo> listaEquipo = new ArrayList<Equipo>();
    
    public Torneo(){
        this.listaEquipo=null;
    }
    
    public void agregar(Equipo e){
        this.listaEquipo.add(e);
    }
    public int eliminar(Equipo e){
        int res=-1;
      for(Equipo b:listaEquipo){
           res++;
            if(e.getNombre().equals(b.getNombre())){
                break;
            }
        }
        listaEquipo.remove(res);
        return res;
    }
    
    public int tam(){
        return listaEquipo.size();
    }
        
    public ArrayList<Equipo> getListaEquipo() {
        return listaEquipo;
    }

    public void setListaEquipo(ArrayList<Equipo> listaEquipo) {
        this.listaEquipo = listaEquipo;
    }
    
}
