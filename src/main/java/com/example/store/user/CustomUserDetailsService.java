package com.example.store.user;

import com.example.store.role.Role;
import com.example.store.role.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;


import static java.util.stream.Collectors.toList;


@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findByUsernameIgnoreCase(username)
                .orElseThrow(() -> new RuntimeException(username + " not found"));

        var authorities = mapRolesToAuthorities(user.getRoles());

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getUserPassword(), authorities);
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleName()))
                .collect(toList());
    }

    public User registerUser(User user) {
        boolean isUserExisting = userRepository.existsByUsername(user.getUsername());
        if (isUserExisting) {
            throw new RuntimeException("User with username " + user.getUsername() + " exists");
        }

        var role = roleRepository.findByRoleNameIgnoreCase(user.getUserRole())
                .orElseGet(() -> new Role(null, user.getUserRole()));

        user.setRoles(Set.of(role));
        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));

        return userRepository.save(user);
    }


}
