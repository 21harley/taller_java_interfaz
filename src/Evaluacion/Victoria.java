package Evaluacion;

public class Victoria extends Partido {
    private int puntos;
    private int gA;
    public Victoria (){
        this.puntos=3;
    }
    
    public Victoria (String resultado,String ganador,String perdedor,int gA){
        super(resultado,ganador,perdedor);
        this.puntos=3;
        this.gA=gA;
    }
    public int resultados() {
        return this.gA;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getgA() {
        return gA;
    }

    public void setgA(int gA) {
        this.gA = gA;
    }
    
}