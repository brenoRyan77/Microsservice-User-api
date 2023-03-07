package br.com.breno.userapi.services.impl;

import br.com.breno.userapi.domain.User;
import br.com.breno.userapi.repositories.UserRepository;
import br.com.breno.userapi.services.UserService;
import br.com.breno.userapi.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;
    private final Environment envi;

    @Override
    public User findById(Long id) {

        log.info("USER_SERVICE ::: Get request on "
                + envi.getProperty("local.server.port") + " port" );

        return repository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("Object not found"));
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }
}
