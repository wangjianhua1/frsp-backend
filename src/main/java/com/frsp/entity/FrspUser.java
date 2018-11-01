package com.frsp.entity;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Accessors(chain = true)
@Data
@ToString
public class FrspUser implements Serializable{
    private Long id;
    private String username;
    private String password;
    private String account;
}
