
package Evaluacion;

public abstract class Partido {
    private String resultado;
    private String ganador;
    private String perdedor;
    public Partido(){
        this.resultado="";
        this.ganador="";
        this.perdedor="";
    }
    public Partido(String resultado,String ganador,String perdedor){
        this.resultado=resultado;
        this.ganador=ganador;
        this.perdedor=perdedor;
    }
    
    public abstract int resultados();
    
    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getGanador() {
        return ganador;
    }

    public void setGanador(String ganador) {
        this.ganador = ganador;
    }

    public String getPerdedor() {
        return perdedor;
    }

    public void setPerdedor(String perdedor) {
        this.perdedor = perdedor;
    }
    
}
