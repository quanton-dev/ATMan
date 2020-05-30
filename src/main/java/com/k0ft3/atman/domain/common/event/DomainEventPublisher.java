package com.k0ft3.atman.domain.common.event;

public interface DomainEventPublisher {

    void publish(DomainEvent event);
}