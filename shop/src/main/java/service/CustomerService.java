package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CustomerDao;
import entity.Cart;
import entity.Customer;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public void signUp(Customer customer) {
        Cart cart = new Cart();
        customer.setCart(cart);

        customer.setEnabled(true);
        customerDao.signUp(customer);
    }

    public Customer getCustomer(String email) {
        return customerDao.getCustomer(email);
    }

}

