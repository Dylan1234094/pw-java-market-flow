package pe.edu.upc.market.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "producto_tiendas")
@IdClass(ProductoTiendaId.class)
public class ProductoTienda {
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Id
	@ManyToOne
	@JoinColumn(name= "product_id")
	private Producto producto;
	
	@Id
	@ManyToOne
	@JoinColumn(name= "tienda_id")
	private Tienda tienda;
	
	@Column(name = "cantidad", nullable = false)
	private Integer cantidad;

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Tienda getTienda() {
		return tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
}
