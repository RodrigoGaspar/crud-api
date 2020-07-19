package br.com.rcgasp.cruddemo.service;

import br.com.rcgasp.cruddemo.entity.Funcionario;

import java.util.List;

public interface repositoryFuncionarioAdapter {

    List<Funcionario> listAll();

    Funcionario getFuncionarioById(int id);

    void saveFuncionario(Funcionario funcionario);

    void updateFuncionario(Funcionario funcionario);

    void deleteFuncionario(int id);

}
