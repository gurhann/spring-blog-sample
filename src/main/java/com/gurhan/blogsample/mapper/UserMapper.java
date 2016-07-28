package com.gurhan.blogsample.mapper;

import java.util.ArrayList;
import java.util.List;

import com.gurhan.blogsample.persistence.model.User;
import com.gurhan.blogsample.web.dto.UserDTO;

public class UserMapper {

	public static UserDTO userModelToDTO(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setEmail(user.getEmail());
		userDTO.setFirstName(user.getFirtName());
		userDTO.setLastName(user.getLastName());
		return userDTO;
	}

	public static User userDTOToModel(UserDTO userDTO) {
		User user = new User();
		user.setEmail(userDTO.getEmail());
		user.setId(userDTO.getId());
		user.setFirtName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setPassword(userDTO.getPassword());
		return user;
	}

	public static List<UserDTO> userListModelTODTO(List<User> userList) {
		List<UserDTO> userDTOList = new ArrayList<UserDTO>();
		for (User user : userList) {
			userDTOList.add(userModelToDTO(user));
		}
		return userDTOList;
	}

	public static List<User> userListDTOToModel(List<UserDTO> userDTOList) {
		List<User> userList = new ArrayList<User>();
		for (UserDTO userDTO : userDTOList) {
			userList.add(userDTOToModel(userDTO));
		}
		return userList;
	}
}
