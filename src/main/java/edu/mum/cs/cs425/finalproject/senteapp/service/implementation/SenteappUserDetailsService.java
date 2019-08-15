package edu.mum.cs.cs425.finalproject.senteapp.service.implementation;

import edu.mum.cs.cs425.finalproject.senteapp.model.User;
import edu.mum.cs.cs425.finalproject.senteapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class SenteappUserDetailsService  implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found"));
        //System.out.println(user.);
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                getAuthorities(user));

    }

    private static Collection<? extends GrantedAuthority> getAuthorities(User user) {
        String[] userRoles = user.getRoles().stream().map((role) -> role.getName()).toArray(String[]::new);
        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
        return authorities;
    }

    public User saveNewUser(User user){
        return userRepository.save(user);
    }

    public  void deleteUser(User user){
        userRepository.delete(user);
    }

    public List<User> userList(){
        return userRepository.findAll();
    }

    public User findUserByEmail(String email){
        return userRepository.findByUsernameEquals(email);
    }
}
