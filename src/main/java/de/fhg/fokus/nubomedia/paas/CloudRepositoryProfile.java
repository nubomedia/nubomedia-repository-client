/*******************************************************************************
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * @author Alice Cheambe <alice.cheambe[at]fokus.fraunhofer.de>
 *******************************************************************************/
package de.fhg.fokus.nubomedia.paas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 *  @author Alice Cheambe <alice.cheambe[at]fokus.fraunhofer.de>
 * 
 */
public class CloudRepositoryProfile {
	
	private static CloudRepositoryProfile instance;
	private static final Logger logger = LoggerFactory.getLogger(CloudRepositoryProfile.class);

	private String repositoryAddress;
	private String repositoryUser;
	private String repositoryPassword;
	private String repositoryServiceURI;
	private int repositoryPort;

	public CloudRepositoryProfile() {
		super();
		logger.info("Instatiating the Cloud Repository Profile with the following properties;\n CLOUDREPO_IP: "
		+ System.getenv("CLOUDREPO_IP")+"\nCLOUDREPO_USER: "
		+ System.getenv("CLOUDREPO_USER")+"\n CLOUDREPO_PASSWORD: "
		+ System.getenv("CLOUDREPO_PASSWORD")+"\n CLOUDREPO_PORT: "
				+ System.getenv("CLOUDREPO_PORT"));
				
		repositoryAddress = System.getenv("CLOUDREPO_IP");
		repositoryUser = System.getenv("CLOUDREPO_USER");
		repositoryPassword = System.getenv("CLOUDREPO_PASSWORD");
		repositoryPort =  Integer.parseInt((System.getenv("CLOUDREPO_PORT")!=null)?  System.getenv("CLOUDREPO_PORT"): "27018");
		
		if(repositoryAddress == null)
			instance  = null;
		else{
			this.repositoryServiceURI = "http://"+repositoryAddress+":"+repositoryPort;			
			instance = this;
		}		
	}


	public static CloudRepositoryProfile getInstance() {

		if(instance == null)
			new CloudRepositoryProfile();		

		return instance;
	}

	public String getRepositoryURI() {
		return repositoryServiceURI;
	}

	public String getRepositoryPassword() {
		return repositoryPassword;
	}

	public String getRepositoryAddress() {
		return repositoryAddress;
	}


	public String getRepositoryUser() {
		return repositoryUser;
	}


	public String getRepositoryServiceURI() {
		return repositoryServiceURI;
	}


	public int getRepositoryPort() {
		return repositoryPort;
	}


	public void setRepositoryPassword(String repositoryPassword) {
		this.repositoryPassword = repositoryPassword;
	}
	

	public String getServerAddress() {
		return repositoryAddress;
	}

	public void setServerAddress(String serverAddress) {
		this.repositoryAddress = serverAddress;
	}

}
