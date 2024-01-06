package com.esther.internship.service;

import com.esther.internship.model.Internship;
import com.esther.internship.model.Users;
import com.esther.internship.repository.InternshipRepository;
import com.esther.internship.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userrepository;

    @Autowired
    InternshipRepository internshiprepository;


    public String registerUser(Users users) {

        userrepository.save(users);

        return "redirect:/login";
    }

    public void saveApplication(Internship application) {

        internshiprepository.save(application);
    }

    public boolean validateEmail(String email) {
       boolean emailExists = internshiprepository.existsByEmail(email);
       return emailExists;
        }
        }

//
//    public void saveApplication(Internship application) {
//        userrepository.save(application);
//    }
//}

//    public void saveApplication(Internship application) {
//        userrepository.save(application);
//    }

//    public void validateLogin(Users users) {
//        userrepository.findByEmailAndPassword(users);
//    }
//}
