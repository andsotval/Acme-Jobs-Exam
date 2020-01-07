
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

// TODO: Cambiar

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

		request.transfer(request.getModel(), "confirm");
		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Xxxrequest> request, final Xxxrequest entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		model.setAttribute("confirm", false);
		request.unbind(entity, model, "text", "xxx", "job.id");
	}

	@Override
	public Xxxrequest instantiate(final Request<Xxxrequest> request) {
		assert request != null;

		int jobId;
		if (request.getModel().getInteger("jobId") != null) {
			jobId = request.getModel().getInteger("jobId");
		} else {
			jobId = request.getModel().getInteger("job.id");
		}

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

		boolean confirmed;
		if (!errors.hasErrors("confirm")) {
			confirmed = request.getModel().getBoolean("confirm");
			errors.state(request, confirmed, "confirm", "employer.xxxrequest.form.error.confirmation");
		}
	}

	@Override
	public void create(final Request<Xxxrequest> request, final Xxxrequest entity) {
		assert request != null;
		assert entity != null;

		int jobId = request.getModel().getInteger("job.id");
		Job job = this.repository.findOneJobById(jobId);

		entity.setJob(job);

		this.repository.save(entity);
	}

}
