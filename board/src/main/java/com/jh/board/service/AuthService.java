package  com.jh.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jh.board.dto.ResponseDto;
import com.jh.board.dto.SignInDto;
import com.jh.board.dto.SignInResponseDto;
import com.jh.board.dto.SignUpDto;
import com.jh.board.entity.UserEntity;
import com.jh.board.repository.UserRepository;
import com.jh.board.security.TokenProvider;

@Service
public class AuthService {
	
	@Autowired UserRepository userRepository;
	@Autowired TokenProvider tokenProvider;
	
	public ResponseDto<?> signUp(SignUpDto dto){
		
		String userEmail = dto.getUserEmail();
		String userPassword = dto.getUserPassword();
		String userPasswordCheck = dto.getUserPasswordCheck();
		
		try {
			if (userRepository.existsById(userEmail)) {
				return ResponseDto.setFailed("Existed Email");
				}
		} catch (Exception e) {
				return ResponseDto.setFailed("Data base Error");
			}
		if(!userPassword.equals(userPasswordCheck)) {
			return ResponseDto.setFailed("Password does not matched!");
		}
		UserEntity userEntity = new UserEntity(dto);
		try {
			userRepository.save(userEntity);
		} catch (Exception e) {
			return ResponseDto.setFailed("Data Base Error");
			}
		return ResponseDto.setSuccess("Sign Up Success!", null);
	}
	public ResponseDto<SignInResponseDto> SignIn(SignInDto dto){
		String userEmail = dto.getUserEmail();
		String userPassword = dto.getUserPassword();
		
		try {
			boolean existed = userRepository.existsByUserEmailAndUserPassword(userEmail, userPassword);
			
			if (!existed) {
				return ResponseDto.setFailed("Sign In Informaion does not Match");
			}
		} catch (Exception error) {
			return ResponseDto.setFailed("Data base Error");
		}
		UserEntity userEntity = null;
		try {
			userEntity = userRepository.findById(userEmail).get();
		} catch (Exception error) {
			return ResponseDto.setFailed("Data base Error");
		}
		
		userEntity.setUserPassword("");
		
		String token = tokenProvider.create(userEmail);
		int exprTime = 3600000;
		SignInResponseDto signInResponseDto = new SignInResponseDto(token, exprTime, userEntity);
		return ResponseDto.setSuccess("Sign In Success", signInResponseDto);
	}
}
