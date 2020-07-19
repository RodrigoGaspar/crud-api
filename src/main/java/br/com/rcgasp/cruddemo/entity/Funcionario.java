package br.com.rcgasp.cruddemo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Funcionario {

    public int id;
    public String nome;
    public String departamento;
    public double salario;

}
