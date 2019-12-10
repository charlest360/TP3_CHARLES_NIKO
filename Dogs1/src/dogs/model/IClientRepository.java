package dogs.model;

import java.util.Map;

public interface IClientRepository {

	void addClient(IClient client);

	public Map<Integer,IClient> getClientList();

}
