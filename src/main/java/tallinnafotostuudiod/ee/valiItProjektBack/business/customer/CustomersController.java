package tallinnafotostuudiod.ee.valiItProjektBack.business.customer;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tallinnafotostuudiod.ee.valiItProjektBack.business.customer.dto.CustomerDto;

@RestController
public class CustomersController {

    @Resource
    private CustomersService customersService;

    @PostMapping("/customer")
    public void addCustomerInfo(@RequestParam Integer bookingId, @RequestBody CustomerDto customerDto){
        customersService.addCustomerInfo(bookingId, customerDto);
    }

}
