package com.infogain.crewManager.InfogainCrewManagerServerGateway.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.infogain.crewManager.InfogainCrewManagerServerGateway.auth.AuthResponse;
import com.infogain.crewManager.InfogainCrewManagerServerGateway.auth.LoginRequest;
import com.infogain.crewManager.InfogainCrewManagerServerGateway.auth.User;
import com.infogain.crewManager.InfogainCrewManagerServerGateway.service.ILoginService;

@RestController
@RequestMapping("/api")
public class LoginController {

	@Autowired
	private ILoginService iLoginService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private HttpSession httpSession;

	@GetMapping("/signin/getEncodedPassword")
	@ResponseBody
	public String getEncodedPassword(@RequestParam String password) {
		return "encoded password:::" + passwordEncoder.encode(password);
	}

	@CrossOrigin("*")
	@PostMapping("/signin")
	@ResponseBody
	public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest) {

		System.out.println("encoded password:::" + passwordEncoder.encode("bittu@123"));

		
		String crewid = "";
		String token = iLoginService.login(loginRequest.getUsername(), loginRequest.getPassword());
		HttpHeaders headers = new HttpHeaders();
		List<String> headerlist = new ArrayList<>();
		List<String> exposeList = new ArrayList<>();
		headerlist.add("Content-Type");
		headerlist.add(" Accept");
		headerlist.add("X-Requested-With");
		headerlist.add("Authorization");
		headers.setAccessControlAllowHeaders(headerlist);
		exposeList.add("Authorization");
		headers.setAccessControlExposeHeaders(exposeList);
		headers.set("Authorization", token);
		// headers.set("crewId", httpSession.getAttribute("user").toString());

		return new ResponseEntity<AuthResponse>(new AuthResponse(token, (User) httpSession.getAttribute("user")),
				headers, HttpStatus.CREATED);
	}

	@CrossOrigin("*")
	@PostMapping("/signout")
	@ResponseBody
	public ResponseEntity<AuthResponse> logout(@RequestHeader(value = "Authorization") String token) {
		HttpHeaders headers = new HttpHeaders();
		if (iLoginService.logout(token)) {
			headers.remove("Authorization");
			return new ResponseEntity<AuthResponse>(new AuthResponse("logged out", null), headers, HttpStatus.CREATED);
		}
		return new ResponseEntity<AuthResponse>(new AuthResponse("Logout Failed", null), headers,
				HttpStatus.NOT_MODIFIED);
	}

	/**
	 *
	 * @param token
	 * @return boolean. if request reach here it means it is a valid token.
	 */
	@PostMapping("/valid/token")
	@ResponseBody
	public Boolean isValidToken(@RequestHeader(value = "Authorization") String token) {
		return true;
	}

	@PostMapping("/signin/createNewToken")
	@CrossOrigin("*")
	@ResponseBody
	public ResponseEntity<AuthResponse> createNewToken(@RequestHeader(value = "Authorization") String token) {
		String newToken = iLoginService.createNewToken(token);
		HttpHeaders headers = new HttpHeaders();
		List<String> headerList = new ArrayList<>();
		List<String> exposeList = new ArrayList<>();
		headerList.add("Content-Type");
		headerList.add(" Accept");
		headerList.add("X-Requested-With");
		headerList.add("Authorization");
		headers.setAccessControlAllowHeaders(headerList);
		exposeList.add("Authorization");
		headers.setAccessControlExposeHeaders(exposeList);
		headers.set("Authorization", newToken);
		return new ResponseEntity<AuthResponse>(new AuthResponse(newToken,null), headers, HttpStatus.CREATED);
	}
}