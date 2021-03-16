package com.conduent.provider.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.conduent.provider.bean.Provider;
import com.conduent.provider.dao.ProviderDAO;

/**
 * @author: Paramesh
 * @version:
 * @Since:
 */
@Component("providerDAOImpl")
public class ProviderDAOImpl implements ProviderDAO {
	
	@Autowired
	EntityManager entityManager;
	
	List<Provider>  list = new ArrayList<> (Arrays.asList(
			new Provider("1234", "provider1", "ORP"),
			new Provider("1235", "provider2", "Render"),
			new Provider("1236", "provider3", "Billing"),
			new Provider("1237", "provider4", "non - Billing"),
			new Provider("1238", "provider5", "From DAO")));
	
	public List<Provider> getProviders() {
		List<Provider> providerList = (List<Provider>)entityManager
                .createQuery("SELECT p FROM Provider p")
                .getResultList();		
        return providerList;
	}
}
