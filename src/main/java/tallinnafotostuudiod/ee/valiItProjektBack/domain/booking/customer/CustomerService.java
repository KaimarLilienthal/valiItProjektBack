package tallinnafotostuudiod.ee.valiItProjektBack.domain.booking.customer;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Resource
    private CustomerRepository customerRepository;

    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }
}
