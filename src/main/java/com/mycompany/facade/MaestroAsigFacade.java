/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.facade;

import com.mycompany.model.MaestroAsig;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.mycompany.model.MaestroAsig_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.mycompany.model.Grado;
import com.mycompany.model.Maestro;
import com.mycompany.model.Seccion;

/**
 *
 * @author Alexis
 */
@Stateless
public class MaestroAsigFacade extends AbstractFacade<MaestroAsig> {

    @PersistenceContext(unitName = "com.mycompany_ESCUELAMAVEN_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MaestroAsigFacade() {
        super(MaestroAsig.class);
    }

    public boolean isIdGradoEmpty(MaestroAsig entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<MaestroAsig> maestroAsig = cq.from(MaestroAsig.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(maestroAsig, entity), cb.isNotNull(maestroAsig.get(MaestroAsig_.idGrado)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Grado findIdGrado(MaestroAsig entity) {
        return this.getMergedEntity(entity).getIdGrado();
    }

    public boolean isIdMaestroEmpty(MaestroAsig entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<MaestroAsig> maestroAsig = cq.from(MaestroAsig.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(maestroAsig, entity), cb.isNotNull(maestroAsig.get(MaestroAsig_.idMaestro)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Maestro findIdMaestro(MaestroAsig entity) {
        return this.getMergedEntity(entity).getIdMaestro();
    }

    public boolean isIdSeccionEmpty(MaestroAsig entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<MaestroAsig> maestroAsig = cq.from(MaestroAsig.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(maestroAsig, entity), cb.isNotNull(maestroAsig.get(MaestroAsig_.idSeccion)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Seccion findIdSeccion(MaestroAsig entity) {
        return this.getMergedEntity(entity).getIdSeccion();
    }
    
}
