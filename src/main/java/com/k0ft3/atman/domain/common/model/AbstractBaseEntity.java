package com.k0ft3.atman.domain.common.model;

import java.io.Serializable;

public abstract class AbstractBaseEntity implements Serializable {

    private static final long serialVersionUID = -1153931912966528994L;

    public abstract boolean equals(Object obj);

    public abstract int hashCode();

    public abstract String toString();

}