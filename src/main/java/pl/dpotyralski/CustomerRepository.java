package pl.dpotyralski;

public interface CustomerRepository {

    Customer save(Customer customer);

    Customer findByFirstNameAndLastName(String firstName, String lastName);

}
