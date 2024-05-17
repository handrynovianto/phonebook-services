package com.example.phonebookservices.services;

import com.example.phonebookservices.dao.ContactRepository;
import com.example.phonebookservices.dto.Contact;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServices {
    private final ContactRepository contactRepository;

    public ContactServices(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<Contact> getAllContact() {
        return (List<Contact>) contactRepository.findAll();
    }

    public Object getContactById(Long id) {
        return contactRepository.findById(id).orElse(null);
    }
    public Object getContactByPhone(String phone) {
        return contactRepository.findByPhone(phone).orElse(null);
    }

    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }

    public void updateContact(Long id, Contact updatedContact) {
        Optional<Contact> existingContactOptional = contactRepository.findById(id);
        if (existingContactOptional.isPresent()) {
            Contact existingContact = existingContactOptional.get();
            existingContact.setName(updatedContact.getName());
            existingContact.setPhone(updatedContact.getPhone());
            existingContact.setEmail(updatedContact.getEmail());
            contactRepository.save(existingContact);
        } else {
            // Handle error if contact with given id doesn't exist
        }
    }
}
