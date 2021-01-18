package com.mycompany.controller;

import com.mycompany.model.Bloque;
import com.mycompany.model.Actividad;
import java.util.List;
import com.mycompany.facade.BloqueFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "bloqueController")
@ViewScoped
public class BloqueController extends AbstractController<Bloque> {

    @Inject
    private AlumnoController idAlumnoController;
    @Inject
    private BloqueCController idBloqueCatController;
    @Inject
    private GradoController idGradoController;
    @Inject
    private MateriaController idMateriaController;
    @Inject
    private SeccionController idSeccionController;

    // Flags to indicate if child collections are empty
    private boolean isActividadListEmpty;

    public BloqueController() {
        // Inform the Abstract parent controller of the concrete Bloque Entity
        super(Bloque.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idAlumnoController.setSelected(null);
        idBloqueCatController.setSelected(null);
        idGradoController.setSelected(null);
        idMateriaController.setSelected(null);
        idSeccionController.setSelected(null);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsActividadListEmpty();
    }

    /**
     * Sets the "selected" attribute of the Alumno controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdAlumno(ActionEvent event) {
        Bloque selected = this.getSelected();
        if (selected != null && idAlumnoController.getSelected() == null) {
            idAlumnoController.setSelected(selected.getIdAlumno());
        }
    }

    /**
     * Sets the "selected" attribute of the BloqueC controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdBloqueCat(ActionEvent event) {
        Bloque selected = this.getSelected();
        if (selected != null && idBloqueCatController.getSelected() == null) {
            idBloqueCatController.setSelected(selected.getIdBloqueCat());
        }
    }

    /**
     * Sets the "selected" attribute of the Grado controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdGrado(ActionEvent event) {
        Bloque selected = this.getSelected();
        if (selected != null && idGradoController.getSelected() == null) {
            idGradoController.setSelected(selected.getIdGrado());
        }
    }

    /**
     * Sets the "selected" attribute of the Materia controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdMateria(ActionEvent event) {
        Bloque selected = this.getSelected();
        if (selected != null && idMateriaController.getSelected() == null) {
            idMateriaController.setSelected(selected.getIdMateria());
        }
    }

    /**
     * Sets the "selected" attribute of the Seccion controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdSeccion(ActionEvent event) {
        Bloque selected = this.getSelected();
        if (selected != null && idSeccionController.getSelected() == null) {
            idSeccionController.setSelected(selected.getIdSeccion());
        }
    }

    public boolean getIsActividadListEmpty() {
        return this.isActividadListEmpty;
    }

    private void setIsActividadListEmpty() {
        Bloque selected = this.getSelected();
        if (selected != null) {
            BloqueFacade ejbFacade = (BloqueFacade) this.getFacade();
            this.isActividadListEmpty = ejbFacade.isActividadListEmpty(selected);
        } else {
            this.isActividadListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Actividad entities that
     * are retrieved from Bloque and returns the navigation outcome.
     *
     * @return navigation outcome for Actividad page
     */
    public String navigateActividadList() {
        Bloque selected = this.getSelected();
        if (selected != null) {
            BloqueFacade ejbFacade = (BloqueFacade) this.getFacade();
            List<Actividad> selectedActividadList = ejbFacade.findActividadList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Actividad_items", selectedActividadList);
        }
        return "/app/actividad/index";
    }

}
