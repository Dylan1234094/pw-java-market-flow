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
	@JoinColumn(name = "dueño_id")
	private Dueño dueño;
	
	@OneToMany(mappedBy = "tienda")
	private List<ProductoTienda> producoTiendas;
	
	@Transient
	private Integer dueñoId;

	public Tienda() {
		producoTiendas = new ArrayList<ProductoTienda>();
		this.dueñoId = 0;
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

	public Dueño getDueño() {
		return dueño;
	}

	public void setDueño(Dueño dueño) {
		this.dueño = dueño;
	}

	public List<ProductoTienda> getProducoTiendas() {
		return producoTiendas;
	}

	public void setProducoTiendas(List<ProductoTienda> producoTiendas) {
		this.producoTiendas = producoTiendas;
	}
	
	public Integer getDueñoId() {
		if (this.dueñoId <= 0 && this.dueñoId != null) {
			this.dueñoId = this.dueño.getId();
		}
		return dueñoId;
	}

	public void setDueñoId(Integer dueñoId) {
		this.dueñoId = dueñoId;
	}
}
