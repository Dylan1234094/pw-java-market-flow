package pe.edu.upc.market.models.entities;

import java.io.Serializable;
import java.util.Objects;

public class ProductoTiendaId implements Serializable{ //base para los id's pq JPA no interviene en los complementos 

	private static final long serialVersionUID = 1L; //Serializable: esta clase se insertará en la base de datos completa
	
	private Integer producto;
	private Integer tienda;
	
	public ProductoTiendaId() {
		
	}
	
	public ProductoTiendaId(Integer producto, Integer tienda) {
		super();
		this.producto = producto;
		this.tienda = tienda;
	}
	
	public Integer getProducto() {
		return producto;
	}

	public void setProducto(Integer producto) {
		this.producto = producto;
	}

	public Integer getTienda() {
		return tienda;
	}

	public void setTienda(Integer tienda) {
		this.tienda = tienda;
	}

	@Override
    public int hashCode() {
        return Objects.hash(producto, tienda);
    }
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj) 
            return true;
        if (obj == null || getClass() != obj.getClass()) 
            return false;
        ProductoTiendaId productoTiendaId = (ProductoTiendaId) obj;
        if (this.producto != productoTiendaId.producto) 
            return false;
        return this.tienda == productoTiendaId.tienda;
    }
}
