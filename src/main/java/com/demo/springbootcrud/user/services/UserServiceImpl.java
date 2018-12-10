package com.demo.springbootcrud.user.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.springbootcrud.exceptions.UserNotFoundException;
import com.demo.springbootcrud.task.models.Task;
import com.demo.springbootcrud.task.models.TaskHistory;
import com.demo.springbootcrud.user.dtos.UserCreateDto;
import com.demo.springbootcrud.user.dtos.UserDto;
import com.demo.springbootcrud.user.models.User;
import com.demo.springbootcrud.user.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto addUser(UserCreateDto userCreateDto) {
		User user = modelMapper.map(userCreateDto, User.class);
		userRepository.save(user);
		
		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public User getUserById(Long userId) throws UserNotFoundException {
		return userRepository.findById(userId)
					.orElseThrow(() -> new UserNotFoundException());
	}

	@Override
	public UserDto getCompleteUser(Long id) throws UserNotFoundException {
		Optional<User> optionalUser = userRepository.findById(id);
		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			
			List<Task> tasks = user.getTasks();
			
			for (Task task : tasks) {
				List<TaskHistory> histories = task.getHistory();
				histories.size();
			}
			
			return modelMapper.map(user, UserDto.class);
		} else {
			throw new UserNotFoundException();
		}
	}

}
