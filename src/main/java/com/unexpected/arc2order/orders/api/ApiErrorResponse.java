package com.unexpected.arc2order.orders.api;

public record ApiErrorResponse(String code, String message, String traceId) {

}
