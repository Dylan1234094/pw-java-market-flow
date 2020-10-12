package pe.edu.upc.market.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="dueño")
public class Dueño {
	@Id
	private Integer Id; 
	
	@Column(name="nombre", length = 20, nullable = false)
	private String nombre;
	
	@Column(name="numeroDocumento", length = 20, nullable = false)
	private Integer numeroDocumento;
	
	@Column(name="FechaNacimiento", length = 20, nullable = false)
	@Temporal(TemporalType.DATE) 
	private Date fechaNacimiento;
	
	@OneToMany(mappedBy = "dueño") //nombre del atributo con el que se está vinculando 
	private List<Tienda> tiendas;
		
	public Dueño() { //constructor - Solo Necesario cuando se encuentran listas
		tiendas = new ArrayList<Tienda>();
	}
	
	//getters y setters = medios de interacción de los atributos

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

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public List<Tienda> getTiendas() {
		return tiendas;
	}

	public void setTiendas(List<Tienda> tiendas) {
		this.tiendas = tiendas;
	}

	public Integer getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(Integer numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	
}
