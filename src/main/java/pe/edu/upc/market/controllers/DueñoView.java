package pe.edu.upc.market.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import pe.edu.upc.market.models.entities.Dueño;
import pe.edu.upc.market.services.DueñoService;
import pe.edu.upc.market.utils.Action;

@Named("dueñoView")
@ViewScoped
public class DueñoView implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Dueño> dueños;
	private Dueño dueño;
	private Dueño dueñoSelected;
	private Dueño dueñoSearch;
	
	private Action action;
	private String stylePanelDueño; 
	private String styleTableDueño;
	
	private boolean disabledButtonNuevo;
	private boolean disabledButtonGuardar;
	private boolean disabledButtonCancelar;
	private boolean disabledButtonEditar;
	private boolean disabledButtonEliminar;
	
	private String messageConfirmDialog;
	
	@Inject
	private DueñoService dueñoService;
	
	@PostConstruct
	private void init() {
		this.dueñoSearch = new Dueño();
		this.cleanForm();
		this.loadDueños();
		this.action = Action.NONE;
		this.stateList();
	}
	
	 public void loadDueños() {
        try {
            this.dueños = dueñoService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.print(e.getMessage());
        }
    }

    public void cleanForm() {
        this.dueño = new Dueño();
        this.dueñoSelected = null;
    }
    
    public void newDueño() {
        cleanForm();
        this.action = Action.NEW;
        this.stateNewEdit();     
    }
    
    public void saveDueño() {
        if (this.action == Action.NEW || this.action == Action.EDIT) {
            try {
                if (this.action == Action.NEW)
                    dueñoService.save(this.dueño);
                else
                    dueñoService.update(this.dueño);
                cleanForm();
                loadDueños();
                this.action = Action.NONE;
            } catch (Exception e) {
                e.printStackTrace();
                System.err.print(e.getMessage());
            }
        }
    }
    
 // metodo que se ejecuta cuando el evento rowSelect ocurra:
    public void selectDueño(SelectEvent<Dueño> e) {
        this.dueñoSelected = e.getObject();
        this.messageConfirmDialog = this.dueñoSelected.getNombre();
        this.stateSelectRow();
    }

    // metodo que se ejecuta cuando el evento rowUnselect ocurra:
    public void unselectDueño(UnselectEvent<Dueño> e) {
        this.dueñoSelected = null;
        this.stateList();
    }

    public void editDueño() {
        if (this.dueñoSelected != null) {
            this.dueño = this.dueñoSelected;
            this.action = Action.EDIT;
            this.stateNewEdit();
        }
    }
    
    public void deleteDueño() {
        if (this.dueñoSelected != null) {
            try {
                dueñoService.deleteById(this.dueñoSelected.getId());
                cleanForm();
                loadDueños();
                this.action = Action.NONE;
                // this.stateList();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
    }
    
    public void cancelarDueño() {
    	cleanForm();
    	this.stateList();
    }
    
	public void findByNombre() {
		if (!this.dueñoSearch.getNombre().isEmpty()) {
			try {
				this.dueños = dueñoService.findByNombre(dueñoSearch.getNombre());
				this.stateList();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
	}
	
	public void cleanbyNombre() {
		this.dueñoSearch.setNombre("");
		loadDueños();
		this.stateList();
	}

    public void stateList() {
        this.stylePanelDueño = "display:none;";
        this.styleTableDueño = "display:block;";
        this.disabledButtonNuevo = false;
        this.disabledButtonGuardar = true;
        this.disabledButtonCancelar = true;
        this.disabledButtonEditar = true;
        this.disabledButtonEliminar = true;
    }

    public void stateNewEdit() {
        this.stylePanelDueño = "display:block;";
        this.styleTableDueño = "display:none;";
        this.disabledButtonNuevo = true;
        this.disabledButtonGuardar = false;
        this.disabledButtonCancelar = false;
        this.disabledButtonEditar = true;
        this.disabledButtonEliminar = true;
    }

    public void stateSelectRow() {
        this.stylePanelDueño = "display:none;";
        this.styleTableDueño = "display:block;";
        this.disabledButtonNuevo = false;
        this.disabledButtonGuardar = true;
        this.disabledButtonCancelar = false;
        this.disabledButtonEditar = false;
        this.disabledButtonEliminar = false;
    }
    
	public List<Dueño> getDueños() {
		return dueños;
	}

	public Dueño getDueño() {
		return dueño;
	}

	public Dueño getDueñoSelected() {
		return dueñoSelected;
	}

	public Action getAction() {
		return action;
	}

	public String getStylePanelDueño() {
		return stylePanelDueño;
	}

	public DueñoService getDueñoService() {
		return dueñoService;
	}

	public Dueño getDueñoSearch() {
		return dueñoSearch;
	}

	public String getStyleTableDueño() {
		return styleTableDueño;
	}

	public boolean isDisabledButtonNuevo() {
		return disabledButtonNuevo;
	}

	public boolean isDisabledButtonGuardar() {
		return disabledButtonGuardar;
	}

	public boolean isDisabledButtonCancelar() {
		return disabledButtonCancelar;
	}

	public boolean isDisabledButtonEditar() {
		return disabledButtonEditar;
	}

	public boolean isDisabledButtonEliminar() {
		return disabledButtonEliminar;
	}

	public String getMessageConfirmDialog() {
		return messageConfirmDialog;
	}
    
}

