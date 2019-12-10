package dogs.model;

import java.util.HashMap;
import java.util.Map;

public class ClientRepository implements IClientRepository {
private Map<Integer,IClient> clientList = new HashMap<Integer,IClient>();
	
	
	public void addClient(IClient client) {
		this.clientList.put(client.getId(), client);
	}
	
	public Map<Integer,IClient> getClientList() {
		return this.clientList;
	}
}
