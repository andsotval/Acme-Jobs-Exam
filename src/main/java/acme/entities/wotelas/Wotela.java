
package acme.entities.wotelas;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

import acme.entities.jobs.Job;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Wotela extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	//Atributes ------------------------------------------
	@NotBlank
	@Size(max = 256)
	private String				text;

	@URL
	private String				ticker;

	//Relationships --------------------------------------

	@OneToOne(optional = false)
	private Job					job;
}
