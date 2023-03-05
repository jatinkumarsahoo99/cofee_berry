package com.example.demo.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.example.demo.common.JsonResponse;
import com.example.demo.common.ServerDao;
import com.example.demo.common.security.CustomUserDetailsService;
import com.example.demo.common.security.JwtTokenUtil;

@Repository
public class UserDao {

	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;
	
	 @Autowired 
	 PasswordEncoder passEncoder;
	 
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private CustomUserDetailsService userDetailsService;
	Logger logger = LoggerFactory.getLogger(UserDao.class);

	public JsonResponse<Object> adUserdSignUp(UserModel user) {
		logger.info("Method : adUserdSignUp starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		Boolean validity = true;
		if (user.getUser_name() == null || user.getUser_name() == "") {
			resp.setCode("failed");
			resp.setMessage("User Name required");
			validity = false;
		}
		if (user.getUser_mobile() == null || user.getUser_mobile() == "") {
			resp.setCode("failed");
			resp.setMessage("User Mobile required");
			validity = false;
		}
		if (user.getUser_email() == null || user.getUser_email() == "") {
			resp.setCode("failed");
			resp.setMessage("User Email required");
			validity = false;
		}
		if (user.getUser_password() == null || user.getUser_password() == "") {
			resp.setCode("failed");
			resp.setMessage("User Email required");
			validity = false;
		}
		if (validity) {
			try {
				System.out.println("user===" + user);
				String uid = "";
				// GenerateCreateUserParam.getMeetingMasterParam(user);
				if (user.getUser_id() != null && user.getUser_id() != "") {
					uid = user.getUser_id();
				}
				String password = null;
				if (user.getUser_password() != null && user.getUser_password() != "") {
					password = passEncoder.encode(user.getUser_password());
				} 
				String values = "SET @p_name='" + user.getUser_name() + "',@p_mob='" + user.getUser_mobile()
						+ "',@p_email='" + user.getUser_email() + "',@p_password='" + password + "';";

				System.out.println("VALUES" + values);

				if (user.getUser_id() == null || user.getUser_id() == "") {

					em.createNamedStoredProcedureQuery("create_userRoutines").setParameter("actionType", "create_user")
							.setParameter("actionValue", values).execute();
				} else {

					em.createNamedStoredProcedureQuery("create_userRoutines").setParameter("actionType", "modify_user")
							.setParameter("actionValue", values).execute();
				}

				resp.setCode("Success");
				resp.setMessage("Data Saved Successfully");
			} catch (Exception e) {
				e.printStackTrace();
				resp.setCode("Failed");
				resp.setMessage(e.getLocalizedMessage());

			}
		}
		logger.info("Method : adUserdSignUp ends");
		return resp;
	}

//userSignIn
	@SuppressWarnings("unchecked")
	public JsonResponse<List<UserModel>> userSignIn(String loginid, String password) {
		logger.info("Method : userSignIn starts");
		JsonResponse<List<UserModel>> jsonResponse = new JsonResponse<List<UserModel>>();
		jsonResponse.setCode("");
		jsonResponse.setMessage("");
		try {
			authenticate(loginid,password);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<UserModel> userArray = new ArrayList<UserModel>();
		List<String> userRole = new ArrayList<String>();

		String value = "SET @p_userName='" + loginid + "';";
		System.out.println("value===" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("create_userRoutines")
					.setParameter("actionType", "getUser_byUserName").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				System.out.println("Amar===========" + Arrays.toString(m));
				String role = (String) m[5];

				if (role != null && role.length() > 0) {
					String[] roles = role.split(",");
					userRole = Arrays.asList(roles);
				}

				UserModel user = new UserModel(m[0].toString(), m[1], m[2], m[3], m[4], userRole, m[6], null);
				userArray.add(user);
			}

			String encodePassword = userArray.get(0).getUser_password();
			System.out.println("userArray===" + userArray.size());
			if (userArray.size() > 0) {
				final UserDetails userDetails = userDetailsService.loadUserByUsername(userArray.get(0).getUser_email());
				  final String token = jwtTokenUtil.generateToken(userDetails);
				userArray.get(0).setToken("Bearer " +token);
				logger.info("User Array aaa =====" + userArray);

				if (passEncoder.matches(password, encodePassword)) {
					jsonResponse.setBody(userArray);
					jsonResponse.setCode("Success");
					jsonResponse.setMessage("Data Fetch Successfully");
				} else {

					jsonResponse.setCode("Failed");
					jsonResponse.setMessage("Password Incorrect");
				}
			}

		} catch (Exception e) {
			jsonResponse.setCode("Failed");
			jsonResponse.setMessage("Login Failed");
		}
		logger.info("Method : userSignIn ends");
		return jsonResponse;

	}
private void authenticate(String email, String password) throws Exception {
		
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
		} catch (DisabledException e) {
			throw new Exception("User disabled");
		} catch (BadCredentialsException e) {
			throw new Exception("Bad Credentials");
		}
		
	}
}