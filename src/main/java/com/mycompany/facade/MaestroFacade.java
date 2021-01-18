/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.facade;

import com.mycompany.model.Maestro;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.mycompany.model.Maestro_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.mycompany.model.MaestroAsig;
import com.mycompany.model.Usuario;
import java.util.List;

/**
 *
 * @author Alexis
 */
@Stateless
public class MaestroFacade extends AbstractFacade<Maestro> {

    @PersistenceContext(unitName = "com.mycompany_ESCUELAMAVEN_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MaestroFacade() {
        super(Maestro.class);
    }

    public boolean isMaestroAsigListEmpty(Maestro entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Maestro> maestro = cq.from(Maestro.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(maestro, entity), cb.isNotEmpty(maestro.get(Maestro_.maestroAsigList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<MaestroAsig> findMaestroAsigList(Maestro entity) {
        Maestro mergedEntity = this.getMergedEntity(entity);
        List<MaestroAsig> maestroAsigList = mergedEntity.getMaestroAsigList();
        maestroAsigList.size();
        return maestroAsigList;
    }

    public boolean isUsuarioListEmpty(Maestro entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Maestro> maestro = cq.from(Maestro.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(maestro, entity), cb.isNotEmpty(maestro.get(Maestro_.usuarioList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Usuario> findUsuarioList(Maestro entity) {
        Maestro mergedEntity = this.getMergedEntity(entity);
        List<Usuario> usuarioList = mergedEntity.getUsuarioList();
        usuarioList.size();
        return usuarioList;
    }
    
}
