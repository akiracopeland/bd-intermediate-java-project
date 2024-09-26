package com.amazon.ata.deliveringonourpromise.orderfulfillmentservice;

import com.amazon.ata.deliveringonourpromise.PromiseClient;
import com.amazon.ata.deliveringonourpromise.types.Promise;
import com.amazon.ata.orderfulfillmentservice.OrderFulfillmentService;
import com.amazon.ata.orderfulfillmentservice.OrderPromise;

/**
 * Client implementation for accessing the {@link OrderFulfillmentService} to retrieve promises for order items.
 *
 * The {@link OrderFulfillmentServiceClient} acts as a bridge between the order fulfillment service and
 * the promise retrieval system. It implements the {@link PromiseClient} interface, allowing it to be used
 * within the promise fetching infrastructure.
 */

public class OrderFulfillmentServiceClient implements PromiseClient {
    private OrderFulfillmentService ofService;

    /**
     * Constructs a new {@link OrderFulfillmentServiceClient} using the given {@link OrderFulfillmentService}.
     *
     * @param ofService The {@link OrderFulfillmentService} used to retrieve order promises.
     */

    public OrderFulfillmentServiceClient(OrderFulfillmentService ofService) {
        this.ofService = ofService;
    }

    @Override
    public Promise getPromiseByOrderItemId(String customerOrderItemId) {
        OrderPromise orderPromise = ofService.getOrderPromise(customerOrderItemId);

        if (orderPromise == null) {
            return null;
        }

        return Promise.builder()
                .withPromiseLatestArrivalDate(orderPromise.getPromiseLatestArrivalDate())
                .withCustomerOrderItemId(orderPromise.getCustomerOrderItemId())
                .withPromiseLatestShipDate(orderPromise.getPromiseLatestShipDate())
                .withPromiseEffectiveDate(orderPromise.getPromiseEffectiveDate())
                .withIsActive(orderPromise.isActive())
                .withPromiseProvidedBy(orderPromise.getPromiseProvidedBy())
                .withAsin(orderPromise.getAsin())
                .build();
    }
}
