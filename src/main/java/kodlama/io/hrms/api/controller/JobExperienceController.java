package kodlama.io.hrms.api.controller;

import kodlama.io.hrms.business.abstracts.JobExperienceService;
import kodlama.io.hrms.core.Utilities.Results.DataResult;
import kodlama.io.hrms.core.Utilities.Results.Result;
import kodlama.io.hrms.entities.concretes.JobExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/jobexperience")
public class JobExperienceController {
    @Autowired
    private JobExperienceService jobExperienceService;

    @GetMapping("/getall")
    public DataResult<List<JobExperience>> getAll(){
        return this.jobExperienceService.getAll();
    }

    @PostMapping("/add")
    public ResponseEntity<?> Add(@Valid @RequestBody JobExperience jobExperience){
        return ResponseEntity.ok(this.jobExperienceService.add(jobExperience));
    }


}
