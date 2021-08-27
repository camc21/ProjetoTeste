package br.com.carlos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.carlos.model.Login;
import br.com.carlos.repository.LoginRepository;

@Service
public class LoginService implements UserDetailsService {
	
	@Autowired
	LoginRepository loginRepository;
	
	
	public LoginService(LoginRepository loginRepository) {
		this.loginRepository = loginRepository;
	}

	public Login findByUserName(String userName){
		return loginRepository.findByUserName(userName);
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		var user = loginRepository.findByUserName(userName);
		
		if(user != null) {
			return user;
		} else {
			throw new UsernameNotFoundException("UserName " + userName + " not find");
		}
		
	}
}
