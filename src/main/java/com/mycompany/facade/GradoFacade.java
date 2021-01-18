/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.facade;

import com.mycompany.model.Grado;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.mycompany.model.Grado_;
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
public class GradoFacade extends AbstractFacade<Grado> {

    @PersistenceContext(unitName = "com.mycompany_ESCUELAMAVEN_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GradoFacade() {
        super(Grado.class);
    }

    public boolean isMaestroAsigListEmpty(Grado entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Grado> grado = cq.from(Grado.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(grado, entity), cb.isNotEmpty(grado.get(Grado_.maestroAsigList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<MaestroAsig> findMaestroAsigList(Grado entity) {
        Grado mergedEntity = this.getMergedEntity(entity);
        List<MaestroAsig> maestroAsigList = mergedEntity.getMaestroAsigList();
        maestroAsigList.size();
        return maestroAsigList;
    }

    public boolean isAlumnoListEmpty(Grado entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Grado> grado = cq.from(Grado.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(grado, entity), cb.isNotEmpty(grado.get(Grado_.alumnoList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Alumno> findAlumnoList(Grado entity) {
        Grado mergedEntity = this.getMergedEntity(entity);
        List<Alumno> alumnoList = mergedEntity.getAlumnoList();
        alumnoList.size();
        return alumnoList;
    }

    public boolean isBloqueListEmpty(Grado entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Grado> grado = cq.from(Grado.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(grado, entity), cb.isNotEmpty(grado.get(Grado_.bloqueList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Bloque> findBloqueList(Grado entity) {
        Grado mergedEntity = this.getMergedEntity(entity);
        List<Bloque> bloqueList = mergedEntity.getBloqueList();
        bloqueList.size();
        return bloqueList;
    }
    
}
