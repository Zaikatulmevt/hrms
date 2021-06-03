package kodlama.io.hrms.api.controller;

import io.swagger.models.Response;
import kodlama.io.hrms.business.abstracts.JobSeekerService;
import kodlama.io.hrms.core.Utilities.Results.DataResult;
import kodlama.io.hrms.core.Utilities.Results.Result;
import kodlama.io.hrms.entities.concretes.JobPosition;
import kodlama.io.hrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/jobseekers")
public class JobSeekerController {

    @Autowired
    private JobSeekerService jobSeekerService;

    @GetMapping("/getall")
    public DataResult<List<JobSeeker>> getAll() {
        return this.jobSeekerService.getAll();
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody JobSeeker jobSeeker) {
        return ResponseEntity.ok(this.jobSeekerService.add(jobSeeker));

    }
}
