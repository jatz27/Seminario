package com.mycompany.controller;

import com.mycompany.model.Seccion;
import com.mycompany.model.MaestroAsig;
import com.mycompany.model.Alumno;
import com.mycompany.model.Bloque;
import java.util.List;
import com.mycompany.facade.SeccionFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "seccionController")
@ViewScoped
public class SeccionController extends AbstractController<Seccion> {

    // Flags to indicate if child collections are empty
    private boolean isMaestroAsigListEmpty;
    private boolean isAlumnoListEmpty;
    private boolean isBloqueListEmpty;

    public SeccionController() {
        // Inform the Abstract parent controller of the concrete Seccion Entity
        super(Seccion.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsMaestroAsigListEmpty();
        this.setIsAlumnoListEmpty();
        this.setIsBloqueListEmpty();
    }

    public boolean getIsMaestroAsigListEmpty() {
        return this.isMaestroAsigListEmpty;
    }

    private void setIsMaestroAsigListEmpty() {
        Seccion selected = this.getSelected();
        if (selected != null) {
            SeccionFacade ejbFacade = (SeccionFacade) this.getFacade();
            this.isMaestroAsigListEmpty = ejbFacade.isMaestroAsigListEmpty(selected);
        } else {
            this.isMaestroAsigListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of MaestroAsig entities that
     * are retrieved from Seccion and returns the navigation outcome.
     *
     * @return navigation outcome for MaestroAsig page
     */
    public String navigateMaestroAsigList() {
        Seccion selected = this.getSelected();
        if (selected != null) {
            SeccionFacade ejbFacade = (SeccionFacade) this.getFacade();
            List<MaestroAsig> selectedMaestroAsigList = ejbFacade.findMaestroAsigList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("MaestroAsig_items", selectedMaestroAsigList);
        }
        return "/app/maestroAsig/index";
    }

    public boolean getIsAlumnoListEmpty() {
        return this.isAlumnoListEmpty;
    }

    private void setIsAlumnoListEmpty() {
        Seccion selected = this.getSelected();
        if (selected != null) {
            SeccionFacade ejbFacade = (SeccionFacade) this.getFacade();
            this.isAlumnoListEmpty = ejbFacade.isAlumnoListEmpty(selected);
        } else {
            this.isAlumnoListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Alumno entities that are
     * retrieved from Seccion and returns the navigation outcome.
     *
     * @return navigation outcome for Alumno page
     */
    public String navigateAlumnoList() {
        Seccion selected = this.getSelected();
        if (selected != null) {
            SeccionFacade ejbFacade = (SeccionFacade) this.getFacade();
            List<Alumno> selectedAlumnoList = ejbFacade.findAlumnoList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Alumno_items", selectedAlumnoList);
        }
        return "/app/alumno/index";
    }

    public boolean getIsBloqueListEmpty() {
        return this.isBloqueListEmpty;
    }

    private void setIsBloqueListEmpty() {
        Seccion selected = this.getSelected();
        if (selected != null) {
            SeccionFacade ejbFacade = (SeccionFacade) this.getFacade();
            this.isBloqueListEmpty = ejbFacade.isBloqueListEmpty(selected);
        } else {
            this.isBloqueListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Bloque entities that are
     * retrieved from Seccion and returns the navigation outcome.
     *
     * @return navigation outcome for Bloque page
     */
    public String navigateBloqueList() {
        Seccion selected = this.getSelected();
        if (selected != null) {
            SeccionFacade ejbFacade = (SeccionFacade) this.getFacade();
            List<Bloque> selectedBloqueList = ejbFacade.findBloqueList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Bloque_items", selectedBloqueList);
        }
        return "/app/bloque/index";
    }

}
