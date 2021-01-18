/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.facade;

import com.mycompany.model.Actividad;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.mycompany.model.Actividad_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.mycompany.model.Bloque;

/**
 *
 * @author Alexis
 */
@Stateless
public class ActividadFacade extends AbstractFacade<Actividad> {

    @PersistenceContext(unitName = "com.mycompany_ESCUELAMAVEN_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ActividadFacade() {
        super(Actividad.class);
    }

    public boolean isIdBloqueEmpty(Actividad entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Actividad> actividad = cq.from(Actividad.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(actividad, entity), cb.isNotNull(actividad.get(Actividad_.idBloque)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Bloque findIdBloque(Actividad entity) {
        return this.getMergedEntity(entity).getIdBloque();
    }
    
}
