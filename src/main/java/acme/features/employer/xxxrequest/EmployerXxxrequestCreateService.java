
package acme.features.employer.xxxrequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.jobs.Job;
import acme.entities.roles.Employer;
import acme.entities.xxxrequests.Xxxrequest;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class EmployerXxxrequestCreateService implements AbstractCreateService<Employer, Xxxrequest> {

	@Autowired
	private EmployerXxxrequestRepository repository;


	@Override
	public boolean authorise(final Request<Xxxrequest> request) {

		return true;
	}

	@Override
	public void bind(final Request<Xxxrequest> request, final Xxxrequest entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Xxxrequest> request, final Xxxrequest entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "text", "xxx");
	}

	@Override
	public Xxxrequest instantiate(final Request<Xxxrequest> request) {
		int jobId = request.getModel().getInteger("jobId");

		Job job = this.repository.findOneJobById(jobId);
		Xxxrequest result = new Xxxrequest();
		result.setJob(job);

		return result;
	}

	@Override
	public void validate(final Request<Xxxrequest> request, final Xxxrequest entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<Xxxrequest> request, final Xxxrequest entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

}
