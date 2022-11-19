package pl.dpotyralski;

import org.junit.jupiter.api.Test;
import org.mockito.stubbing.Answer;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class _15_JUnitStubNoReturnWithMockitoTest {

    CustomerJPARepository customerJPARepository = mock(CustomerJPARepository.class);
    ReportService reportService = mock(ReportService.class);

    CustomerJPAService customerJPAService = new CustomerJPAService(customerJPARepository, reportService);

    @Test
    void shouldGetCustomerEnriched() {
        //given
        doAnswer((Answer<Void>) invocation -> {
            CustomerJPA passedCustomerJPA = invocation.getArgument(0);
            passedCustomerJPA.setId(321);
            return null;
        }).when(customerJPARepository).persist(any(CustomerJPA.class));

        //when
        customerJPAService.saveCustomer(createTestCustomerJPA());

        //then
        verify(reportService).notify(321);
    }

    private CustomerJPA createTestCustomerJPA() {
        CustomerJPA customerJPA = new CustomerJPA();
        customerJPA.setName("Test1");
        return customerJPA;
    }

}
