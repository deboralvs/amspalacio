package br.com.sankhya.entity;

public class Client {

    private String tipPessoa;
    private String nomeParc;
    private String codCid;
    private String ativo;
    private String cliente;
    private String classificMS;

    public Client() {
    }

    public Client(String tipPessoa, String nomeParc, String codCid, String ativo, String cliente, String classificMS) {
        this.tipPessoa = tipPessoa;
        this.nomeParc = nomeParc;
        this.codCid = codCid;
        this.ativo = ativo;
        this.cliente = cliente;
        this.classificMS = classificMS;
    }

    public String getTipPessoa() {
        return tipPessoa;
    }

    public void setTipPessoa(String tipPessoa) {
        this.tipPessoa = tipPessoa;
    }

    public String getNomeParc() {
        return nomeParc;
    }

    public void setNomeParc(String nomeParc) {
        this.nomeParc = nomeParc;
    }

    public String getCodCid() {
        return codCid;
    }

    public void setCodCid(String codCid) {
        this.codCid = codCid;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getClassificMS() {
        return classificMS;
    }

    public void setClassificMS(String classificMS) {
        this.classificMS = classificMS;
    }
}
