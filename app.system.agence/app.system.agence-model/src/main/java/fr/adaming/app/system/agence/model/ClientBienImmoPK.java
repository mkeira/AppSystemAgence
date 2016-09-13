package fr.adaming.app.system.agence.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the client_has_bien_immo database table.
 * 
 */
@Embeddable
public class ClientBienImmoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="client_id", insertable=false, updatable=false, unique=true, nullable=false)
	private int clientId;

	@Column(name="bien_immo_id", insertable=false, updatable=false, unique=true, nullable=false)
	private int bienImmoId;

	public ClientBienImmoPK() {
	}
	public int getClientId() {
		return this.clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public int getBienImmoId() {
		return this.bienImmoId;
	}
	public void setBienImmoId(int bienImmoId) {
		this.bienImmoId = bienImmoId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ClientBienImmoPK)) {
			return false;
		}
		ClientBienImmoPK castOther = (ClientBienImmoPK)other;
		return 
			(this.clientId == castOther.clientId)
			&& (this.bienImmoId == castOther.bienImmoId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.clientId;
		hash = hash * prime + this.bienImmoId;
		
		return hash;
	}
}