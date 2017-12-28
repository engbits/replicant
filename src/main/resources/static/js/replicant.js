$(document).ready(function () {
    $("#tagCandidateButton").on('click', function(e) {
        $("#tagCandidateForm").submit();
        e.preventDefault();
    });
});