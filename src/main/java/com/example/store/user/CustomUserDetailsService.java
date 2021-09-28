package com.example.store.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Data
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    //    private final RoleRepository roleRepository;
    //    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByUsernameIgnoreCase(userName)
                .orElseThrow(() -> new RuntimeException(userName + " could not be found"));
        return new MyUserDetails(user);


//        var authorities = mapRolesToAuthorities(user.getRoles());
//        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getUserPassword(), authorities);
    }

//    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
//        return roles.stream()
//                .map(role -> new SimpleGrantedAuthority(role.getRoleName()))
//                .collect(toList());
//    }
//
//    public User registerUser(User user) {
//        boolean isUserExisting = userRepository.existsByUsername(user.getUserName());
//        if (isUserExisting) {
//            throw new RuntimeException("User with username " + user.getUserName() + " exists");
//        }
//
//        var role = roleRepository.findByRoleNameIgnoreCase(user.getUserRole())
//                .orElseGet(() -> new Role(null, user.getUserRole()));
//
//        user.setRoles(Set.of(role));
//        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
////        user.setUserAge(user.userGetAge());    * enable after datepicker will be placed in registration_form
//        user.setUserCreatedAt(LocalDate.now());
//        return userRepository.save(user);
//    }

}
