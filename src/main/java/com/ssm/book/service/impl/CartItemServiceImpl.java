package com.ssm.book.service.impl;


import com.ssm.book.mapper.BookMapper;
import com.ssm.book.mapper.CartMapper;
import com.ssm.book.pojo.Cart;
import com.ssm.book.pojo.CartItem;
import com.ssm.book.pojo.User;
import com.ssm.book.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartItemServiceImpl  implements CartItemService {

    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private BookMapper bookMapper;
    @Override
    public List<CartItem> getCartItemList(User user) {
        List<CartItem> cartItemList = cartMapper.getCartItemList(user);
        for(CartItem cartItem:cartItemList){
          /*  //查到具体的book  不能只有id
            Book book = bookMapper.getBookById(cartItem.getBook().getId());
            cartItem.setBook(book);*/
            //get方法  就会把xj赋给这个属性了
            cartItem.setXj(cartItem.getXj());
            cartItem.setUserBean(user);
        }
        return cartItemList;
    }

    @Override
    public Cart getCart(User user) {
        //得到一个人的购物车里的所有购物项
        //这里调用自己的 方法getCartItemList 里面的book是具体的信息
        List<CartItem> cartItemList = this.getCartItemList(user);
        //放入map集合
        HashMap<Integer, CartItem> cartItemMap = new HashMap<>();
        for (CartItem cartItem : cartItemList) {
            cartItemMap.put(cartItem.getBook().getId(), cartItem);
        }
        //设置cart  其他的会自己计算的
        Cart cart = new Cart();
        cart.setCartItemMap(cartItemMap);
        return cart;//现在购物车里面就有了 book的具体信息
    }

    @Override
    public void updateCartItem(CartItem cartItem) {
        cartMapper.updateCartItem(cartItem);
    }

    @Override
    public void addOrUpdateCart(CartItem cartItem, Cart cart) {
        //判断当前用户的购物车是否有这本书的cartItem 有update数量 无add 书编号 数量 用户
        if (cart != null) {
            Map<Integer, CartItem> cartItemMap = cart.getCartItemMap();
            if (cartItemMap == null) {
                cartItemMap = new HashMap<>();
            }
            //map里面有对应的这个图书
            if (cartItemMap.containsKey(cartItem.getBook().getId())) {
                CartItem cartItemTemp = cartItemMap.get(cartItem.getBook().getId());
                cartItemTemp.setBuyCount(cartItemTemp.getBuyCount() + 1);
                updateCartItem(cartItemTemp);
            } else {//没有这本书
                addCartItem(cartItem);
            }
        } else {//连购物车都没有
            addCartItem(cartItem);
        }
    }

    @Override
    public void deleteAllCartItem() {
        cartMapper.deleteAllCartItem();
    }

    @Override
    public void deleteCartItemById(Integer id) {
        cartMapper.deleteCartItemById(id);
    }

    public void addCartItem(CartItem cartItem) {
        cartMapper.addCartItem(cartItem);
    }
}
