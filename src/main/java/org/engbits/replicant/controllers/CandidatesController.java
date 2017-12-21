/*
 * Copyright (c) 2017 Tideworks Technology, Inc.
 */

package org.engbits.replicant.controllers;

import org.engbits.replicant.service.CandidatesService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;

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
    public String showCandidates() {
        return "candidates";
    }
}
