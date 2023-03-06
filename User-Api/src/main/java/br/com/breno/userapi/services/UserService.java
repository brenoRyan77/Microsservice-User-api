package br.com.breno.userapi.services;

import br.com.breno.userapi.domain.User;

import java.util.List;

public interface UserService {

    User findById(Long id);
    List<User> findAll();
}
