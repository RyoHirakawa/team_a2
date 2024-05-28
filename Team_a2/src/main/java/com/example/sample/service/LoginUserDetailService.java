package com.example.sample.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.sample.model.Role;
import com.example.sample.model.User;
import com.example.sample.repository.RoleRepository;
import com.example.sample.repository.UserRepository;

@Service
public class LoginUserDetailService implements UserDetailsService {
	 @Autowired
	 private UserRepository userRepository;
	 
	 @Autowired
	 private RoleRepository roleRepository;
	 
	 
	
 
	 @Autowired
	    private PasswordEncoder passwordEncoder;

	    public User save(User user, String roleName) {
	        user.setPassword(passwordEncoder.encode(user.getPassword()));
	        Set<Role> roles = new HashSet<>();
	        Role role = roleRepository.findByName(roleName);
	        if (role != null) {
	            roles.add(role);
	        }
	        user.setRoles(roles);
	        return userRepository.save(user);
	    }
	    
	    public void saveUserWithDefaultRole(User user) {
	        Role defaultRole = roleRepository.findByName("ROLE_USER");
	        if (defaultRole == null) {
	            defaultRole = new Role();
	            defaultRole.setName("ROLE_USER");
	            roleRepository.save(defaultRole);
	        }
	        user.setPassword(passwordEncoder.encode(user.getPassword()));
	        Set<Role> roles = new HashSet<>();
	        roles.add(defaultRole);
	        user.setRoles(roles);
	        userRepository.save(user);
	    }

	    public void saveUserWithAdminRole(User user) {
	        Role adminRole = roleRepository.findByName("ROLE_ADMIN");
	        if (adminRole == null) {
	            adminRole = new Role();
	            adminRole.setName("ROLE_ADMIN");
	            roleRepository.save(adminRole);
	        }
	        user.setPassword(passwordEncoder.encode(user.getPassword()));
	        Set<Role> roles = new HashSet<>();
	        roles.add(adminRole);
	        user.setRoles(roles);
	        userRepository.save(user);
	    }
	 
	 
	  public LoginUserDetailService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
	    this.userRepository = userRepository;
	    this.roleRepository = roleRepository;
	    this.passwordEncoder = passwordEncoder;
	  }
	
	  @Override
	  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	    Optional<User> _user = userRepository.findByEmail(email);
	    return _user.map(user -> new LoginUserDetails(user))
	        .orElseThrow(() -> new UsernameNotFoundException("not found email=" + email));
	  }


	public Set<String> getUserRoles(String username) {
		return userRepository.findRolesByName(username);
	}
}