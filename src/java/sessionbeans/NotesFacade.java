/*
 * Created by Luke Mazzu on 2017.04.18  * 
 * Copyright © 2017 Luke Mazzu. All rights reserved. * 
 */
package sessionbeans;

import entityclasses.Notes;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Luke
 */
@Stateless
public class NotesFacade extends AbstractFacade<Notes> {

    @PersistenceContext(unitName = "TakeNote-Team6PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NotesFacade() {
        super(Notes.class);
    }
    
}
