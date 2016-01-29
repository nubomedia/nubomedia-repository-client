package de.fhg.fokus.nubomedia.paas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Alice Cheambe <alice.cheambe[at]fokus.fraunhofer.de>
 *
 */
public class CloudRepositoryProfile {
	
	private static CloudRepositoryProfile instance;
	private static final Logger logger = LoggerFactory.getLogger(CloudRepositoryProfile.class);

	private String repositoryAddress;
	private String repositoryUser;
	private String repositoryPassword;
	private String repositoryServiceURI;
	private int repositoryPort = 27018;

	public CloudRepositoryProfile() {
		super();
		logger.info("Instatiating the Cloud Repository Profile with the following properties;\n CLOUDREPO_IP: "
		+ System.getenv("CLOUDREPO_IP")+"\nCLOUDREPO_USER: "
		+ System.getenv("CLOUDREPO_USER")+"\n CLOUDREPO_PASSWORD: "
		+ System.getenv("CLOUDREPO_PASSWORD"));
		
		//max = (a > b) ? a : b;
		repositoryAddress = System.getenv("CLOUDREPO_IP");
		repositoryUser = System.getenv("CLOUDREPO_USER");
		repositoryPassword = System.getenv("CLOUDREPO_PASSWORD");
		
		if(repositoryAddress == null)
			instance  = null;
		else{
			//final static String DEFAULT_REPOSITORY_SERVER_URI = "http://localhost:7676";
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
