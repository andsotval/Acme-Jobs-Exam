
package acme.features.authenticated.wotela;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.wotelas.Wotela;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedWotelaShowByJobService implements AbstractShowService<Authenticated, Wotela> {

	@Autowired
	private AuthenticatedWotelaRepository repository;


	@Override
	public boolean authorise(final Request<Wotela> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Wotela> request, final Wotela entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "text", "ticker");

	}

	@Override
	public Wotela findOne(final Request<Wotela> request) {
		assert request != null;

		Wotela result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneByJobId(id);

		return result;
	}

}
