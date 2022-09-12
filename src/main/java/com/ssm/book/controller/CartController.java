package com.ssm.book.controller;

import com.ssm.book.pojo.Book;
import com.ssm.book.pojo.Cart;
import com.ssm.book.pojo.CartItem;
import com.ssm.book.pojo.User;
import com.ssm.book.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class CartController {
    @Autowired
    private CartItemService cartItemService;

    @RequestMapping(value = "/book/cart", method = RequestMethod.GET)
    public String Cart(Model model, HttpSession session) {
        User currentUser = (User) session.getAttribute("user");
        Cart cart = cartItemService.getCart(currentUser);
        currentUser.setCart(cart);
        model.addAttribute("currentUser", currentUser);
        session.setAttribute("user", currentUser);
        return "/cart";
    }

    @RequestMapping(value = "/editCart/{cartItemId}/{buyCount}", method = RequestMethod.GET)
    public String editCart(@PathVariable("cartItemId") Integer cartItemId, @PathVariable("buyCount") Integer buyCount) {
        cartItemService.updateCartItem(new CartItem(cartItemId, buyCount));
        return "redirect:/book/cart";
    }

    @RequestMapping(value = "/insertIntoCart/{id}", method = RequestMethod.GET)
    public String addCart(@PathVariable("id") Integer id, HttpSession session) {
        User currentUser = (User) session.getAttribute("user");
        CartItem cartItem = new CartItem(new Book(id), 1, currentUser);
        cartItemService.addOrUpdateCart(cartItem, currentUser.getCart());
        return "redirect:/index";
    }

    @RequestMapping(value = "/delete/all", method = RequestMethod.GET)
    public String deleteAllCartItem() {
        cartItemService.deleteAllCartItem();
        return "redirect:/book/cart";
    }

    @RequestMapping(value = "/delete/simple/{id}", method = RequestMethod.GET)
    public String deleteSimple(@PathVariable("id") Integer id) {
        cartItemService.deleteCartItemById(id);
        return "redirect:/book/cart";
    }
}
