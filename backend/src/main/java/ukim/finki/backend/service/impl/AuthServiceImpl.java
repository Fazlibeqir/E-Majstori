package ukim.finki.backend.service.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ukim.finki.backend.configs.JWTUtils;
import ukim.finki.backend.model.AppUser;
import ukim.finki.backend.model.JobProvider;
import ukim.finki.backend.model.dto.ReqRes;
import ukim.finki.backend.repository.AppUserRepository;
import ukim.finki.backend.repository.JobProviderRepository;
import ukim.finki.backend.service.AuthService;

import java.util.HashMap;
@Service
public class AuthServiceImpl implements AuthService {
    private final AppUserRepository appUserRepository;
    private final JWTUtils jwtUtils;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    private final JobProviderRepository jobProviderRepository;

    public AuthServiceImpl(AppUserRepository appUserRepository, JWTUtils jwtUtils,
                           PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JobProviderRepository jobProviderRepository) {
        this.appUserRepository = appUserRepository;
        this.jwtUtils = jwtUtils;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jobProviderRepository = jobProviderRepository;
    }

    @Override
    public ReqRes signUp(ReqRes registrationRequest) {
        ReqRes resp = new ReqRes();
        try {
            AppUser ourUsers = new AppUser();
            ourUsers.setUsername(registrationRequest.getUsername());
            ourUsers.setPhoneNumber(registrationRequest.getPhoneNumber());
            ourUsers.setEmail(registrationRequest.getEmail());
            ourUsers.setFirstName(registrationRequest.getFirstName());
            ourUsers.setLastName(registrationRequest.getLastName());
            ourUsers.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
            JobProvider jobProvider = new JobProvider();
            AppUser ourUserResult = appUserRepository.save(ourUsers);
            jobProvider.setAppUser(ourUserResult);
            jobProvider.setName(ourUserResult.getFirstName() + " " + ourUserResult.getLastName());
            jobProviderRepository.save(jobProvider);
            ourUserResult.setJobProvider(jobProviderRepository.save(jobProvider));
            appUserRepository.save(ourUserResult);
            if (ourUserResult.getId()>0) {
                resp.setAppUser(ourUserResult);
                resp.setMessage("User Saved Successfully");
                resp.setStatusCode(200);
            }
        }catch (Exception e){
            resp.setStatusCode(500);
            resp.setError(e.getMessage());
        }
        return resp;
    }

    @Override
    public ReqRes signIn(ReqRes signingRequest) {
        ReqRes response = new ReqRes();

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signingRequest.getEmail(),signingRequest.getPassword()));
            AppUser user = appUserRepository.findByEmail(signingRequest.getEmail()).orElseThrow();
            System.out.println("USER IS: "+ user);//TODO Remove this line
            String jwt = jwtUtils.generateToken(user);
            String refreshToken = jwtUtils.generateRefreshToken(new HashMap<>(), user);
            response.setStatusCode(200);
            response.setToken(jwt);
            response.setRefreshToken(refreshToken);
            response.setExpirationTime("24Hr");
            response.setMessage("Successfully Signed In");
        }catch (Exception e){
            response.setStatusCode(500);
            response.setError(e.getMessage());
        }
        return response;
    }

    @Override
    public ReqRes refreshToken(ReqRes refreshTokenRequest) {
        ReqRes response = new ReqRes();
        String ourEmail = jwtUtils.extractUsername(refreshTokenRequest.getToken());
        AppUser users = appUserRepository.findByEmail(ourEmail).orElseThrow();
        if (jwtUtils.isTokenValid(refreshTokenRequest.getToken(), users)) {
            String jwt = jwtUtils.generateToken(users);
            response.setStatusCode(200);
            response.setToken(jwt);
            response.setRefreshToken(refreshTokenRequest.getToken());
            response.setExpirationTime("24Hr");
            response.setMessage("Successfully Refreshed Token");
        }
        response.setStatusCode(500);
        return response;
    }
}
