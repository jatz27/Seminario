package com.mycompany.controller;

import com.mycompany.model.Usuario;
import com.mycompany.facade.UsuarioFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "usuarioController")
@ViewScoped
public class UsuarioController extends AbstractController<Usuario> {

    @Inject
    private MaestroController idMaestroController;

    public UsuarioController() {
        // Inform the Abstract parent controller of the concrete Usuario Entity
        super(Usuario.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idMaestroController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Maestro controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdMaestro(ActionEvent event) {
        Usuario selected = this.getSelected();
        if (selected != null && idMaestroController.getSelected() == null) {
            idMaestroController.setSelected(selected.getIdMaestro());
        }
    }

}
