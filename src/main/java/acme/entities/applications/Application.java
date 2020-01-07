
package acme.entities.applications;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;

import acme.entities.jobs.Job;
import acme.entities.roles.Worker;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(indexes = {
	@Index(columnList = "status"), @Index(columnList = "creationMoment desc, referenceNumber desc, status asc")
})
public class Application extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	//Atributes ------------------------------------------

	@Column(unique = true)
	@NotBlank
	@Length(min = 5, max = 15)
	private String				referenceNumber;

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date				creationMoment;

	@Enumerated
	private ApplicationStatus	status;

	@NotBlank
	@Length(max = 1200)
	private String				statement;

	@NotBlank
	private String				skills;

	@NotBlank
	private String				qualifications;

	private String				justification;

	//TODO: Cambiar
	private String				XXXRequestResponse;

	//TODO: Cambiar
	private String				xxx;

	//TODO: Cambiar
	//	@Pattern(regexp = "([A-Z])\\w+")
	private String				password;

	//Relationships ---------------------------------------

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private Worker				worker;

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private Job					job;

}
