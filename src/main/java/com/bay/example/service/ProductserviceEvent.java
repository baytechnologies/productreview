package com.bay.example.service;

import org.springframework.context.ApplicationEvent;



/**
 * @Class ProductserviceEvent
 * This is an optional class used in publishing application events.
 * This can be used to inject events into the Spring Boot audit management endpoint.
 * @author Dinesh Metkari
 * @version v0.1
 * @since 2017-01-13
 * 
 */
public class ProductserviceEvent extends ApplicationEvent {

    public ProductserviceEvent(Object source) {
        super(source);
    }

    public String toString() {
        return "My productservice Event";
    }
}