package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserReopsitoryCustom
{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public int checkLoginCredentials(String username, String password) {
        Query query = entityManager.createNativeQuery("SELECT * FROM datastore.user WHERE email=? AND password=?", User.class);
        query.setParameter(1, username);
        query.setParameter(2, password);

        return query.getResultList().size();
    }

}
