package com.k0ft3.atman.domain.common.event;

public interface TriggeredBy {

    /**
     * Get the id of the user who triggered this command
     *
     * @return a user's id
     */
    UserId getUserId();

    /**
     * Get the IP address where the request originated from
     *
     * @return an IP address
     */
    IpAddress getIpAddress();
}©2020 GitHu