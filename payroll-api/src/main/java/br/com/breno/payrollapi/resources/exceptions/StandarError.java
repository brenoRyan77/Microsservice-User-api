package br.com.breno.payrollapi.resources.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter @Setter
public class StandarError {

    private LocalDateTime timeStamp;
    private String error;
    private Integer status;
    private String path;
}
