package com.aluraCurso.ForoHubChallenge.controller;

import com.aluraCurso.ForoHubChallenge.domain.user.User;
import com.aluraCurso.ForoHubChallenge.domain.user.UserData;
import com.aluraCurso.ForoHubChallenge.infra.security.TokenData;
import com.aluraCurso.ForoHubChallenge.infra.security.TokenService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseBody
@RequestMapping("/login")
@SecurityRequirement(name = "bearer-key")
public class UserController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<TokenData> getLogin(@RequestBody @Valid UserData userData) {
        Authentication authenticationToken = new UsernamePasswordAuthenticationToken(userData.email(), userData.password());
        var userAuth = authenticationManager.authenticate(authenticationToken);
        var token = tokenService.createToken((User) userAuth.getPrincipal());
        return ResponseEntity.ok(new TokenData(token));
    }
}
