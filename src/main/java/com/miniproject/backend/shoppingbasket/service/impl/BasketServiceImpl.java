package com.miniproject.backend.shoppingbasket.service.impl;

import com.miniproject.backend.shoppingbasket.domain.Basket;
import com.miniproject.backend.shoppingbasket.dto.BasketResponseDTO;
import com.miniproject.backend.shoppingbasket.repository.BasketRepository;
import com.miniproject.backend.shoppingbasket.service.BasketService;
import com.miniproject.backend.user.domain.User;
import com.miniproject.backend.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BasketServiceImpl implements BasketService {

    private final BasketRepository basketRepository;

    private final UserRepository userRepository;

    @Override
    public List<BasketResponseDTO> selectBasketList(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if(user!=null) {
            return basketRepository.findById(user.get().getId())
                    .stream().map(entity -> new BasketResponseDTO(entity))
                    .collect(Collectors.toList());
        }else{
            // TODO 예외처리 추가하기
            return null;
        }

    }
}
