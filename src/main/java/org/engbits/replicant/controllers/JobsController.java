/*
 * Copyright (c) 2017 Tideworks Technology, Inc.
 */

package org.engbits.replicant.controllers;

import org.apache.commons.lang3.StringUtils;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.engbits.replicant.model.Job;
import org.engbits.replicant.model.JobCandidate;
import org.engbits.replicant.service.CandidatesService;
import org.engbits.replicant.service.JobsService;
import org.engbits.replicant.service.ScreensService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

/**
 * Controller for Jobs functionality
 *
 * @author replicant.team
 * @since 0.1.0
 */
@Controller
@RequestMapping("/jobs")
public class JobsController {

    private final CandidatesService candidatesService;
    private final JobsService jobsService;
    private final ScreensService screensService;

    @Inject
    public JobsController(final JobsService jobsService,
                          final CandidatesService candidatesService,
                          final ScreensService screensService) {
        this.jobsService       = jobsService;
        this.candidatesService = candidatesService;
        this.screensService    = screensService;
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
        mv.addObject("allCandidates", candidatesService.getCandidates());
        mv.addObject("jobCandidate", new JobCandidate());

        // Convert the JD to HTML
        if(StringUtils.isNotBlank(job.getDescription())) {
            final Parser parser = Parser.builder().build();
            final Node document = parser.parse(job.getDescription());
            final HtmlRenderer htmlRenderer = HtmlRenderer.builder().build();
            final String jobDescription = htmlRenderer.render(document);
            mv.addObject("jobDescription", jobDescription);
        }

        return mv;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showJobs() {
        final ModelAndView mv = new ModelAndView("jobs");
        mv.addObject("jobs", jobsService.getJobs());

        return mv;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView showAddJob() {
        final ModelAndView mv = new ModelAndView("add_job");
        mv.addObject("job", new Job());

        return mv;
    }

    @RequestMapping(value = "/{jobId}/tag", method = RequestMethod.POST)
    public String tagCandidateForJob(@PathVariable("jobId") final Long jobId,
                                     final HttpServletRequest request) {
        final Long candidateId = Long.valueOf(request.getParameter("candidateId"));

        jobsService.tagCandidateForJob(candidateId, jobId);
        screensService.createFirstScreenForCandidate(candidateId, jobId);

        return "redirect:/jobs/".concat(Long.toString(jobId));
    }

}
