package com.invest.user_service.DTO;

import org.antlr.v4.runtime.misc.NotNull;

public record UserDTO(
        @NotNull String username,
        @NotNull String email,
        @NotNull String password,
        @NotNull String documentId,
        String phone
) { }

