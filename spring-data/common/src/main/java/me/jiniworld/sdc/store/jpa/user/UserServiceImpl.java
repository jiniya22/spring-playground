package me.jiniworld.sdc.store.jpa.user;

import lombok.RequiredArgsConstructor;
import me.jiniworld.sdc.service.UserService;
import org.springframework.data.domain.Limit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public User jiniworldUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public List<User> findAllByEmailContains(String email) {
        return userRepository.findAllByEmailContains(email);
    }

    @Override
    public List<User> findAllByAddress_zipCode(String zipCode) {
        return userRepository.findAllByAddress_zipCode(zipCode);
    }

    @Override
    public Page<User> findAllByAddress__tagContains(String tag, Pageable pageable) {
        return userRepository.findTop2AllByAddress__tagContains(tag, pageable);
    }

    @Override
    public List<User> phone(String fPhone, String sPhone, int size) {
        return userRepository.findAllByfPhoneStartsWithAndInfo_sPhoneContains(fPhone, sPhone, Limit.of(size));
    }
}
