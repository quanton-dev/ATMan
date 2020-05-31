package com.k0ft3.atman.domain.model.user;

import com.k0ft3.atman.domain.common.model.AbstractBaseId;

public class UserId extends AbstractBaseId {

    private static final long serialVersionUID = -3316570974935023332L;

    public UserId(long id) {
        super(id);
    }

    public String toString() {
        return String.valueOf(value());
    }
}