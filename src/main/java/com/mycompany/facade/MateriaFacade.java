/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.facade;

import com.mycompany.model.Materia;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.mycompany.model.Materia_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.mycompany.model.Bloque;
import java.util.List;

/**
 *
 * @author Alexis
 */
@Stateless
public class MateriaFacade extends AbstractFacade<Materia> {

    @PersistenceContext(unitName = "com.mycompany_ESCUELAMAVEN_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MateriaFacade() {
        super(Materia.class);
    }

    public boolean isBloqueListEmpty(Materia entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Materia> materia = cq.from(Materia.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(materia, entity), cb.isNotEmpty(materia.get(Materia_.bloqueList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Bloque> findBloqueList(Materia entity) {
        Materia mergedEntity = this.getMergedEntity(entity);
        List<Bloque> bloqueList = mergedEntity.getBloqueList();
        bloqueList.size();
        return bloqueList;
    }
    
}
