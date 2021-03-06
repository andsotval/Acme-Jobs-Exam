
package acme.features.worker.wotela;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.wotelas.Wotela;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface WorkerWotelaRepository extends AbstractRepository {

	@Query("select w from Wotela w where w.job.id = ?1")
	Wotela findOneByJobId(int id);

}
