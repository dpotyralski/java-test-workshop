package pl.dpotyralski;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class CustomerJPAService {

    private final CustomerJPARepository customerJPARepository;
    private final ReportService reportService;

    public void saveCustomer(CustomerJPA customerJPA) {
        customerJPARepository.persist(customerJPA);
        reportService.notify(customerJPA.getId());
    }

}
