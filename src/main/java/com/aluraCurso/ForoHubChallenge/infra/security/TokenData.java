package com.aluraCurso.ForoHubChallenge.infra.security;

import jakarta.validation.constraints.NotBlank;

public record TokenData(
        @NotBlank
        String token
) {
}
