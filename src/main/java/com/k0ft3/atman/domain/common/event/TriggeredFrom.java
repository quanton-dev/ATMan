package com.k0ft3.atman.domain.common.event;

import com.k0ft3.atman.utils.IpAddress;

public interface TriggeredFrom {

    /**
     * Get the IP address where the request originated from
     *
     * @return an IP address
     */
    IpAddress getIpAddress();
}