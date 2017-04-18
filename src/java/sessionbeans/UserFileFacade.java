/*
 * Created by Luke Mazzu on 2017.04.18  * 
 * Copyright © 2017 Luke Mazzu. All rights reserved. * 
 */
package sessionbeans;

import entityclasses.UserFile;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Luke
 */
@Stateless
public class UserFileFacade extends AbstractFacade<UserFile> {

    @PersistenceContext(unitName = "TakeNote-Team6PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFileFacade() {
        super(UserFile.class);
    }
    
}
