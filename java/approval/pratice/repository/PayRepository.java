package approval.pratice.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class PayRepository {

    @PersistenceContext
    EntityManager em;




}
