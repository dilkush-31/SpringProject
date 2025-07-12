package com.Smart_task.mini_project.Service;
import com.Smart_task.mini_project.DTO.LoginRequest;
import com.Smart_task.mini_project.DTO.RegisterRequest;
import com.Smart_task.mini_project.Entity.UserEntity;
import com.Smart_task.mini_project.Repository.UserRepository;
import com.Smart_task.mini_project.Security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


                public UserEntity registerUser(RegisterRequest request) {
                    UserEntity user = new UserEntity();
                    user.setName(request.getName());
                    user.setEmail(request.getEmail());
                    user.setPassword(passwordEncoder.encode(request.getPassword()));
                    return userRepository.save(user);
                }

    public String login(LoginRequest request) {
        Optional<UserEntity> userOpt = userRepository.findByEmail(request.getEmail());

        if (userOpt.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        UserEntity user = userOpt.get();

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return jwtUtil.generateToken(user.getEmail());
    }
}
