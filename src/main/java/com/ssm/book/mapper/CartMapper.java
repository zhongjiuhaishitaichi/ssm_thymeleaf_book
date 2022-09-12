package com.ssm.book.mapper;

import com.ssm.book.pojo.CartItem;
import com.ssm.book.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface CartMapper {
    List<CartItem> getCartItemList(User user);

    void updateCartItem(CartItem cartItem);

    void addCartItem(CartItem cartItem);

    void deleteAllCartItem();

    void deleteCartItemById(@Param("id") Integer id);
}
