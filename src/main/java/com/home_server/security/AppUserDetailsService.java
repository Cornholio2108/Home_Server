package com.home_server.security;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AppUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
//
//	@Resource
//	private GenericDAO genericDAO;
//	
//	@Override
//	@Transactional(readOnly=true)
//	public UserDetails loadUserByUsername(String username)
//			throws UsernameNotFoundException {
//		
//		Map<String, Object> equalAttrs = new HashMap<String, Object>();
//		equalAttrs.put("username", username);
//		
//		User user = genericDAO.getEntity(User.class, equalAttrs);
//		
//		if(user == null) {
//			throw new UsernameNotFoundException("Can't find username: " + username);
//		}
//		
//		return new AppUserDetails(user);
//	}
}
