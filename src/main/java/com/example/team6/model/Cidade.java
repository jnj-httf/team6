package com.example.team6.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cidade
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonProperty("vlr_latitude")
    private String vlrLatitude;
    @JsonProperty("vlr_longitude")
    private String vlrLongitude;
    @JsonProperty("cod_munic")
    private String codMunic;
    @JsonProperty("cod_cnes")
    private String codCnes;
    @JsonProperty("nom_estab")
    private String nomEstab;
    @JsonProperty("dsc_endereco")
    private String dscEndereco;
    @JsonProperty("dsc_bairro")
    private String dscBairro;
    @JsonProperty("dsc_cidade")
    private String dscCidade;
    @JsonProperty("dsc_telefone")
    private String dscTelefone;
    @JsonProperty("dsc_estrut_fisic_ambiencia")
    private String dscEstrutFisicAmbiencia;
    @JsonProperty("dsc_adap_defic_fisic_idosos")
    private String dscAdapDeficFisicIdosos;
    @JsonProperty("dsc_equipamentos")
    private String dscEquipamentos;
    @JsonProperty("dsc_medicamentos")
    private String dscMedicamentos;
    @JsonProperty("co_cep")
    private String coCep;

    @Transient
    private Double distanceFrom;
}