package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.UserContact;
import za.ac.cput.repository.UserContactRepository;
import za.ac.cput.service.UserContactService;

import java.util.List;
import java.util.Optional;

@Service
public class UserContactServiceImpl implements UserContactService {

    private final UserContactRepository userContactRepository;

    @Autowired
    public UserContactServiceImpl(UserContactRepository userContactRepository) {
        this.userContactRepository = userContactRepository;
    }

    @Override
    public UserContact save(UserContact userContact) {
        return this.userContactRepository.save(userContact);
    }


    @Override
    public Optional<UserContact> read(String s) {
        return this.userContactRepository.findById(s);
    }

    @Override
    public boolean delete(UserContact userContact) {
        this.userContactRepository.delete(userContact);
        return false;
    }

        @Override
        public List<UserContact> findAll () {
            return null;
    }

}