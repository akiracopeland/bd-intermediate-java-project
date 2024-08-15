package com.amazon.ata.deliveringonourpromise.dao;

import com.amazon.ata.deliveringonourpromise.App;
import com.amazon.ata.deliveringonourpromise.ordermanipulationauthority.OrderManipulationAuthorityClient;
import com.amazon.ata.deliveringonourpromise.types.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class OrderDaoTest {

    private OrderDao dao;
    private OrderManipulationAuthorityClient omaClient = App.getOrderManipulationAuthorityClient();


    @Test
    public void get_forKnownOrderId_returnsOrder() {
        //GIVEN - An order ID that we know exists
        final String ORDER_ID = "900-3746402-0000001";
        //WHEN - We call get() with that order ID
        OrderDao dao = new OrderDao(omaClient);
        Order result = dao.get(ORDER_ID);
        //THEN - The result is not null
        assertNotNull(result, "Expected not null");
    }

    @Test
    public void get_forNonExistentOrderId_returnsNull() {
        //GIVEN
        final String ORDER_ID = "900-0000000-0000000";
        //WHEN
        OrderDao dao = new OrderDao(omaClient);
        Order result = dao.get(ORDER_ID);
        //THEN
        assertNull(result, "Expected null order");
    }

}
