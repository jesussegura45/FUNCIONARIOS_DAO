/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import domain.Funcionario;

/**
 *
 * @author Super
 */
public interface FuncionarioDao {
    List<Funcionario> findAll();
    
    Funcionario findById(String documento);
    
    int save(Funcionario funcionario);
    
    int update(Funcionario funcionario);
    
    void delete(String documento);
}
