package dogs.model;

import java.util.HashMap;
import java.util.Map;

public class ClientRepositoryStub implements IClientRepository {
	
	
	private Map<Integer,IClient> clientList = new HashMap<Integer,IClient>();
	
	public ClientRepositoryStub() {
		
	}
	
	public ClientRepositoryStub(IClient client) {
		this.addClient(client);
	}
	
	@Override
	public void addClient(IClient client) {
		this.clientList.put(client.getId(),client);
	}

	@Override
	public Map<Integer, IClient> getClientList() {
		return clientList;
	}
	
	

}