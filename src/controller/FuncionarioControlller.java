/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.FuncionarioDao;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import domain.Funcionario;

/**
 *
 * @author Super
 */
public class FuncionarioControlller {
    private FuncionarioDao funcionarioDao;

    public FuncionarioControlller(FuncionarioDao funcionarioDao) {
        this.funcionarioDao = funcionarioDao;
    }
    
    public DefaultTableModel llenarTabla(){
        DefaultTableModel model=new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row,int column){
                return false;
            }
        };
        model.addColumn("Id");
        model.addColumn("Número Doc.");
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("Direccion");
        model.addColumn("Telefono");
        model.addColumn("Fecha Nac.");
        List<Funcionario> funcionarios=funcionarioDao.findAll();
        String [] registros= new String [7];
        for(Funcionario f:funcionarios){
            registros[0]=String.valueOf(f.getId());
            registros[1]=f.getNumeroIdentificacion();
            registros[2]=f.getNombres();
            registros[3]=f.getApellidos();
            registros[4]=f.getDireccion();
            registros[5]=f.getTelefono();
            registros[6]=f.getFechaNacimiento().toString();
            model.addRow(registros);
        }
        return model;
    }
    
    public Funcionario listarPorDocumento(String documento){
        return funcionarioDao.findById(documento);
    }
    
    public int guardar(Funcionario funcionario){
        return funcionarioDao.save(funcionario);
    }
    
    public int actualizar(Funcionario funcionario){
        return funcionarioDao.update(funcionario);
    }
    
    public void borrar(String documento){
        funcionarioDao.delete(documento);
    }
}
