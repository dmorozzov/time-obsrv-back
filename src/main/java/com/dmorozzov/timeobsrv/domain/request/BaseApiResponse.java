package com.dmorozzov.timeobsrv.domain.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseApiResponse {

    private BaseApiResponse(Status status, String message) {
        this.status = status;
        this.message = message;
    }

    public enum Status {SUCCESS, WARNING, FAILURE}

    private Status status;
    private String message;

    public static BaseApiResponse success(String message) {
        return new BaseApiResponse(Status.SUCCESS, message);
    }

    public static BaseApiResponse failure(String message) {
        return new BaseApiResponse(Status.FAILURE, message);
    }

    public static BaseApiResponse warn(String message) {
        return new BaseApiResponse(Status.WARNING, message);
    }
}
