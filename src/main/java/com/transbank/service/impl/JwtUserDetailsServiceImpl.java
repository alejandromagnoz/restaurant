package com.transbank.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//import com.transbank.model.Usuario;
//import com.transbank.repo.IUsuarioRepo;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService{

//	@Autowired
//	private IUsuarioRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		//Usuario usuario = repo.findOneByUsername(username);

		if ("javainuse".equals(username)) {
			
			List<GrantedAuthority> roles = new ArrayList<>();
			roles.add(new SimpleGrantedAuthority("read"));
			
			//se simula para que funcione con usuario "java" y el password = "password" cuya encriptaciòn es la siguiente:
			UserDetails ud = new User("java", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6", roles);
			return ud;

		}else {
			throw new UsernameNotFoundException(String.format("Usuario no encontrado con el nombre: ", username));
		}
	}
}
