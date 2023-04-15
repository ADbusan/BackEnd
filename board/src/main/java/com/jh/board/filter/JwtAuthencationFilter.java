package com.jh.board.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.jh.board.security.TokenProvider;

@Component
public class JwtAuthencationFilter extends OncePerRequestFilter {

//	request가 들어왔을 때 request header의 autohorization 필드의 bearer toke 가져옴
//	가져온 토은을 검증하고 검증 결과를 securitycontext에 추고
	@Autowired private TokenProvider tokenProvider;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token = parseVearerToken(request);
		if(token != null && !token.equalsIgnoreCase("null")) {
//	토큰 검증해서 payload에 useEmail을 가져옴
			String userEmail = tokenProvider.validate(token);
			
			AbstractAuthenticationToken authentication =
					new UsernamePasswordAuthenticationToken(userEmail,null,AuthorityUtils.NO_AUTHORITIES);
			
			
		}
	}
//	request header의 autohorization 필드의 bearer token을 가져오는 메서드
	private String parseVearerToken(HttpServletRequest request) {
		String bearerToken = request.getHeader("Authorization");
		
		if(StringUtils.hasText(bearerToken)&& bearerToken.startsWith("Bearer"))
			return bearerToken.substring(7);
	}else {
		return null;
	}
	

}
