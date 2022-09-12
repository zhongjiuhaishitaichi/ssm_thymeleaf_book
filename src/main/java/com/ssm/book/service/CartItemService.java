package com.ssm.book.service;


import com.ssm.book.pojo.Cart;
import com.ssm.book.pojo.CartItem;
import com.ssm.book.pojo.User;

import java.util.List;

public interface CartItemService {
    List<CartItem> getCartItemList(User user);

    Cart getCart(User currentUser);

    void addCartItem(CartItem cartItem);

    void updateCartItem(CartItem cartItem);


    void addOrUpdateCart(CartItem cartItem, Cart cart);

    void deleteAllCartItem();

    void deleteCartItemById(Integer id);
}
