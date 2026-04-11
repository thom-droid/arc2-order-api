package com.unexpected.arc2order.orders.api;

import com.unexpected.arc2order.orders.application.OrderNotFoundException;

public record ApiErrorResponse(String code, String message, String traceId) {

}
