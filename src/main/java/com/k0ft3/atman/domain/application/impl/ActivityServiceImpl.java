package com.k0ft3.atman.domain.application.impl;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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