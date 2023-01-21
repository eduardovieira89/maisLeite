// Generated with g9.

package com.leiteria.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity(name="coberturas")
public class Coberturas{

    /** Primary key. */
    //protected static final String PK = "idCobertura";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_cobertura", unique=true, nullable=false, precision=19)
    private long idCobertura;
    
    @Column(name="qtde_dose_semen", precision=10)
    private int qtdeDoseSemen;
    
    @NotNull(message = "Data é um campo obrigatório")
    @Column(nullable=false, name="data")
    private LocalDate data;
    
    @Column(name="monta_controlada")
    private Boolean montaControlada;
    
    @Column(name="escore_corporal")
    private float escoreCorporal;
    
    @Column(length=255)
    private String observacao;
    
    @NotNull(message = "É obrigatório informar de qual vaca a cobertura será realizada")
    @ManyToOne(optional=false)
    @JoinColumn(name="vaca", nullable=false)
    private Animais vaca;
    
    @ManyToOne
    @JoinColumn(name="touro_monta")
    private Animais touroMonta;
    
    @ManyToOne
    @JoinColumn(name="inseminador")
    private Usuarios inseminador;
    
    @ManyToOne
    @JoinColumn(name="semen")
    private Semens semens;
    
    @NotNull(message = "Tipo de cobertura é um campo obrigatório")
    @ManyToOne
    @JoinColumn(name="tipo_cobertura", nullable=false)
    private TiposCobertura tipoCobertura;


    public Coberturas() {
        super();
    }

    public long getIdCobertura() {
        return idCobertura;
    }
    
    public int getQtdeDoseSemen() {
        return qtdeDoseSemen;
    }
    public void setQtdeDoseSemen(int aQtdeDoseSemen) {
        qtdeDoseSemen = aQtdeDoseSemen;
    }


    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate aData) {
        data = aData;
    }


    public Boolean getMontaControlada() {
        return montaControlada;
    }
    public void setMontaControlada(Boolean aMontaControlada) {
        montaControlada = aMontaControlada;
    }


    public float getEscoreCorporal() {
        return escoreCorporal;
    }
    public void setEscoreCorporal(float aEscoreCorporal) {
        escoreCorporal = aEscoreCorporal;
    }


    public String getObservacao() {
        return observacao;
    }
    public void setObservacao(String aObservacao) {
        observacao = aObservacao;
    }


    public Animais getVaca() {
        return vaca;
    }
    public void setVaca(Animais aAnimais) {
        vaca = aAnimais;
    }


    public Animais getTouroMonta() {
        return touroMonta;
    }
    public void setTouroMonta(Animais aAnimais2) {
        touroMonta = aAnimais2;
    }

    public Usuarios getInseminador() {
        return inseminador;
    }
    public void setInseminador(Usuarios aUsuarios) {
        inseminador = aUsuarios;
    }

    public Semens getSemens() {
        return semens;
    }
    public void setSemens(Semens aSemens) {
        semens = aSemens;
    }

    public TiposCobertura getTipoCobertura() {
        return tipoCobertura;
    }
    public void setTipoCobertura(TiposCobertura aTiposCobertura) {
        tipoCobertura = aTiposCobertura;
    }
    
    /**
     * Compares the key for this instance with another Coberturas.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Coberturas and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Coberturas)) {
            return false;
        }
        Coberturas that = (Coberturas) other;
        if (this.getIdCobertura() != that.getIdCobertura()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Coberturas.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Coberturas)) return false;
        return this.equalKeys(other) && ((Coberturas)other).equalKeys(this);
    }

    /**
     * Returns a hash code for this instance.
     *
     * @return Hash code
     */
    @Override
    public int hashCode() {
        int i;
        int result = 17;
        i = (int)(getIdCobertura() ^ (getIdCobertura()>>>32));
        result = 37*result + i;
        return result;
    }

    /**
     * Returns a debug-friendly String representation of this instance.
     *
     * @return String representation of this instance
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[Coberturas |");
        sb.append(" idCobertura=").append(getIdCobertura());
        sb.append("]");
        return sb.toString();
    }

}
