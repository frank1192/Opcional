
package MODELO;

/**
 *
 * @author Franklin Aguirre
 */
public class Modelo_Registro {
    private int Identificacion;
     private String Apellidos;
    private String Nombres;
    private String Deporte;

    
    public Modelo_Registro(Integer Identificacion, String Nombres,String Apellidos,String Deporte) {
        this.Identificacion = Identificacion;
        this.Nombres = Nombres;
        this.Apellidos= Apellidos;
        this.Deporte= Deporte;
        
    }
    
    public int getIdentificacion() {
        return Identificacion;
    }

    public void setIdentificacion(int Identificacion) {
        this.Identificacion = Identificacion;
    }
 
    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getDeporte() {
        return Deporte;
    }

    public void setDeporte(String Deporte) {
        this.Deporte = Deporte;
    }
    
    @Override
    public String toString() {
        return "{" + "Identificacion: " + this.getIdentificacion()+ ", Nombres: " + this.getNombres() + ", Apellidos: " + this.getApellidos() + ", Deporte: " + this.getDeporte()+   "}";
    }
}
