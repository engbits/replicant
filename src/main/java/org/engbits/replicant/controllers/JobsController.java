/*
 * Copyright (c) 2017 Tideworks Technology, Inc.
 */

package org.engbits.replicant.controllers;

import org.engbits.replicant.model.Job;
import org.engbits.replicant.service.JobsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @PostMapping("/jobs")
    public String addJob(@ModelAttribute final Job job) {
        jobsService.createJob(job);

        return "redirect:/jobs";
    }

    @GetMapping("/jobs/{jobId}")
    public String showJob(final Model model, @PathVariable("jobId") final Long jobId) {
        final Job job = jobsService.getJobById(jobId);
        model.addAttribute("job", job);

        return "job_detail";
    }

    @GetMapping("/jobs")
    public String showJobs(final Model model) {
        final List<Job> jobs = jobsService.getJobs();
        model.addAttribute("jobs", jobs);

        return "jobs";
    }

    @GetMapping("/jobs/add")
    public String showAddJob(final Model model) {
        model.addAttribute("job", new Job());

        return "add_job";
    }

}
