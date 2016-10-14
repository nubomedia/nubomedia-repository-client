/*
 * (C) Copyright 2016 NUBOMEDIA (http://www.nubomedia.eu)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package de.fhg.fokus.nubomedia;

import org.kurento.repository.RepositoryUrlProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.fhg.fokus.nubomedia.paas.CloudRepositoryProfile;

/**
 * Used to obtain the URL for the NUBOMEDIA cloud repository 
 * 
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
		{
			logger.info("returning the NUBOMEDIA repository URL: "+repositoryProfile.getRepositoryURI());
			return repositoryProfile.getRepositoryURI();
		}
		else
			return null;
	}

}
