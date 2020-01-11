
package acme.features.employer.wotela;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.jobs.Job;
import acme.entities.roles.Employer;
import acme.entities.wotelas.Wotela;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

// TODO: Cambiar

@Service
public class EmployerWotelaShowService implements AbstractShowService<Employer, Wotela> {

	@Autowired
	EmployerWotelaRepository repository;


	@Override
	public boolean authorise(final Request<Wotela> request) {
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
	public void unbind(final Request<Wotela> request, final Wotela entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "text", "ticker", "job");
	}

	@Override
	public Wotela findOne(final Request<Wotela> request) {
		assert request != null;

		Wotela result;

		int id;

		id = request.getModel().getInteger("jobId");
		result = this.repository.findOneWotelaByJobId(id);

		return result;
	}

}
