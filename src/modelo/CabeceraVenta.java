package modelo;
// Autor: Angel Naut
public class CabeceraVenta {
//atributos
	private int idCabeceraventa;
	private int idCliente;
	private double valorPagar;
	private String fechaVenta;
	private int estado;
	
	public CabeceraVenta() {
		this.idCabeceraventa = 0;
		this.idCliente = 0;
		this.valorPagar = 0.0;
		this.fechaVenta = "";
		this.estado = 0;
	}

	//constructor sobrecargado
	 public CabeceraVenta(int idCabeceraventa, int idCliente, double valorPagar, String fechaVenta, int estado) {
	        this.idCabeceraventa = idCabeceraventa;
	        this.idCliente = idCliente;
	        this.valorPagar = valorPagar;
	        this.fechaVenta = fechaVenta;
	        this.estado = estado;
	    }
	
	// Métodos getter y setter

	    // Getter para idCabeceraventa
	    public int getIdCabeceraventa() {
	        return idCabeceraventa;
	    }

	    // Setter para idCabeceraventa
	    public void setIdCabeceraventa(int idCabeceraventa) {
	        this.idCabeceraventa = idCabeceraventa;
	    }

	    // Getter para idCliente
	    public int getIdCliente() {
	        return idCliente;
	    }

	    // Setter para idCliente
	    public void setIdCliente(int idCliente) {
	        this.idCliente = idCliente;
	    }

	    // Getter para valorPagar
	    public double getValorPagar() {
	        return valorPagar;
	    }

	    // Setter para valorPagar
	    public void setValorPagar(double valorPagar) {
	        this.valorPagar = valorPagar;
	    }

	    // Getter para fechaVenta
	    public String getFechaVenta() {
	        return fechaVenta;
	    }

	    // Setter para fechaVenta
	    public void setFechaVenta(String fechaVenta) {
	        this.fechaVenta = fechaVenta;
	    }

	    // Getter para estado
	    public int getEstado() {
	        return estado;
	    }

	    // Setter para estado
	    public void setEstado(int estado) {
	        this.estado = estado;
	    }
}
