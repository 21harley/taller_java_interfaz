
package Evaluacion;

public class Empate extends Partido {
    private int puntos;

    public Empate(){
        this.puntos=1;
    }
    
    public Empate(String resultado,String e1,String ea){
        super(resultado,e1,ea);
        this.puntos=1;
    }
    public int resultados() {
        return 1;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    
}
