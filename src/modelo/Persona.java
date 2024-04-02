package modelo;

/**
 *
 * @author Samuel Linares
 */
public abstract class Persona {
    
    //Atributos
    private int id;
    private String nombre;
    private String apellido;
    private String telefono;
    private int estado;
    
    //Constructor
    public Persona(){
        
    }
    
    //Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public int getEstado(){
        return estado;
    }
    
    public void setEstado(int estado){
        this.estado = estado;
    }
    
    
}
