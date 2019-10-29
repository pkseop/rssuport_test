package test.rsupport.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import test.rsupport.entity.CustomUser;
import test.rsupport.repository.CustomUserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private CustomUserRepository customUserRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<CustomUser> opUser = customUserRepository.findByUsername(username);
		CustomUser cUser = opUser.orElseThrow(() -> new UsernameNotFoundException(username));
        return new User(cUser.getUsername(), cUser.getPassword(), authorities());
	}
	
	
	private Collection<? extends GrantedAuthority> authorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

}
