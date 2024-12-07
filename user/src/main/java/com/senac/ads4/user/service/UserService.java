package com.senac.ads4.user.service;

import com.senac.ads4.user.dto.UserDto;
import com.senac.ads4.user.interfaces.IService;
import com.senac.ads4.user.mapper.UserMapper;
import com.senac.ads4.user.model.UserModel;
import com.senac.ads4.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class UserService implements IService<UserDto, Integer> {

    @Autowired
    public UserMapper userMapper;

    @Autowired
    public UserRepository userRepository;

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public UserDto create(UserDto dto) {
        log.info("UserService::create");

        UserModel userModel = userMapper.toModel(dto);

        UserModel userModelGravado = userRepository.save(userModel);

        return userMapper.toDto(userModelGravado);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDto read(Integer id) {
        log.info("UserService::read(id)");

        UserModel userPesquisado = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Id pesquisado não existe:{}"));

        return userMapper.toDto(userPesquisado);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDto> read() {
        log.info("UserService::read()");

        List<UserModel> userModelList = userRepository.findAll();

        return userMapper.toDtoList(userModelList);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public UserDto update(Integer id, UserDto entity) {
        log.info("UserService::update(id,entity");

        UserModel userPesquisado = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Id pesquisado não existe:{}"));

        userPesquisado.setCpf(entity.getCpf());
        userPesquisado.setEmail(entity.getEmail());
        userPesquisado.setNome(entity.getNome());
        userPesquisado.setTelefone(entity.getTelefone());


        UserModel userAtualizado = userRepository.save(userPesquisado);

        return userMapper.toDto(userAtualizado);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void delete(Integer id) {
        log.info("UserService::delete(id)");

        userRepository.deleteById(id);
    }
}
