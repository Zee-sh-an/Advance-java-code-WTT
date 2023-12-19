package com.productapi.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class Error {
    private final String message;
    //    private final String message;
    private String code;

}
