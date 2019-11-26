
package batm.batmanStore.DAO;

import batm.batmanStore.Model.Customers;

import batm.batmanStore.Services.CustomerService;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class CustomerDAO implements CustomerService{

    private EntityManagerFactory emf;
    

    @Autowired
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    
    @Override
    public List<Customers> Listcustomer() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("from Customers", Customers.class).getResultList();
    }

    @Override
    public Customers saveOrUpdate(Customers customers) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Customers saved = em.merge(customers);
        em.getTransaction().commit();
        return saved;
    }

    @Override
    public Customers getIdCustomer(Integer id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Customers.class, id);
    }

    @Override
    public void deleteId(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Customers.class, id));
        em.getTransaction().commit();
    }
    
    
    
    
    
    
}
