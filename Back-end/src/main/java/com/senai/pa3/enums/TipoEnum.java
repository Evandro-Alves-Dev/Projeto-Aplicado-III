package com.senai.pa3.enums;

import com.senai.pa3.exceptions.ParametrosException;

public enum TipoEnum {

    ADMINISTRADOR("Administrador"),
    OPERADOR("Operador");

    private String tipo;

    TipoEnum(String tipo) {
        this.tipo = tipo;
    }

    public static String parse(String type) {
        for (TipoEnum tipoEnum : TipoEnum.values()) {
            if (tipoEnum.tipo.equals(type)) {
                return type;
            }
        }
       throw new ParametrosException("Informar um tipo válido: Administrador ou Operador");
    }
}