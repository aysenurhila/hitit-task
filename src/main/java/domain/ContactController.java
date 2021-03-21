package domain;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping
@AllArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @RequestMapping("/new")
    public String showNewContactPage(Model model) {
        Contact contact = new Contact();
        model.addAttribute("contact", contact);
        return "create_user";
    }

    @PostMapping("/save-contact")
    public String createTheContact(@ModelAttribute("contact") Contact contact){
        contactService.addContact(contact);
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String listAllContact(Model model){
        model.addAttribute("list", contactService.findAll());
        return "index";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteContact(Model model, @PathVariable Long id){
        contactService.deleteContact(id);
        List<Contact> contactList = contactService.findAll();
        model.addAttribute("list", contactList);
        return "contact_list::list_fragment(list=${list})";
    }

    @GetMapping("/updateContact/{id}")
    public String updateContact(@PathVariable (value ="id") Long id, Model model){
        Contact contact = contactService.findById(id);
        model.addAttribute("contact" ,contact);
        return "update_user";
    }

}
