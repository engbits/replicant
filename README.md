# Replicant
Replicant is a simple Applicant Tracking System (ATS) to aid engineering organizations wrangle all of 
the hires they must complete to sustain their teams.

# Concepts
Replicant is designed around the following key concepts. Each one is intended to be simple and not have 
any overly complicated logic encompassing its existence.

* __Jobs__ - Jobs are posted and tied to a hiring manager. The hiring manager maintains the lifecycle
of the job until it is either filled or closed.
* __Candidates__ - Candidates are tagged for a job, or multiple jobs. Hiring managers then determine
which candidates they wish to screen for the job.
* __Screens__ - Screens are how a candidate is evaluated to be offered, or rejected, a job. There are
three main types of screens, listed below. The hiring manager may add any number of screens for the 
candidate.
  1. _Resume_ - Screens a candidate against their resume to see if they are qualified for the job.
  2. _Phone_ - First screen of a candidate where an interviewer interviews the candidate over the phone
  3. _Interview_ - Screen performed face-to-face where the candidate is evaluated in front of multiple
   people to evaluate their skills.
* __Feedback__ - Feedback is attached to a screen and is given by the interviewer. All feedback is open
for viewing by other interviewers who participate in a screen of the candidate.
