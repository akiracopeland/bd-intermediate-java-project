package com.amazon.ata.deliveringonourpromise.types;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;



public class OrderTest {

    @Test
    public void constructOrder_customerOrderItemList_isImmutable() {
        //GIVEN

        OrderItem original = OrderItem.builder().withOrderId("3").build();
        OrderItem fake = OrderItem.builder().withOrderId("5").build();

        List<OrderItem> originalCustomerOrderItemList = new ArrayList<>();
        originalCustomerOrderItemList.add(original);

        Order originalOrder = Order.builder().withCustomerOrderItemList(originalCustomerOrderItemList).build();

        //WHEN
        List<OrderItem> copyCustomerOrderItemList = originalOrder.getCustomerOrderItemList();
        copyCustomerOrderItemList.set(0, fake);

        //THEN
        assertEquals("3", originalOrder.getCustomerOrderItemList().get(0).getOrderId(), "Expected to not change from PENDING status");

    }
}
