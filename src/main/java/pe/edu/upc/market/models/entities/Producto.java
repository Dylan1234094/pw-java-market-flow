package pe.edu.upc.market.models.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Productos")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	@Column(name = "nombre", length = 20, nullable = false)
	private String nombre;
	
	@Column(name = "proveedor", length = 20, nullable = false)
	private String proveedor;
	
	@Column(name="precio", nullable = false)
	private Double precio; 
	
	@OneToMany(mappedBy = "producto")
	private List<ProductoTienda> producoTiendas;
	
	public Producto() {
		producoTiendas = new ArrayList<ProductoTienda>();
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public List<ProductoTienda> getProducoTiendas() {
		return producoTiendas;
	}

	public void setProducoTiendas(List<ProductoTienda> producoTiendas) {
		this.producoTiendas = producoTiendas;
	}
	
}
