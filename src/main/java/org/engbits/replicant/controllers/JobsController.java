/*
 * Copyright (c) 2017 Tideworks Technology, Inc.
 */

package org.engbits.replicant.controllers;

import org.engbits.replicant.model.Job;
import org.engbits.replicant.service.JobsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;

import java.util.List;

/**
 * Controller for Jobs functionality
 *
 * @author replicant.team
 * @since 0.1.0
 */
@Controller
public class JobsController {

    private JobsService jobsService;

    @Inject
    public JobsController(final JobsService jobsService) {
        this.jobsService = jobsService;
    }

    @RequestMapping("/jobs")
    public String showJobs(final Model model) {
        final List<Job> jobs = jobsService.getJobs();
        model.addAttribute("jobs", jobs);

        return "jobs";
    }

}
