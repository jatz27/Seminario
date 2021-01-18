/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.facade;

import com.mycompany.model.Bloque;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.mycompany.model.Bloque_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.mycompany.model.Alumno;
import com.mycompany.model.BloqueC;
import com.mycompany.model.Grado;
import com.mycompany.model.Materia;
import com.mycompany.model.Seccion;
import com.mycompany.model.Actividad;
import java.util.List;

/**
 *
 * @author Alexis
 */
@Stateless
public class BloqueFacade extends AbstractFacade<Bloque> {

    @PersistenceContext(unitName = "com.mycompany_ESCUELAMAVEN_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BloqueFacade() {
        super(Bloque.class);
    }

    public boolean isIdAlumnoEmpty(Bloque entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Bloque> bloque = cq.from(Bloque.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(bloque, entity), cb.isNotNull(bloque.get(Bloque_.idAlumno)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Alumno findIdAlumno(Bloque entity) {
        return this.getMergedEntity(entity).getIdAlumno();
    }

    public boolean isIdBloqueCatEmpty(Bloque entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Bloque> bloque = cq.from(Bloque.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(bloque, entity), cb.isNotNull(bloque.get(Bloque_.idBloqueCat)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public BloqueC findIdBloqueCat(Bloque entity) {
        return this.getMergedEntity(entity).getIdBloqueCat();
    }

    public boolean isIdGradoEmpty(Bloque entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Bloque> bloque = cq.from(Bloque.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(bloque, entity), cb.isNotNull(bloque.get(Bloque_.idGrado)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Grado findIdGrado(Bloque entity) {
        return this.getMergedEntity(entity).getIdGrado();
    }

    public boolean isIdMateriaEmpty(Bloque entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Bloque> bloque = cq.from(Bloque.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(bloque, entity), cb.isNotNull(bloque.get(Bloque_.idMateria)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Materia findIdMateria(Bloque entity) {
        return this.getMergedEntity(entity).getIdMateria();
    }

    public boolean isIdSeccionEmpty(Bloque entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Bloque> bloque = cq.from(Bloque.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(bloque, entity), cb.isNotNull(bloque.get(Bloque_.idSeccion)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Seccion findIdSeccion(Bloque entity) {
        return this.getMergedEntity(entity).getIdSeccion();
    }

    public boolean isActividadListEmpty(Bloque entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Bloque> bloque = cq.from(Bloque.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(bloque, entity), cb.isNotEmpty(bloque.get(Bloque_.actividadList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Actividad> findActividadList(Bloque entity) {
        Bloque mergedEntity = this.getMergedEntity(entity);
        List<Actividad> actividadList = mergedEntity.getActividadList();
        actividadList.size();
        return actividadList;
    }
    
}
