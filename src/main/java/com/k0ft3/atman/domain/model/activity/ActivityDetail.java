package com.k0ft3.atman.domain.model.activity;

import java.util.HashMap;
import java.util.Map;

import com.k0ft3.atman.utils.JsonUtils;

class ActivityDetail {

    private Map<String, Object> detail = new HashMap<>();

    private ActivityDetail() {
    }

    static ActivityDetail blank() {
        return new ActivityDetail();
    }

    public ActivityDetail add(String key, Object value) {
        detail.put(key, value);
        return this;
    }

    String toJson() {
        return JsonUtils.toJson(detail);
    }
}