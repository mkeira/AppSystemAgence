package fr.adaming.app.system.agence.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Proprietaire database table.
 * 
 */
@Entity
@Table(name="Proprietaire")
@NamedQuery(name="Proprietaire.findAll", query="SELECT p FROM Proprietaire p")
public class Proprietaire implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=45)
	private String nom;

	//bi-directional many-to-one association to BienImmo
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
	@JoinColumn(name="bien_immo_id",  insertable=false, updatable=false)
	private BienImmo bienImmo1;

	//bi-directional many-to-one association to BienImmo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="bien_immo_id", insertable=false, updatable=false)
	private BienImmo bienImmo2;

	public Proprietaire() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
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

}