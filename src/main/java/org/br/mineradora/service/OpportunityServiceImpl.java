package org.br.mineradora.service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.br.mineradora.dto.OpportunityDTO;
import org.br.mineradora.dto.ProposalDTO;
import org.br.mineradora.dto.QuotationDTO;
import org.br.mineradora.entity.OpportunityEntity;
import org.br.mineradora.entity.QuotationEntity;
import org.br.mineradora.repository.OpportunityRepository;
import org.br.mineradora.repository.QuotationRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class OpportunityServiceImpl implements OpportunityService{
	
	@Inject
	QuotationRepository quotationRepository;
	
	@Inject
	OpportunityRepository opportunityRepository;

	@Override
	public void buildOpportunity(ProposalDTO proposal) {
		List<QuotationEntity> quotationEntities = quotationRepository.findAll().list();
		Collections.reverse(quotationEntities);
		
		OpportunityEntity opportunity = new OpportunityEntity();
		opportunity.setDate(new Date());
		opportunity.setProposalId(proposal.getProposalId());
		opportunity.setCustomer(proposal.getCustomer());
		opportunity.setPriceTonne(proposal.getPriceTonne());
		opportunity.setLastDollarQuotation(quotationEntities.get(0).getCurrencyPrice());
		
		opportunityRepository.persist(opportunity);
	}

	@Override
	public void saveQuotation(QuotationDTO quotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<OpportunityDTO> generateOpportunityData() {
		// TODO Auto-generated method stub
		return null;
	}

}
