package model.domain;

public class Equipamento {

    private int codigoEquipamento;
    private int codigoTipoExame;
    private String nome;
    private boolean defeito;

    public int getCodigoEquipamento() {
        return codigoEquipamento;
    }

    public void setCodigoEquipamento(int codigoEquipamento) {
        this.codigoEquipamento = codigoEquipamento;
    }

    public int getCodigoTipoExame() {
        return codigoTipoExame;
    }

    public void setCodigoTipoExame(int codigoTipoExame) {
        this.codigoTipoExame = codigoTipoExame;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isDefeito() {
        return defeito;
    }

    public void setDefeito(boolean defeito) {
        this.defeito = defeito;
    }
    
}
