package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import dao.ItemOrderDao;
import entity.Customer;
import entity.MenuItem;
import entity.OrderItem;

@Service
public class ItemOrderService {

    @Autowired
    private MenuInfoService menuInfoService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ItemOrderDao itemOrderDao;

    public void saveItem(int menuId) {
        final OrderItem orderItem = new OrderItem();
        final MenuItem menuItem = menuInfoService.getMenuItem(menuId);

        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();
        Customer customer = customerService.getCustomer(username);

        orderItem.setMenuItem(menuItem);
        orderItem.setCart(customer.getCart());
        orderItem.setQuantity(1);
        orderItem.setPrice(menuItem.getPrice());
        itemOrderDao.save(orderItem);
    }
}