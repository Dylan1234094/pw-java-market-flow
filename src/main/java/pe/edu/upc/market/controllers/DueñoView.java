package pe.edu.upc.market.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import pe.edu.upc.market.models.entities.Due�o;
import pe.edu.upc.market.services.Due�oService;
import pe.edu.upc.market.utils.Action;

@Named("due�oView")
@ViewScoped
public class Due�oView implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Due�o> due�os;
	private Due�o due�o;
	private Due�o due�oSelected;
	private Due�o due�oSearch;
	
	private Action action;
	private String stylePanelDue�o; 
	private String styleTableDue�o;
	
	private boolean disabledButtonNuevo;
	private boolean disabledButtonGuardar;
	private boolean disabledButtonCancelar;
	private boolean disabledButtonEditar;
	private boolean disabledButtonEliminar;
	
	private String messageConfirmDialog;
	
	@Inject
	private Due�oService due�oService;
	
	@PostConstruct
	private void init() {
		this.due�oSearch = new Due�o();
		this.cleanForm();
		this.loadDue�os();
		this.action = Action.NONE;
		this.stateList();
	}
	
	 public void loadDue�os() {
        try {
            this.due�os = due�oService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.print(e.getMessage());
        }
    }

    public void cleanForm() {
        this.due�o = new Due�o();
        this.due�oSelected = null;
    }
    
    public void newDue�o() {
        cleanForm();
        this.action = Action.NEW;
        this.stateNewEdit();     
    }
    
    public void saveDue�o() {
        if (this.action == Action.NEW || this.action == Action.EDIT) {
            try {
                if (this.action == Action.NEW)
                    due�oService.save(this.due�o);
                else
                    due�oService.update(this.due�o);
                cleanForm();
                loadDue�os();
                this.action = Action.NONE;
            } catch (Exception e) {
                e.printStackTrace();
                System.err.print(e.getMessage());
            }
        }
    }
    
 // metodo que se ejecuta cuando el evento rowSelect ocurra:
    public void selectDue�o(SelectEvent<Due�o> e) {
        this.due�oSelected = e.getObject();
        this.messageConfirmDialog = this.due�oSelected.getNombre();
        this.stateSelectRow();
    }

    // metodo que se ejecuta cuando el evento rowUnselect ocurra:
    public void unselectDue�o(UnselectEvent<Due�o> e) {
        this.due�oSelected = null;
        this.stateList();
    }

    public void editDue�o() {
        if (this.due�oSelected != null) {
            this.due�o = this.due�oSelected;
            this.action = Action.EDIT;
            this.stateNewEdit();
        }
    }
    
    public void deleteDue�o() {
        if (this.due�oSelected != null) {
            try {
                due�oService.deleteById(this.due�oSelected.getId());
                cleanForm();
                loadDue�os();
                this.action = Action.NONE;
                // this.stateList();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
    }
    
    public void cancelarDue�o() {
    	cleanForm();
    	this.stateList();
    }
    
	public void findByNombre() {
		if (!this.due�oSearch.getNombre().isEmpty()) {
			try {
				this.due�os = due�oService.findByNombre(due�oSearch.getNombre());
				this.stateList();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
	}
	
	public void cleanbyNombre() {
		this.due�oSearch.setNombre("");
		loadDue�os();
		this.stateList();
	}

    public void stateList() {
        this.stylePanelDue�o = "display:none;";
        this.styleTableDue�o = "display:block;";
        this.disabledButtonNuevo = false;
        this.disabledButtonGuardar = true;
        this.disabledButtonCancelar = true;
        this.disabledButtonEditar = true;
        this.disabledButtonEliminar = true;
    }

    public void stateNewEdit() {
        this.stylePanelDue�o = "display:block;";
        this.styleTableDue�o = "display:none;";
        this.disabledButtonNuevo = true;
        this.disabledButtonGuardar = false;
        this.disabledButtonCancelar = false;
        this.disabledButtonEditar = true;
        this.disabledButtonEliminar = true;
    }

    public void stateSelectRow() {
        this.stylePanelDue�o = "display:none;";
        this.styleTableDue�o = "display:block;";
        this.disabledButtonNuevo = false;
        this.disabledButtonGuardar = true;
        this.disabledButtonCancelar = false;
        this.disabledButtonEditar = false;
        this.disabledButtonEliminar = false;
    }
    
	public List<Due�o> getDue�os() {
		return due�os;
	}

	public Due�o getDue�o() {
		return due�o;
	}

	public Due�o getDue�oSelected() {
		return due�oSelected;
	}

	public Action getAction() {
		return action;
	}

	public String getStylePanelDue�o() {
		return stylePanelDue�o;
	}

	public Due�oService getDue�oService() {
		return due�oService;
	}

	public Due�o getDue�oSearch() {
		return due�oSearch;
	}

	public String getStyleTableDue�o() {
		return styleTableDue�o;
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

