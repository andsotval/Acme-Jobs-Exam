
package acme.features.employer.wotela;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.jobs.Job;
import acme.entities.wotelas.Wotela;
import acme.framework.repositories.AbstractRepository;

// TODO: cambiar
@Repository
public interface EmployerWotelaRepository extends AbstractRepository {

	@Query("select w from Wotela w where w.job.id = ?1")
	Wotela findOneWotelaByJobId(int jobId);

	@Query("select w.job from Wotela w where w.job.id = ?1")
	Job findOneJobByWotela(int jobId);

	@Query("select j from Job j where j.id = ?1")
	Job findOneJobById(int jobId);
}
