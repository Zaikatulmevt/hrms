package kodlama.io.hrms.api.controller;

import io.swagger.models.Response;
import kodlama.io.hrms.business.abstracts.JobAdvertisementService;
import kodlama.io.hrms.core.Utilities.Results.DataResult;
import kodlama.io.hrms.core.Utilities.Results.ErrorDataResult;
import kodlama.io.hrms.core.Utilities.Results.Result;
import kodlama.io.hrms.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/jobAdvertisements")
public class JobAdvertisementController {
    @Autowired
    private JobAdvertisementService jobAdvertisementService;

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody JobAdvertisement jobAdvertisement){
        return ResponseEntity.ok(this.jobAdvertisementService.add(jobAdvertisement));
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
        Map<String, String> validationErrors = new HashMap<String, String>();
        for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Validation Errors");
        return errors;
    }

}
