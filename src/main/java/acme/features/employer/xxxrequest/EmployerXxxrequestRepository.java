
package acme.features.employer.xxxrequest;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.jobs.Job;
import acme.entities.xxxrequests.Xxxrequest;
import acme.framework.repositories.AbstractRepository;

// TODO: cambiar
@Repository
public interface EmployerXxxrequestRepository extends AbstractRepository {

	@Query("select x from Xxxrequest x where x.job.id = ?1")
	Xxxrequest findOneXxxrequestByJobId(int jobId);

	@Query("select x.job from Xxxrequest x where x.job.id = ?1")
	Job findOneJobByXxxrequest(int jobId);

	@Query("select j from Job j where j.id = ?1")
	Job findOneJobById(int jobId);
}
