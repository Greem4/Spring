package edu.spring.projectdemoboot.controllers;


import edu.spring.projectdemoboot.dao.PersonDAO;
import edu.spring.projectdemoboot.models.Person;
import edu.spring.projectdemoboot.services.ItemService;
import edu.spring.projectdemoboot.services.PeopleService;
import edu.spring.projectdemoboot.util.PersonValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PeopleService peopleService;
    private final ItemService itemService;

    private final PersonValidator personValidator;

    @Autowired
    public PeopleController(PersonDAO personDAO, PeopleService peopleService, ItemService itemService, PersonValidator personValidator) {
        this.peopleService = peopleService;
        this.itemService = itemService;
        this.personValidator = personValidator;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("people", peopleService.findAll());

        itemService.findByItemName("Airpods");
        itemService.finByOwner(peopleService.findAll().get(0));

        peopleService.test();

        // Получим всех людей из DAO и передадим на отображение в представление
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", peopleService.findOne(id));
        // Получим одного человека по id из DAO и передадим на отображение в представлении
        return "people/show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "people/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") @Valid Person person,
                         BindingResult bindingResult) {
        personValidator.validate(person, bindingResult);

        if (bindingResult.hasErrors())
            return "people/new";

        peopleService.save(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", peopleService.findOne(id));
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid Person person,
                         BindingResult bindingResult,
                         @PathVariable("id") int id) {
        personValidator.validate(person, bindingResult);

        if (bindingResult.hasErrors()) {
            return "people/edit";
        }

        peopleService.update(id, person);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@ModelAttribute("id") int id) {
        peopleService.delete(id);
        return "redirect:/people";
    }
}
