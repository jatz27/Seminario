package com.mycompany.controller;

import com.mycompany.model.MaestroAsig;
import com.mycompany.facade.MaestroAsigFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "maestroAsigController")
@ViewScoped
public class MaestroAsigController extends AbstractController<MaestroAsig> {

    @Inject
    private GradoController idGradoController;
    @Inject
    private MaestroController idMaestroController;
    @Inject
    private SeccionController idSeccionController;

    public MaestroAsigController() {
        // Inform the Abstract parent controller of the concrete MaestroAsig Entity
        super(MaestroAsig.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idGradoController.setSelected(null);
        idMaestroController.setSelected(null);
        idSeccionController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Grado controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdGrado(ActionEvent event) {
        MaestroAsig selected = this.getSelected();
        if (selected != null && idGradoController.getSelected() == null) {
            idGradoController.setSelected(selected.getIdGrado());
        }
    }

    /**
     * Sets the "selected" attribute of the Maestro controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdMaestro(ActionEvent event) {
        MaestroAsig selected = this.getSelected();
        if (selected != null && idMaestroController.getSelected() == null) {
            idMaestroController.setSelected(selected.getIdMaestro());
        }
    }

    /**
     * Sets the "selected" attribute of the Seccion controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdSeccion(ActionEvent event) {
        MaestroAsig selected = this.getSelected();
        if (selected != null && idSeccionController.getSelected() == null) {
            idSeccionController.setSelected(selected.getIdSeccion());
        }
    }

}
