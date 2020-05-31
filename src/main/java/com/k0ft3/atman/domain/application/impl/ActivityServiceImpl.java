package com.k0ft3.atman.domain.application.impl;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import com.k0ft3.atman.domain.application.ActivityService;
import com.k0ft3.atman.domain.model.activity.Activity;
import com.k0ft3.atman.domain.model.activity.ActivityRepository;

@Service
@Transactional
public class ActivityServiceImpl implements ActivityService {

    private ActivityRepository activityRepository;

    public ActivityServiceImpl(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @Override
    public void saveActivity(Activity activity) {
        activityRepository.save(activity);
    }
}