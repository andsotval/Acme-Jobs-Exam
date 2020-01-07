
package acme.features.employer.xxxrequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.jobs.Job;
import acme.entities.roles.Employer;
import acme.entities.xxxrequests.Xxxrequest;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class EmployerXxxrequestShowService implements AbstractShowService<Employer, Xxxrequest> {

	@Autowired
	EmployerXxxrequestRepository repository;


	@Override
	public boolean authorise(final Request<Xxxrequest> request) {
		assert request != null;

		boolean result;
		int jobId;
		Job job;
		Employer employer;
		Principal principal;

		jobId = request.getModel().getInteger("jobId");
		job = this.repository.findOneJobById(jobId);
		employer = job.getEmployer();
		principal = request.getPrincipal();
		result = employer.getUserAccount().getId() == principal.getAccountId();

		return result;
	}

	@Override
	public void unbind(final Request<Xxxrequest> request, final Xxxrequest entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "text", "xxx");
	}

	@Override
	public Xxxrequest findOne(final Request<Xxxrequest> request) {
		assert request != null;

		Xxxrequest result;

		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

}
