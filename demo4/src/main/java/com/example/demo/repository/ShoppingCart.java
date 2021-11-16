package com.example.demo.repository;

import com.example.demo.bean.Book;
import com.example.demo.bean.CartItem;

import java.util.ArrayList;
import java.util.Iterator;

public class ShoppingCart {
    private ArrayList<CartItem> cart = new ArrayList();

    public ShoppingCart() {
    }

    public ArrayList<CartItem> getCart() {
        return this.cart;
    }

    public void addCartItem(CartItem item) {
        CartItem oldItem = null;
        if (item != null) {
            for (int i = 0; i < this.cart.size(); ++i) {
                oldItem = (CartItem) this.cart.get(i);
                if (oldItem.getId().equals(item.getId())) {
                    oldItem.setQuantity(oldItem.getQuantity() + item.getQuantity());
                    return;
                }
            }

            this.cart.add(item);
        }

    }

    public boolean removeCartItem(String id) {
        CartItem item = null;

        for (int i = 0; i < this.cart.size(); ++i) {
            item = (CartItem) this.cart.get(i);
            if (item.getId().equals(id)) {
                this.cart.remove(i);
                return true;
            }
        }

        return false;
    }

    public void removeAllCartItem() {
        CartItem item = null;
        for (int i = 0; i < this.cart.size(); ++i) {
            item = (CartItem) this.cart.get(i);
            this.cart.remove(i);
        }

    }
    public double getTotal() {
        Iterator<CartItem> it = this.cart.iterator();
        double sum = 0.0D;

        for (CartItem item = null; it.hasNext(); sum += item.getSum()) {
            item = (CartItem) it.next();
        }

        return sum;
    }
}

