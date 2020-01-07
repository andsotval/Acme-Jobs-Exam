
package acme.features.employer.xxxrequest;

import org.springframework.stereotype.Service;

import acme.entities.roles.Employer;
import acme.entities.xxxrequests.Xxxrequest;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractDeleteService;

@Service
public class EmployerXxxrequestDeleteService implements AbstractDeleteService<Employer, Xxxrequest> {

	@Override
	public boolean authorise(final Request<Xxxrequest> request) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void bind(final Request<Xxxrequest> request, final Xxxrequest entity, final Errors errors) {
		// TODO Auto-generated method stub

	}

	@Override
	public void unbind(final Request<Xxxrequest> request, final Xxxrequest entity, final Model model) {
		// TODO Auto-generated method stub

	}

	@Override
	public Xxxrequest findOne(final Request<Xxxrequest> request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void validate(final Request<Xxxrequest> request, final Xxxrequest entity, final Errors errors) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(final Request<Xxxrequest> request, final Xxxrequest entity) {
		// TODO Auto-generated method stub

	}

}
