package org.TFG.project;

import accounts.UserProfile;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class AccountService {
    private Session session;

    public AccountService(Session session) {
        this.session = session;
    }

    public UserProfile getUserByLogin(String login) throws HibernateException {
        Criteria criteria = session.createCriteria(UserProfile.class);
        return ((UserProfile) criteria.add(Restrictions.eq("login", login)).uniqueResult());
    }

    public void insertUser(String login, String password, String email) throws HibernateException {
        session.save(new UserProfile(login, password, email));
        session.flush();
    }
}

