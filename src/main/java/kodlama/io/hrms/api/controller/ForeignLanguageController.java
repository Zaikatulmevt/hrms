package kodlama.io.hrms.api.controller;

import kodlama.io.hrms.business.abstracts.ForeignLanguageService;
import kodlama.io.hrms.core.Utilities.Results.DataResult;
import kodlama.io.hrms.core.Utilities.Results.ErrorDataResult;
import kodlama.io.hrms.core.Utilities.Results.Result;
import kodlama.io.hrms.entities.concretes.ForeignLanguage;
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

@RequestMapping("/api/foreignlanguage")
@RestController
public class ForeignLanguageController {

    @Autowired
    private ForeignLanguageService foreignLanguageService;

    @GetMapping("/getall")
    public DataResult<List<ForeignLanguage>> getAll(){
        return this.foreignLanguageService.getAll();
    }

    @PostMapping("/add")
    public ResponseEntity<?> Add(@Valid @RequestBody ForeignLanguage foreignLanguage){
        return ResponseEntity.ok(this.foreignLanguageService.add(foreignLanguage));
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
