/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import domain.Conexion;
import domain.Funcionario;
import java.sql.PreparedStatement;
import utis.Mensajes;

/**
 *
 * @author Super
 */
public class FuncionarioDaoImpl implements FuncionarioDao {
    
    private Conexion conexion;
    private Statement st;
    private ResultSet rS;
    private PreparedStatement pSt;

    @Override
    public List<Funcionario> findAll() {
        List<Funcionario> funcionarios = new ArrayList<>();
            try {
                /*
                String sql="
                SELECT f.*,t.nombre nombret,e.nombre nombre e 
                FROM funcionarios f
                INNER JOIN tipos_identificacion t
                ON f.tipos_identificacion_id=t.id
                INNER JOIN estados_civiles e
                ON f.estados_civiles_id=e.id
                "
                */
                String sql = "SELECT * FROM funcionarios";
                conexion=new Conexion();
                st=conexion.getCon().createStatement();
                rS=st.executeQuery(sql);
                while(rS.next()){
                    Funcionario funcionario= new Funcionario();
                    funcionario.setId(rS.getInt("id"));
                    funcionario.setNumeroIdentificacion(rS.getString("numero_identificacion"));
                    funcionario.setNombres(rS.getString("nombres"));
                    funcionario.setApellidos(rS.getString("apellidos"));
                    funcionario.setDireccion(rS.getString("direccion"));
                    funcionario.setTelefono(rS.getString("telefono"));
                    funcionario.setFechaNacimiento(LocalDate.parse(rS.getString("fecha_nacimiento")));
                    funcionarios.add(funcionario);
                }
                st.close();
                rS.close();
                conexion.getCon().close();
            } catch (SQLException ex) {
                Mensajes.mensajeError("Error de BBDD", ex.getMessage());
            }

            return funcionarios;
    }

    @Override
    public Funcionario findById(String documento) {
        Funcionario funcionario = new Funcionario();
        String sql = "SELECT * FROM funcionarios WHERE numero_identificacion=?";
        conexion=new Conexion();
        try {
            
            
            pSt=conexion.getCon().prepareStatement(sql);
            pSt.setString(1, documento);
            rS=pSt.executeQuery();
            if(rS.first()){
                funcionario.setId(rS.getInt("id"));
                funcionario.setNumeroIdentificacion(rS.getString("numero_identificacion"));
                funcionario.setNombres(rS.getString("nombres"));
                funcionario.setApellidos(rS.getString("apellidos"));
                funcionario.setDireccion(rS.getString("direccion"));
                funcionario.setTelefono(rS.getString("telefono"));
                funcionario.setFechaNacimiento(LocalDate.parse(rS.getString("fecha_nacimiento"))); 
            }
            pSt.close();
            rS.close();
            conexion.getCon().close();
        } catch (SQLException ex) {
            Mensajes.mensajeError("Error de BBDD", ex.getMessage());
        }
        
        return funcionario;
    }

    @Override
    public int save(Funcionario funcionario) {
        int resultado=0;
        String sql = "INSERT INTO funcionarios(" +
                "numero_identificacion," +
                "nombres," +
                "apellidos, " +
                "sexo," +
                "direccion," +
                "telefono," +
                "fecha_nacimiento," +
                "tipos_identificacion_id," +
                "estados_civiles_id" +
                ")" +
                "VALUES(?,?,?,?,?,?,?,?,?);";
        conexion=new Conexion();
        try{
            pSt=conexion.getCon().prepareStatement(sql);
            pSt.setString(1, funcionario.getNumeroIdentificacion());
            pSt.setString(2, funcionario.getNombres());
            pSt.setString(3, funcionario.getApellidos());
            pSt.setString(4, String.valueOf(funcionario.getSexo()));
            pSt.setString(5, funcionario.getDireccion());
            pSt.setString(6, funcionario.getTelefono());
            pSt.setString(7, funcionario.getFechaNacimiento().toString());
            pSt.setInt(8, funcionario.getTipoIdentificacion().getId());
            pSt.setInt(9, funcionario.getEstadoCivil().getId());
            resultado=pSt.executeUpdate();
            pSt.close();
            conexion.getCon().close();
        } catch (SQLException ex) {
            Mensajes.mensajeError("Error de BBDD", ex.getMessage());
        }
        return resultado;
    }

    @Override
    public int update(Funcionario funcionario) {
        int resultado=0;
        int funcID = 0;
        List<Funcionario> func=new ArrayList<>();
        func=findAll();
        for(Funcionario f:func){
            if(f.getNumeroIdentificacion().equals(funcionario.getNumeroIdentificacion())){
                funcID=f.getId();
                break;
            }
        }
        System.out.println(funcID);
        String sql = "UPDATE funcionarios SET numero_identificacion=" +"'"+funcionario.getNumeroIdentificacion()+"'"+
                ",nombres=" +"'"+ funcionario.getNombres()+"'"+
                ",apellidos= " +"'"+ funcionario.getApellidos()+"'"+ ",sexo=" +"'"+ funcionario.getSexo()+"'"+
                ",direccion=" +"'"+funcionario.getDireccion()+"'"+
                ",telefono=" +"'"+ funcionario.getTelefono()+"'"+
                ",fecha_nacimiento=" +"'"+funcionario.getFechaNacimiento()+"'"+
                "WHERE id="+funcID;
        conexion=new Conexion();
        try{
            pSt=conexion.getCon().prepareStatement(sql);
            /*pSt.setString(1, funcionario.getNumeroIdentificacion());
            System.out.println(funcionario.getNumeroIdentificacion());
            pSt.setString(2, funcionario.getNombres());
            pSt.setString(3, funcionario.getApellidos());
            pSt.setString(4, String.valueOf(funcionario.getSexo()));
            pSt.setString(5, funcionario.getDireccion());
            pSt.setString(6, funcionario.getTelefono());
            pSt.setString(7, funcionario.getFechaNacimiento().toString());
            pSt.setInt(8, funcionario.getId());
            System.out.println(funcionario.getId());*/
            System.out.println(sql);
            resultado=pSt.executeUpdate();
            pSt.close();
            conexion.getCon().close();
        } catch (SQLException ex) {
            Mensajes.mensajeError("Error de BBDD", ex.getMessage());
        }
        return resultado;
    }

    @Override
    public void delete(String documento) {
        String sql="DELETE FROM funcionarios WHERE numero_identificacion=?";
        conexion= new Conexion();
        try {
            pSt= conexion.getCon().prepareStatement(sql);
            pSt.setString(1, documento);
            pSt.executeUpdate();
            pSt.close();
            conexion.getCon().close();
        } catch (SQLException ex) {
            Mensajes.mensajeError("Error de BBDD", ex.getMessage());
            
                  
        }
        
        
    }
    
}
