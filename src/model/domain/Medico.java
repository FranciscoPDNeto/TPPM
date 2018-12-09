package model.domain;

import java.sql.Date;

public class Medico {
    
    private String cpf;
    private int crm;
    private String nome;
    private long telefone;
    private String email;
    private Date hora1;
    private Date hora2;
    private Date hora3;
    private Date horaIntervalo;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getCrm() {
        return crm;
    }

    public void setCrm(int crm) {
        this.crm = crm;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getHora1() {
        return hora1;
    }

    public void setHora1(Date hora1) {
        this.hora1 = hora1;
    }

    public Date getHora2() {
        return hora2;
    }

    public void setHora2(Date hora2) {
        this.hora2 = hora2;
    }

    public Date getHora3() {
        return hora3;
    }

    public void setHora3(Date hora3) {
        this.hora3 = hora3;
    }

    public Date getHoraIntervalo() {
        return horaIntervalo;
    }

    public void setHoraIntervalo(Date horaIntervalo) {
        this.horaIntervalo = horaIntervalo;
    }

}
