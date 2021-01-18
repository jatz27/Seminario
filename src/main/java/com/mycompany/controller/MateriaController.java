package com.mycompany.controller;

import com.mycompany.model.Materia;
import com.mycompany.model.Bloque;
import java.util.List;
import com.mycompany.facade.MateriaFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "materiaController")
@ViewScoped
public class MateriaController extends AbstractController<Materia> {

    // Flags to indicate if child collections are empty
    private boolean isBloqueListEmpty;

    public MateriaController() {
        // Inform the Abstract parent controller of the concrete Materia Entity
        super(Materia.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsBloqueListEmpty();
    }

    public boolean getIsBloqueListEmpty() {
        return this.isBloqueListEmpty;
    }

    private void setIsBloqueListEmpty() {
        Materia selected = this.getSelected();
        if (selected != null) {
            MateriaFacade ejbFacade = (MateriaFacade) this.getFacade();
            this.isBloqueListEmpty = ejbFacade.isBloqueListEmpty(selected);
        } else {
            this.isBloqueListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Bloque entities that are
     * retrieved from Materia and returns the navigation outcome.
     *
     * @return navigation outcome for Bloque page
     */
    public String navigateBloqueList() {
        Materia selected = this.getSelected();
        if (selected != null) {
            MateriaFacade ejbFacade = (MateriaFacade) this.getFacade();
            List<Bloque> selectedBloqueList = ejbFacade.findBloqueList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Bloque_items", selectedBloqueList);
        }
        return "/app/bloque/index";
    }

}
