package com.sinoduck.api.service;

import com.sinoduck.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author where.liu
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


}
