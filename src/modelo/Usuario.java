package modelo;

/**
 *
 * @author Samuel Linares
 */
public class Usuario extends Persona{
    
    //Atributos 
    private String usuario;
    private String password;
    
    //Constructor
    public Usuario(){

    }
    
    //Getters y setters
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
