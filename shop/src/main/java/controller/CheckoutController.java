package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import service.CartService;

@Controller
public class CheckoutController {

    @Autowired
    private CartService cartService;

    @RequestMapping(value = "/checkout", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public void checkout() {
        cartService.cleanCart();
    }
}