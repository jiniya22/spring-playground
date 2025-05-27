package me.jiniworld.sdc.service.user;

import lombok.RequiredArgsConstructor;
import me.jiniworld.sdc.service.UserService;
import me.jiniworld.sdc.domain.UserDetail;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
@RequiredArgsConstructor
@Service
class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDetail findById(Long id) {
        return userRepository.findById(id).map(UserMapper.INSTANCE::toUserDetail).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<UserDetail> findAllByEmailContains(String email) {
        return userRepository.findAllByEmailContains(email).stream().map(UserMapper.INSTANCE::toUserDetail).toList();
    }

}
