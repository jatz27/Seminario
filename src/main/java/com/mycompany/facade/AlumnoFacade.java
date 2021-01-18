/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.facade;

import com.mycompany.model.Alumno;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.mycompany.model.Alumno_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.mycompany.model.Grado;
import com.mycompany.model.Seccion;
import com.mycompany.model.Bloque;
import java.util.List;

/**
 *
 * @author Alexis
 */
@Stateless
public class AlumnoFacade extends AbstractFacade<Alumno> {

    @PersistenceContext(unitName = "com.mycompany_ESCUELAMAVEN_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AlumnoFacade() {
        super(Alumno.class);
    }

    public boolean isIdGradoEmpty(Alumno entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Alumno> alumno = cq.from(Alumno.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(alumno, entity), cb.isNotNull(alumno.get(Alumno_.idGrado)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Grado findIdGrado(Alumno entity) {
        return this.getMergedEntity(entity).getIdGrado();
    }

    public boolean isIdSeccionEmpty(Alumno entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Alumno> alumno = cq.from(Alumno.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(alumno, entity), cb.isNotNull(alumno.get(Alumno_.idSeccion)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Seccion findIdSeccion(Alumno entity) {
        return this.getMergedEntity(entity).getIdSeccion();
    }

    public boolean isBloqueListEmpty(Alumno entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Alumno> alumno = cq.from(Alumno.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(alumno, entity), cb.isNotEmpty(alumno.get(Alumno_.bloqueList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Bloque> findBloqueList(Alumno entity) {
        Alumno mergedEntity = this.getMergedEntity(entity);
        List<Bloque> bloqueList = mergedEntity.getBloqueList();
        bloqueList.size();
        return bloqueList;
    }
    
}
