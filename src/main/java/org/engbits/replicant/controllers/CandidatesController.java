/*
 * Copyright (c) 2017 Tideworks Technology, Inc.
 */

package org.engbits.replicant.controllers;

import org.engbits.replicant.model.Candidate;
import org.engbits.replicant.service.CandidatesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;

import java.util.List;

/**
 * Controller for Candidates functionality
 *
 * @author replicant.team
 * @since 0.1.0
 */
@Controller
public class CandidatesController {

    private CandidatesService candidatesService;

    @Inject
    public CandidatesController(final CandidatesService candidatesService) {
        this.candidatesService = candidatesService;
    }

    @RequestMapping("/candidates")
    public String showCandidates(final Model model) {
        final List<Candidate> candidates = candidatesService.getCandidates();
        model.addAttribute("candidates", candidates);

        return "candidates";
    }
}
