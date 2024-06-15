package com.pritam.amex.CRUDapp.Pritam_amex_CRUDapp.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserDto {

    private String email;

    private String password;
}
