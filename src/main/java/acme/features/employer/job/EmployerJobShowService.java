
package acme.features.employer.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.jobs.Job;
import acme.entities.roles.Employer;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

// TODO: Cambiar

@Service
public class EmployerJobShowService implements AbstractShowService<Employer, Job> {

	@Autowired
	EmployerJobRepository repository;


	@Override
	public boolean authorise(final Request<Job> request) {
		assert request != null;

		boolean result;
		int jobId;
		Job job;
		Employer employer;
		Principal principal;

		jobId = request.getModel().getInteger("id");
		job = this.repository.findOneJobById(jobId);
		employer = job.getEmployer();
		principal = request.getPrincipal();
		result = employer.getUserAccount().getId() == principal.getAccountId();

		return result;
	}

	@Override
	public void unbind(final Request<Job> request, final Job entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		int jobId = request.getModel().getInteger("jobId");

		boolean hasXxxrequest = this.repository.findXxxrequestByJobId(jobId) != null;

		model.setAttribute("hasXxxrequest", hasXxxrequest);

		request.unbind(entity, model, "reference", "title", "deadline");
		request.unbind(entity, model, "salary", "moreInfo", "description", "finalMode");
	}

	@Override
	public Job findOne(final Request<Job> request) {
		assert request != null;

		Job result;

		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneJobById(id);
		return result;
	}

}
