/*
 * Copyright (c) 2017 Tideworks Technology, Inc.
 */

package org.engbits.replicant.controllers;

import org.engbits.replicant.model.Candidate;
import org.engbits.replicant.service.CandidatesService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;

/**
 * Controller for Candidates functionality
 *
 * @author replicant.team
 * @since 0.1.0
 */
@Controller
@RequestMapping("/candidates")
public class CandidatesController {

    private final CandidatesService candidatesService;

    @Inject
    public CandidatesController(final CandidatesService candidatesService) {
        this.candidatesService = candidatesService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addCandidate(@ModelAttribute final Candidate candidate) {
        candidatesService.createCandidate(candidate);

        return "redirect:/candidates";
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showCandidates() {
        final ModelAndView mv = new ModelAndView("candidates");
        mv.addObject("candidates", candidatesService.getCandidates());

        return mv;
    }

    @RequestMapping(value = "/{candidateId}", method = RequestMethod.GET)
    public ModelAndView showCandidate(@PathVariable("candidateId") final Long candidateId) {
        final ModelAndView mv = new ModelAndView("candidate_detail");

        final Candidate candidate = candidatesService.getCandidateById(candidateId);
        mv.addObject("candidate", candidate);

        return mv;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView showAddCandidate() {
        final ModelAndView mv = new ModelAndView("add_candidate");
        mv.addObject("candidate", new Candidate());

        return mv;
    }

}
