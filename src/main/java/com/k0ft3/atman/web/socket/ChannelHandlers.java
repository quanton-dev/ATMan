package com.k0ft3.atman.web.socket;

public final class ChannelHandlers {

    public static String getPattern(ChannelHandler channelHandler) {
        if (!"".equals(channelHandler.pattern())) {
            return channelHandler.pattern();
        }
        return channelHandler.value();
    }
}