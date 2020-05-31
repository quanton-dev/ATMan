package com.k0ft3.atman.domain.application;

import com.k0ft3.atman.domain.model.activity.Activity;

public interface ActivityService {

    /**
     * Save an activity
     *
     * @param activity the activity instance
     */
    void saveActivity(Activity activity);
}