package fr.adaming.app.system.agence.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the client database table.
 * 
 */
@Entity
@Table(name="client")
@NamedQuery(name="Client.findAll", query="SELECT c FROM Client c")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="nom_client", length=45)
	private String nomClient;

	//bi-directional many-to-one association to ClientBienImmo
	@OneToMany(mappedBy="client")
	private List<ClientBienImmo> clientHasBienImmos;

	public Client() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomClient() {
		return this.nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public List<ClientBienImmo> getClientHasBienImmos() {
		return this.clientHasBienImmos;
	}

	public void setClientHasBienImmos(List<ClientBienImmo> clientHasBienImmos) {
		this.clientHasBienImmos = clientHasBienImmos;
	}

	public ClientBienImmo addClientHasBienImmo(ClientBienImmo clientHasBienImmo) {
		getClientHasBienImmos().add(clientHasBienImmo);
		clientHasBienImmo.setClient(this);

		return clientHasBienImmo;
	}

	public ClientBienImmo removeClientHasBienImmo(ClientBienImmo clientHasBienImmo) {
		getClientHasBienImmos().remove(clientHasBienImmo);
		clientHasBienImmo.setClient(null);

		return clientHasBienImmo;
	}

}