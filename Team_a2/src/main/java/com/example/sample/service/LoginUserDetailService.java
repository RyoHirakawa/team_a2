package com.example.sample.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.sample.model.User;
import com.example.sample.repository.UserRepository;

@Service
public class LoginUserDetailService implements UserDetailsService {
	 @Autowired
	 private UserRepository userRepository;
 
	 @Autowired
	    private PasswordEncoder passwordEncoder;

	    public User save(User user) {
	        user.setPassword(passwordEncoder.encode(user.getPassword()));
	        return userRepository.save(user);
	    }
	 
	 
	  public LoginUserDetailService(UserRepository userRepository) {
	    this.userRepository = userRepository;
	  }
	
	  @Override
	  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	    Optional<User> _user = userRepository.findByEmail(email);
	    return _user.map(user -> new LoginUserDetails(user))
	        .orElseThrow(() -> new UsernameNotFoundException("not found email=" + email));
	  }
}