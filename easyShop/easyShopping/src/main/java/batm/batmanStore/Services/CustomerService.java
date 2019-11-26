
package batm.batmanStore.Services;

import batm.batmanStore.Model.Customers;

import java.util.List;


public interface CustomerService {
    
    List<Customers> Listcustomer();
    Customers saveOrUpdate(Customers customers);
    Customers getIdCustomer(Integer id);
    void deleteId(int id);
}
