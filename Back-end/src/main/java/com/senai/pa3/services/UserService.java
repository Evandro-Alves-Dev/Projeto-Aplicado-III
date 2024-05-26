package com.senai.pa3.services;

import com.senai.pa3.dto.UserDTO;
import com.senai.pa3.entities.User;
import com.senai.pa3.enums.TipoEnum;
import com.senai.pa3.exceptions.ResourceNotFoundException;
import com.senai.pa3.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //TODO: Implementar o método findAll
    //TODO: Implementar o método findById

    @Transactional
    public UserDTO insert(UserDTO userDTO) {
        User user = new User();
        copyDtoToEntity(userDTO, user);
        user = userRepository.save(user);
        return new UserDTO(user);
    }

    @Transactional
    public UserDTO update(Long id, UserDTO userDTO) {
        try {
            var entity = userRepository.getOne(id);
            copyDtoToEntity(userDTO, entity);
            entity = userRepository.save(entity);
            return new UserDTO(entity);
        } catch (EntityNotFoundException e ) {
            throw new ResourceNotFoundException("Id " + id + " não encontrado");
        }
    }

    //TODO: Implementar o método delete

    private void copyDtoToEntity(UserDTO userDTO, User user) {
        user.setName(userDTO.getName());
        user.setPosition(userDTO.getPosition());
        user.setType(TipoEnum.parse(userDTO.getType()));
    }
}
