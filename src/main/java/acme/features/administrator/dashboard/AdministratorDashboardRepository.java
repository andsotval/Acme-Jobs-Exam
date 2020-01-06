
package acme.features.administrator.dashboard;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository {

	@Query("select count(a) from Announcement a")
	Integer countAnnouncement();

	@Query("select count(c) from Companyrecord c")
	Integer countCompanyRecord();

	@Query("select count(i) from Investorrecord i")
	Integer countInvestorRecords();

	@Query("select g.sector, count(g) from Companyrecord g group by g.sector")
	Object[] sectorspercompany();

	@Query("select g.sector, count(g) from Investorrecord g group by g.sector")
	Object[] sectorsperinvestor();

	@Query("select min(r.reward.amount),max(r.reward.amount),avg(r.reward.amount),stddev(r.reward.amount) from Request r where r.deadline > ?1")
	Double[][] queryActiveRequest(Date deadline);

	@Query("select min(r.rangeMin.amount),max(r.rangeMin.amount),avg(r.rangeMin.amount),stddev(r.rangeMin.amount) from Offer r where r.deadline > ?1")
	Double[][] queryRangeMinActiveOffer(Date deadline);

	@Query("select min(r.rangeMax.amount),max(r.rangeMax.amount),avg(r.rangeMax.amount),stddev(r.rangeMax.amount) from Offer r where r.deadline > ?1")
	Double[][] queryRangeMaxActiveOffer(Date deadline);

	@Query("select avg(select count(j) from Job j where j.employer.id = e.id) from Employer e")
	Double queryAVGJobPerEmployer();

	@Query("select avg(select count(a) from Application a where a.job.employer.id = e.id) from Employer e")
	Double queryAVGApplicationPerEmployer();

	@Query("select avg(select count(a) from Application a where a.worker.id = w.id) from Worker w")
	Double queryAVGApplicationPerWorker();

	@Query("select 1.0*count(j)/(select count(j2) from Job j2) from Job j where j.finalMode=1")
	Double ratioJobsGroupedStatusPublished();

	@Query("select 1.0*count(j)/(select count(j2) from Job j2) from Job j where j.finalMode=0")
	Double ratioJobsGroupedStatusDraft();

	@Query("select 1.0*count(j)/(select count(j2) from Application j2) from Application j where j.status=acme.entities.applications.ApplicationStatus.PENDING")
	Double ratioApplicationsGroupedStatusPending();

	@Query("select 1.0*count(j)/(select count(j2) from Application j2) from Application j where j.status=acme.entities.applications.ApplicationStatus.ACCEPTED")
	Double ratioApplicationsGroupedStatusAccepted();

	@Query("select 1.0*count(j)/(select count(j2) from Application j2) from Application j where j.status=acme.entities.applications.ApplicationStatus.REJECTED")
	Double ratioApplicationsGroupedStatusRejected();

	@Query("select j.creationMoment,count(j) from Application j where j.status=acme.entities.applications.ApplicationStatus.PENDING and j.creationMoment between ?1 and ?2 group by j.creationMoment")
	Object[] numberApplicationsStatusPendingByDay(Date from, Date to);

	@Query("select j.creationMoment,count(j) from Application j where j.status=acme.entities.applications.ApplicationStatus.ACCEPTED and j.creationMoment between ?1 and ?2 group by j.creationMoment")
	Object[] numberApplicationsStatusAcceptedByDay(Date from, Date to);

	@Query("select j.creationMoment,count(j) from Application j where j.status=acme.entities.applications.ApplicationStatus.REJECTED and j.creationMoment between ?1 and ?2 group by j.creationMoment")
	Object[] numberApplicationsStatusRejectedByDay(Date from, Date to);

	//TODO: Cambiar - Estan son las 3 queries del Dashboard

	@Query("select 1.0*count(j)/(select count(j2) from Job j2) from Job j where j.xxxRequest != null")
	Double ratioJobWithXxxrequest();

	@Query("select 1.0*count(j)/(select count(j2) from XXXRequest j2) from XXXRequest j where j.xxx != '' or j.xxx != null")
	Double ratioXxxWithXxx();

	@Query("select 1.0*count(j)/(select count(j2) from Application j2) from Application j where j.job.xxxRequest.password != null")
	Double ratioAplicationsWithxxx();
}
