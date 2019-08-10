package demo.example.blogspring1.service;

import demo.example.blogspring1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class UserDetailServiesImpl implements UserDetailsService, Serializable {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        return     userRepository.findByEmail(email).orElseThrow(()->new UsernameNotFoundException(email+" not found."));

    }
}
