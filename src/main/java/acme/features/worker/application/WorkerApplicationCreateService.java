
package acme.features.worker.application;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.applications.Application;
import acme.entities.applications.ApplicationStatus;
import acme.entities.jobs.Job;
import acme.entities.roles.Worker;
import acme.framework.components.Errors;
import acme.framework.components.HttpMethod;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractCreateService;

@Service
public class WorkerApplicationCreateService implements AbstractCreateService<Worker, Application> {

	@Autowired
	private WorkerApplicationRepository repository;


	@Override
	public boolean authorise(final Request<Application> request) {
		assert request != null;

		Integer jobId = request.getModel().getInteger("job.id");
		if (jobId == null) {
			jobId = request.getModel().getInteger("id");
		}
		Job job = this.repository.findOneJobById(jobId);

		Date moment;
		moment = new Date(System.currentTimeMillis() - 1);

		boolean result;

		result = job.getDeadline().after(moment) && job.getFinalMode();

		return result;
	}

	//TODO: Cambiar
	@Override
	public void unbind(final Request<Application> request, final Application entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		Integer jobId = request.getModel().getInteger("id");
		if (jobId == null) {
			jobId = request.getModel().getInteger("job.id");
		}
		boolean hasWotela = this.repository.findOneWotelaByJobId(jobId) != null;
		model.setAttribute("hasWotela", hasWotela);

		request.unbind(entity, model, "referenceNumber", "statement", "skills", "qualifications", "job.id");
		request.unbind(entity, model, "wotelaResponse", "ticker", "password");

		if (request.isMethod(HttpMethod.GET)) {
			model.setAttribute("confirmation", "");
		} else {
			request.transfer(model, "confirmation");
		}
	}

	@Override
	public void bind(final Request<Application> request, final Application entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public Application instantiate(final Request<Application> request) {
		assert request != null;

		Application result = new Application();

		Integer id = request.getModel().getInteger("job.id");
		if (id == null) {
			id = request.getModel().getInteger("id");
		}
		Job job = this.repository.findOneJobById(id);

		Principal principal = request.getPrincipal();
		Worker worker;

		worker = this.repository.findWorkerById(principal.getActiveRoleId());

		result.setJob(job);
		result.setSkills(worker.getSkills());
		result.setQualifications(worker.getQualifications());
		result.setWorker(worker);

		return result;
	}

	@Override
	public void validate(final Request<Application> request, final Application entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		boolean isMatching;
		String password, confirmation;

		String refNum = entity.getReferenceNumber();
		int numApplications = this.repository.countApplicationsByRefNum(refNum);

		errors.state(request, numApplications == 0, "referenceNumber", "worker.application.form.errors.referenceNumber.alreadyExists");

		password = request.getModel().getString("password");
		confirmation = request.getModel().getString("confirmation");
		isMatching = password.equals(confirmation);
		errors.state(request, isMatching, "confirmation", "anonymous.user-account.error.confirmation-no-match");

		boolean hasWotela = this.repository.findOneWotelaByJobId(entity.getJob().getId()) != null;

		if (hasWotela) {
			request.getModel().setAttribute("hasWotela", true);
		}
	}

	@Override
	public void create(final Request<Application> request, final Application entity) {
		assert request != null;
		assert entity != null;

		Date moment;
		moment = new Date(System.currentTimeMillis() - 1);
		entity.setCreationMoment(moment);

		Integer id = request.getModel().getInteger("job.id");
		if (id == null) {
			id = request.getModel().getInteger("id");
		}

		Job job = this.repository.findOneJobById(id);

		entity.setJob(job);

		Principal principal = request.getPrincipal();
		Worker worker;

		worker = this.repository.findWorkerById(principal.getActiveRoleId());

		entity.setWorker(worker);

		entity.setStatus(ApplicationStatus.PENDING);

		this.repository.save(entity);
	}

}
