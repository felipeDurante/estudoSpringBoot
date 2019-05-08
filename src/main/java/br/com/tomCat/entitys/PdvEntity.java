//package br.com.tomCat.entitys;
//
//import java.io.Serializable;
//import java.util.Date;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Table(name = "TRD_PDV")
//@Data
//@NoArgsConstructor
//public class PdvEntity implements Serializable {
//
//	private static final long serialVersionUID = 1L;
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "ID_PDV")
//	private Long idPdv;
//
//	@Column(name = "CD_DDD_REGIAO")
//	private String cdDddRegiao;
//
//	@Column(name = "CD_LATTD")
//	private String cdLattd;
//
//	@Column(name = "CD_LONGTD")
//	private String cdLongtd;
//
//	@Column(name = "CD_PDV")
//	private String cdPdv;
//
//	@Column(name = "DS_TP_LOCAL_PDV")
//	private String dsTpLocalPdv;
//
//	@Temporal(TemporalType.DATE)
//	@Column(name = "DT_ATLZCO")
//	private Date dtAtlzco;
//
//	@Temporal(TemporalType.DATE)
//	@Column(name = "DT_CRIAC")
//	private Date dtCriac;
//
//	@Temporal(TemporalType.DATE)
//	@Column(name = "DT_POSTVAC")
//	private Date dtPostvac;
//
//	@Temporal(TemporalType.DATE)
//	@Column(name = "DT_VENC_POSTVAC")
//	private Date dtVencPostvac;
//
//	@Column(name = "ID_TP_LOCAL_PDV")
//	private Long idTpLocalPdv;
//
//	@Column(name = "ID_TP_PDV")
//	private Long idTpPdv;
//
//	@Column(name = "IND_POSTVAC")
//	private String indPostvac;
//
//	@Column(name = "NM_FNTSIA")
//	private String nmFntsia;
//
//	@Column(name = "NM_RAZAO_SOCIAL")
//	private String nmRazaoSocial;
//
//	@Column(name = "NM_REDE")
//	private String nmRede;
//
//	@Column(name = "NM_USUARO_ATLZCO")
//	private String nmUsuaroAtlzco;
//
//	@Column(name = "NM_USUARO_CRIAC")
//	private String nmUsuaroCriac;
//
//	@Column(name = "NR_CNPJ_CPF")
//	private Long nrCnpjCpf;
//
//	@Column(name = "ST_PDV")
//	private String stPdv;
//
//}