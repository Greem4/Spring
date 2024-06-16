package edu.spring.firstrestapp.controllers;

import edu.spring.firstrestapp.model.Person;
import edu.spring.firstrestapp.service.PeopleService;
import edu.spring.firstrestapp.util.PersonErrorResponse;
import edu.spring.firstrestapp.util.PersonNotCreatedException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PeopleController {

    private final PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping
    public List<Person> getPeople() {
        return peopleService.findAll(); // Jackson конвертирует эти объекты в JSON
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable("id") int id) {
        return peopleService.findOne(id); // Jackson конвертирует в JSON
    }

    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestBody @Valid Person person,
                                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder errorsMsg = new StringBuilder();

            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                errorsMsg.append(error.getField())
                        .append(" - ")
                        .append(error.getDefaultMessage())
                        .append(";");
            }

            throw new PersonNotCreatedException(errorsMsg.toString());
        }

        peopleService.save(person);

        // отправляем HTTP ответ с пустым телом и со статусом 200
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler(PersonNotCreatedException.class)
    private ResponseEntity<PersonErrorResponse> handlerException(PersonNotCreatedException e) {
        PersonErrorResponse response = new PersonErrorResponse(
                e.getMessage(),
                System.currentTimeMillis()
        );

        // В HTTP ответе тело ответа (response) и статус в заголовке
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST); // NOT_FOUND - 404 статус
    }
}
