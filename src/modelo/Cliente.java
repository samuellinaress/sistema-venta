package modelo;

/**
 *
 * @author Samuel Linares
 */
public class Cliente extends Persona{
    
    //Atributos
    private String cedula;
    private String telefono;
    private String direccion;
    private int estado;
    
    //Constructor
    public Cliente(){
        
    }

    //Setters y Getters

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
}
