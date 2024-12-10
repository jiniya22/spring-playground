package me.jiniworld.sdc.store.jpa.user;

import lombok.RequiredArgsConstructor;
import me.jiniworld.sdc.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }
}
