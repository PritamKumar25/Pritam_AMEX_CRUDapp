package com.pritam.amex.CRUDapp.Pritam_amex_CRUDapp.ResponsePayload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {

    private String token;

    private long expiresIn;

}
