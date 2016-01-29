package de.fhg.fokus.nubomedia;

import org.kurento.repository.RepositoryUrlProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.fhg.fokus.nubomedia.paas.CloudRepositoryProfile;

/**
 * Used to obtain the URL for the NUBOMEDIA cloud repository 
 * @author Alice Cheambe <alice.cheambe[at]fokus.fraunhofer.de>
 *
 */
public class PaasRepositoryProvider implements RepositoryUrlProvider{

	private static final Logger logger = LoggerFactory.getLogger(PaasRepositoryProvider.class);

	private CloudRepositoryProfile repositoryProfile;
	

	public PaasRepositoryProvider(){
		repositoryProfile = CloudRepositoryProfile.getInstance();
	}

	
	
	@Override
	public String getRepositoryUrl() {
		if(repositoryProfile != null)
			return repositoryProfile.getRepositoryURI();
		else
			return null;
	}

}
