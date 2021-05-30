package kodlama.io.hrms.api.controller;

import kodlama.io.hrms.business.abstracts.JobAdvertisementService;
import kodlama.io.hrms.core.Utilities.Results.DataResult;
import kodlama.io.hrms.core.Utilities.Results.Result;
import kodlama.io.hrms.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobAdvertisements")
public class JobAdvertisementController {
    @Autowired
    private JobAdvertisementService jobAdvertisementService;

    @PostMapping("/add")
    public Result add(@RequestBody JobAdvertisement jobAdvertisement){
        return this.jobAdvertisementService.add(jobAdvertisement);
    }

    @PutMapping("/setValue")
    public Result setValue(@RequestParam int id,@RequestParam boolean value) {
        return this.jobAdvertisementService.setValue(id, value);
    }

    @GetMapping("/findAllByActiveTrue")
    public DataResult<List<JobAdvertisement>> findAllByActiveTrue() {
        return this.jobAdvertisementService.findAllByActiveTrue();
    }

    @GetMapping("/findAllByActiveTrueOrderByCreatedDateDesc")
    public DataResult<List<JobAdvertisement>> findAllByActiveTrueOrderByCreatedDateDesc() {
        return this.jobAdvertisementService.findAllByActiveTrueOrderByCreatedDateDesc();
    }

    @GetMapping("/findAllByEmployer_IdAndActiveTrue")
    public DataResult<List<JobAdvertisement>> findAllByEmployer_IdAndActiveTrue(@RequestParam int employerId) {
        return this.jobAdvertisementService.findAllByEmployer_IdAndActiveTrue(employerId);
    }

}
