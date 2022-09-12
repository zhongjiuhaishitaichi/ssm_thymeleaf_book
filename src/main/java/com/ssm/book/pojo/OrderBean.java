package com.ssm.book.pojo;

import java.util.Date;
import java.util.List;

//订单 状态  总的订单 谁的 一共多少钱.....
public class OrderBean {
    private Integer id ;
    private String orderNo ;
    private Date orderDate;
    private User orderUser ;
    private Double orderMoney ;
    private Integer orderStatus;
    //这一个订单里会有多个订单详情 各种各样的书 买了几本...
    private List<OrderItem> orderItemList ;     //1:N
    private Integer totalBookCount;

    @Override
    public String toString() {
        return "OrderBean{" +
                "id=" + id +
                ", orderNo='" + orderNo + '\'' +
                ", orderDate=" + orderDate +
                ", orderUser=" + orderUser +
                ", orderMoney=" + orderMoney +
                ", orderStatus=" + orderStatus +
                ", orderItemList=" + orderItemList +
                ", totalBookCount=" + totalBookCount +
                '}';
    }

    public OrderBean(){}
    public OrderBean(Integer id){
        this.id= id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public User getOrderUser() {
        return orderUser;
    }

    public void setOrderUser(User orderUser) {
        this.orderUser = orderUser;
    }

    public Double getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(Double orderMoney) {
        this.orderMoney = orderMoney;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public Integer getTotalBookCount() {
        return totalBookCount;
    }

    public void setTotalBookCount(Integer totalBookCount) {
        this.totalBookCount = totalBookCount;
    }
}
