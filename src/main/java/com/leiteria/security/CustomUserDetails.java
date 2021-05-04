package com.leiteria.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.leiteria.model.Usuario;

@SuppressWarnings("serial")
public class CustomUserDetails implements UserDetails {
	
	private Usuario user;
	private Collection<? extends GrantedAuthority> authorities;
	
	

	public CustomUserDetails(Usuario user) {
		List<GrantedAuthority> authorities = user.getRegras().stream()
				.map(role -> new SimpleGrantedAuthority(role.getNomeRegra().name()))
				.collect(Collectors.toList());
		this.authorities = authorities;
		this.user = user;
		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return user.getSenha();
	}

	@Override
	public String getUsername() {
		return user.getEmail();
	}
	
	public String getNomeUsuario() {
		return user.getNome();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
