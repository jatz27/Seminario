package com.mycompany.controller;

import com.mycompany.model.BloqueC;
import com.mycompany.model.Bloque;
import java.util.List;
import com.mycompany.facade.BloqueCFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "bloqueCController")
@ViewScoped
public class BloqueCController extends AbstractController<BloqueC> {

    // Flags to indicate if child collections are empty
    private boolean isBloqueListEmpty;

    public BloqueCController() {
        // Inform the Abstract parent controller of the concrete BloqueC Entity
        super(BloqueC.class);
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
        BloqueC selected = this.getSelected();
        if (selected != null) {
            BloqueCFacade ejbFacade = (BloqueCFacade) this.getFacade();
            this.isBloqueListEmpty = ejbFacade.isBloqueListEmpty(selected);
        } else {
            this.isBloqueListEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Bloque entities that are
     * retrieved from BloqueC and returns the navigation outcome.
     *
     * @return navigation outcome for Bloque page
     */
    public String navigateBloqueList() {
        BloqueC selected = this.getSelected();
        if (selected != null) {
            BloqueCFacade ejbFacade = (BloqueCFacade) this.getFacade();
            List<Bloque> selectedBloqueList = ejbFacade.findBloqueList(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Bloque_items", selectedBloqueList);
        }
        return "/app/bloque/index";
    }

}
