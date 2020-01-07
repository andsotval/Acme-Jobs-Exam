
package acme.entities.xxxrequests;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.entities.jobs.Job;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Xxxrequest extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	//Atributes ------------------------------------------
	@NotBlank
	//Todo: Cambiar
	@Length(max = 10)
	private String				text;

	@URL
	private String				xxx;

	//Relationships --------------------------------------

	@OneToOne(optional = false)
	private Job					job;
}
