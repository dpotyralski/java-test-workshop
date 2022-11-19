package pl.dpotyralski;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer findCustomer(String name, String lastName) {
        return customerRepository.findByFirstNameAndLastName(name, lastName);
    }

}
