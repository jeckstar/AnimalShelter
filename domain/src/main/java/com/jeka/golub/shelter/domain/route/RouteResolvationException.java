package com.jeka.golub.shelter.domain.route;

public class RouteResolvationException extends RuntimeException {

    public RouteResolvationException() {
    }

    public RouteResolvationException(String s) {
        super(s);
    }

    public RouteResolvationException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public RouteResolvationException(Throwable throwable) {
        super(throwable);
    }

}
