package com.example.phonebookservices.controller;

import com.example.phonebookservices.dto.Contact;
import com.example.phonebookservices.services.ContactServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {
    private final ContactServices contactServices;


    public ContactController(ContactServices contactServices) {
        this.contactServices = contactServices;
    }

    @GetMapping
    public List<Contact> getAllContact() {
        return contactServices.getAllContact();
    }

    @GetMapping("/{id}")
    public Contact getStudentById(@PathVariable Long id) {
        return (Contact) contactServices.getContactById(id);
    }
    @GetMapping("/byPhoneNumber/{phone}")
    public Contact getStudentById(@PathVariable String phone) {
        return (Contact) contactServices.getContactByPhone(phone);
    }

    @PostMapping
    public Contact saveStudent(@RequestBody Contact students) {
        return contactServices.saveContact(students);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        contactServices.deleteContact(id);
    }

    @PutMapping("/{id}")
    public void updateContact(@PathVariable Long id, @RequestBody Contact updatedContact) {
        contactServices.updateContact(id, updatedContact);
    }
}
