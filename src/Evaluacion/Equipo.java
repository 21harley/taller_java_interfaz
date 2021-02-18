
package Evaluacion;

import java.util.ArrayList;
import java.util.Objects;

public class Equipo {
    private String nombre;
    private String codigo;
    private ArrayList<Partido> listaPartidos = new ArrayList<Partido>();
    public Equipo(){
        this.nombre="";
        this.codigo="";
        this.listaPartidos=null;
    }
    public Equipo(String nombre,String codigo,ArrayList<Partido> listaPartidos){
        this.nombre=nombre;
        this.codigo=codigo;
        this.listaPartidos=listaPartidos;
    }
    public void limpiarPartidos(){
        listaPartidos=null;
    }
    public int tam(){
        return listaPartidos.size();
    }
    public void addP(Partido a){
        if(this.listaPartidos==null){
            listaPartidos = new ArrayList<Partido>();
        }
        listaPartidos.add(a);
    }
    public int partidoJ(){
        return listaPartidos.size();
    }
    public int puntos(){
        int res=0;
        for(int i=0;i<listaPartidos.size();i++){
            if(listaPartidos.get(i) instanceof Victoria){
               res+=3;
            }
            if(listaPartidos.get(i) instanceof Empate){
               res+=1;
            }
        }
        return res;
    }      
    public int partidoGa(){
        int res=0;
        for(int i=0;i<listaPartidos.size();i++){
            if(listaPartidos.get(i) instanceof Victoria){
               res++;
            }
        }
        return res;
    }
    public int partidoE(){
        int res=0;
        for(int i=0;i<listaPartidos.size();i++){
            if(listaPartidos.get(i) instanceof Empate){
               res++;
            }
        }
        return res;
    }
    public int partidoP(){
        int res=0;
        for(int i=0;i<listaPartidos.size();i++){
            if(listaPartidos.get(i) instanceof Derrota){
               res++;
            }
        }
        return res;
    }
    public int golesEn(){
        int res=0;
        for(int i=0;i<listaPartidos.size();i++){
            if(listaPartidos.get(i) instanceof Derrota){
               res+=listaPartidos.get(i).resultados();
            }
        }
        return res;
    }
    public int golesAf(){
        int res=0;
        for(int i=0;i<listaPartidos.size();i++){
            if(listaPartidos.get(i) instanceof Victoria){
               res+=listaPartidos.get(i).resultados();
            }
        }
        return res;
    }  
    public String getNombre() {
        return nombre;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public ArrayList<Partido> getListaPartidos() {
        return listaPartidos;
    }
    public void setListaPartidos(ArrayList<Partido> listaPartidos) {
        this.listaPartidos = listaPartidos;
    }
 
}
