package com.miniproject.backend.user.service.impl;

import com.miniproject.backend.global.jwt.auth.AuthToken;
import com.miniproject.backend.global.jwt.auth.AuthTokenProvider;
import com.miniproject.backend.user.domain.User;
import com.miniproject.backend.user.dto.LoginRequestDTO;
import com.miniproject.backend.user.exception.UserException;
import com.miniproject.backend.user.exception.UserExceptionType;
import com.miniproject.backend.user.repository.UserRepository;
import com.miniproject.backend.user.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * 로그인 함수
     * @param loginRequestDTO : 이메일, 비밀번호 받는 DTO
     * @return User entity 반환 , 실패시 예외 처리
     */
    @Override
    public User login(LoginRequestDTO loginRequestDTO) {
        User user = userRepository.findByEmail(loginRequestDTO.getEmail())
                .orElseThrow(() -> new UserException(UserExceptionType.ACCOUNT_NOT_EXIST));

        if(passwordEncoder.matches(loginRequestDTO.getPassword(),user.getPassword())) return user;
        else throw new UserException(UserExceptionType.UNMATCHED_PASSWORD);

    }


}
