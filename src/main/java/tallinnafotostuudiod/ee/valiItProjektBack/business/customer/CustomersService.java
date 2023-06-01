package tallinnafotostuudiod.ee.valiItProjektBack.business.customer;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import tallinnafotostuudiod.ee.valiItProjektBack.business.customer.dto.CustomerDto;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.booking.Booking;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.booking.BookingService;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.booking.customer.Customer;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.booking.customer.CustomerMapper;
import tallinnafotostuudiod.ee.valiItProjektBack.domain.booking.customer.CustomerService;

@Service
public class CustomersService {
    @Resource
    private CustomerMapper customerMapper;

    @Resource
    private CustomerService customerService;

    @Resource
    private BookingService bookingService;
    public void addCustomerInfo(Integer bookingId, CustomerDto customerDto) {
        // todo: teen uue

        Customer customer = customerMapper.toEntity(customerDto);
        customerService.addCustomer(customer);

        Booking booking = bookingService.getBookingInformation(bookingId);
        booking.setCustomer(customer);
        bookingService.addBooking(booking);

    }
}
