package com.cjay.ecom.userManagement.user;

import com.cjay.ecom.userManagement.addressInfo.Address;
import com.cjay.ecom.userManagement.paymentMethod.PaymentMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();

    }

    public void addUsers(User user) {
        Optional<User> userByEmail = userRepository.findUserByEmail(user.getEmail());
        if (userByEmail.isPresent()) {
            throw new IllegalStateException("email already associated with an existing user");
        }

        else {
            userRepository.save(user);
        }
    }
}
