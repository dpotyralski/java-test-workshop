package pl.dpotyralski;

import org.junit.jupiter.api.Test;
import org.mockito.stubbing.Answer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.startsWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class _14_JUnitStubWithMockitoTest {

    CustomerRepository customerRepository = mock(CustomerRepository.class);
    CustomerService customerService = new CustomerService(customerRepository);

    private static Customer createTestCustomer() {
        return new Customer(1, "Jon Snow", "UK");
    }

    private static Customer createTestCustomer(String name) {
        return new Customer(1, name, "UK");
    }

    @Test
    void shouldReturnCustomerStub() {
        //given
        Customer expectedCustomer = createTestCustomer();

        when(customerRepository.save(any())).thenReturn(expectedCustomer);

        //when
        Customer actualCustomer = customerService.saveCustomer(null);

        //then
        assertEquals(expectedCustomer, actualCustomer);
    }

    @Test
    void shouldThrowExceptionWhenSaving() {
        //given
        Customer customer = createTestCustomer();

        when(customerRepository.save(customer)).thenThrow(new IllegalArgumentException("Something!"));

        //expect
        assertThrows(IllegalArgumentException.class, () -> customerService.saveCustomer(customer));
    }

    @Test
    void shouldGetCustomerBasedOnMatcher() {
        //given
        when(customerRepository.findByFirstNameAndLastName(anyString(), startsWith("J"))).thenReturn(createTestCustomer());

        //when
        Customer customer = customerService.findCustomer("anyString", "Jon");

        //then
        assertEquals("Jon Snow", customer.getFullName());
    }

    @Test
    void shouldGetCustomerEnriched() {
        //given
        when(customerRepository.findByFirstNameAndLastName("Tyrion", "Lannister"))
                .thenAnswer((Answer<Customer>) invocation -> {
                    String firstName = invocation.getArgument(0);
                    String lastName = invocation.getArgument(1);
                    return createTestCustomer(firstName + " " + lastName);
                });

        //when
        Customer customer = customerService.findCustomer("Tyrion", "Lannister");

        //then
        assertEquals("Tyrion Lannister", customer.getFullName());
    }


}
