package config.xml.wildcard;


public class ClientService {
	private ClientDao clientDao;
	
	public void setClientDao(ClientDao clientDao) {
		this.clientDao = clientDao;
	}

	public ClientDao getClientDao() {
		return clientDao;
	}

	public void findClient(String string) {
		System.out.println("**** test.mock");
	}

}
