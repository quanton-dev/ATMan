package com.k0ft3.atman.domain.common.event;

public interface DomainEventPublisher {

    /**
     * Publish a domain event
     */
    void publish(DomainEvent event);
}