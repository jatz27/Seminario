package com.mycompany.controller;

import com.mycompany.model.Alumno;
import com.mycompany.model.Bloque;
import java.util.List;
import com.mycompany.facade.AlumnoFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "alumnoController")
@ViewScoped
public class AlumnoController extends AbstractController<Alumno> {

    @Inject
    private GradoController idGradoController;
    @Inject
    private SeccionController idSeccionController;

    // Flags to indicate if child collections are empty
    private boolean isBloqueListEmpty;

    public AlumnoController() {
        // Inform the Abstract parent controller of the concrete Alumno Entity
        super(Alumno.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idGradoController.setSelected(null);
        idSeccionController.setSelected(null);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsBloqueListEmpty();
    }

    /**
     * Sets the "selected" attribute of the Grado controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdGrado(ActionEvent event) {
        Alumno selected = this.getSelected();
        if (selected != null && idGradoController.getSelected() == null) {
            idGradoController.setSelected(selected.getIdGrado());
        }
    }

    /**
     * Sets the "selected" attribute of the Seccion controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdSeccion(ActionEvent event) {
        Alumno selected = this.getSelected();
        if (selected != null && idSeccionController.getSelected() == null) {
            idSeccionController.setSelected(selected.getIdSeccion());
        }
    }

    public boolean getIsBloqueListEmpty() {
        return this.isBloqueListEmpty;
    }

    private void setIsBloqueListEmpty() {
        Alumno selected = this.getSelected();
        if (selected != null) {
            AlumnoFacade ejbFacade = (AlumnoFacade) this.getFacade();
            this.isBloqueListEmpty = ejbFacade.isBloqueListEmpty(selected);
        } else {
            this.isBloqueListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Bloque entities that are
     * retrieved from Alumno and returns the navigation outcome.
     *
     * @return navigation outcome for Bloque page
     */
    public String navigateBloqueList() {
        Alumno selected = this.getSelected();
        if (selected != null) {
            AlumnoFacade ejbFacade = (AlumnoFacade) this.getFacade();
            List<Bloque> selectedBloqueList = ejbFacade.findBloqueList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Bloque_items", selectedBloqueList);
        }
        return "/app/bloque/index";
    }

}
