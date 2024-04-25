package ukim.finki.backend.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ukim.finki.backend.model.dto.ReqRes;
import ukim.finki.backend.service.AuthService;

@RestController
@RequestMapping("/api/auth")//Or JUST @RequestMapping("/auth")??
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    @PostMapping("/signup")
    public ResponseEntity<ReqRes> signUp(@RequestBody ReqRes signUpRequest){
        return ResponseEntity.ok().body(authService.signUp(signUpRequest));
    }
    @PostMapping("/signin")
    public ResponseEntity<ReqRes> signIn(@RequestBody ReqRes signInRequest){
        return ResponseEntity.ok().body(authService.signIn(signInRequest));
    }
    @PostMapping("/refresh")
    public ResponseEntity<ReqRes> refresh(@RequestBody ReqRes refreshRequest){
        return ResponseEntity.ok().body(authService.refreshToken(refreshRequest));
    }
}
