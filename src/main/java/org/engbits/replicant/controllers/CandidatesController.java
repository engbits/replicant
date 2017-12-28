/*
 * Copyright (c) 2017 Tideworks Technology, Inc.
 */

package org.engbits.replicant.controllers;

import org.engbits.replicant.model.Candidate;
import org.engbits.replicant.service.CandidatesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;

import java.util.List;

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
    public String showCandidates(final Model model) {
        final List<Candidate> candidates = candidatesService.getCandidates();
        model.addAttribute("candidates", candidates);

        return "candidates";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showAddCandidate(final Model model) {
        model.addAttribute("candidate", new Candidate());

        return "add_candidate";
    }

}
