package com.cloudwave.best_zizon.global.error;

public record ApiError(int status, String message, String path) {}

