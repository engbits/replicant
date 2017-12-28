/*
 * Copyright (c) 2017 Tideworks Technology, Inc.
 */

package org.engbits.replicant.controllers;

import org.engbits.replicant.model.Job;
import org.engbits.replicant.service.JobsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;

import java.util.List;

/**
 * Controller for Jobs functionality
 *
 * @author replicant.team
 * @since 0.1.0
 */
@Controller
@RequestMapping("/jobs")
public class JobsController {

    private final JobsService jobsService;

    @Inject
    public JobsController(final JobsService jobsService) {
        this.jobsService = jobsService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addJob(@ModelAttribute final Job job) {
        jobsService.createJob(job);

        return "redirect:/jobs";
    }

    @RequestMapping(value = "/{jobId}", method = RequestMethod.GET)
    public ModelAndView showJob(@PathVariable("jobId") final Long jobId) {
        final Job job = jobsService.getJobById(jobId);

        final ModelAndView mv = new ModelAndView("job_detail");
        mv.addObject("job", job);

        return mv;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showJobs() {
        final List<Job> jobs = jobsService.getJobs();

        final ModelAndView mv = new ModelAndView("jobs");
        mv.addObject("jobs", jobs);

        return mv;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView showAddJob() {
        final ModelAndView mv = new ModelAndView("jobs");
        mv.addObject("job", new Job());

        return mv;
    }

}
