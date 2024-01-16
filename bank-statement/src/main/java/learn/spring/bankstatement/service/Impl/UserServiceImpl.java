package learn.spring.bankstatement.service.Impl;

import learn.spring.bankstatement.dao.UserRepository;
import learn.spring.bankstatement.entity.User;
import learn.spring.bankstatement.payload.UserDto;
import learn.spring.bankstatement.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User savedUser = userRepository.save(modelMapper.map(userDto, User.class));
        return modelMapper.map(savedUser, UserDto.class);
    }
}
