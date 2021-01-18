package com.mycompany.controller;

import com.mycompany.model.Actividad;
import com.mycompany.facade.ActividadFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "actividadController")
@ViewScoped
public class ActividadController extends AbstractController<Actividad> {

    @Inject
    private BloqueController idBloqueController;

    public ActividadController() {
        // Inform the Abstract parent controller of the concrete Actividad Entity
        super(Actividad.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idBloqueController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Bloque controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdBloque(ActionEvent event) {
        Actividad selected = this.getSelected();
        if (selected != null && idBloqueController.getSelected() == null) {
            idBloqueController.setSelected(selected.getIdBloque());
        }
    }

}
