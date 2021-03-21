package domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public Contact addContact(Contact user) {

        if (user.getId() == null) {
            return contactRepository.save(user);
        } else {
            Optional<Contact> contact = contactRepository.findById(user.getId());
            if (contact.isPresent()) {
                Contact contact1 = contact.get();
                contact1.setFirstName(user.getFirstName());
                contact1.setLastName(user.getLastName());
                contact1.setGender(user.getGender());
                contact1.setPhoneNumber(user.getPhoneNumber());
                contact1 = contactRepository.save(contact1);
                return contact1;
            }
            else {
                user = contactRepository.save(user);
                return user;
            }
        }
    }

    public List<Contact> findAll(){
        return contactRepository.findAll();
    }

    public void deleteContact(Long id){
        contactRepository.deleteById(id);
    }

    public Contact findById(Long id) {
        Optional<Contact> contact = contactRepository.findById(id);
        Contact contact1 = null;
        if(contact.isPresent()){
            contact1 = contact.get();
        }
        else{
            throw new RuntimeException("Bulunamadı" + id);
        }
       return contact1;
    }


}
