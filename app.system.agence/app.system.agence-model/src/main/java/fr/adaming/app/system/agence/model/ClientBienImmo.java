package fr.adaming.app.system.agence.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the client_has_bien_immo database table.
 * 
 */
@Entity
@Table(name="client_has_bien_immo")
@NamedQuery(name="ClientBienImmo.findAll", query="SELECT c FROM ClientBienImmo c")
public class ClientBienImmo implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ClientBienImmoPK id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_heure_visite")
	private Date dateHeureVisite;

	//bi-directional many-to-one association to BienImmo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="bien_immo_id", nullable=false, insertable=false, updatable=false)
	private BienImmo bienImmo1;

	//bi-directional many-to-one association to BienImmo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="bien_immo_id", nullable=false, insertable=false, updatable=false)
	private BienImmo bienImmo2;

	//bi-directional many-to-one association to Client
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="client_id", nullable=false, insertable=false, updatable=false)
	private Client client;

	public ClientBienImmo() {
	}

	public ClientBienImmoPK getId() {
		return this.id;
	}

	public void setId(ClientBienImmoPK id) {
		this.id = id;
	}

	public Date getDateHeureVisite() {
		return this.dateHeureVisite;
	}

	public void setDateHeureVisite(Date dateHeureVisite) {
		this.dateHeureVisite = dateHeureVisite;
	}

	public BienImmo getBienImmo1() {
		return this.bienImmo1;
	}

	public void setBienImmo1(BienImmo bienImmo1) {
		this.bienImmo1 = bienImmo1;
	}

	public BienImmo getBienImmo2() {
		return this.bienImmo2;
	}

	public void setBienImmo2(BienImmo bienImmo2) {
		this.bienImmo2 = bienImmo2;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}