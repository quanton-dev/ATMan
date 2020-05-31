package com.k0ft3.atman.web.socket.handlers;

import com.k0ft3.atman.web.socket.Action;
import com.k0ft3.atman.web.socket.ChannelHandler;
import com.k0ft3.atman.web.socket.ChannelValue;
import com.k0ft3.atman.web.socket.RealTimeSession;
import com.k0ft3.atman.web.socket.SubscriptionHub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ChannelHandler("/board/*")
public class BoardChannelHandler {

    private static final Logger log = LoggerFactory.getLogger(BoardChannelHandler.class);

    @Action("subscribe")
    public void subscribe(RealTimeSession session, @ChannelValue String channel) {
        log.debug("RealTimeSession[{}] Subscribe to channel `{}`", session.id(), channel);
        SubscriptionHub.subscribe(session, channel);
    }

    @Action("unsubscribe")
    public void unsubscribe(RealTimeSession session, @ChannelValue String channel) {
        log.debug("RealTimeSession[{}] Unsubscribe from channel `{}`", session.id(), channel);
        SubscriptionHub.unsubscribe(session, channel);
    }
}