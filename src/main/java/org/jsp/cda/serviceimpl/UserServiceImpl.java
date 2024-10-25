package org.jsp.cda.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.dao.UserDao;
import org.jsp.cda.entity.User;
import org.jsp.cda.exceptionclasses.InvalidCredentialsException;
import org.jsp.cda.responsestructure.ResponseStructure;
import org.jsp.cda.utility.AuthOTP;
import org.jsp.cda.utility.AuthUser;
import org.jsp.cda.utility.Helper;
import org.jsp.cda.utility.UserStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.jsp.cda.exceptionclasses.InvalidUserIdException;
import org.jsp.cda.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

	@Autowired
	private Helper helper;

	@Override
	public ResponseEntity<?> saveUser(User user) {

		String email = user.getEmail();
		user.setStatus(UserStatus.IN_ACTIVE);
		user =dao.saveUser(user);

		helper.sendMail(email);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("User Successfully saved").body(user).build());
	}

	@Override
	public ResponseEntity<?> findAllUsers() {
		List<User> li=dao.findAllUsers();
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Found All users").body(li).build());
	}

	@Override
	public ResponseEntity<?> findUserById(int id) {
		Optional<User> u=dao.findUserById(id);
		if(u.isEmpty())
		{
			throw InvalidUserIdException.builder().message("Inavlid user Id.").build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().message("Found  users by Id").body(u).build());
	}


	@Override
	public ResponseEntity<?> updateRoleToStudent(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> login(AuthUser authUser)
	{
//		String username = authUser.getUsername();
//		String password = authUser.getPassword();

		Optional<User> optional = dao.findByUsernameAndPassword(authUser.getUsername(), authUser.getPassword());

		if(optional.isEmpty())
			throw InvalidCredentialsException.builder().message("Invalid Username and password...").build();
//		User user = optional.get();
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("User verification successfully").body(optional.get()).build());
	}

	@Override
	public ResponseEntity<?> verifyOTP(AuthOTP authOTP) {
		Optional<User> optional = dao.findUserById(authOTP.getUid());

		// do validation here
//		if(optional.isEmpty())
//			throw

		User user = optional.get();
//		if(user.getOtp() != authOTP.getOtp())
//			throw
		user.setStatus(UserStatus.ACTIVE);
		user = dao.saveUser(user);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("User activated successfully").body(user).build());
	}


}


