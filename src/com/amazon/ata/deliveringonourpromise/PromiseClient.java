package com.amazon.ata.deliveringonourpromise;

import com.amazon.ata.deliveringonourpromise.types.Promise;

/**
 * Interface representing a client that provides promises for a given order item.
 * Implementations of this interface are responsible for fetching promise data from various services
 * based on a customer order item ID. The returned {@link Promise} object contains information about
 * delivery expectations, fulfillment status, and other related details.
 */

public interface PromiseClient {

    /**
     * Retrieves the {@link Promise} for a given order item ID.
     *
     * This method is used to fetch the promise details, such as delivery date, shipping date, and
     * fulfillment status, for the provided {@code customerOrderItemId}. The returned {@link Promise}
     * will contain relevant promise data or null if no promise exists for the specified order item.
     *
     * @param customerOrderItemId The unique identifier of the customer order item.
     * @return The {@link Promise} associated with the specified order item, or null if no promise exists.
     */

    Promise getPromiseByOrderItemId(String customerOrderItemId);
}
