package com.home_server.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class AppUserDetails implements UserDetails {

	private static final String ROLE_PREFIX = "ROLE_";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	
//	protected AppUserDetails(User appUser) {
//		this.appUser = appUser;
//	}
//	
//	private User appUser;
//	
//	public User getUser() {
//		return appUser;
//	}
//
//	public void setUser(User appUser) {
//		this.appUser = appUser;
//	}
//	
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		
//		Collection<GrantedAuthority> grantedAuthorities =
//			new ArrayList<GrantedAuthority>();
//		
//		grantedAuthorities.add(new GrantedAuthority() {
//			
//			/**
//			 * 
//			 */
//			private static final long serialVersionUID = 1L;
//
//			@Override
//			public String getAuthority() {
//				return AppUserDetails.ROLE_PREFIX + 
//					AppUserDetails.this.appUser.getUserRole().toString();
//			}
//		});
//		
//		return grantedAuthorities;
//	}
//
//	@Override
//	public String getPassword() {
//		return this.appUser.getPassword();
//	}
//
//	@Override
//	public String getUsername() {
//		return this.appUser.getUsername();
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		
//		return appUser.getAccountStatus() == AccountStatus.ACTIVE;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		
//		return true;
//	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
}
