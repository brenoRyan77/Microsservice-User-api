package br.com.breno.userapi.resources.impl;

import br.com.breno.userapi.domain.User;
import br.com.breno.userapi.resources.UserResource;
import br.com.breno.userapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
public class UserResourceImpl implements UserResource {

    @Autowired
    private UserService service;

    @Override
    public ResponseEntity<User> findById(Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @Override
    public ResponseEntity<List<User>> findaAll() {
        return ResponseEntity.ok().body(service.findAll());
    }
}
