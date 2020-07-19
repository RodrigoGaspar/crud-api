package br.com.rcgasp.cruddemo.service;

import br.com.rcgasp.cruddemo.entity.Funcionario;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class RepositoryFuncionarioMemory implements repositoryFuncionarioAdapter {

    List<Funcionario> banco = new ArrayList<>();

    @Override
    public List<Funcionario> listAll() {
        return banco;
    }

    @Override
    public Funcionario getFuncionarioById(int id) {
        int i;
        for (i = 0; i < banco.size(); i++) {
            if (banco.get(i).id == id) {
                break;
            }
        }
        return banco.get(i);
    }

    @Override
    public void saveFuncionario(Funcionario funcionario) {
        banco.add(funcionario);
    }

    @Override
    public void updateFuncionario(Funcionario funcionario) {
        for (int i = 0; i < banco.size(); i++) {
            if (banco.get(i).id == funcionario.id) {
                banco.set(i, funcionario);
                break;
            }
        }
    }

    @Override
    public void deleteFuncionario(int id) {
        banco.remove(id -1);
    }
}