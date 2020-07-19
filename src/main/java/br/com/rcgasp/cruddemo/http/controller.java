package br.com.rcgasp.cruddemo.http;

import br.com.rcgasp.cruddemo.entity.Funcionario;
import br.com.rcgasp.cruddemo.service.repositoryFuncionarioAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class controller {

    @Autowired
    repositoryFuncionarioAdapter repositoryFuncionario;

    @GetMapping
    public ResponseEntity<?> listAllFuncionario(){
        return  new ResponseEntity<>(repositoryFuncionario.listAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getFuncionarioById(@PathVariable("id") int id){
        return  new ResponseEntity<>(repositoryFuncionario.getFuncionarioById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveFuncionario(@RequestParam int id,
                                             @RequestParam String nome,
                                             @RequestParam String departamento,
                                             @RequestParam double salario){

        Funcionario funcionario = new Funcionario(id, nome, departamento, salario);
        repositoryFuncionario.saveFuncionario(funcionario);

        return  new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<?> updateFuncionario(@RequestParam int id,
                                               @RequestParam String nome,
                                               @RequestParam String departamento,
                                               @RequestParam double salario){

        Funcionario funcionario = new Funcionario(id, nome, departamento, salario);
        repositoryFuncionario.updateFuncionario(funcionario);

        return  new ResponseEntity<>(null, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteFuncionario(@RequestParam int id){

        repositoryFuncionario.deleteFuncionario(id);

        return  new ResponseEntity<>(null, HttpStatus.OK);
    }

}