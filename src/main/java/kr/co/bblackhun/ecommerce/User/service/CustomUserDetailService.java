package kr.co.bblackhun.ecommerce.User.service;

import kr.co.bblackhun.ecommerce.User.model.CustomUserDetail;
import kr.co.bblackhun.ecommerce.User.model.User;
import kr.co.bblackhun.ecommerce.User.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findUserByEmail(email);
        user.orElseThrow(() -> new UsernameNotFoundException("User is not found")
        );
        return user.map(CustomUserDetail::new).get();
    }
}
