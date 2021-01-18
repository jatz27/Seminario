package com.mycompany.controller;

import com.mycompany.model.Maestro;
import com.mycompany.model.MaestroAsig;
import com.mycompany.model.Usuario;
import java.util.List;
import com.mycompany.facade.MaestroFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "maestroController")
@ViewScoped
public class MaestroController extends AbstractController<Maestro> {

    // Flags to indicate if child collections are empty
    private boolean isMaestroAsigListEmpty;
    private boolean isUsuarioListEmpty;

    public MaestroController() {
        // Inform the Abstract parent controller of the concrete Maestro Entity
        super(Maestro.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsMaestroAsigListEmpty();
        this.setIsUsuarioListEmpty();
    }

    public boolean getIsMaestroAsigListEmpty() {
        return this.isMaestroAsigListEmpty;
    }

    private void setIsMaestroAsigListEmpty() {
        Maestro selected = this.getSelected();
        if (selected != null) {
            MaestroFacade ejbFacade = (MaestroFacade) this.getFacade();
            this.isMaestroAsigListEmpty = ejbFacade.isMaestroAsigListEmpty(selected);
        } else {
            this.isMaestroAsigListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of MaestroAsig entities that
     * are retrieved from Maestro and returns the navigation outcome.
     *
     * @return navigation outcome for MaestroAsig page
     */
    public String navigateMaestroAsigList() {
        Maestro selected = this.getSelected();
        if (selected != null) {
            MaestroFacade ejbFacade = (MaestroFacade) this.getFacade();
            List<MaestroAsig> selectedMaestroAsigList = ejbFacade.findMaestroAsigList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("MaestroAsig_items", selectedMaestroAsigList);
        }
        return "/app/maestroAsig/index";
    }

    public boolean getIsUsuarioListEmpty() {
        return this.isUsuarioListEmpty;
    }

    private void setIsUsuarioListEmpty() {
        Maestro selected = this.getSelected();
        if (selected != null) {
            MaestroFacade ejbFacade = (MaestroFacade) this.getFacade();
            this.isUsuarioListEmpty = ejbFacade.isUsuarioListEmpty(selected);
        } else {
            this.isUsuarioListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Usuario entities that are
     * retrieved from Maestro and returns the navigation outcome.
     *
     * @return navigation outcome for Usuario page
     */
    public String navigateUsuarioList() {
        Maestro selected = this.getSelected();
        if (selected != null) {
            MaestroFacade ejbFacade = (MaestroFacade) this.getFacade();
            List<Usuario> selectedUsuarioList = ejbFacade.findUsuarioList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Usuario_items", selectedUsuarioList);
        }
        return "/app/usuario/index";
    }

}
