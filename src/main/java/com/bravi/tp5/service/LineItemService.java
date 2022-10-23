package com.bravi.tp5.service;

import com.bravi.tp5.entity.LineItem;
import java.math.BigDecimal;
import java.util.Set;

public interface LineItemService {

    void addItemToCart(LineItem lineItem);
    Set<LineItem> getItems();
    void clearCart();
    BigDecimal getCartTotal();
    void printCart();
}
