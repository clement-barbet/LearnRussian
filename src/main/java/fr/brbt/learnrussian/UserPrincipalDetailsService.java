package fr.brbt.learnrussian;

import fr.brbt.learnrussian.db.UserRepository;
import fr.brbt.learnrussian.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public UserPrincipalDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =  userRepository.findByUsername(username);
        UserPrincipal userPrincipal = new UserPrincipal(user);

        return userPrincipal;
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void addUser(String username, String password, String roles, String permissions) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User user = new User((int) (userRepository.count()+1), username, encoder.encode(password), 1, roles, permissions);
        userRepository.save(user);
    }

    public String countEntries() {
        return "" + userRepository.count();
    }


}
