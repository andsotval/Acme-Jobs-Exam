
package acme.features.employer.job;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.applications.Application;
import acme.entities.jobs.Job;
import acme.entities.roles.Employer;
import acme.entities.xxxrequests.Xxxrequest;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EmployerJobRepository extends AbstractRepository {

	@Query("select j from Job j where j.id = ?1")
	Job findOneJobById(int id);

	@Query("select j from Job j where j.employer.id = ?1")
	Collection<Job> findManyByEmployerId(int employerId);

	@Query("select e from Employer e where e.userAccount.id = ?1")
	Employer findOneEmployerByUserAccountId(int id);

	@Query("select j from Job j where j.reference = ?1")
	Job findOneJobByReference(String reference);

	@Query("select j from Job j where j.reference = ?1 and j.id != ?2")
	Job findOneJobByReferenceWithoutJobId(String reference, int id);

	@Query("select sum(d.percentageOfTime) from Duty d where d.job.id = ?1")
	Double sumPercentageOfTimeByJobId(int id);

	@Query("select a from Application a where a.job.id = ?1")
	Collection<Application> findOneApplicationByJobId(int id);

	//TODO: cambiar
	@Query("select x from Xxxrequest x where x.job.id = ?1")
	Xxxrequest findXxxrequestByJobId(int jobId);
}
