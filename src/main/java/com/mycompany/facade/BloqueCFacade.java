/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.facade;

import com.mycompany.model.BloqueC;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.mycompany.model.BloqueC_;
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
public class BloqueCFacade extends AbstractFacade<BloqueC> {

    @PersistenceContext(unitName = "com.mycompany_ESCUELAMAVEN_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BloqueCFacade() {
        super(BloqueC.class);
    }

    public boolean isBloqueListEmpty(BloqueC entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<BloqueC> bloqueC = cq.from(BloqueC.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(bloqueC, entity), cb.isNotEmpty(bloqueC.get(BloqueC_.bloqueList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Bloque> findBloqueList(BloqueC entity) {
        BloqueC mergedEntity = this.getMergedEntity(entity);
        List<Bloque> bloqueList = mergedEntity.getBloqueList();
        bloqueList.size();
        return bloqueList;
    }
    
}
