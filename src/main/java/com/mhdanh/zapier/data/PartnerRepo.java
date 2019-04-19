package com.mhdanh.zapier.data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;

import com.mhdanh.zapier.model.Partner;

@ApplicationScoped
public class PartnerRepo {
	
	private List<Partner> partners = new ArrayList<>();
	
	public List<Partner> getAll(String tenant) {
		return partners.stream().filter(p -> p.getTenant().equalsIgnoreCase(tenant)).collect(Collectors.toList());
	}
	
	public Partner create(Partner partner) {
		partner.setId(UUID.randomUUID().toString());
		partners.add(partner);
		return partner;
	}
	
}
