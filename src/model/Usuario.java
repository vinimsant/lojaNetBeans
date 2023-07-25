/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author viniv
 */
public class Usuario {
    
    
    
private int idUsuario;
private String usuario;
private String statusDoUsuario;
private String senhaDoUsuario;
private String cpf;
private String dataNascimento;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getStatusDoUsuario() {
        return statusDoUsuario;
    }

    public void setStatusDoUsuario(String statusDoUsuario) {
        this.statusDoUsuario = statusDoUsuario;
    }

    public String getSenhaDoUsuario() {
        return senhaDoUsuario;
    }

    public void setSenhaDoUsuario(String senhaDoUsuario) {
        this.senhaDoUsuario = senhaDoUsuario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    


}



