
package Evaluacion;

public class Derrota extends Partido {
    private int puntos;
    private int gC;
    public Derrota(){
        this.puntos=0;
    }
    
    public Derrota(String resultado,String ganador,String perdedor,int gC){
        super(resultado,ganador,perdedor);
        this.puntos=0;
        this.gC=gC;
    }
    public int resultados() {
        return this.gC;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getgC() {
        return gC;
    }

    public void setgC(int gC) {
        this.gC = gC;
    }
    
}
