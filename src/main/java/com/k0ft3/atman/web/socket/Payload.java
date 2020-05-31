package com.k0ft3.atman.web.socket;

import java.lang.annotation.*;

/**
 * Mark a parameter as the payload in an action method of channel handler.
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Payload {
}