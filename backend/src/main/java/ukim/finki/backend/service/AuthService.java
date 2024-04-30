package ukim.finki.backend.service;

import ukim.finki.backend.model.dto.ReqRes;

public interface AuthService {
    ReqRes signUp(ReqRes registrationRequest);
    ReqRes signIn(ReqRes signingRequest);
    ReqRes refreshToken(ReqRes refreshTokenRequest);
}
