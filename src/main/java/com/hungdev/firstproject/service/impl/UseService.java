package com.hungdev.firstproject.service.impl;

import com.hungdev.firstproject.constant.SystemConstant;
import com.hungdev.firstproject.entity.RoleEntity;
import com.hungdev.firstproject.entity.UserEntity;
import com.hungdev.firstproject.exception.MyException;
import com.hungdev.firstproject.model.PasswordDTO;
import com.hungdev.firstproject.repository.RoleRepository;
import com.hungdev.firstproject.service.IUserService;

import com.hungdev.firstproject.converter.UserConverter;
import com.hungdev.firstproject.model.UserDTO;
import com.hungdev.firstproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UseService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public UserDTO findUserById(Integer id) {
        UserEntity userEntity = userRepository.findById(id).get();
        UserDTO userDTO = userConverter.convertToDto(userEntity);
        return userDTO;
    }

    @Override
    public UserDTO findOneByUserName(String userName) {
        UserEntity userEntity = userRepository.findOneByFullName(userName);
        UserDTO userDTO = userConverter.convertToDto(userEntity);
        return userDTO;
    }

    @Override
    @Transactional
    public UserDTO registerNewUser(UserDTO userDTO) {

        UserEntity newUser = new UserEntity();
        newUser.setFullName(userDTO.getFullName());
        newUser.setPhoneNumber(userDTO.getPhoneNumber());
        newUser.setDateOfBirth(userDTO.getDateOfBirth());
        newUser.setHometown(userDTO.getHometown());
        newUser.setCurrentAddress(userDTO.getCurrentAddress());
        newUser.setProfilePictureUrl(userDTO.getProfilePictureUrl());
        newUser.setHobbies(userDTO.getHobbies());
        newUser.setPersonalStory(userDTO.getPersonalStory());
        newUser.setEmergencyContactPhone(userDTO.getEmergencyContactPhone());
        newUser.setEmergencyContactEmail(userDTO.getEmergencyContactEmail());
        newUser.setPasswordHash(passwordEncoder.encode(userDTO.getPasswordHash()));



        List<RoleEntity> assignedRoles = new ArrayList<>();
        RoleEntity defaultRole = roleRepository.findOneByCode("USER");

        assignedRoles.add(defaultRole);
        newUser.setRoles(assignedRoles);

        UserEntity savedUser = userRepository.save(newUser);

        return userConverter.convertToDto(savedUser);
    }


    @Override
    @Transactional
    public UserDTO login(UserDTO userDTO) throws MyException {
        try {
            // 1. Thực hiện xác thực
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            userDTO.getFullName(),
                            userDTO.getPasswordHash()
                    )
            );

            // 2. Nếu xác thực thành công, lưu vào SecurityContext
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // 3. Lấy thông tin user đã xác thực để trả về
            // (Bạn có thể trả về JWT thay vì UserDTO ở bước này)
            UserEntity userEntity = userRepository.findOneByFullName(userDTO.getFullName());
            return userConverter.convertToDto(userEntity);

        } catch (BadCredentialsException e) {
            // 4. Bắt lỗi nếu sai username hoặc password
            throw new MyException("Invalid username or password!");
        } catch (Exception e) {
            throw new MyException(e.getMessage());
        }
    }


    @Override
    @Transactional
    public UserDTO insert(UserDTO newUser) {
        RoleEntity role = roleRepository.findOneByCode(newUser.getRoleCode());
        UserEntity userEntity = userConverter.convertToEntity(newUser);
        userEntity.setRoles(Stream.of(role).collect(Collectors.toList()));
        userEntity.setPasswordHash(passwordEncoder.encode(SystemConstant.PASSWORD_DEFAULT));
        return userConverter.convertToDto(userRepository.save(userEntity));
    }

    @Override
    @Transactional
    public UserDTO update(Integer id, UserDTO updateUser) {
        RoleEntity role = roleRepository.findOneByCode(updateUser.getRoleCode());
        UserEntity oldUser = userRepository.findById(id).get();
        UserEntity userEntity = userConverter.convertToEntity(updateUser);
        userEntity.setFullName(oldUser.getFullName());
//        userEntity.setStatus(oldUser.getStatus());
        userEntity.setRoles(Stream.of(role).collect(Collectors.toList()));
        userEntity.setPasswordHash(oldUser.getPasswordHash());
        return userConverter.convertToDto(userRepository.save(userEntity));
    }

    @Override
    @Transactional
    public void updatePassword(Integer id, PasswordDTO passwordDTO) throws MyException {
        UserEntity user = userRepository.findById(id).get();
        if (passwordEncoder.matches(passwordDTO.getOldPassword(), user.getPasswordHash())
                && passwordDTO.getNewPassword().equals(passwordDTO.getConfirmPassword())) {
            user.setPasswordHash(passwordEncoder.encode(passwordDTO.getNewPassword()));
            userRepository.save(user);
        } else {
            throw new MyException(SystemConstant.CHANGE_PASSWORD_FAIL);
        }
    }

    @Override
    @Transactional
    public UserDTO resetPassword(Integer id) {
        UserEntity userEntity = userRepository.findById(id).get();
        userEntity.setPasswordHash(passwordEncoder.encode(SystemConstant.PASSWORD_DEFAULT));
        return userConverter.convertToDto(userRepository.save(userEntity));
    }

    @Override
    @Transactional
    public UserDTO updateProfileOfUser(String username, UserDTO updateUser) {
        UserEntity oldUser = userRepository.findOneByFullName(username);
        oldUser.setFullName(updateUser.getFullName());
        oldUser.setDateOfBirth(updateUser.getDateOfBirth());
        oldUser.setPhoneNumber(updateUser.getPhoneNumber());
        oldUser.setHometown(updateUser.getHometown());
        oldUser.setCurrentAddress(updateUser.getCurrentAddress());
        oldUser.setProfilePictureUrl(updateUser.getProfilePictureUrl());
        oldUser.setHobbies(updateUser.getHobbies());
        oldUser.setPersonalStory(updateUser.getPersonalStory());
        oldUser.setEmergencyContactPhone(updateUser.getEmergencyContactPhone());
        oldUser.setEmergencyContactEmail(updateUser.getEmergencyContactEmail());
        return userConverter.convertToDto(userRepository.save(oldUser));
    }

    @Override
    @Transactional
    public void delete(Integer[] ids) {
        for (Integer item : ids) {
            UserEntity userEntity = userRepository.findById(item).get();
//            userEntity.setStatus(0);
            userRepository.save(userEntity);
        }
    }

}
