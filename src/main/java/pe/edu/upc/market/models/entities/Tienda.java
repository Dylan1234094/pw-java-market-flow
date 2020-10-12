package pe.edu.upc.market.models.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Table(name = "tiendas")
public class Tienda { //upper cammel case 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id; //lower cammel case 
	
	@Column(name="nombre", length = 20, nullable = false)
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name = "due�o_id")
	private Due�o due�o;
	
	@OneToMany(mappedBy = "tienda")
	private List<ProductoTienda> producoTiendas;
	
	@Transient
	private Integer due�oId;

	public Tienda() {
		producoTiendas = new ArrayList<ProductoTienda>();
		this.due�oId = 0;
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

	public Due�o getDue�o() {
		return due�o;
	}

	public void setDue�o(Due�o due�o) {
		this.due�o = due�o;
	}

	public List<ProductoTienda> getProducoTiendas() {
		return producoTiendas;
	}

	public void setProducoTiendas(List<ProductoTienda> producoTiendas) {
		this.producoTiendas = producoTiendas;
	}
	
	public Integer getDue�oId() {
		if (this.due�oId <= 0 && this.due�oId != null) {
			this.due�oId = this.due�o.getId();
		}
		return due�oId;
	}

	public void setDue�oId(Integer due�oId) {
		this.due�oId = due�oId;
	}
}
