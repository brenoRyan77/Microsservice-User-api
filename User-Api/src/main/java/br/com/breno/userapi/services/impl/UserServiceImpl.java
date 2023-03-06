package br.com.breno.userapi.services.impl;

import br.com.breno.userapi.domain.User;
import br.com.breno.userapi.repositories.UserRepository;
import br.com.breno.userapi.services.UserService;
import br.com.breno.userapi.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User findById(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("Object not found"));
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }
}
