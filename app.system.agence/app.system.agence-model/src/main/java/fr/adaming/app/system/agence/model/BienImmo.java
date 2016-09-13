package fr.adaming.app.system.agence.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the bien_immo database table.
 * 
 */
@Entity
@Table(name="bien_immo")
@NamedQuery(name="BienImmo.findAll", query="SELECT b FROM BienImmo b")
public class BienImmo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_disponibilite")
	private Date dateDisponibilite;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_soumission")
	private Date dateSoumission;

	@Column(name="revenu_cadastral")
	private float revenuCadastral;

	@Column(name="type_bien", length=15)
	private String typeBien;

	//bi-directional many-to-one association to Proprietaire
	@OneToMany(mappedBy="bienImmo1")
	private List<Proprietaire> proprietaires1;

	//bi-directional many-to-one association to Proprietaire
	@OneToMany(mappedBy="bienImmo2")
	private List<Proprietaire> proprietaires2;

	//bi-directional many-to-one association to ClientBienImmo
	@OneToMany(mappedBy="bienImmo1")
	private List<ClientBienImmo> clientHasBienImmos1;

	//bi-directional many-to-one association to ClientBienImmo
	@OneToMany(mappedBy="bienImmo2")
	private List<ClientBienImmo> clientHasBienImmos2;

	public BienImmo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateDisponibilite() {
		return this.dateDisponibilite;
	}

	public void setDateDisponibilite(Date dateDisponibilite) {
		this.dateDisponibilite = dateDisponibilite;
	}

	public Date getDateSoumission() {
		return this.dateSoumission;
	}

	public void setDateSoumission(Date dateSoumission) {
		this.dateSoumission = dateSoumission;
	}

	public float getRevenuCadastral() {
		return this.revenuCadastral;
	}

	public void setRevenuCadastral(float revenuCadastral) {
		this.revenuCadastral = revenuCadastral;
	}

	public String getTypeBien() {
		return this.typeBien;
	}

	public void setTypeBien(String typeBien) {
		this.typeBien = typeBien;
	}

	public List<Proprietaire> getProprietaires1() {
		return this.proprietaires1;
	}

	public void setProprietaires1(List<Proprietaire> proprietaires1) {
		this.proprietaires1 = proprietaires1;
	}

	public Proprietaire addProprietaires1(Proprietaire proprietaires1) {
		getProprietaires1().add(proprietaires1);
		proprietaires1.setBienImmo1(this);

		return proprietaires1;
	}

	public Proprietaire removeProprietaires1(Proprietaire proprietaires1) {
		getProprietaires1().remove(proprietaires1);
		proprietaires1.setBienImmo1(null);

		return proprietaires1;
	}

	public List<Proprietaire> getProprietaires2() {
		return this.proprietaires2;
	}

	public void setProprietaires2(List<Proprietaire> proprietaires2) {
		this.proprietaires2 = proprietaires2;
	}

	public Proprietaire addProprietaires2(Proprietaire proprietaires2) {
		getProprietaires2().add(proprietaires2);
		proprietaires2.setBienImmo2(this);

		return proprietaires2;
	}

	public Proprietaire removeProprietaires2(Proprietaire proprietaires2) {
		getProprietaires2().remove(proprietaires2);
		proprietaires2.setBienImmo2(null);

		return proprietaires2;
	}

	public List<ClientBienImmo> getClientHasBienImmos1() {
		return this.clientHasBienImmos1;
	}

	public void setClientHasBienImmos1(List<ClientBienImmo> clientHasBienImmos1) {
		this.clientHasBienImmos1 = clientHasBienImmos1;
	}

	public ClientBienImmo addClientHasBienImmos1(ClientBienImmo clientHasBienImmos1) {
		getClientHasBienImmos1().add(clientHasBienImmos1);
		clientHasBienImmos1.setBienImmo1(this);

		return clientHasBienImmos1;
	}

	public ClientBienImmo removeClientHasBienImmos1(ClientBienImmo clientHasBienImmos1) {
		getClientHasBienImmos1().remove(clientHasBienImmos1);
		clientHasBienImmos1.setBienImmo1(null);

		return clientHasBienImmos1;
	}

	public List<ClientBienImmo> getClientHasBienImmos2() {
		return this.clientHasBienImmos2;
	}

	public void setClientHasBienImmos2(List<ClientBienImmo> clientHasBienImmos2) {
		this.clientHasBienImmos2 = clientHasBienImmos2;
	}

	public ClientBienImmo addClientHasBienImmos2(ClientBienImmo clientHasBienImmos2) {
		getClientHasBienImmos2().add(clientHasBienImmos2);
		clientHasBienImmos2.setBienImmo2(this);

		return clientHasBienImmos2;
	}

	public ClientBienImmo removeClientHasBienImmos2(ClientBienImmo clientHasBienImmos2) {
		getClientHasBienImmos2().remove(clientHasBienImmos2);
		clientHasBienImmos2.setBienImmo2(null);

		return clientHasBienImmos2;
	}

}