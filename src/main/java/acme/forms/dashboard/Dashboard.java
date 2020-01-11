
package acme.forms.dashboard;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dashboard implements Serializable {

	private static final long	serialVersionUID	= 1L;

	Integer						countAnnouncement;
	Integer						countCompanyRecords;
	Integer						countInvestorRecords;
	Double						minActiveRequest;
	Double						maxActiveRequest;
	Double						avgActiveRequest;
	Double						stDerivationActiveRequest;
	Double						minRangeMinActiveOffer;
	Double						maxRangeMinActiveOffer;
	Double						avgRangeMinActiveOffer;
	Double						stDerivationRangeMinActiveOffer;
	Double						minRangeMaxActiveOffer;
	Double						maxRangeMaxActiveOffer;
	Double						avgRangeMaxActiveOffer;
	Double						stDerivationRangeMaxActiveOffer;
	List<Integer>				numSectorbyCompany;
	List<String>				sectorsbyCompany;
	List<Integer>				numSectorbyInvestor;
	List<String>				sectorsbyInvestor;
	Double						avgJobPerEmployer;
	Double						avgApplicationPerEmployer;
	Double						avgApplicationPerWorker;
	//Object[]					InvestorsSectors;
	Double						ratioJobsGroupedStatusPublished;
	Double						ratioJobsGroupedStatusDraft;
	Double						ratioApplicationsGroupedStatusPending;
	Double						ratioApplicationsGroupedStatusAccepted;
	Double						ratioApplicationsGroupedStatusRejected;
	List<Integer>				numberApplicationsStatusPendingByDay;
	List<String>				daysApplicationsStatusPendingByDay;
	List<Integer>				numberApplicationsStatusAcceptedByDay;
	List<String>				daysApplicationsStatusAcceptedByDay;
	List<Integer>				numberApplicationsStatusRejectedByDay;
	List<String>				daysApplicationsStatusRejectedByDay;
	//TODO: Cambiar
	Double						ratioJobWithWotela;
	Double						ratioWotelaWithTicker;
	Double						ratioAplicationsWithTickerAndPass;
}
