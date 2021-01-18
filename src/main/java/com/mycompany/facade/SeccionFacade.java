/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.facade;

import com.mycompany.model.Seccion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.mycompany.model.Seccion_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.mycompany.model.MaestroAsig;
import com.mycompany.model.Alumno;
import com.mycompany.model.Bloque;
import java.util.List;

/**
 *
 * @author Alexis
 */
@Stateless
public class SeccionFacade extends AbstractFacade<Seccion> {

    @PersistenceContext(unitName = "com.mycompany_ESCUELAMAVEN_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeccionFacade() {
        super(Seccion.class);
    }

    public boolean isMaestroAsigListEmpty(Seccion entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Seccion> seccion = cq.from(Seccion.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(seccion, entity), cb.isNotEmpty(seccion.get(Seccion_.maestroAsigList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<MaestroAsig> findMaestroAsigList(Seccion entity) {
        Seccion mergedEntity = this.getMergedEntity(entity);
        List<MaestroAsig> maestroAsigList = mergedEntity.getMaestroAsigList();
        maestroAsigList.size();
        return maestroAsigList;
    }

    public boolean isAlumnoListEmpty(Seccion entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Seccion> seccion = cq.from(Seccion.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(seccion, entity), cb.isNotEmpty(seccion.get(Seccion_.alumnoList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Alumno> findAlumnoList(Seccion entity) {
        Seccion mergedEntity = this.getMergedEntity(entity);
        List<Alumno> alumnoList = mergedEntity.getAlumnoList();
        alumnoList.size();
        return alumnoList;
    }

    public boolean isBloqueListEmpty(Seccion entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Seccion> seccion = cq.from(Seccion.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(seccion, entity), cb.isNotEmpty(seccion.get(Seccion_.bloqueList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Bloque> findBloqueList(Seccion entity) {
        Seccion mergedEntity = this.getMergedEntity(entity);
        List<Bloque> bloqueList = mergedEntity.getBloqueList();
        bloqueList.size();
        return bloqueList;
    }
    
}
